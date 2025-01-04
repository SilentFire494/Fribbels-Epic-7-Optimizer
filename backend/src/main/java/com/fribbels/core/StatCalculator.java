package com.fribbels.core;

import com.fribbels.enums.StatType;
import com.fribbels.model.*;

import java.util.Map;

import static com.fribbels.handler.OptimizationRequestHandler.SET_COUNT;

/**
 * The StatCalculator class provides methods for calculating and manipulating
 * the stats of heroes
 * based on their base stats, items equipped, and various bonuses.
 */
public class StatCalculator {

    private static boolean settingRageSet = true;
    private static boolean settingPenSet = true;
    private static int settingPenDefense = 1500;

    private float atkSetBonus;
    private float hpSetBonus;
    private float defSetBonus;
    private float speedSetBonus;
    private float revengeSetBonus;

    private float bonusBaseAtk;
    private float bonusBaseHp;
    private float bonusBaseDef;

    private float bonusMaxAtk;
    private float bonusMaxHp;
    private float bonusMaxDef;

    private float penSetDmgBonus;

    public StatCalculator() {

    }

    /**
     * Sets the base values for attack, health, defense, and speed based on the
     * hero's stats and the base stats.
     *
     * @param base The base stats of the hero.
     * @param hero The hero whose stats will be modified.
     */
    public void setBaseValues(final HeroStats base, final Hero hero) {
        atkSetBonus = 0.45f * base.getAtk();
        hpSetBonus = 0.20f * base.getHp();
        defSetBonus = 0.20f * base.getDef();

        speedSetBonus = 0.25f * base.getSpd();
        revengeSetBonus = 0.12f * base.getSpd();

        bonusBaseAtk = base.getAtk() + base.getAtk() * (hero.getBonusAtkPercent() + hero.getAeiAtkPercent()) / 100f
                + hero.getBonusAtk() + hero.getAeiAtk();
        bonusBaseHp = base.getHp() + base.getHp() * (hero.getBonusHpPercent() + hero.getAeiHpPercent()) / 100f
                + hero.getBonusHp() + hero.getAeiHp();
        bonusBaseDef = base.getDef() + base.getDef() * (hero.getBonusDefPercent() + hero.getAeiDefPercent()) / 100f
                + hero.getBonusDef() + hero.getAeiDef();

        if (base.getBonusStats() == null) {
            bonusMaxAtk = 1 + hero.getFinalAtkMultiplier() / 100;
            bonusMaxHp = 1 + hero.getFinalHpMultiplier() / 100;
            bonusMaxDef = 1 + hero.getFinalDefMultiplier() / 100;
        } else {
            bonusMaxAtk = 1 + base.getBonusStats().getBonusMaxAtkPercent() / 100f + hero.getFinalAtkMultiplier() / 100;
            bonusMaxHp = 1 + base.getBonusStats().getBonusMaxHpPercent() / 100f + hero.getFinalHpMultiplier() / 100;
            bonusMaxDef = 1 + base.getBonusStats().getBonusMaxDefPercent() / 100f + hero.getFinalDefMultiplier() / 100;
        }

        penSetDmgBonus = (settingPenDefense / 300f + 1) / (0.00283333f * settingPenDefense + 1);
    }

    /**
     * Returns an array of new stat values based on the base hero stats, item
     * equipped, and whether reforged stats are used.
     *
     * @param bas             The base stats of the hero.
     * @param ite             The item equipped by the hero.
     * @param useReforgeStats Whether to use reforged stats or augmented stats.
     * @return An array of updated stat values.
     */
    public float[] getNewStatAccumulatorArr(final HeroStats base, final Item item, final boolean useReforgeStats) {

        final float[] accumulator = buildStatAccumulatorArr(base, item, useReforgeStats);
        item.setTempStatAccArr(accumulator);
        return accumulator;
    }

    /**
     * Adds the stat accumulator arrays to the hero's stats after applying various
     * modifications.
     *
     * @param bas             The base stats of the hero.
     * @param acc             The stat accumulator arrays.
     * @param set             The sets of items equipped.
     * @param her             The hero whose stats are being modified.
     * @param upgrades        The number of upgrades.
     * @param conversions     The number of conversions.
     * @param alreadyEquipped The number of already equipped items.
     * @param priority        The priority for the stat calculation.
     * @return The new hero stats after applying the accumulators.
     */
    public HeroStats addAccumulatorArrsToHero(final HeroStats base, final float[][] accs, final int[] sets,
            final Hero hero, final int upgrades, final int conversions, final int alreadyEquipped, final int priority) {
        final float[] accs0 = accs[0];
        final float[] accs1 = accs[1];
        final float[] accs2 = accs[2];
        final float[] accs3 = accs[3];
        final float[] accs4 = accs[4];
        final float[] accs5 = accs[5];

        final float atk = ((bonusBaseAtk + accs0[0] + accs1[0] + accs2[0] + accs3[0] + accs4[0] + accs5[0]
                + (sets[2] > 3 ? atkSetBonus : 0)) * bonusMaxAtk);
        final float hp = ((bonusBaseHp + accs0[1] + accs1[1] + accs2[1] + accs3[1] + accs4[1] + accs5[1]
                + (sets[0] > 1 ? sets[0] / 2 * hpSetBonus : 0) + (sets[17] > 1 ? sets[17] / 2 * hpSetBonus / -2 : 0))
                * bonusMaxHp);
        final float def = ((bonusBaseDef + accs0[2] + accs1[2] + accs2[2] + accs3[2] + accs4[2] + accs5[2]
                + (sets[1] > 1 ? sets[1] / 2 * defSetBonus : 0)) * bonusMaxDef);
        final float cr = (base.getCr() + accs0[6] + accs1[6] + accs2[6] + accs3[6] + accs4[6] + accs5[6]
                + (sets[4] > 1 ? sets[4] / 2 * 12 : 0) + hero.getBonusCr() + hero.getAeiCr());

        final int cd = (int) (base.getCd() + accs0[7] + accs1[7] + accs2[7] + accs3[7] + accs4[7] + accs5[7]
                + (sets[6] > 3 ? 60 : 0) + hero.getBonusCd() + hero.getAeiCd());
        final int eff = (int) (base.getEff() + accs0[8] + accs1[8] + accs2[8] + accs3[8] + accs4[8] + accs5[8]
                + (sets[5] > 1 ? sets[5] / 2 * 20 : 0) + hero.getBonusEff() + hero.getAeiEff());
        final int res = (int) (base.getRes() + accs0[9] + accs1[9] + accs2[9] + accs3[9] + accs4[9] + accs5[9]
                + (sets[9] > 1 ? sets[9] / 2 * 20 : 0) + hero.getBonusRes() + hero.getAeiRes());
        final int spd = (int) (base.getSpd() + accs0[10] + accs1[10] + accs2[10] + accs3[10] + accs4[10] + accs5[10]
                + (sets[3] > 3 ? speedSetBonus : 0) + (sets[14] > 3 ? revengeSetBonus : 0) + hero.getBonusSpeed()
                + hero.getAeiSpeed());

        final float critRate = cr > 100 ? 1 : cr / 100f;
        final float critDamage = cd > 350 ? 3.5f : cd / 100f;

        final int cp = (int) (((atk * 1.6f + atk * 1.6f * critRate * critDamage) * (1.0 + (spd - 45f) * 0.02f) + hp
                + def * 9.3f) * (1f + (res / 100f + eff / 100f) / 4f));

        final float penSetOn = sets[13] > 1 ? 1 : 0;
        final float rageMultiplier = settingRageSet && sets[11] > 3 ? 0.3f : 0;
        final float penMultiplier = settingPenSet && sets[13] > 1 ? penSetDmgBonus : 1;
        final float torrentMultiplier = sets[17] > 1 ? sets[17] / 2 * 0.1f : 0;
        final float spdDiv1000 = (float) spd / 1000;
        final float pctDmgMultiplier = 1 + rageMultiplier + torrentMultiplier;

        final int ehp = (int) (hp * (def / 300 + 1));
        final int hpps = (int) (hp * spdDiv1000);
        final int ehpps = (int) (ehp * spdDiv1000);
        final int dmg = (int) (((critRate * atk * critDamage) + (1 - critRate) * atk) * penMultiplier
                * pctDmgMultiplier);
        final int dmgps = (int) (dmg * spdDiv1000);
        final int mcdmg = (int) (atk * critDamage * penMultiplier * pctDmgMultiplier);
        final int mcdmgps = (int) (mcdmg * spdDiv1000);
        final int dmgh = (int) ((critDamage * hp) / 10 * penMultiplier * pctDmgMultiplier);
        final int dmgd = (int) ((critDamage * def) * penMultiplier * pctDmgMultiplier);

        DamageMultipliers multis = hero.getDamageMultipliers();
        multis = multis == null ? new DamageMultipliers() : multis;

        final int s1 = getSkillValue(multis, 0, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);
        final int s2 = getSkillValue(multis, 1, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);
        final int s3 = getSkillValue(multis, 2, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);
        final int score = (int) (accs0[11] + accs1[11] + accs2[11] + accs3[11] + accs4[11] + accs5[11]);

        final float bsHp = (hp - base.getHp() - hero.getArtifactHealth() - (sets[0] > 1 ? sets[0] / 2 * hpSetBonus : 0)
                + (sets[17] > 1 ? sets[17] / 2 * hpSetBonus / 2 : 0)) / base.getHp() * 100;
        final float bsAtk = (atk - base.getAtk() - hero.getArtifactAttack()
                - (sets[2] > 1 ? sets[2] / 4 * atkSetBonus : 0)) / base.getAtk() * 100;
        final float bsDef = (def - base.getDef() - (sets[1] > 1 ? sets[1] / 2 * defSetBonus : 0)) / base.getDef() * 100;
        final float bsCr = (cr - base.getCr() - (sets[4] > 1 ? sets[4] / 2 * 12 : 0));
        final float bsCd = (cd - base.getCd() - (sets[6] > 3 ? 60 : 0));
        final float bsEff = (eff - base.getEff() - (sets[5] > 1 ? sets[5] / 2 * 20 : 0));
        final float bsRes = (res - base.getRes() - (sets[9] > 1 ? sets[9] / 2 * 20 : 0));
        final float bsSpd = (spd - base.getSpd() - (sets[3] > 3 ? speedSetBonus : 0)
                - (sets[14] > 3 ? revengeSetBonus : 0));

        final int bs = (int) (bsHp + bsAtk + bsDef + bsCr * 1.6f + bsCd * 1.14f + bsEff + bsRes + bsSpd * 2);

        return new HeroStats((int) atk, (int) hp, (int) def, (int) cr, cd, eff, res, 0, spd, cp, ehp, hpps, ehpps, dmg,
                dmgps, mcdmg, mcdmgps, dmgh, dmgd, s1, s2, s3, upgrades, conversions, alreadyEquipped, score, bs,
                priority, base.getBonusStats(), null, null, null, null, null, null, null);
    }

    /**
     * Retrieves the stat accumulator array for a given item based on the hero's
     * base stats and whether reforged stats are used.
     *
     * @param bas                  The base stats of the hero.
     * @param ite                  The item equipped by the hero.
     * @param accumulatorsByItemId A map of stat accumulators by item ID.
     * @param useReforgeStats      Whether to use reforged stats.
     * @return The stat accumulator array.
     */
    public float[] getStatAccumulatorArr(final HeroStats base, final Item item,
            final Map<String, float[]> accumulatorsByItemId, final boolean useReforgeStats) {
        if (accumulatorsByItemId.containsKey(item.getModId())) {
            return accumulatorsByItemId.get(item.getModId());
        }

        final float[] accumulator = buildStatAccumulatorArr(base, item, useReforgeStats);
        accumulatorsByItemId.put(item.getModId(), accumulator);
        return accumulator;
    }

    /**
     * Builds an array of stat values for a given item based on the hero's base
     * stats and whether reforged stats are used.
     *
     * @param bas             The base stats of the hero.
     * @param ite             The item equipped by the hero.
     * @param useReforgeStats Whether to use reforged stats.
     * @return An array of stat values.
     */
    public float[] buildStatAccumulatorArr(final HeroStats base, final Item item, final boolean useReforgeStats) {
        final AugmentedStats stats;
        if (useReforgeStats) {
            stats = item.getReforgedStats();
        } else {
            stats = item.getAugmentedStats();
        }

        final float[] statAccumulatorArr = new float[15];

        statAccumulatorArr[0] += stats.getAttack() + stats.getAttackPercent() / 100f * base.getAtk();
        statAccumulatorArr[1] += stats.getHealth() + stats.getHealthPercent() / 100f * base.getHp();
        statAccumulatorArr[2] += stats.getDefense() + stats.getDefensePercent() / 100f * base.getDef();

        statAccumulatorArr[10] += stats.getSpeed();
        statAccumulatorArr[6] += stats.getCritRate();
        statAccumulatorArr[7] += stats.getCritDamage();
        statAccumulatorArr[8] += stats.getEffectiveness();
        statAccumulatorArr[9] += stats.getEffectResistance();

        final StatType mainType = stats.getMainType();
        final int mainTypeIndex = mainType.getIndex();

        if (mainTypeIndex == 3) {
            statAccumulatorArr[0] += stats.getMainValue() / 100f * base.getAtk();
        } else if (mainType == StatType.HEALTHPERCENT) {
            statAccumulatorArr[1] += stats.getMainValue() / 100f * base.getHp();
        } else if (mainType == StatType.DEFENSEPERCENT) {
            statAccumulatorArr[2] += stats.getMainValue() / 100f * base.getDef();
        } else {
            statAccumulatorArr[mainTypeIndex] += stats.getMainValue();
        }

        statAccumulatorArr[11] += useReforgeStats ? item.getReforgedWss() : item.getWss();

        return statAccumulatorArr;
    }

    /**
     * Builds an array representing the sets of items equipped by the hero.
     *
     * @param items The items equipped by the hero.
     * @return An array representing the sets.
     */
    public int[] buildSetsArr(final Item[] items) {
        final int[] sets = new int[SET_COUNT];
        sets[items[0].getSet().getIndex()]++;
        sets[items[1].getSet().getIndex()]++;
        sets[items[2].getSet().getIndex()]++;
        sets[items[3].getSet().getIndex()]++;
        sets[items[4].getSet().getIndex()]++;
        sets[items[5].getSet().getIndex()]++;
        return sets;
    }

    /**
     * Retrieves the stat value for a specific skill based on the given multipliers
     * and hero stats.
     *
     * @param The              damage multipliers for the hero's skills.
     * @param The              skill index.
     * @param at               The hero's attack value.
     * @param de               The hero's defense value.
     * @param h                The hero's health value.
     * @param sp               The hero's speed value.
     * @param critDamage       The hero's critical damage value.
     * @param pctDmgMultiplier The percentage damage multiplier.
     * @param penSetOn         Whether the penetration set is active.
     * @return The calculated skill value.
     */
    private int getSkillValue(final DamageMultipliers m, final int s, final float atk, final float def, final float hp,
            final float spd, final float critDamage, final float pctDmgMultiplier, final float penSetOn) {
        final int targetS = m.getTargets()[s] == 1 ? 1 : 0;
        final float realPenetration = (1 - m.getPenetration()[s]) * (1 - penSetOn * 0.15f * targetS);
        final float statScalings = m.getSelfHpScaling()[s] * hp + m.getSelfAtkScaling()[s] * atk
                + m.getSelfDefScaling()[s] * def + m.getSelfSpdScaling()[s] * spd;
        final float hitTypeMultis = m.getCrit()[s] * (critDamage + m.getCdmgIncrease()[s]) + m.getHitMulti()[s];
        final float increasedValue = 1 + m.getIncreasedValue()[s];
        final float dmgUpMod = 1 + m.getSelfSpdScaling()[s] * spd;
        final float extraDamage = (m.getExtraSelfHpScaling()[s] * hp + m.getExtraSelfAtkScaling()[s] * atk
                + m.getExtraSelfDefScaling()[s] * def) * 1.871f * 1f
                / (StatCalculator.settingPenDefense * 0.3f / 300f + 1f);
        final float offensive = (atk * m.getRate()[s] + statScalings) * 1.871f * m.getPow()[s] * increasedValue
                * hitTypeMultis * dmgUpMod * pctDmgMultiplier;
        final float support = m.getSelfHpScaling()[s] * hp * m.getSupport()[s]
                + m.getSelfAtkScaling()[s] * atk * m.getSupport()[s]
                + m.getSelfDefScaling()[s] * def * m.getSupport()[s];
        final float defensive = 1f / (StatCalculator.settingPenDefense * Math.max(0, realPenetration) / 300f + 1f);
        return (int) (offensive * defensive + support + extraDamage);
    }

    /**
     * Retrieves the bonus base attack value.
     *
     * @return The bonus base attack value.
     */
    public static boolean isSettingRageSet() {
        return settingRageSet;
    }

    /**
     * Sets the bonus base attack value.
     *
     * @param settingRageSet The bonus base attack value.
     */
    public static void setSettingRageSet(boolean settingRageSet) {
        StatCalculator.settingRageSet = settingRageSet;
    }

    /**
     * Retrieves the bonus base health value.
     *
     * @return The bonus base health value.
     */
    public static boolean isSettingPenSet() {
        return settingPenSet;
    }

    /**
     * Sets the bonus base health value.
     *
     * @param settingPenSet The bonus base health value.
     */
    public static void setSettingPenSet(boolean settingPenSet) {
        StatCalculator.settingPenSet = settingPenSet;
    }

    /**
     * Retrieves the bonus base defense value.
     *
     * @return The bonus base defense value.
     */
    public static int getSettingPenDefense() {
        return settingPenDefense;
    }

    /**
     * Sets the bonus base defense value.
     *
     * @param settingPenDefense The bonus base defense value.
     */
    public static void setSettingPenDefense(int settingPenDefense) {
        StatCalculator.settingPenDefense = settingPenDefense;
    }

}