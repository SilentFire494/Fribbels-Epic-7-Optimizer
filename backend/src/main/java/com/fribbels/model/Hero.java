package com.fribbels.model;

import com.fribbels.enums.Gear;
import com.fribbels.enums.StatType;
import com.fribbels.request.BonusStatsRequest;
import com.fribbels.request.ModStatsRequest;
import com.fribbels.request.OptimizationRequest;
import com.fribbels.request.SkillOptionsRequest;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Hero {

    private int atk;
    private int hp;
    private int def;
    private int cr;
    private int cd;
    private int eff;
    private int res;
    private int dac;
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

    public Hero(int atk, int hp, int def, int cr, int cd, int eff, int res, int dac, int spd, int ehp, int hpps,
            int ehpps, int dmg, int dmgps, int mcdmg, int mcdmgps, int dmgh, int dmgd, int s1, int s2, int s3,
            int upgrades, int score, int bs, int priority, int conversions, String id, String name, int index,
            int rarity, int stars, String attribute, String role, int bonusAtk, int bonusDef, int bonusHp,
            float bonusAtkPercent, float bonusDefPercent, float bonusHpPercent, int bonusSpeed, float bonusCr,
            float bonusCd, float bonusEff, float bonusRes, float aeiAtk, float aeiDef, float aeiHp, float aeiAtkPercent,
            float aeiDefPercent, float aeiHpPercent, int aeiSpeed, float aeiCr, float aeiCd, float aeiEff, float aeiRes,
            float finalAtkMultiplier, float finalDefMultiplier, float finalHpMultiplier, float artifactAttack,
            float artifactHealth, String artifactName, String artifactLevel, String imprintNumber, String eeNumber,
            int bonusMaxAtkPercent, int bonusMaxDefPercent, int bonusMaxHpPercent, String modGrade,
            String keepStatOptions, Float rollQuality, Integer limitRolls, List<StatType> keepStats,
            List<StatType> ignoreStats, List<StatType> discardStats, int[] sets, int cp, Map<Gear, Item> equipment,
            List<HeroStats> builds, OptimizationRequest optimizationRequest, HeroSkillOptions skillOptions,
            DamageMultipliers damageMultipliers, HeroSkills skills) {
        this.atk = atk;
        this.hp = hp;
        this.def = def;
        this.cr = cr;
        this.cd = cd;
        this.eff = eff;
        this.res = res;
        this.dac = dac;
        this.spd = spd;
        this.ehp = ehp;
        this.hpps = hpps;
        this.ehpps = ehpps;
        this.dmg = dmg;
        this.dmgps = dmgps;
        this.mcdmg = mcdmg;
        this.mcdmgps = mcdmgps;
        this.dmgh = dmgh;
        this.dmgd = dmgd;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.upgrades = upgrades;
        this.score = score;
        this.bs = bs;
        this.priority = priority;
        this.conversions = conversions;
        this.id = id;
        this.name = name;
        this.index = index;
        this.rarity = rarity;
        this.stars = stars;
        this.attribute = attribute;
        this.role = role;
        this.bonusAtk = bonusAtk;
        this.bonusDef = bonusDef;
        this.bonusHp = bonusHp;
        this.bonusAtkPercent = bonusAtkPercent;
        this.bonusDefPercent = bonusDefPercent;
        this.bonusHpPercent = bonusHpPercent;
        this.bonusSpeed = bonusSpeed;
        this.bonusCr = bonusCr;
        this.bonusCd = bonusCd;
        this.bonusEff = bonusEff;
        this.bonusRes = bonusRes;
        this.aeiAtk = aeiAtk;
        this.aeiDef = aeiDef;
        this.aeiHp = aeiHp;
        this.aeiAtkPercent = aeiAtkPercent;
        this.aeiDefPercent = aeiDefPercent;
        this.aeiHpPercent = aeiHpPercent;
        this.aeiSpeed = aeiSpeed;
        this.aeiCr = aeiCr;
        this.aeiCd = aeiCd;
        this.aeiEff = aeiEff;
        this.aeiRes = aeiRes;
        this.finalAtkMultiplier = finalAtkMultiplier;
        this.finalDefMultiplier = finalDefMultiplier;
        this.finalHpMultiplier = finalHpMultiplier;
        this.artifactAttack = artifactAttack;
        this.artifactHealth = artifactHealth;
        this.artifactName = artifactName;
        this.artifactLevel = artifactLevel;
        this.imprintNumber = imprintNumber;
        this.eeNumber = eeNumber;
        this.bonusMaxAtkPercent = bonusMaxAtkPercent;
        this.bonusMaxDefPercent = bonusMaxDefPercent;
        this.bonusMaxHpPercent = bonusMaxHpPercent;
        this.modGrade = modGrade;
        this.keepStatOptions = keepStatOptions;
        this.rollQuality = rollQuality;
        this.limitRolls = limitRolls;
        this.keepStats = keepStats;
        this.ignoreStats = ignoreStats;
        this.discardStats = discardStats;
        this.sets = sets;
        this.cp = cp;
        this.equipment = equipment;
        this.builds = builds;
        this.optimizationRequest = optimizationRequest;
        this.skillOptions = skillOptions;
        this.damageMultipliers = damageMultipliers;
        this.skills = skills;
    }

    public DamageMultipliers getDamageMultipliers() {
        if (damageMultipliers != null) {
            return damageMultipliers;
        }
        if (skills == null || skills.getS1()[0].getName() == null) {
            skills = HeroSkills.builder()
                    .s1(new SkillData[] { SkillData.builder().build(), SkillData.builder().build(),
                            SkillData.builder().build() })
                    .s2(new SkillData[] { SkillData.builder().build(), SkillData.builder().build(),
                            SkillData.builder().build() })
                    .s3(new SkillData[] { SkillData.builder().build(), SkillData.builder().build(),
                            SkillData.builder().build() })
                    .build();
        }
        if (skillOptions == null) {
            return DamageMultipliers.builder()
                    .rate(new Float[] { skills.getS1()[0].getRate(), skills.getS2()[0].getRate(), skills.getS3()[0].getRate() })
                    .pow(new Float[] { skills.getS1()[0].getPow(), skills.getS2()[0].getPow(), skills.getS3()[0].getPow() })
                    .targets(new Integer[] { skills.getS1()[0].getTargets(), skills.getS2()[0].getTargets(), skills.getS3()[0].getTargets() })
                    .selfHpScaling(new Float[] { skills.getS1()[0].getSelfHpScaling(), skills.getS2()[0].getSelfHpScaling(),
                            skills.getS3()[0].getSelfHpScaling() })
                    .selfAtkScaling(new Float[] { skills.getS1()[0].getSelfAtkScaling(), skills.getS2()[0].getSelfAtkScaling(),
                            skills.getS3()[0].getSelfAtkScaling() })
                    .selfDefScaling(new Float[] { skills.getS1()[0].getSelfDefScaling(), skills.getS2()[0].getSelfDefScaling(),
                            skills.getS3()[0].getSelfDefScaling() })
                    .selfSpdScaling(new Float[] { skills.getS1()[0].getSelfSpdScaling(), skills.getS2()[0].getSelfSpdScaling(),
                            skills.getS3()[0].getSelfSpdScaling() })
                    .increasedValue(new Float[] { skills.getS1()[0].getIncreasedValue(), skills.getS2()[0].getIncreasedValue(),
                            skills.getS3()[0].getIncreasedValue() })
                    .extraSelfHpScaling(new Float[] { skills.getS1()[0].getExtraSelfHpScaling(), skills.getS2()[0].getExtraSelfHpScaling(),
                            skills.getS3()[0].getExtraSelfHpScaling() })
                    .extraSelfDefScaling(new Float[] { skills.getS1()[0].getExtraSelfDefScaling(),
                            skills.getS2()[0].getExtraSelfDefScaling(), skills.getS3()[0].getExtraSelfDefScaling() })
                    .extraSelfAtkScaling(new Float[] { skills.getS1()[0].getExtraSelfAtkScaling(),
                            skills.getS2()[0].getExtraSelfAtkScaling(), skills.getS3()[0].getExtraSelfAtkScaling() })
                    .cdmgIncrease(new Float[] { skills.getS1()[0].getCdmgIncrease(), skills.getS2()[0].getCdmgIncrease(),
                            skills.getS3()[0].getCdmgIncrease() })
                    .penetration(new Float[] { skills.getS1()[0].getPenetration(), skills.getS2()[0].getPenetration(),
                            skills.getS3()[0].getPenetration() })
                    .hitMulti(new Float[] { calculateHitMulti(skills.getS1()[0].getName()),
                            calculateHitMulti(skills.getS2()[0].getName()), calculateHitMulti(skills.getS3()[0].getName()) })
                    .support(new Float[] { calculateSupport(skills.getS1()[0].getName()),
                            calculateSupport(skills.getS2()[0].getName()), calculateSupport(skills.getS3()[0].getName()) })
                    .crit(new Float[] { calculateCrit(skills.getS1()[0].getName()), calculateCrit(skills.getS2()[0].getName()),
                            calculateCrit(skills.getS3()[0].getName()) })
                    .build();
        } else {
            final SkillData s1 = Arrays.stream(skills.getS1())
                    .filter(x -> x.getName().equals(skillOptions.getS1().getSkillEffect())).findFirst()
                    .orElse(skills.getS1()[0]);
            final SkillData s2 = Arrays.stream(skills.getS2())
                    .filter(x -> x.getName().equals(skillOptions.getS2().getSkillEffect())).findFirst()
                    .orElse(skills.getS2()[0]);
            final SkillData s3 = Arrays.stream(skills.getS3())
                    .filter(x -> x.getName().equals(skillOptions.getS3().getSkillEffect())).findFirst()
                    .orElse(skills.getS3()[0]);
            return DamageMultipliers.builder()
                    .rate(new Float[] { s1.getRate(), s2.getRate(), s3.getRate() })
                    .pow(new Float[] { s1.getPow(), s2.getPow(), s3.getPow() })
                    .targets(new Integer[] { s1.getTargets(), s2.getTargets(), s3.getTargets() })
                    .selfHpScaling(new Float[] { s1.getSelfHpScaling(), s2.getSelfHpScaling(), s3.getSelfHpScaling() })
                    .selfAtkScaling(new Float[] { s1.getSelfAtkScaling(), s2.getSelfAtkScaling(), s3.getSelfAtkScaling() })
                    .selfDefScaling(new Float[] { s1.getSelfDefScaling(), s2.getSelfDefScaling(), s3.getSelfDefScaling() })
                    .selfSpdScaling(new Float[] { s1.getSelfSpdScaling(), s2.getSelfSpdScaling(), s3.getSelfSpdScaling() })
                    .increasedValue(new Float[] { s1.getIncreasedValue(), s2.getIncreasedValue(), s3.getIncreasedValue() })
                    .extraSelfHpScaling(
                            new Float[] { s1.getExtraSelfHpScaling(), s2.getExtraSelfHpScaling(), s3.getExtraSelfHpScaling() })
                    .extraSelfDefScaling(
                            new Float[] { s1.getExtraSelfDefScaling(), s2.getExtraSelfDefScaling(), s3.getExtraSelfDefScaling() })
                    .extraSelfAtkScaling(
                            new Float[] { s1.getExtraSelfAtkScaling(), s2.getExtraSelfAtkScaling(), s3.getExtraSelfAtkScaling() })
                    .cdmgIncrease(new Float[] { s1.getCdmgIncrease(), s2.getCdmgIncrease(), s3.getCdmgIncrease() })
                    .penetration(new Float[] { s1.getPenetration(), s2.getPenetration(), s3.getPenetration() })
                    .hitMulti(new Float[] { calculateHitMulti(getSkillOptionsByIndex(0).getSkillEffect()),
                            calculateHitMulti(getSkillOptionsByIndex(1).getSkillEffect()),
                            calculateHitMulti(getSkillOptionsByIndex(2).getSkillEffect()) })
                    .support(new Float[] { calculateSupport(getSkillOptionsByIndex(0).getSkillEffect()),
                            calculateSupport(getSkillOptionsByIndex(1).getSkillEffect()),
                            calculateSupport(getSkillOptionsByIndex(2).getSkillEffect()) })
                    .crit(new Float[] { calculateCrit(getSkillOptionsByIndex(0).getSkillEffect()),
                            calculateCrit(getSkillOptionsByIndex(1).getSkillEffect()),
                            calculateCrit(getSkillOptionsByIndex(2).getSkillEffect()) })
                    .build();
        }
    }

    private SingleSkillOptions getSkillOptionsByIndex(final int skill) {
        if (skill == 0)
            return skillOptions.s1;
        if (skill == 1)
            return skillOptions.s2;
        return skillOptions.s3;
    }

    private float calculateSupport(final String name) {
        if (name.contains("heal") ||
                name.contains("barrier")) {
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
        final Item previousItem = addToEquipment(gear, item);

        if (previousItem != null) {
            return previousItem;
        }

        return null;
    }

    private Item addToEquipment(final Gear gear, final Item item) {
        if (equipment == null) {
            equipment = new EnumMap<>(Gear.class);
        }

        return equipment.put(gear, item);
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
        if (equipment == null) {
            equipment = new EnumMap<>(Gear.class);
        }

        return equipment;
    }

    public void setStats(final HeroStats heroStats) {
        this.atk = heroStats.getAtk();
        this.hp = heroStats.getHp();
        this.def = heroStats.getDef();
        this.cr = heroStats.getCr();
        this.cd = heroStats.getCd();
        this.eff = heroStats.getEff();
        this.res = heroStats.getRes();
        this.dac = heroStats.getDac();
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

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getEff() {
        return eff;
    }

    public void setEff(int eff) {
        this.eff = eff;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getDac() {
        return dac;
    }

    public void setDac(int dac) {
        this.dac = dac;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getEhp() {
        return ehp;
    }

    public void setEhp(int ehp) {
        this.ehp = ehp;
    }

    public int getHpps() {
        return hpps;
    }

    public void setHpps(int hpps) {
        this.hpps = hpps;
    }

    public int getEhpps() {
        return ehpps;
    }

    public void setEhpps(int ehpps) {
        this.ehpps = ehpps;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDmgps() {
        return dmgps;
    }

    public void setDmgps(int dmgps) {
        this.dmgps = dmgps;
    }

    public int getMcdmg() {
        return mcdmg;
    }

    public void setMcdmg(int mcdmg) {
        this.mcdmg = mcdmg;
    }

    public int getMcdmgps() {
        return mcdmgps;
    }

    public void setMcdmgps(int mcdmgps) {
        this.mcdmgps = mcdmgps;
    }

    public int getDmgh() {
        return dmgh;
    }

    public void setDmgh(int dmgh) {
        this.dmgh = dmgh;
    }

    public int getDmgd() {
        return dmgd;
    }

    public void setDmgd(int dmgd) {
        this.dmgd = dmgd;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getS3() {
        return s3;
    }

    public void setS3(int s3) {
        this.s3 = s3;
    }

    public int getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(int upgrades) {
        this.upgrades = upgrades;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBs() {
        return bs;
    }

    public void setBs(int bs) {
        this.bs = bs;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getConversions() {
        return conversions;
    }

    public void setConversions(int conversions) {
        this.conversions = conversions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getBonusAtk() {
        return bonusAtk;
    }

    public void setBonusAtk(int bonusAtk) {
        this.bonusAtk = bonusAtk;
    }

    public int getBonusDef() {
        return bonusDef;
    }

    public void setBonusDef(int bonusDef) {
        this.bonusDef = bonusDef;
    }

    public int getBonusHp() {
        return bonusHp;
    }

    public void setBonusHp(int bonusHp) {
        this.bonusHp = bonusHp;
    }

    public float getBonusAtkPercent() {
        return bonusAtkPercent;
    }

    public void setBonusAtkPercent(float bonusAtkPercent) {
        this.bonusAtkPercent = bonusAtkPercent;
    }

    public float getBonusDefPercent() {
        return bonusDefPercent;
    }

    public void setBonusDefPercent(float bonusDefPercent) {
        this.bonusDefPercent = bonusDefPercent;
    }

    public float getBonusHpPercent() {
        return bonusHpPercent;
    }

    public void setBonusHpPercent(float bonusHpPercent) {
        this.bonusHpPercent = bonusHpPercent;
    }

    public int getBonusSpeed() {
        return bonusSpeed;
    }

    public void setBonusSpeed(int bonusSpeed) {
        this.bonusSpeed = bonusSpeed;
    }

    public float getBonusCr() {
        return bonusCr;
    }

    public void setBonusCr(float bonusCr) {
        this.bonusCr = bonusCr;
    }

    public float getBonusCd() {
        return bonusCd;
    }

    public void setBonusCd(float bonusCd) {
        this.bonusCd = bonusCd;
    }

    public float getBonusEff() {
        return bonusEff;
    }

    public void setBonusEff(float bonusEff) {
        this.bonusEff = bonusEff;
    }

    public float getBonusRes() {
        return bonusRes;
    }

    public void setBonusRes(float bonusRes) {
        this.bonusRes = bonusRes;
    }

    public float getAeiAtk() {
        return aeiAtk;
    }

    public void setAeiAtk(float aeiAtk) {
        this.aeiAtk = aeiAtk;
    }

    public float getAeiDef() {
        return aeiDef;
    }

    public void setAeiDef(float aeiDef) {
        this.aeiDef = aeiDef;
    }

    public float getAeiHp() {
        return aeiHp;
    }

    public void setAeiHp(float aeiHp) {
        this.aeiHp = aeiHp;
    }

    public float getAeiAtkPercent() {
        return aeiAtkPercent;
    }

    public void setAeiAtkPercent(float aeiAtkPercent) {
        this.aeiAtkPercent = aeiAtkPercent;
    }

    public float getAeiDefPercent() {
        return aeiDefPercent;
    }

    public void setAeiDefPercent(float aeiDefPercent) {
        this.aeiDefPercent = aeiDefPercent;
    }

    public float getAeiHpPercent() {
        return aeiHpPercent;
    }

    public void setAeiHpPercent(float aeiHpPercent) {
        this.aeiHpPercent = aeiHpPercent;
    }

    public int getAeiSpeed() {
        return aeiSpeed;
    }

    public void setAeiSpeed(int aeiSpeed) {
        this.aeiSpeed = aeiSpeed;
    }

    public float getAeiCr() {
        return aeiCr;
    }

    public void setAeiCr(float aeiCr) {
        this.aeiCr = aeiCr;
    }

    public float getAeiCd() {
        return aeiCd;
    }

    public void setAeiCd(float aeiCd) {
        this.aeiCd = aeiCd;
    }

    public float getAeiEff() {
        return aeiEff;
    }

    public void setAeiEff(float aeiEff) {
        this.aeiEff = aeiEff;
    }

    public float getAeiRes() {
        return aeiRes;
    }

    public void setAeiRes(float aeiRes) {
        this.aeiRes = aeiRes;
    }

    public float getFinalAtkMultiplier() {
        return finalAtkMultiplier;
    }

    public void setFinalAtkMultiplier(float finalAtkMultiplier) {
        this.finalAtkMultiplier = finalAtkMultiplier;
    }

    public float getFinalDefMultiplier() {
        return finalDefMultiplier;
    }

    public void setFinalDefMultiplier(float finalDefMultiplier) {
        this.finalDefMultiplier = finalDefMultiplier;
    }

    public float getFinalHpMultiplier() {
        return finalHpMultiplier;
    }

    public void setFinalHpMultiplier(float finalHpMultiplier) {
        this.finalHpMultiplier = finalHpMultiplier;
    }

    public float getArtifactAttack() {
        return artifactAttack;
    }

    public void setArtifactAttack(float artifactAttack) {
        this.artifactAttack = artifactAttack;
    }

    public float getArtifactHealth() {
        return artifactHealth;
    }

    public void setArtifactHealth(float artifactHealth) {
        this.artifactHealth = artifactHealth;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public void setArtifactName(String artifactName) {
        this.artifactName = artifactName;
    }

    public String getArtifactLevel() {
        return artifactLevel;
    }

    public void setArtifactLevel(String artifactLevel) {
        this.artifactLevel = artifactLevel;
    }

    public String getImprintNumber() {
        return imprintNumber;
    }

    public void setImprintNumber(String imprintNumber) {
        this.imprintNumber = imprintNumber;
    }

    public String getEeNumber() {
        return eeNumber;
    }

    public void setEeNumber(String eeNumber) {
        this.eeNumber = eeNumber;
    }

    public int getBonusMaxAtkPercent() {
        return bonusMaxAtkPercent;
    }

    public void setBonusMaxAtkPercent(int bonusMaxAtkPercent) {
        this.bonusMaxAtkPercent = bonusMaxAtkPercent;
    }

    public int getBonusMaxDefPercent() {
        return bonusMaxDefPercent;
    }

    public void setBonusMaxDefPercent(int bonusMaxDefPercent) {
        this.bonusMaxDefPercent = bonusMaxDefPercent;
    }

    public int getBonusMaxHpPercent() {
        return bonusMaxHpPercent;
    }

    public void setBonusMaxHpPercent(int bonusMaxHpPercent) {
        this.bonusMaxHpPercent = bonusMaxHpPercent;
    }

    public String getModGrade() {
        return modGrade;
    }

    public void setModGrade(String modGrade) {
        this.modGrade = modGrade;
    }

    public String getKeepStatOptions() {
        return keepStatOptions;
    }

    public void setKeepStatOptions(String keepStatOptions) {
        this.keepStatOptions = keepStatOptions;
    }

    public Float getRollQuality() {
        return rollQuality;
    }

    public void setRollQuality(Float rollQuality) {
        this.rollQuality = rollQuality;
    }

    public Integer getLimitRolls() {
        return limitRolls;
    }

    public void setLimitRolls(Integer limitRolls) {
        this.limitRolls = limitRolls;
    }

    public List<StatType> getKeepStats() {
        return keepStats;
    }

    public void setKeepStats(List<StatType> keepStats) {
        this.keepStats = keepStats;
    }

    public List<StatType> getIgnoreStats() {
        return ignoreStats;
    }

    public void setIgnoreStats(List<StatType> ignoreStats) {
        this.ignoreStats = ignoreStats;
    }

    public List<StatType> getDiscardStats() {
        return discardStats;
    }

    public void setDiscardStats(List<StatType> discardStats) {
        this.discardStats = discardStats;
    }

    public int[] getSets() {
        return sets;
    }

    public void setSets(int[] sets) {
        this.sets = sets;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setEquipment(Map<Gear, Item> equipment) {
        this.equipment = equipment;
    }

    public List<HeroStats> getBuilds() {
        return builds;
    }

    public void setBuilds(List<HeroStats> builds) {
        this.builds = builds;
    }

    public OptimizationRequest getOptimizationRequest() {
        return optimizationRequest;
    }

    public void setOptimizationRequest(OptimizationRequest optimizationRequest) {
        this.optimizationRequest = optimizationRequest;
    }

    public HeroSkillOptions getSkillOptions() {
        return skillOptions;
    }

    public void setSkillOptions(HeroSkillOptions skillOptions) {
        this.skillOptions = skillOptions;
    }

    public void setDamageMultipliers(DamageMultipliers damageMultipliers) {
        this.damageMultipliers = damageMultipliers;
    }

    public HeroSkills getSkills() {
        return skills;
    }

    public void setSkills(HeroSkills skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Hero [atk=" + atk + ", hp=" + hp + ", def=" + def + ", cr=" + cr + ", cd=" + cd + ", eff=" + eff
                + ", res=" + res + ", dac=" + dac + ", spd=" + spd + ", ehp=" + ehp + ", hpps=" + hpps + ", ehpps="
                + ehpps + ", dmg=" + dmg + ", dmgps=" + dmgps + ", mcdmg=" + mcdmg + ", mcdmgps=" + mcdmgps + ", dmgh="
                + dmgh + ", dmgd=" + dmgd + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", upgrades=" + upgrades
                + ", score=" + score + ", bs=" + bs + ", priority=" + priority + ", conversions=" + conversions
                + ", id=" + id + ", name=" + name + ", index=" + index + ", rarity=" + rarity + ", stars=" + stars
                + ", attribute=" + attribute + ", role=" + role + ", bonusAtk=" + bonusAtk + ", bonusDef=" + bonusDef
                + ", bonusHp=" + bonusHp + ", bonusAtkPercent=" + bonusAtkPercent + ", bonusDefPercent="
                + bonusDefPercent + ", bonusHpPercent=" + bonusHpPercent + ", bonusSpeed=" + bonusSpeed + ", bonusCr="
                + bonusCr + ", bonusCd=" + bonusCd + ", bonusEff=" + bonusEff + ", bonusRes=" + bonusRes + ", aeiAtk="
                + aeiAtk + ", aeiDef=" + aeiDef + ", aeiHp=" + aeiHp + ", aeiAtkPercent=" + aeiAtkPercent
                + ", aeiDefPercent=" + aeiDefPercent + ", aeiHpPercent=" + aeiHpPercent + ", aeiSpeed=" + aeiSpeed
                + ", aeiCr=" + aeiCr + ", aeiCd=" + aeiCd + ", aeiEff=" + aeiEff + ", aeiRes=" + aeiRes
                + ", finalAtkMultiplier=" + finalAtkMultiplier + ", finalDefMultiplier=" + finalDefMultiplier
                + ", finalHpMultiplier=" + finalHpMultiplier + ", artifactAttack=" + artifactAttack
                + ", artifactHealth=" + artifactHealth + ", artifactName=" + artifactName + ", artifactLevel="
                + artifactLevel + ", imprintNumber=" + imprintNumber + ", eeNumber=" + eeNumber
                + ", bonusMaxAtkPercent=" + bonusMaxAtkPercent + ", bonusMaxDefPercent=" + bonusMaxDefPercent
                + ", bonusMaxHpPercent=" + bonusMaxHpPercent + ", modGrade=" + modGrade + ", keepStatOptions="
                + keepStatOptions + ", rollQuality=" + rollQuality + ", limitRolls=" + limitRolls + ", keepStats="
                + keepStats + ", ignoreStats=" + ignoreStats + ", discardStats=" + discardStats + ", sets="
                + Arrays.toString(sets) + ", cp=" + cp + ", equipment=" + equipment + ", builds=" + builds
                + ", optimizationRequest=" + optimizationRequest + ", skillOptions=" + skillOptions
                + ", damageMultipliers=" + damageMultipliers + ", skills=" + skills + "]";
    }

    public Hero withCp(int cp) {
        return this.cp == cp ? this
                : new Hero(atk, hp, def, cr, cd, eff, res, dac, spd, ehp, hpps, ehpps, dmg, dmgps, mcdmg, mcdmgps, dmgh,
                        dmgd, s1, s2, s3, upgrades, score, bs, priority, conversions, id, name, index, rarity, stars,
                        attribute, role, bonusAtk, bonusDef, bonusHp, bonusAtkPercent, bonusDefPercent, bonusHpPercent,
                        bonusSpeed, bonusCr, bonusCd, bonusEff, bonusRes, aeiAtk, aeiDef, aeiHp, aeiAtkPercent,
                        aeiDefPercent, aeiHpPercent, aeiSpeed, aeiCr, aeiCd, aeiEff, aeiRes, finalAtkMultiplier,
                        finalDefMultiplier, finalHpMultiplier, artifactAttack, artifactHealth, artifactName, artifactLevel,
                        imprintNumber, eeNumber, bonusMaxAtkPercent, bonusMaxDefPercent, bonusMaxHpPercent, modGrade,
                        keepStatOptions, rollQuality, limitRolls, keepStats, ignoreStats, discardStats, sets, cp, equipment,
                        builds, optimizationRequest, skillOptions, damageMultipliers, skills);
    }
}
