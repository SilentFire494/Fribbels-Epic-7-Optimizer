package com.fribbels.model;

import java.util.Arrays;

public class DamageMultipliers {

    private Float[] rate = new Float[] { 1f, 1f, 1f };
    private Float[] pow = new Float[] { 1f, 1f, 1f };
    private Integer[] targets = new Integer[] { 0, 0, 0 };

    private Float[] selfHpScaling = new Float[] { 1f, 1f, 1f };
    private Float[] selfAtkScaling = new Float[] { 1f, 1f, 1f };
    private Float[] selfDefScaling = new Float[] { 1f, 1f, 1f };
    private Float[] selfSpdScaling = new Float[] { 1f, 1f, 1f };
    private Float[] constantValue = new Float[] { 1f, 1f, 1f };
    private Float[] selfAtkConstantValue = new Float[] { 1f, 1f, 1f };
    private Float[] increasedValue = new Float[] { 1f, 1f, 1f };
    private Float[] defDiffPen = new Float[] { 1f, 1f, 1f };
    private Float[] defDiffPenMax = new Float[] { 1f, 1f, 1f };
    private Float[] atkDiffPen = new Float[] { 1f, 1f, 1f };
    private Float[] atkDiffPenMax = new Float[] { 1f, 1f, 1f };
    private Float[] spdDiffPen = new Float[] { 1f, 1f, 1f };
    private Float[] spdDiffPenMax = new Float[] { 1f, 1f, 1f };
    private Float[] penetration = new Float[] { 0f, 0f, 0f };
    private Float[] atkIncrease = new Float[] { 1f, 1f, 1f };
    private Float[] cdmgIncrease = new Float[] { 1f, 1f, 1f };
    private Float[] crit = new Float[] { 1f, 1f, 1f };
    private Float[] damage = new Float[] { 1f, 1f, 1f };
    private Float[] support = new Float[] { 1f, 1f, 1f };
    private Float[] hitMulti = new Float[] { 1f, 1f, 1f };

    private Float[] extraSelfAtkScaling = new Float[] { 1f, 1f, 1f };
    private Float[] extraSelfDefScaling = new Float[] { 1f, 1f, 1f };
    private Float[] extraSelfHpScaling = new Float[] { 1f, 1f, 1f };

    public DamageMultipliers() {
    }

    public DamageMultipliers(Float[] rate, Float[] pow, Integer[] targets, Float[] selfHpScaling,
            Float[] selfAtkScaling, Float[] selfDefScaling, Float[] selfSpdScaling, Float[] constantValue,
            Float[] selfAtkConstantValue, Float[] increasedValue, Float[] defDiffPen, Float[] defDiffPenMax,
            Float[] atkDiffPen, Float[] atkDiffPenMax, Float[] spdDiffPen, Float[] spdDiffPenMax, Float[] penetration,
            Float[] atkIncrease, Float[] cdmgIncrease, Float[] crit, Float[] damage, Float[] support, Float[] hitMulti,
            Float[] extraSelfAtkScaling, Float[] extraSelfDefScaling, Float[] extraSelfHpScaling) {
        this.rate = rate;
        this.pow = pow;
        this.targets = targets;
        this.selfHpScaling = selfHpScaling;
        this.selfAtkScaling = selfAtkScaling;
        this.selfDefScaling = selfDefScaling;
        this.selfSpdScaling = selfSpdScaling;
        this.constantValue = constantValue;
        this.selfAtkConstantValue = selfAtkConstantValue;
        this.increasedValue = increasedValue;
        this.defDiffPen = defDiffPen;
        this.defDiffPenMax = defDiffPenMax;
        this.atkDiffPen = atkDiffPen;
        this.atkDiffPenMax = atkDiffPenMax;
        this.spdDiffPen = spdDiffPen;
        this.spdDiffPenMax = spdDiffPenMax;
        this.penetration = penetration;
        this.atkIncrease = atkIncrease;
        this.cdmgIncrease = cdmgIncrease;
        this.crit = crit;
        this.damage = damage;
        this.support = support;
        this.hitMulti = hitMulti;
        this.extraSelfAtkScaling = extraSelfAtkScaling;
        this.extraSelfDefScaling = extraSelfDefScaling;
        this.extraSelfHpScaling = extraSelfHpScaling;
    }

    public Float[] getRate() {
        return rate;
    }

    public void setRate(Float[] rate) {
        this.rate = rate;
    }

    public Float[] getPow() {
        return pow;
    }

    public void setPow(Float[] pow) {
        this.pow = pow;
    }

    public Integer[] getTargets() {
        return targets;
    }

    public void setTargets(Integer[] targets) {
        this.targets = targets;
    }

    public Float[] getSelfHpScaling() {
        return selfHpScaling;
    }

    public void setSelfHpScaling(Float[] selfHpScaling) {
        this.selfHpScaling = selfHpScaling;
    }

    public Float[] getSelfAtkScaling() {
        return selfAtkScaling;
    }

    public void setSelfAtkScaling(Float[] selfAtkScaling) {
        this.selfAtkScaling = selfAtkScaling;
    }

    public Float[] getSelfDefScaling() {
        return selfDefScaling;
    }

    public void setSelfDefScaling(Float[] selfDefScaling) {
        this.selfDefScaling = selfDefScaling;
    }

    public Float[] getSelfSpdScaling() {
        return selfSpdScaling;
    }

    public void setSelfSpdScaling(Float[] selfSpdScaling) {
        this.selfSpdScaling = selfSpdScaling;
    }

    public Float[] getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(Float[] constantValue) {
        this.constantValue = constantValue;
    }

    public Float[] getSelfAtkConstantValue() {
        return selfAtkConstantValue;
    }

    public void setSelfAtkConstantValue(Float[] selfAtkConstantValue) {
        this.selfAtkConstantValue = selfAtkConstantValue;
    }

    public Float[] getIncreasedValue() {
        return increasedValue;
    }

    public void setIncreasedValue(Float[] increasedValue) {
        this.increasedValue = increasedValue;
    }

    public Float[] getDefDiffPen() {
        return defDiffPen;
    }

    public void setDefDiffPen(Float[] defDiffPen) {
        this.defDiffPen = defDiffPen;
    }

    public Float[] getDefDiffPenMax() {
        return defDiffPenMax;
    }

    public void setDefDiffPenMax(Float[] defDiffPenMax) {
        this.defDiffPenMax = defDiffPenMax;
    }

    public Float[] getAtkDiffPen() {
        return atkDiffPen;
    }

    public void setAtkDiffPen(Float[] atkDiffPen) {
        this.atkDiffPen = atkDiffPen;
    }

    public Float[] getAtkDiffPenMax() {
        return atkDiffPenMax;
    }

    public void setAtkDiffPenMax(Float[] atkDiffPenMax) {
        this.atkDiffPenMax = atkDiffPenMax;
    }

    public Float[] getSpdDiffPen() {
        return spdDiffPen;
    }

    public void setSpdDiffPen(Float[] spdDiffPen) {
        this.spdDiffPen = spdDiffPen;
    }

    public Float[] getSpdDiffPenMax() {
        return spdDiffPenMax;
    }

    public void setSpdDiffPenMax(Float[] spdDiffPenMax) {
        this.spdDiffPenMax = spdDiffPenMax;
    }

    public Float[] getPenetration() {
        return penetration;
    }

    public void setPenetration(Float[] penetration) {
        this.penetration = penetration;
    }

    public Float[] getAtkIncrease() {
        return atkIncrease;
    }

    public void setAtkIncrease(Float[] atkIncrease) {
        this.atkIncrease = atkIncrease;
    }

    public Float[] getCdmgIncrease() {
        return cdmgIncrease;
    }

    public void setCdmgIncrease(Float[] cdmgIncrease) {
        this.cdmgIncrease = cdmgIncrease;
    }

    public Float[] getCrit() {
        return crit;
    }

    public void setCrit(Float[] crit) {
        this.crit = crit;
    }

    public Float[] getDamage() {
        return damage;
    }

    public void setDamage(Float[] damage) {
        this.damage = damage;
    }

    public Float[] getSupport() {
        return support;
    }

    public void setSupport(Float[] support) {
        this.support = support;
    }

    public Float[] getHitMulti() {
        return hitMulti;
    }

    public void setHitMulti(Float[] hitMulti) {
        this.hitMulti = hitMulti;
    }

    public Float[] getExtraSelfAtkScaling() {
        return extraSelfAtkScaling;
    }

    public void setExtraSelfAtkScaling(Float[] extraSelfAtkScaling) {
        this.extraSelfAtkScaling = extraSelfAtkScaling;
    }

    public Float[] getExtraSelfDefScaling() {
        return extraSelfDefScaling;
    }

    public void setExtraSelfDefScaling(Float[] extraSelfDefScaling) {
        this.extraSelfDefScaling = extraSelfDefScaling;
    }

    public Float[] getExtraSelfHpScaling() {
        return extraSelfHpScaling;
    }

    public void setExtraSelfHpScaling(Float[] extraSelfHpScaling) {
        this.extraSelfHpScaling = extraSelfHpScaling;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(rate);
        result = prime * result + Arrays.hashCode(pow);
        result = prime * result + Arrays.hashCode(targets);
        result = prime * result + Arrays.hashCode(selfHpScaling);
        result = prime * result + Arrays.hashCode(selfAtkScaling);
        result = prime * result + Arrays.hashCode(selfDefScaling);
        result = prime * result + Arrays.hashCode(selfSpdScaling);
        result = prime * result + Arrays.hashCode(constantValue);
        result = prime * result + Arrays.hashCode(selfAtkConstantValue);
        result = prime * result + Arrays.hashCode(increasedValue);
        result = prime * result + Arrays.hashCode(defDiffPen);
        result = prime * result + Arrays.hashCode(defDiffPenMax);
        result = prime * result + Arrays.hashCode(atkDiffPen);
        result = prime * result + Arrays.hashCode(atkDiffPenMax);
        result = prime * result + Arrays.hashCode(spdDiffPen);
        result = prime * result + Arrays.hashCode(spdDiffPenMax);
        result = prime * result + Arrays.hashCode(penetration);
        result = prime * result + Arrays.hashCode(atkIncrease);
        result = prime * result + Arrays.hashCode(cdmgIncrease);
        result = prime * result + Arrays.hashCode(crit);
        result = prime * result + Arrays.hashCode(damage);
        result = prime * result + Arrays.hashCode(support);
        result = prime * result + Arrays.hashCode(hitMulti);
        result = prime * result + Arrays.hashCode(extraSelfAtkScaling);
        result = prime * result + Arrays.hashCode(extraSelfDefScaling);
        result = prime * result + Arrays.hashCode(extraSelfHpScaling);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DamageMultipliers other = (DamageMultipliers) obj;
        if (!Arrays.equals(rate, other.rate))
            return false;
        if (!Arrays.equals(pow, other.pow))
            return false;
        if (!Arrays.equals(targets, other.targets))
            return false;
        if (!Arrays.equals(selfHpScaling, other.selfHpScaling))
            return false;
        if (!Arrays.equals(selfAtkScaling, other.selfAtkScaling))
            return false;
        if (!Arrays.equals(selfDefScaling, other.selfDefScaling))
            return false;
        if (!Arrays.equals(selfSpdScaling, other.selfSpdScaling))
            return false;
        if (!Arrays.equals(constantValue, other.constantValue))
            return false;
        if (!Arrays.equals(selfAtkConstantValue, other.selfAtkConstantValue))
            return false;
        if (!Arrays.equals(increasedValue, other.increasedValue))
            return false;
        if (!Arrays.equals(defDiffPen, other.defDiffPen))
            return false;
        if (!Arrays.equals(defDiffPenMax, other.defDiffPenMax))
            return false;
        if (!Arrays.equals(atkDiffPen, other.atkDiffPen))
            return false;
        if (!Arrays.equals(atkDiffPenMax, other.atkDiffPenMax))
            return false;
        if (!Arrays.equals(spdDiffPen, other.spdDiffPen))
            return false;
        if (!Arrays.equals(spdDiffPenMax, other.spdDiffPenMax))
            return false;
        if (!Arrays.equals(penetration, other.penetration))
            return false;
        if (!Arrays.equals(atkIncrease, other.atkIncrease))
            return false;
        if (!Arrays.equals(cdmgIncrease, other.cdmgIncrease))
            return false;
        if (!Arrays.equals(crit, other.crit))
            return false;
        if (!Arrays.equals(damage, other.damage))
            return false;
        if (!Arrays.equals(support, other.support))
            return false;
        if (!Arrays.equals(hitMulti, other.hitMulti))
            return false;
        if (!Arrays.equals(extraSelfAtkScaling, other.extraSelfAtkScaling))
            return false;
        if (!Arrays.equals(extraSelfDefScaling, other.extraSelfDefScaling))
            return false;
        if (!Arrays.equals(extraSelfHpScaling, other.extraSelfHpScaling))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DamageMultipliers [rate=" + Arrays.toString(rate) + ", pow=" + Arrays.toString(pow) + ", targets="
                + Arrays.toString(targets) + ", selfHpScaling=" + Arrays.toString(selfHpScaling) + ", selfAtkScaling="
                + Arrays.toString(selfAtkScaling) + ", selfDefScaling=" + Arrays.toString(selfDefScaling)
                + ", selfSpdScaling=" + Arrays.toString(selfSpdScaling) + ", constantValue="
                + Arrays.toString(constantValue) + ", selfAtkConstantValue=" + Arrays.toString(selfAtkConstantValue)
                + ", increasedValue=" + Arrays.toString(increasedValue) + ", defDiffPen=" + Arrays.toString(defDiffPen)
                + ", defDiffPenMax=" + Arrays.toString(defDiffPenMax) + ", atkDiffPen=" + Arrays.toString(atkDiffPen)
                + ", atkDiffPenMax=" + Arrays.toString(atkDiffPenMax) + ", spdDiffPen=" + Arrays.toString(spdDiffPen)
                + ", spdDiffPenMax=" + Arrays.toString(spdDiffPenMax) + ", penetration=" + Arrays.toString(penetration)
                + ", atkIncrease=" + Arrays.toString(atkIncrease) + ", cdmgIncrease=" + Arrays.toString(cdmgIncrease)
                + ", crit=" + Arrays.toString(crit) + ", damage=" + Arrays.toString(damage) + ", support="
                + Arrays.toString(support) + ", hitMulti=" + Arrays.toString(hitMulti) + ", extraSelfAtkScaling="
                + Arrays.toString(extraSelfAtkScaling) + ", extraSelfDefScaling=" + Arrays.toString(extraSelfDefScaling)
                + ", extraSelfHpScaling=" + Arrays.toString(extraSelfHpScaling) + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private DamageMultipliers damageMultipliers;

        public Builder() {
            damageMultipliers = new DamageMultipliers();
        }

        public Builder rate(Float[] rate) {
            damageMultipliers.setRate(rate);
            return this;
        }

        public Builder pow(Float[] pow) {
            damageMultipliers.setPow(pow);
            return this;
        }

        public Builder targets(Integer[] targets) {
            damageMultipliers.setTargets(targets);
            return this;
        }

        public Builder selfHpScaling(Float[] selfHpScaling) {
            damageMultipliers.setSelfHpScaling(selfHpScaling);
            return this;
        }

        public Builder selfAtkScaling(Float[] selfAtkScaling) {
            damageMultipliers.setSelfAtkScaling(selfAtkScaling);
            return this;
        }

        public Builder selfDefScaling(Float[] selfDefScaling) {
            damageMultipliers.setSelfDefScaling(selfDefScaling);
            return this;
        }

        public Builder selfSpdScaling(Float[] selfSpdScaling) {
            damageMultipliers.setSelfSpdScaling(selfSpdScaling);
            return this;
        }

        public Builder constantValue(Float[] constantValue) {
            damageMultipliers.setConstantValue(constantValue);
            return this;
        }

        public Builder selfAtkConstantValue(Float[] selfAtkConstantValue) {
            damageMultipliers.setSelfAtkConstantValue(selfAtkConstantValue);
            return this;
        }

        public Builder increasedValue(Float[] increasedValue) {
            damageMultipliers.setIncreasedValue(increasedValue);
            return this;
        }

        public Builder defDiffPen(Float[] defDiffPen) {
            damageMultipliers.setDefDiffPen(defDiffPen);
            return this;
        }

        public Builder defDiffPenMax(Float[] defDiffPenMax) {
            damageMultipliers.setDefDiffPenMax(defDiffPenMax);
            return this;
        }

        public Builder atkDiffPen(Float[] atkDiffPen) {
            damageMultipliers.setAtkDiffPen(atkDiffPen);
            return this;
        }

        public Builder atkDiffPenMax(Float[] atkDiffPenMax) {
            damageMultipliers.setAtkDiffPenMax(atkDiffPenMax);
            return this;
        }

        public Builder spdDiffPen(Float[] spdDiffPen) {
            damageMultipliers.setSpdDiffPen(spdDiffPen);
            return this;
        }

        public Builder spdDiffPenMax(Float[] spdDiffPenMax) {
            damageMultipliers.setSpdDiffPenMax(spdDiffPenMax);
            return this;
        }

        public Builder penetration(Float[] penetration) {
            damageMultipliers.setPenetration(penetration);
            return this;
        }

        public Builder atkIncrease(Float[] atkIncrease) {
            damageMultipliers.setAtkIncrease(atkIncrease);
            return this;
        }

        public Builder cdmgIncrease(Float[] cdmgIncrease) {
            damageMultipliers.setCdmgIncrease(cdmgIncrease);
            return this;
        }

        public Builder crit(Float[] crit) {
            damageMultipliers.setCrit(crit);
            return this;
        }

        public Builder damage(Float[] damage) {
            damageMultipliers.setDamage(damage);
            return this;
        }

        public Builder support(Float[] support) {
            damageMultipliers.setSupport(support);
            return this;
        }

        public Builder hitMulti(Float[] hitMulti) {
            damageMultipliers.setHitMulti(hitMulti);
            return this;
        }

        public Builder extraSelfAtkScaling(Float[] extraSelfAtkScaling) {
            damageMultipliers.setExtraSelfAtkScaling(extraSelfAtkScaling);
            return this;
        }

        public Builder extraSelfDefScaling(Float[] extraSelfDefScaling) {
            damageMultipliers.setExtraSelfDefScaling(extraSelfDefScaling);
            return this;
        }

        public Builder extraSelfHpScaling(Float[] extraSelfHpScaling) {
            damageMultipliers.setExtraSelfHpScaling(extraSelfHpScaling);
            return this;
        }

        public DamageMultipliers build() {
            return damageMultipliers;
        }
    }
}
