package com.fribbels.model;

public class BonusStats {

    private int bonusMaxAtkPercent;
    private int bonusMaxDefPercent;
    private int bonusMaxHpPercent;
    private int overrideAtk;
    private int overrideHp;
    private int overrideDef;
    private int overrideAdditionalCr;
    private int overrideAdditionalCd;
    private int overrideAdditionalSpd;
    private int overrideAdditionalEff;
    private int overrideAdditionalRes;

    public BonusStats() {
    }

    public BonusStats(int bonusMaxAtkPercent, int bonusMaxDefPercent, int bonusMaxHpPercent, int overrideAtk,
            int overrideHp, int overrideDef, int overrideAdditionalCr, int overrideAdditionalCd,
            int overrideAdditionalSpd, int overrideAdditionalEff, int overrideAdditionalRes) {
        this.bonusMaxAtkPercent = bonusMaxAtkPercent;
        this.bonusMaxDefPercent = bonusMaxDefPercent;
        this.bonusMaxHpPercent = bonusMaxHpPercent;
        this.overrideAtk = overrideAtk;
        this.overrideHp = overrideHp;
        this.overrideDef = overrideDef;
        this.overrideAdditionalCr = overrideAdditionalCr;
        this.overrideAdditionalCd = overrideAdditionalCd;
        this.overrideAdditionalSpd = overrideAdditionalSpd;
        this.overrideAdditionalEff = overrideAdditionalEff;
        this.overrideAdditionalRes = overrideAdditionalRes;
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

    public int getOverrideAtk() {
        return overrideAtk;
    }

    public void setOverrideAtk(int overrideAtk) {
        this.overrideAtk = overrideAtk;
    }

    public int getOverrideHp() {
        return overrideHp;
    }

    public void setOverrideHp(int overrideHp) {
        this.overrideHp = overrideHp;
    }

    public int getOverrideDef() {
        return overrideDef;
    }

    public void setOverrideDef(int overrideDef) {
        this.overrideDef = overrideDef;
    }

    public int getOverrideAdditionalCr() {
        return overrideAdditionalCr;
    }

    public void setOverrideAdditionalCr(int overrideAdditionalCr) {
        this.overrideAdditionalCr = overrideAdditionalCr;
    }

    public int getOverrideAdditionalCd() {
        return overrideAdditionalCd;
    }

    public void setOverrideAdditionalCd(int overrideAdditionalCd) {
        this.overrideAdditionalCd = overrideAdditionalCd;
    }

    public int getOverrideAdditionalSpd() {
        return overrideAdditionalSpd;
    }

    public void setOverrideAdditionalSpd(int overrideAdditionalSpd) {
        this.overrideAdditionalSpd = overrideAdditionalSpd;
    }

    public int getOverrideAdditionalEff() {
        return overrideAdditionalEff;
    }

    public void setOverrideAdditionalEff(int overrideAdditionalEff) {
        this.overrideAdditionalEff = overrideAdditionalEff;
    }

    public int getOverrideAdditionalRes() {
        return overrideAdditionalRes;
    }

    public void setOverrideAdditionalRes(int overrideAdditionalRes) {
        this.overrideAdditionalRes = overrideAdditionalRes;
    }

    @Override
    public String toString() {
        return "BonusStats [bonusMaxAtkPercent=" + bonusMaxAtkPercent + ", bonusMaxDefPercent=" + bonusMaxDefPercent
                + ", bonusMaxHpPercent=" + bonusMaxHpPercent + ", overrideAtk=" + overrideAtk + ", overrideHp="
                + overrideHp + ", overrideDef=" + overrideDef + ", overrideAdditionalCr=" + overrideAdditionalCr
                + ", overrideAdditionalCd=" + overrideAdditionalCd + ", overrideAdditionalSpd=" + overrideAdditionalSpd
                + ", overrideAdditionalEff=" + overrideAdditionalEff + ", overrideAdditionalRes="
                + overrideAdditionalRes + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BonusStats bonusStats;

        public Builder() {
            bonusStats = new BonusStats();
        }

        public Builder bonusMaxAtkPercent(int bonusMaxAtkPercent) {
            bonusStats.setBonusMaxAtkPercent(bonusMaxAtkPercent);
            return this;
        }

        public Builder bonusMaxDefPercent(int bonusMaxDefPercent) {
            bonusStats.setBonusMaxDefPercent(bonusMaxDefPercent);
            return this;
        }

        public Builder bonusMaxHpPercent(int bonusMaxHpPercent) {
            bonusStats.setBonusMaxHpPercent(bonusMaxHpPercent);
            return this;
        }

        public Builder overrideAtk(int overrideAtk) {
            bonusStats.setOverrideAtk(overrideAtk);
            return this;
        }

        public Builder overrideHp(int overrideHp) {
            bonusStats.setOverrideHp(overrideHp);
            return this;
        }

        public Builder overrideDef(int overrideDef) {
            bonusStats.setOverrideDef(overrideDef);
            return this;
        }

        public Builder overrideAdditionalCr(int overrideAdditionalCr) {
            bonusStats.setOverrideAdditionalCr(overrideAdditionalCr);
            return this;
        }

        public Builder overrideAdditionalCd(int overrideAdditionalCd) {
            bonusStats.setOverrideAdditionalCd(overrideAdditionalCd);
            return this;
        }

        public Builder overrideAdditionalSpd(int overrideAdditionalSpd) {
            bonusStats.setOverrideAdditionalSpd(overrideAdditionalSpd);
            return this;
        }

        public Builder overrideAdditionalEff(int overrideAdditionalEff) {
            bonusStats.setOverrideAdditionalEff(overrideAdditionalEff);
            return this;
        }

        public Builder overrideAdditionalRes(int overrideAdditionalRes) {
            bonusStats.setOverrideAdditionalRes(overrideAdditionalRes);
            return this;
        }

        public BonusStats build() {
            return bonusStats;
        }
    }
}
