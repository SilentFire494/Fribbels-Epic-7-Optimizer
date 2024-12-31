package com.fribbels.model;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HeroStats {

    private int atk;
    private int hp;
    private int def;
    private int cr;
    private int cd;
    private int eff;
    private int res;
    private int dac;
    private int spd;
    private int cp;

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
    private int conversions;
    private int eq;
    private int score;
    private int bs;
    private int priority;

    private BonusStats bonusStats;

    private int[] sets;

    private String id;
    private String name;
    private String property;
    private List<String> items;
    private List<String> modIds;
    private List<Mod> mods;

    public HeroStats() {
    }

    public HeroStats(int atk, int hp, int def, int cr, int cd, int eff, int res, int dac, int spd, int cp, int ehp,
            int hpps, int ehpps, int dmg, int dmgps, int mcdmg, int mcdmgps, int dmgh, int dmgd, int s1, int s2, int s3,
            int upgrades, int conversions, int eq, int score, int bs, int priority, BonusStats bonusStats, int[] sets,
            String id, String name, String property, List<String> items, List<String> modIds, List<Mod> mods) {
        this.atk = atk;
        this.hp = hp;
        this.def = def;
        this.cr = cr;
        this.cd = cd;
        this.eff = eff;
        this.res = res;
        this.dac = dac;
        this.spd = spd;
        this.cp = cp;
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
        this.conversions = conversions;
        this.eq = eq;
        this.score = score;
        this.bs = bs;
        this.priority = priority;
        this.bonusStats = bonusStats;
        this.sets = sets;
        this.id = id;
        this.name = name;
        this.property = property;
        this.items = items;
        this.modIds = modIds;
        this.mods = mods;
    }

    public String getBuildHash() {
        if (items == null || items.size() != 6) {
            return null;
        }

        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            final String combinedItems = String.join("", items) + (mods == null ? ""
                    : mods.stream()
                            .filter(Objects::nonNull)
                            .map(Mod::toString)
                            .collect(Collectors.joining("")));
            messageDigest.update(combinedItems.getBytes());
            final String stringHash = new String(messageDigest.digest());

            return stringHash;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
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

    public int getConversions() {
        return conversions;
    }

    public void setConversions(int conversions) {
        this.conversions = conversions;
    }

    public int getEq() {
        return eq;
    }

    public void setEq(int eq) {
        this.eq = eq;
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

    public BonusStats getBonusStats() {
        return bonusStats;
    }

    public void setBonusStats(BonusStats bonusStats) {
        this.bonusStats = bonusStats;
    }

    public int[] getSets() {
        return sets;
    }

    public void setSets(int[] sets) {
        this.sets = sets;
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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getModIds() {
        return modIds;
    }

    public void setModIds(List<String> modIds) {
        this.modIds = modIds;
    }

    public List<Mod> getMods() {
        return mods;
    }

    public void setMods(List<Mod> mods) {
        this.mods = mods;
    }

    @Override
    public String toString() {
        return "HeroStats [atk=" + atk + ", hp=" + hp + ", def=" + def + ", cr=" + cr + ", cd=" + cd + ", eff=" + eff
                + ", res=" + res + ", dac=" + dac + ", spd=" + spd + ", cp=" + cp + ", ehp=" + ehp + ", hpps=" + hpps
                + ", ehpps=" + ehpps + ", dmg=" + dmg + ", dmgps=" + dmgps + ", mcdmg=" + mcdmg + ", mcdmgps=" + mcdmgps
                + ", dmgh=" + dmgh + ", dmgd=" + dmgd + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", upgrades="
                + upgrades + ", conversions=" + conversions + ", eq=" + eq + ", score=" + score + ", bs=" + bs
                + ", priority=" + priority + ", bonusStats=" + bonusStats + ", sets=" + Arrays.toString(sets) + ", id="
                + id + ", name=" + name + ", property=" + property + ", items=" + items + ", modIds=" + modIds
                + ", mods=" + mods + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private HeroStats heroStats;

        public Builder() {
            heroStats = new HeroStats();
        }

        public Builder atk(int atk) {
            heroStats.atk = atk;
            return this;
        }

        public Builder hp(int hp) {
            heroStats.hp = hp;
            return this;
        }

        public Builder def(int def) {
            heroStats.def = def;
            return this;
        }

        public Builder cr(int cr) {
            heroStats.cr = cr;
            return this;
        }

        public Builder cd(int cd) {
            heroStats.cd = cd;
            return this;
        }

        public Builder eff(int eff) {
            heroStats.eff = eff;
            return this;
        }

        public Builder res(int res) {
            heroStats.res = res;
            return this;
        }

        public Builder dac(int dac) {
            heroStats.dac = dac;
            return this;
        }

        public Builder spd(int spd) {
            heroStats.spd = spd;
            return this;
        }

        public Builder bonusStats(BonusStats bonusStats) {
            heroStats.bonusStats = bonusStats;
            return this;
        }

        public Builder name(String name) {
            heroStats.name = name;
            return this;
        }

        public HeroStats build() {
            return heroStats;
        }
    }

}
