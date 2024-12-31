package com.fribbels.model;

public class SkillData {

    private String name;
    private Float rate = 0f;
    private Float pow = 0f;
    private Integer targets = 0;
    private Float selfHpScaling = 0f;
    private Float selfAtkScaling = 0f;
    private Float selfDefScaling = 0f;
    private Float selfSpdScaling = 0f;
    private Float increasedValue = 0f;
    private Float extraSelfHpScaling = 0f;
    private Float extraSelfDefScaling = 0f;
    private Float extraSelfAtkScaling = 0f;
    private Float cdmgIncrease = 0f;
    private Float penetration = 0f;

    public SkillData() {
    }

    public SkillData(String name, Float rate, Float pow, Integer targets, Float selfHpScaling, Float selfAtkScaling,
            Float selfDefScaling, Float selfSpdScaling, Float increasedValue, Float extraSelfHpScaling,
            Float extraSelfDefScaling, Float extraSelfAtkScaling, Float cdmgIncrease, Float penetration) {
        this.name = name;
        this.rate = rate;
        this.pow = pow;
        this.targets = targets;
        this.selfHpScaling = selfHpScaling;
        this.selfAtkScaling = selfAtkScaling;
        this.selfDefScaling = selfDefScaling;
        this.selfSpdScaling = selfSpdScaling;
        this.increasedValue = increasedValue;
        this.extraSelfHpScaling = extraSelfHpScaling;
        this.extraSelfDefScaling = extraSelfDefScaling;
        this.extraSelfAtkScaling = extraSelfAtkScaling;
        this.cdmgIncrease = cdmgIncrease;
        this.penetration = penetration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getPow() {
        return pow;
    }

    public void setPow(Float pow) {
        this.pow = pow;
    }

    public Integer getTargets() {
        return targets;
    }

    public void setTargets(Integer targets) {
        this.targets = targets;
    }

    public Float getSelfHpScaling() {
        return selfHpScaling;
    }

    public void setSelfHpScaling(Float selfHpScaling) {
        this.selfHpScaling = selfHpScaling;
    }

    public Float getSelfAtkScaling() {
        return selfAtkScaling;
    }

    public void setSelfAtkScaling(Float selfAtkScaling) {
        this.selfAtkScaling = selfAtkScaling;
    }

    public Float getSelfDefScaling() {
        return selfDefScaling;
    }

    public void setSelfDefScaling(Float selfDefScaling) {
        this.selfDefScaling = selfDefScaling;
    }

    public Float getSelfSpdScaling() {
        return selfSpdScaling;
    }

    public void setSelfSpdScaling(Float selfSpdScaling) {
        this.selfSpdScaling = selfSpdScaling;
    }

    public Float getIncreasedValue() {
        return increasedValue;
    }

    public void setIncreasedValue(Float increasedValue) {
        this.increasedValue = increasedValue;
    }

    public Float getExtraSelfHpScaling() {
        return extraSelfHpScaling;
    }

    public void setExtraSelfHpScaling(Float extraSelfHpScaling) {
        this.extraSelfHpScaling = extraSelfHpScaling;
    }

    public Float getExtraSelfDefScaling() {
        return extraSelfDefScaling;
    }

    public void setExtraSelfDefScaling(Float extraSelfDefScaling) {
        this.extraSelfDefScaling = extraSelfDefScaling;
    }

    public Float getExtraSelfAtkScaling() {
        return extraSelfAtkScaling;
    }

    public void setExtraSelfAtkScaling(Float extraSelfAtkScaling) {
        this.extraSelfAtkScaling = extraSelfAtkScaling;
    }

    public Float getCdmgIncrease() {
        return cdmgIncrease;
    }

    public void setCdmgIncrease(Float cdmgIncrease) {
        this.cdmgIncrease = cdmgIncrease;
    }

    public Float getPenetration() {
        return penetration;
    }

    public void setPenetration(Float penetration) {
        this.penetration = penetration;
    }

    @Override
    public String toString() {
        return "SkillData [name=" + name + ", rate=" + rate + ", pow=" + pow + ", targets=" + targets
                + ", selfHpScaling=" + selfHpScaling + ", selfAtkScaling=" + selfAtkScaling + ", selfDefScaling="
                + selfDefScaling + ", selfSpdScaling=" + selfSpdScaling + ", increasedValue=" + increasedValue
                + ", extraSelfHpScaling=" + extraSelfHpScaling + ", extraSelfDefScaling=" + extraSelfDefScaling
                + ", extraSelfAtkScaling=" + extraSelfAtkScaling + ", cdmgIncrease=" + cdmgIncrease + ", penetration="
                + penetration + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SkillData skillData;

        public Builder() {
            skillData = new SkillData();
        }

        public SkillData build() {
            return skillData;
        }
    }
}
