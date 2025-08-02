package com.fribbels.core;

import java.util.Map;
import java.util.Objects;

import com.fribbels.enums.Set;
import com.fribbels.enums.StatType;
import com.fribbels.handler.OptimizationRequestHandler;
import com.fribbels.model.AugmentedStats;
import com.fribbels.model.DamageMultipliers;
import com.fribbels.model.Hero;
import com.fribbels.model.HeroStats;
import com.fribbels.model.Item;

public class StatCalculator {

    public static class CalculationConfig {
        private boolean rageSetEnabled;
        private boolean penSetEnabled;
        private int penDefenseValue;

        public CalculationConfig(final boolean rageSetEnabled, final boolean penSetEnabled, final int penDefenseValue) {
            this.rageSetEnabled = rageSetEnabled;
            this.penSetEnabled = penSetEnabled;
            this.penDefenseValue = penDefenseValue;
        }

        public boolean isRageSetEnabled() {
            return this.rageSetEnabled;
        }

        public void setRageSetEnabled(final boolean enabled) {
            this.rageSetEnabled = enabled;
        }

        public boolean isPenSetEnabled() {
            return this.penSetEnabled;
        }

        public void setPenSetEnabled(final boolean enabled) {
            this.penSetEnabled = enabled;
        }

        public int getPenDefenseValue() {
            return this.penDefenseValue;
        }
    }

    private static final class StatIndex {
        public static final int ATTACK = 0;
        public static final int HEALTH = 1;
        public static final int DEFENSE = 2;
        public static final int CRIT_RATE = 6;
        public static final int CRIT_DAMAGE = 7;
        public static final int EFFECTIVENESS = 8;
        public static final int RESISTANCE = 9;
        public static final int SPEED = 10;
        public static final int SCORE = 11;
        public static final int COUNT = 15;

        private StatIndex() {
        }
    }

    private static final CalculationConfig config = new CalculationConfig(true, true, 1500);

    private float attackSetMultiplier;
    private float healthSetMultiplier;
    private float defenseSetMultiplier;
    private float speedSetMultiplier;
    private float revengeSetMultiplier;

    private float baseAttackBonus;
    private float baseHealthBonus;
    private float baseDefenseBonus;

    private float maxAttackMultiplier;
    private float maxHealthMultiplier;
    private float maxDefenseMultiplier;

    private float penetrationDamageBonus;

    public void calculateBaseValues(final HeroStats base, final Hero hero) {
        Objects.requireNonNull(base, "Base stats cannot be null");
        Objects.requireNonNull(hero, "Hero cannot be null");

        this.attackSetMultiplier = this.calculateSetBonus(base.getAtk(), 0.45f);
        this.healthSetMultiplier = this.calculateSetBonus(base.getHp(), 0.20f);
        this.defenseSetMultiplier = this.calculateSetBonus(base.getDef(), 0.20f);
        this.speedSetMultiplier = this.calculateSetBonus(base.getSpd(), 0.25f);
        this.revengeSetMultiplier = this.calculateSetBonus(base.getSpd(), 0.12f);

        this.baseAttackBonus = this.calculateStatWithBonuses(
                base.getAtk(),
                hero.getBonusAtkPercent() + hero.getAeiAtkPercent(),
                hero.getBonusAtk() + hero.getAeiAtk());

        this.baseHealthBonus = this.calculateStatWithBonuses(
                base.getHp(),
                hero.getBonusHpPercent() + hero.getAeiHpPercent(),
                hero.getBonusHp() + hero.getAeiHp());

        this.baseDefenseBonus = this.calculateStatWithBonuses(
                base.getDef(),
                hero.getBonusDefPercent() + hero.getAeiDefPercent(),
                hero.getBonusDef() + hero.getAeiDef());

        final float baseAtkMultiplier = hero.getFinalAtkMultiplier() / 100f;
        final float baseHpMultiplier = hero.getFinalHpMultiplier() / 100f;
        final float baseDefMultiplier = hero.getFinalDefMultiplier() / 100f;

        if (base.getBonusStats() == null) {
            this.maxAttackMultiplier = 1 + baseAtkMultiplier;
            this.maxHealthMultiplier = 1 + baseHpMultiplier;
            this.maxDefenseMultiplier = 1 + baseDefMultiplier;
        } else {
            this.maxAttackMultiplier = 1 + base.getBonusStats().getBonusMaxAtkPercent() / 100f + baseAtkMultiplier;
            this.maxHealthMultiplier = 1 + base.getBonusStats().getBonusMaxHpPercent() / 100f + baseHpMultiplier;
            this.maxDefenseMultiplier = 1 + base.getBonusStats().getBonusMaxDefPercent() / 100f + baseDefMultiplier;
        }

        this.penetrationDamageBonus = this.calculatePenetrationBonus(config.getPenDefenseValue());
    }

    public float[] createStatAccumulator(final HeroStats base, final Item item, final boolean useReforgeStats) {
        Objects.requireNonNull(base, "Base stats cannot be null");
        Objects.requireNonNull(item, "Item cannot be null");

        final float[] accumulator = this.calculateStatAccumulator(base, item, useReforgeStats);
        item.setTempStatAccArr(accumulator);
        return accumulator.clone();
    }

    public HeroStats addAccumulatorArrsToHero(final HeroStats base, final float[][] accs, final int[] sets,
            final Hero hero, final int upgrades, final int conversions, final int alreadyEquipped, final int priority) {
        final float atk = this.calculateAtk(accs, sets);
        final float hp = this.calculateHp(accs, sets);
        final float def = this.calculateDef(accs, sets);
        final float cr = this.calculateCr(base, accs, sets, hero);
        final int cd = (int) this.calculateCd(base, accs, sets, hero);
        final int eff = (int) this.calculateEff(base, accs, sets, hero);
        final int res = (int) this.calculateRes(base, accs, sets, hero);
        final int spd = (int) this.calculateSpd(base, accs, sets, hero);

        final float critRate = Math.min(cr, 100f) / 100f;
        final float critDamage = Math.min(cd, 350f) / 100f;

        final int cp = (int) this.calculateCp(atk, hp, def, spd, critRate, critDamage, eff, res);

        final float penSetOn = sets[13] > 1 ? 1 : 0;
        final float rageMultiplier = isRageSetEnabled() && sets[11] > 3 ? 0.3f : 0;
        final float penMultiplier = isPenSetEnabled() && sets[13] > 1 ? this.penetrationDamageBonus : 1;
        final float torrentMultiplier = sets[17] > 1 ? sets[17] / 2f * 0.1f : 0;
        final float pctDmgMultiplier = 1 + rageMultiplier + torrentMultiplier;

        final int ehp = this.calculateEhp(hp, def);
        final int hpps = this.calculateHpps(hp, spd);
        final int ehpps = this.calculateEhpps(ehp, spd);
        final int dmg = this.calculateDmg(atk, critRate, critDamage, penMultiplier, pctDmgMultiplier);
        final int dmgps = this.calculateDmgps(dmg, spd);
        final int mcdmg = this.calculateMcdmg(atk, critDamage, penMultiplier, pctDmgMultiplier);
        final int mcdmgps = this.calculateMcdmgps(mcdmg, spd);
        final int dmgh = this.calculateDmgh(hp, critDamage, penMultiplier, pctDmgMultiplier);
        final int dmgd = this.calculateDmgd(def, critDamage, penMultiplier, pctDmgMultiplier);
        /*
         * 
         * (increase dmg) * [(atk + bonus atk) * (pow * multi) * (cdmg)]
         * 
         * {[(ATK !!)(Atkmod)(Rate **)+(FlatMod)] * (1.871)+(Flat2Mod)} × (pow **)(a) +
         * 
         * a = (EnhanceMod)(HitTypeMod)(ElementMod)(DamageUpMod)(TargetDebuffMod)
         * rate -> scaling
         * flatmod -> max hp/def scaling
         * flat2mod -> ddj
         * 
         */
        DamageMultipliers multis = hero.getDamageMultipliers();
        if (multis == null) {
            multis = new DamageMultipliers();
        }

        final int s1 = this.getSkillValue(multis, 0, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);
        final int s2 = this.getSkillValue(multis, 1, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);
        final int s3 = this.getSkillValue(multis, 2, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);

        final int score = (int) this.sumStatAtIndex(accs, 11);

        final float bsHp = (hp - base.getHp() - hero.getArtifactHealth() - (sets[0] > 1 ? sets[0] / 2f * this.healthSetMultiplier : 0) + (sets[17] > 1 ? sets[17] / 2f * this.healthSetMultiplier / 2 : 0)) / base.getHp() * 100;
        final float bsAtk = (atk - base.getAtk() - hero.getArtifactAttack() - (sets[2] > 1 ? sets[2] / 4f * this.attackSetMultiplier : 0)) / base.getAtk() * 100;
        final float bsDef = (def - base.getDef() - hero.getArtifactDefense() - (sets[1] > 1 ? sets[1] / 2f * this.defenseSetMultiplier : 0)) / base.getDef() * 100;
        final float bsCr = (cr - base.getCr() - (sets[4] > 1 ? sets[4] / 2f * 12 : 0));
        final float bsCd = (cd - base.getCd() - (sets[6] > 3 ? 60 : 0));
        final float bsEff = (eff - base.getEff() - (sets[5] > 1 ? sets[5] / 2 * 20 : 0));
        final float bsRes = (res - base.getRes() - (sets[9] > 1 ? sets[9] / 2 * 20 : 0));
        final float bsSpd = (spd - base.getSpd() - (sets[3] > 3 ? this.speedSetMultiplier : 0) - (sets[14] > 3 ? this.revengeSetMultiplier : 0));

        // hp: (row.hp - base.getHp() - artiHp - bonusSetMaxHp/100*base.getHp() -
        // bonusSetTorrent/100*base.getHp()) / base.getHp() * 100,
        // atk: (row.atk - base.getAtk() - artiAtk - bonusSetAtt/100*base.getAtk()) /
        // base.getAtk() *
        // 100,
        // def: (row.def - base.getDef() - bonusSetDef/100*base.getDef()) /
        // base.getDef() * 100,
        // chc: (Math.min(100, row.chc) - base.chc*100 - bonusSetCri),
        // chd: (Math.min(350, row.chd) - base.chd*100 - bonusSetCriDmg),
        // eff: (row.eff - base.getEff()*100 - bonusSetAcc),
        // res: (row.efr - base.efr*100 - bonusSetRes),
        // spd: (row.spd - base.getSpd() - bonusSetSpeed - bonusSetRevenge),

        final int bs = (int) (bsHp + bsAtk + bsDef + bsCr * 1.6f + bsCd * 1.14f + bsEff + bsRes + bsSpd * 2);

        return new HeroStats((int) atk, (int) hp, (int) def, (int) cr, cd, eff, res, spd, cp, ehp, hpps, ehpps, dmg,
                dmgps, mcdmg, mcdmgps, dmgh, dmgd, s1, s2, s3, upgrades, conversions, alreadyEquipped, score, bs,
                priority, base.getBonusStats(), null, null, null, null, null, null, null);
    }

    public float[] getStatAccumulatorArr(final HeroStats base, final Item item,
            final Map<String, float[]> accumulatorsByItemId, final boolean useReforgeStats) {
        if (accumulatorsByItemId.containsKey(item.getModId())) {
            return accumulatorsByItemId.get(item.getModId());
        }

        final float[] accumulator = this.calculateStatAccumulator(base, item, useReforgeStats);
        accumulatorsByItemId.put(item.getModId(), accumulator);
        return accumulator;
    }

    public float[] calculateStatAccumulator(final HeroStats base, final Item item, final boolean useReforgeStats) {
        Objects.requireNonNull(base, "Base stats cannot be null");
        Objects.requireNonNull(item, "Item cannot be null");

        final AugmentedStats stats = this.selectStats(item, useReforgeStats);
        final float[] accumulator = new float[StatIndex.COUNT];

        this.accumulateSubStats(accumulator, base, stats);
        this.accumulateMainStat(accumulator, base, stats);
        this.accumulateScore(accumulator, item, useReforgeStats);

        return accumulator;
    }

    public int[] buildSetsArr(final Item[] items) {
        Objects.requireNonNull(items, "Items array cannot be null");
        if (items.length != 6) {
            throw new IllegalArgumentException("Exactly 6 items are required");
        }
        final int[] sets = new int[OptimizationRequestHandler.SET_COUNT];
        for (int i = 0; i < 6; i++) {
            final Item item = items[i];
            Objects.requireNonNull(item, "Item at index " + i + " is null");

            final Set set = item.getSet();
            Objects.requireNonNull(set, "Item set at index " + i + " is null");

            sets[set.getIndex()]++;
        }
        return sets;
    }

    private void accumulateSubStats(final float[] accumulator, final HeroStats base, final AugmentedStats stats) {
        accumulator[StatIndex.ATTACK] = this.calculateStatValue(stats.getAttack(), stats.getAttackPercent(),
                base.getAtk());
        accumulator[StatIndex.HEALTH] = this.calculateStatValue(stats.getHealth(), stats.getHealthPercent(),
                base.getHp());
        accumulator[StatIndex.DEFENSE] = this.calculateStatValue(stats.getDefense(), stats.getDefensePercent(),
                base.getDef());
        accumulator[StatIndex.SPEED] = stats.getSpeed();
        accumulator[StatIndex.CRIT_RATE] = stats.getCritRate();
        accumulator[StatIndex.CRIT_DAMAGE] = stats.getCritDamage();
        accumulator[StatIndex.EFFECTIVENESS] = stats.getEffectiveness();
        accumulator[StatIndex.RESISTANCE] = stats.getEffectResistance();
    }

    private void accumulateMainStat(final float[] accumulator, final HeroStats base, final AugmentedStats stats) {
        final StatType mainType = stats.getMainType();
        final float mainValue = stats.getMainValue();

        switch (mainType) {
            case ATTACKPERCENT -> accumulator[StatIndex.ATTACK] += mainValue / 100f * base.getAtk();
            case HEALTHPERCENT -> accumulator[StatIndex.HEALTH] += mainValue / 100f * base.getHp();
            case DEFENSEPERCENT -> accumulator[StatIndex.DEFENSE] += mainValue / 100f * base.getDef();
            default -> accumulator[mainType.getIndex()] += mainValue;
        }
    }

    private void accumulateScore(final float[] accumulator, final Item item, final boolean useReforgeStats) {
        accumulator[StatIndex.SCORE] = useReforgeStats ? item.getReforgedWss() : item.getWss();
    }

    private AugmentedStats selectStats(final Item item, final boolean useReforgeStats) {
        return useReforgeStats ? Objects.requireNonNull(item.getReforgedStats(), "Reforged stats missing")
                : Objects.requireNonNull(item.getAugmentedStats(), "Augmented stats missing");
    }

    private float calculateStatValue(final float flatValue, final float percentValue, final float baseStat) {
        return flatValue + (percentValue / 100f * baseStat);
    }

    public float sumStatAtIndex(final float[][] accs, final int index) {
        Objects.requireNonNull(accs, "Input array cannot be null");

        float sum = 0f;

        for (int i = 0; i < accs.length; i++) {
            final float[] currentArray = accs[i];
            Objects.requireNonNull(currentArray, String.format("Sub-array at position %d is null", i));

            if (index < 0 || index >= currentArray.length) {
                throw new IllegalArgumentException(String.format("Index %d is invalid for array at position %d (length %d)", index, i, currentArray.length));
            }

            sum += currentArray[index];
        }

        return sum;
    }

    private int calculateEhp(final float hp, final float def) {
        return (int) (hp * (def / 300 + 1));
    }

    private int calculateHpps(final float hp, final float spd) {
        return (int) (hp * (spd / 1000));
    }

    private int calculateEhpps(final int ehp, final float spd) {
        return (int) (ehp * (spd / 1000));
    }

    private int calculateDmg(final float atk, final float critRate, final float critDamage, final float penMultiplier,
            final float pctDmgMultiplier) {
        return (int) (((critRate * atk * critDamage) + (1 - critRate) * atk) * penMultiplier * pctDmgMultiplier);
    }

    private int calculateDmgps(final int dmg, final float spd) {
        return (int) (dmg * (spd / 1000));
    }

    private int calculateMcdmg(final float atk, final float critDamage, final float penMultiplier,
            final float pctDmgMultiplier) {
        return (int) (atk * critDamage * penMultiplier * pctDmgMultiplier);
    }

    private int calculateMcdmgps(final int mcdmg, final float spd) {
        return (int) (mcdmg * (spd / 1000));
    }

    private int calculateDmgh(final float hp, final float critDamage, final float penMultiplier,
            final float pctDmgMultiplier) {
        return (int) ((critDamage * hp) / 10 * penMultiplier * pctDmgMultiplier);
    }

    private int calculateDmgd(final float def, final float critDamage, final float penMultiplier,
            final float pctDmgMultiplier) {
        return (int) ((critDamage * def) * penMultiplier * pctDmgMultiplier);
    }

    private int getSkillValue(final DamageMultipliers m, final int s, final float atk, final float def, final float hp,
            final float spd, final float critDamage, final float pctDmgMultiplier, final float penSetOn) {
        final int targets = m.getTargets()[s] == 1 ? 1 : 0;
        final float realPenetration = (1 - m.getPenetration()[s]) * (1 - penSetOn * 0.15f * targets);
        final float statScalings = m.getSelfHpScaling()[s] * hp + m.getSelfAtkScaling()[s] * atk
                + m.getSelfDefScaling()[s] * def + m.getSelfSpdScaling()[s] * spd;
        final float hitTypeMultis = m.getCrit()[s] * (critDamage + m.getCdmgIncrease()[s]) + m.getHitMulti()[s];
        final float increasedValue = 1 + m.getIncreasedValue()[s];
        final float dmgUpMod = 1 + m.getSelfSpdScaling()[s] * spd;
        final float extraDamage = (m.getExtraSelfHpScaling()[s] * hp + m.getExtraSelfAtkScaling()[s] * atk
                + m.getExtraSelfDefScaling()[s] * def) * 1.871f * 1f / (getPenDefenseValue() * 0.3f / 300f + 1f);
        final float offensive = (atk * m.getRate()[s] + statScalings) * 1.871f * m.getPow()[s] * increasedValue
                * hitTypeMultis * dmgUpMod * pctDmgMultiplier;
        final float support = m.getSelfHpScaling()[s] * hp * m.getSupport()[s]
                + m.getSelfAtkScaling()[s] * atk * m.getSupport()[s]
                + m.getSelfDefScaling()[s] * def * m.getSupport()[s];
        final float defensive = 1f / (getPenDefenseValue() * Math.max(0, realPenetration) / 300f + 1f);
        return (int) (offensive * defensive + support + extraDamage);
    }

    private float calculateAtk(final float[][] accs, final int[] sets) {
        return (this.baseAttackBonus + this.sumStatAtIndex(accs, 0) + (sets[2] > 3 ? this.attackSetMultiplier : 0))
                * this.maxAttackMultiplier;
    }

    private float calculateHp(final float[][] accs, final int[] sets) {
        return (this.baseHealthBonus + this.sumStatAtIndex(accs, 1)
                + (sets[0] > 1 ? sets[0] / 2f * this.healthSetMultiplier : 0)
                + (sets[17] > 1 ? sets[17] / 2f * this.healthSetMultiplier / -2 : 0)) * this.maxHealthMultiplier;
    }

    private float calculateDef(final float[][] accs, final int[] sets) {
        return (this.baseDefenseBonus + this.sumStatAtIndex(accs, 2)
                + (sets[1] > 1 ? sets[1] / 2f * this.defenseSetMultiplier : 0)) * this.maxDefenseMultiplier;
    }

    private float calculateCr(final HeroStats base, final float[][] accs, final int[] sets, final Hero hero) {
        return (base.getCr() + this.sumStatAtIndex(accs, 6) + (sets[4] > 1 ? sets[4] / 2f * 12 : 0) + hero.getBonusCr()
                + hero.getAeiCr());
    }

    private float calculateCd(final HeroStats base, final float[][] accs, final int[] sets, final Hero hero) {
        return (base.getCd() + this.sumStatAtIndex(accs, 7) + (sets[6] > 3 ? 60 : 0) + hero.getBonusCd()
                + hero.getAeiCd());
    }

    private float calculateEff(final HeroStats base, final float[][] accs, final int[] sets, final Hero hero) {
        return (base.getEff() + this.sumStatAtIndex(accs, 8) + (sets[5] > 1 ? sets[5] / 2f * 20 : 0)
                + hero.getBonusEff() + hero.getAeiEff());
    }

    private float calculateRes(final HeroStats base, final float[][] accs, final int[] sets, final Hero hero) {
        return (base.getRes() + this.sumStatAtIndex(accs, 9) + (sets[9] > 1 ? sets[9] / 2f * 20 : 0)
                + hero.getBonusRes() + hero.getAeiRes());
    }

    private float calculateSpd(final HeroStats base, final float[][] accs, final int[] sets, final Hero hero) {
        return (base.getSpd() + this.sumStatAtIndex(accs, 10) + (sets[3] > 3 ? this.speedSetMultiplier : 0)
                + (sets[14] > 3 ? this.revengeSetMultiplier : 0) + hero.getBonusSpeed() + hero.getAeiSpeed());
    }

    private float calculateCp(final float atk, final float hp, final float def, final float spd, final float cr,
            final float cd, final float eff, final float res) {
        return (int) (((atk * 1.6f + atk * 1.6f * cr * cd) * (1.0 + (spd - 45f) * 0.02f) + hp + def * 9.3f)
                * (1f + (res / 100f + eff / 100f) / 4f));
    }

    private float calculateSetBonus(final float baseValue, final float multiplier) {
        return baseValue * multiplier;
    }

    private float calculateStatWithBonuses(final float baseValue, final float percentBonus, final float flatBonus) {
        return baseValue + (baseValue * percentBonus / 100f) + flatBonus;
    }

    private float calculatePenetrationBonus(final int defenseValue) {
        return (defenseValue / 300f + 1) / (0.00283333f * defenseValue + 1);
    }

    public static boolean isRageSetEnabled() {
        return config.isRageSetEnabled();
    }

    public static void setSettingRageSet(final boolean enabled) {
        config.setRageSetEnabled(enabled);
    }

    public static boolean isPenSetEnabled() {
        return config.isPenSetEnabled();
    }

    public static void setSettingPenSet(final boolean enabled) {
        config.setPenSetEnabled(enabled);
    }

    public static int getPenDefenseValue() {
        return config.getPenDefenseValue();
    }

    public static void setSettingPenDefense(final int value) {
        config.penDefenseValue = Math.clamp(value, 0, 10_000);
    }
}