package com.fribbels.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.fribbels.enums.Gear;
import com.fribbels.enums.StatType;
import com.fribbels.request.BonusStatsRequest;
import com.fribbels.request.ModStatsRequest;
import com.fribbels.request.OptimizationRequest;
import com.fribbels.request.SkillOptionsRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@Getter
@Setter
@With
@Builder
@ToString
public class Hero {

    private int atk;
    private int hp;
    private int def;
    private int cr;
    private int cd;
    private int eff;
    private int res;
    private int spd;

    private int ehp;
    private int hpps;
    private int ehpps;
    private int dmg;
    private int dmgps;
    private int mcdmg;
    private int mcdmgps;
    private int dmgh;
    private int dmgd;

    private int s1;
    private int s2;
    private int s3;

    private int upgrades;
    private int score;
    private int bs;
    private int priority;
    private int conversions;

    private String id;
    private String name;
    private int index;
    private int rarity;
    private int stars;
    private String attribute;
    private String role;

    private int bonusAtk;
    private int bonusDef;
    private int bonusHp;
    private float bonusAtkPercent;
    private float bonusDefPercent;
    private float bonusHpPercent;
    private int bonusSpeed;
    private float bonusCr;
    private float bonusCd;
    private float bonusEff;
    private float bonusRes;

    private float aeiAtk;
    private float aeiDef;
    private float aeiHp;
    private float aeiAtkPercent;
    private float aeiDefPercent;
    private float aeiHpPercent;
    private int aeiSpeed;
    private float aeiCr;
    private float aeiCd;
    private float aeiEff;
    private float aeiRes;

    private float finalAtkMultiplier;
    private float finalDefMultiplier;
    private float finalHpMultiplier;

    private float artifactAttack;
    private float artifactHealth;
    private float artifactDefense;

    private String artifactName;
    private String artifactLevel;
    private String imprintNumber;
    private String eeNumber;

    private int bonusMaxAtkPercent;
    private int bonusMaxDefPercent;
    private int bonusMaxHpPercent;

    private String modGrade;
    private String keepStatOptions;
    private Float rollQuality;
    private Integer limitRolls;
    private List<StatType> keepStats;
    private List<StatType> ignoreStats;
    private List<StatType> discardStats;

    private int[] sets;
    private int cp;

    private Map<Gear, Item> equipment;

    private List<HeroStats> builds;

    private OptimizationRequest optimizationRequest;

    private HeroSkillOptions skillOptions;
    private DamageMultipliers damageMultipliers;
    private HeroSkills skills;

    public DamageMultipliers getDamageMultipliers() {
        if (this.damageMultipliers != null) {
            return this.damageMultipliers;
        }
        if (this.skills == null || this.skills.S1[0].name == null) {
            this.skills = HeroSkills.builder()
                    .S1(new SkillData[] { SkillData.builder().build(), SkillData.builder().build(),
                            SkillData.builder().build() })
                    .S2(new SkillData[] { SkillData.builder().build(), SkillData.builder().build(),
                            SkillData.builder().build() })
                    .S3(new SkillData[] { SkillData.builder().build(), SkillData.builder().build(),
                            SkillData.builder().build() })
                    .build();
        }
        if (this.skillOptions == null) {
            return DamageMultipliers.builder()
                    .rate(new Float[] { this.skills.S1[0].rate, this.skills.S2[0].rate, this.skills.S3[0].rate })
                    .pow(new Float[] { this.skills.S1[0].pow, this.skills.S2[0].pow, this.skills.S3[0].pow })
                    .targets(new Integer[] { this.skills.S1[0].targets, this.skills.S2[0].targets, this.skills.S3[0].targets })
                    .selfHpScaling(new Float[] { this.skills.S1[0].selfHpScaling, this.skills.S2[0].selfHpScaling,
                            this.skills.S3[0].selfHpScaling })
                    .selfAtkScaling(new Float[] { this.skills.S1[0].selfAtkScaling, this.skills.S2[0].selfAtkScaling,
                            this.skills.S3[0].selfAtkScaling })
                    .selfDefScaling(new Float[] { this.skills.S1[0].selfDefScaling, this.skills.S2[0].selfDefScaling,
                            this.skills.S3[0].selfDefScaling })
                    .selfSpdScaling(new Float[] { this.skills.S1[0].selfSpdScaling, this.skills.S2[0].selfSpdScaling,
                            this.skills.S3[0].selfSpdScaling })
                    .increasedValue(new Float[] { this.skills.S1[0].increasedValue, this.skills.S2[0].increasedValue,
                            this.skills.S3[0].increasedValue })
                    .extraSelfHpScaling(new Float[] { this.skills.S1[0].extraSelfHpScaling, this.skills.S2[0].extraSelfHpScaling,
                            this.skills.S3[0].extraSelfHpScaling })
                    .extraSelfDefScaling(new Float[] { this.skills.S1[0].extraSelfDefScaling,
                            this.skills.S2[0].extraSelfDefScaling, this.skills.S3[0].extraSelfDefScaling })
                    .extraSelfAtkScaling(new Float[] { this.skills.S1[0].extraSelfAtkScaling,
                            this.skills.S2[0].extraSelfAtkScaling, this.skills.S3[0].extraSelfAtkScaling })
                    .cdmgIncrease(new Float[] { this.skills.S1[0].cdmgIncrease, this.skills.S2[0].cdmgIncrease,
                            this.skills.S3[0].cdmgIncrease })
                    .penetration(new Float[] { this.skills.S1[0].penetration, this.skills.S2[0].penetration,
                            this.skills.S3[0].penetration })
                    .hitMulti(new Float[] { this.calculateHitMulti(this.skills.S1[0].name),
                            this.calculateHitMulti(this.skills.S2[0].name), this.calculateHitMulti(this.skills.S3[0].name) })
                    .support(new Float[] { this.calculateSupport(this.skills.S1[0].name),
                            this.calculateSupport(this.skills.S2[0].name), this.calculateSupport(this.skills.S3[0].name) })
                    .crit(new Float[] { this.calculateCrit(this.skills.S1[0].name), this.calculateCrit(this.skills.S2[0].name),
                            this.calculateCrit(this.skills.S3[0].name) })
                    .build();
        } else {
            final SkillData s1 = Arrays.stream(this.skills.S1)
                    .filter(x -> x.name.equals(this.skillOptions.getS1().skillEffect)).findFirst()
                    .orElse(this.skills.S1[0]);
            final SkillData s2 = Arrays.stream(this.skills.S2)
                    .filter(x -> x.name.equals(this.skillOptions.getS2().skillEffect)).findFirst()
                    .orElse(this.skills.S2[0]);
            final SkillData s3 = Arrays.stream(this.skills.S3)
                    .filter(x -> x.name.equals(this.skillOptions.getS3().skillEffect)).findFirst()
                    .orElse(this.skills.S3[0]);
            return DamageMultipliers.builder()
                    .rate(new Float[] { s1.rate, s2.rate, s3.rate })
                    .pow(new Float[] { s1.pow, s2.pow, s3.pow })
                    .targets(new Integer[] { s1.targets, s2.targets, s3.targets })
                    .selfHpScaling(new Float[] { s1.selfHpScaling, s2.selfHpScaling, s3.selfHpScaling })
                    .selfAtkScaling(new Float[] { s1.selfAtkScaling, s2.selfAtkScaling, s3.selfAtkScaling })
                    .selfDefScaling(new Float[] { s1.selfDefScaling, s2.selfDefScaling, s3.selfDefScaling })
                    .selfSpdScaling(new Float[] { s1.selfSpdScaling, s2.selfSpdScaling, s3.selfSpdScaling })
                    .increasedValue(new Float[] { s1.increasedValue, s2.increasedValue, s3.increasedValue })
                    .extraSelfHpScaling(
                            new Float[] { s1.extraSelfHpScaling, s2.extraSelfHpScaling, s3.extraSelfHpScaling })
                    .extraSelfDefScaling(
                            new Float[] { s1.extraSelfDefScaling, s2.extraSelfDefScaling, s3.extraSelfDefScaling })
                    .extraSelfAtkScaling(
                            new Float[] { s1.extraSelfAtkScaling, s2.extraSelfAtkScaling, s3.extraSelfAtkScaling })
                    .cdmgIncrease(new Float[] { s1.cdmgIncrease, s2.cdmgIncrease, s3.cdmgIncrease })
                    .penetration(new Float[] { s1.penetration, s2.penetration, s3.penetration })
                    .hitMulti(new Float[] { this.calculateHitMulti(this.getSkillOptionsByIndex(0).skillEffect),
                            this.calculateHitMulti(this.getSkillOptionsByIndex(1).skillEffect),
                            this.calculateHitMulti(this.getSkillOptionsByIndex(2).skillEffect) })
                    .support(new Float[] { this.calculateSupport(this.getSkillOptionsByIndex(0).skillEffect),
                            this.calculateSupport(this.getSkillOptionsByIndex(1).skillEffect),
                            this.calculateSupport(this.getSkillOptionsByIndex(2).skillEffect) })
                    .crit(new Float[] { this.calculateCrit(this.getSkillOptionsByIndex(0).skillEffect),
                            this.calculateCrit(this.getSkillOptionsByIndex(1).skillEffect),
                            this.calculateCrit(this.getSkillOptionsByIndex(2).skillEffect) })
                    .build();
        }
    }

    private SingleSkillOptions getSkillOptionsByIndex(final int skill) {
        if (skill == 0)
            return this.skillOptions.S1;
        if (skill == 1)
            return this.skillOptions.S2;
        return this.skillOptions.S3;
    }

    private float calculateSupport(final String name) {
        if (name.contains("heal") ||
                "barrier".equals(name)) {
            return 1f;
        }
        return 0f;
    }

    private float calculateCrit(final String name) {
        if (name.contains("crit")) {
            return 1f;
        }
        return 0f;
    }

    private Float calculateHitMulti(final String name) {
        if (name.contains("crit")) {
            return 0f;
        }
        if (name.contains("crushing")) {
            return 1.3f;
        }
        if (name.contains("normal")) {
            return 1f;
        }
        if (name.contains("miss")) {
            return 0.75f;
        }
        return 0f;
    }

    public Item switchItem(final Item item) {
        final Gear gear = item.getGear();
        final Item previousItem = this.addToEquipment(gear, item);

        if (previousItem != null) {
            return previousItem;
        }

        return null;
    }

    private Item addToEquipment(final Gear gear, final Item item) {
        if (this.equipment == null) {
            this.equipment = new EnumMap<>(Gear.class);
        }

        return this.equipment.put(gear, item);
    }

    public void setModStats(final ModStatsRequest modStatsRequest) {
        this.modGrade = modStatsRequest.getModGrade();
        this.keepStatOptions = modStatsRequest.getKeepStatOptions();
        this.rollQuality = modStatsRequest.getRollQuality();
        this.limitRolls = modStatsRequest.getLimitRolls();
        this.keepStats = modStatsRequest.getKeepStats();
        this.ignoreStats = modStatsRequest.getIgnoreStats();
        this.discardStats = modStatsRequest.getDiscardStats();
    }

    public void setBonusStats(final BonusStatsRequest bonusStats) {
        this.bonusAtk = bonusStats.getAtk();
        this.bonusDef = bonusStats.getDef();
        this.bonusHp = bonusStats.getHp();
        this.bonusAtkPercent = bonusStats.getAtkPercent();
        this.bonusDefPercent = bonusStats.getDefPercent();
        this.bonusHpPercent = bonusStats.getHpPercent();
        this.bonusSpeed = bonusStats.getSpeed();
        this.bonusCr = bonusStats.getCr();
        this.bonusCd = bonusStats.getCd();
        this.bonusEff = bonusStats.getEff();
        this.bonusRes = bonusStats.getRes();

        this.aeiAtk = bonusStats.getAeiAtk();
        this.aeiDef = bonusStats.getAeiDef();
        this.aeiHp = bonusStats.getAeiHp();
        this.aeiAtkPercent = bonusStats.getAeiAtkPercent();
        this.aeiDefPercent = bonusStats.getAeiDefPercent();
        this.aeiHpPercent = bonusStats.getAeiHpPercent();
        this.aeiSpeed = bonusStats.getAeiSpeed();
        this.aeiCr = bonusStats.getAeiCr();
        this.aeiCd = bonusStats.getAeiCd();
        this.aeiEff = bonusStats.getAeiEff();
        this.aeiRes = bonusStats.getAeiRes();

        this.finalAtkMultiplier = bonusStats.getFinalAtkMultiplier();
        this.finalDefMultiplier = bonusStats.getFinalDefMultiplier();
        this.finalHpMultiplier = bonusStats.getFinalHpMultiplier();

        this.artifactAttack = bonusStats.getArtifactAttack();
        this.artifactHealth = bonusStats.getArtifactHealth();
        this.artifactDefense = bonusStats.getArtifactDefense();
        this.artifactName = bonusStats.getArtifactName();
        this.artifactLevel = bonusStats.getArtifactLevel();
        
        this.imprintNumber = bonusStats.getImprintNumber();
        this.eeNumber = bonusStats.getEeNumber();

        this.stars = bonusStats.getStars();
    }

    public void setSkillOptions(final SkillOptionsRequest request) {
        this.skillOptions = request.getSkillOptions();
    }

    public Map<Gear, Item> getEquipment() {
        if (this.equipment == null) {
            this.equipment = new EnumMap<>(Gear.class);
        }

        return this.equipment;
    }

    public void setStats(final HeroStats heroStats) {
        this.atk = heroStats.getAtk();
        this.hp = heroStats.getHp();
        this.def = heroStats.getDef();
        this.cr = heroStats.getCr();
        this.cd = heroStats.getCd();
        this.eff = heroStats.getEff();
        this.res = heroStats.getRes();
        this.spd = heroStats.getSpd();

        this.cp = heroStats.getCp();
        this.sets = heroStats.getSets();

        this.ehp = heroStats.getEhp();
        this.ehpps = heroStats.getEhpps();
        this.hpps = heroStats.getHpps();
        this.dmg = heroStats.getDmg();
        this.dmgps = heroStats.getDmgps();
        this.mcdmg = heroStats.getMcdmg();
        this.mcdmgps = heroStats.getMcdmgps();
        this.dmgh = heroStats.getDmgh();
        this.dmgd = heroStats.getDmgd();

        this.s1 = heroStats.getS1();
        this.s2 = heroStats.getS2();
        this.s3 = heroStats.getS3();

        this.upgrades = heroStats.getUpgrades();
        this.score = heroStats.getScore();
        this.bs = heroStats.getBs();
        this.priority = heroStats.getPriority();
        this.conversions = heroStats.getConversions();
    }
}
