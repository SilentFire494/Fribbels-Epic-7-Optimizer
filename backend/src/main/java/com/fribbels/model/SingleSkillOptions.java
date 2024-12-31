package com.fribbels.model;

public class SingleSkillOptions {

    private Float attackImprintPercent;
    private Float attackIncreasePercent;
    private Float damageIncreasePercent;
    private Boolean elementalAdvantageEnabled;
    private Boolean decreasedAttackBuffEnabled;
    private Boolean attackBuffEnabled;
    private Boolean greaterAttackBuffEnabled;
    private Boolean critDamageBuffEnabled;
    private Boolean vigorAttackBuffEnabled;

    private String skillEffect;
    private Boolean applyToAllSkills;

    private Integer targetDefense;
    private Float targetDefenseIncreasePercent;
    private Float targetDamageReductionPercent;
    private Float targetDamageTransferPercent;
    private Boolean targetDefenseBuffEnabled;
    private Boolean targetVigorDefenseBuffEnabled;
    private Boolean targetDefenseBreakBuffEnabled;
    private Boolean targetTargetBuffEnabled;

    public SingleSkillOptions() {
    }

    public SingleSkillOptions(Float attackImprintPercent, Float attackIncreasePercent, Float damageIncreasePercent,
            Boolean elementalAdvantageEnabled, Boolean decreasedAttackBuffEnabled, Boolean attackBuffEnabled,
            Boolean greaterAttackBuffEnabled, Boolean critDamageBuffEnabled, Boolean vigorAttackBuffEnabled,
            String skillEffect, Boolean applyToAllSkills, Integer targetDefense, Float targetDefenseIncreasePercent,
            Float targetDamageReductionPercent, Float targetDamageTransferPercent, Boolean targetDefenseBuffEnabled,
            Boolean targetVigorDefenseBuffEnabled, Boolean targetDefenseBreakBuffEnabled,
            Boolean targetTargetBuffEnabled) {
        this.attackImprintPercent = attackImprintPercent;
        this.attackIncreasePercent = attackIncreasePercent;
        this.damageIncreasePercent = damageIncreasePercent;
        this.elementalAdvantageEnabled = elementalAdvantageEnabled;
        this.decreasedAttackBuffEnabled = decreasedAttackBuffEnabled;
        this.attackBuffEnabled = attackBuffEnabled;
        this.greaterAttackBuffEnabled = greaterAttackBuffEnabled;
        this.critDamageBuffEnabled = critDamageBuffEnabled;
        this.vigorAttackBuffEnabled = vigorAttackBuffEnabled;
        this.skillEffect = skillEffect;
        this.applyToAllSkills = applyToAllSkills;
        this.targetDefense = targetDefense;
        this.targetDefenseIncreasePercent = targetDefenseIncreasePercent;
        this.targetDamageReductionPercent = targetDamageReductionPercent;
        this.targetDamageTransferPercent = targetDamageTransferPercent;
        this.targetDefenseBuffEnabled = targetDefenseBuffEnabled;
        this.targetVigorDefenseBuffEnabled = targetVigorDefenseBuffEnabled;
        this.targetDefenseBreakBuffEnabled = targetDefenseBreakBuffEnabled;
        this.targetTargetBuffEnabled = targetTargetBuffEnabled;
    }

    public Float getAttackImprintPercent() {
        return attackImprintPercent;
    }

    public void setAttackImprintPercent(Float attackImprintPercent) {
        this.attackImprintPercent = attackImprintPercent;
    }

    public Float getAttackIncreasePercent() {
        return attackIncreasePercent;
    }

    public void setAttackIncreasePercent(Float attackIncreasePercent) {
        this.attackIncreasePercent = attackIncreasePercent;
    }

    public Float getDamageIncreasePercent() {
        return damageIncreasePercent;
    }

    public void setDamageIncreasePercent(Float damageIncreasePercent) {
        this.damageIncreasePercent = damageIncreasePercent;
    }

    public Boolean getElementalAdvantageEnabled() {
        return elementalAdvantageEnabled;
    }

    public void setElementalAdvantageEnabled(Boolean elementalAdvantageEnabled) {
        this.elementalAdvantageEnabled = elementalAdvantageEnabled;
    }

    public Boolean getDecreasedAttackBuffEnabled() {
        return decreasedAttackBuffEnabled;
    }

    public void setDecreasedAttackBuffEnabled(Boolean decreasedAttackBuffEnabled) {
        this.decreasedAttackBuffEnabled = decreasedAttackBuffEnabled;
    }

    public Boolean getAttackBuffEnabled() {
        return attackBuffEnabled;
    }

    public void setAttackBuffEnabled(Boolean attackBuffEnabled) {
        this.attackBuffEnabled = attackBuffEnabled;
    }

    public Boolean getGreaterAttackBuffEnabled() {
        return greaterAttackBuffEnabled;
    }

    public void setGreaterAttackBuffEnabled(Boolean greaterAttackBuffEnabled) {
        this.greaterAttackBuffEnabled = greaterAttackBuffEnabled;
    }

    public Boolean getCritDamageBuffEnabled() {
        return critDamageBuffEnabled;
    }

    public void setCritDamageBuffEnabled(Boolean critDamageBuffEnabled) {
        this.critDamageBuffEnabled = critDamageBuffEnabled;
    }

    public Boolean getVigorAttackBuffEnabled() {
        return vigorAttackBuffEnabled;
    }

    public void setVigorAttackBuffEnabled(Boolean vigorAttackBuffEnabled) {
        this.vigorAttackBuffEnabled = vigorAttackBuffEnabled;
    }

    public String getSkillEffect() {
        return skillEffect;
    }

    public void setSkillEffect(String skillEffect) {
        this.skillEffect = skillEffect;
    }

    public Boolean getApplyToAllSkills() {
        return applyToAllSkills;
    }

    public void setApplyToAllSkills(Boolean applyToAllSkills) {
        this.applyToAllSkills = applyToAllSkills;
    }

    public Integer getTargetDefense() {
        return targetDefense;
    }

    public void setTargetDefense(Integer targetDefense) {
        this.targetDefense = targetDefense;
    }

    public Float getTargetDefenseIncreasePercent() {
        return targetDefenseIncreasePercent;
    }

    public void setTargetDefenseIncreasePercent(Float targetDefenseIncreasePercent) {
        this.targetDefenseIncreasePercent = targetDefenseIncreasePercent;
    }

    public Float getTargetDamageReductionPercent() {
        return targetDamageReductionPercent;
    }

    public void setTargetDamageReductionPercent(Float targetDamageReductionPercent) {
        this.targetDamageReductionPercent = targetDamageReductionPercent;
    }

    public Float getTargetDamageTransferPercent() {
        return targetDamageTransferPercent;
    }

    public void setTargetDamageTransferPercent(Float targetDamageTransferPercent) {
        this.targetDamageTransferPercent = targetDamageTransferPercent;
    }

    public Boolean getTargetDefenseBuffEnabled() {
        return targetDefenseBuffEnabled;
    }

    public void setTargetDefenseBuffEnabled(Boolean targetDefenseBuffEnabled) {
        this.targetDefenseBuffEnabled = targetDefenseBuffEnabled;
    }

    public Boolean getTargetVigorDefenseBuffEnabled() {
        return targetVigorDefenseBuffEnabled;
    }

    public void setTargetVigorDefenseBuffEnabled(Boolean targetVigorDefenseBuffEnabled) {
        this.targetVigorDefenseBuffEnabled = targetVigorDefenseBuffEnabled;
    }

    public Boolean getTargetDefenseBreakBuffEnabled() {
        return targetDefenseBreakBuffEnabled;
    }

    public void setTargetDefenseBreakBuffEnabled(Boolean targetDefenseBreakBuffEnabled) {
        this.targetDefenseBreakBuffEnabled = targetDefenseBreakBuffEnabled;
    }

    public Boolean getTargetTargetBuffEnabled() {
        return targetTargetBuffEnabled;
    }

    public void setTargetTargetBuffEnabled(Boolean targetTargetBuffEnabled) {
        this.targetTargetBuffEnabled = targetTargetBuffEnabled;
    }

    @Override
    public String toString() {
        return "SingleSkillOptions [attackImprintPercent=" + attackImprintPercent + ", attackIncreasePercent="
                + attackIncreasePercent + ", damageIncreasePercent=" + damageIncreasePercent
                + ", elementalAdvantageEnabled=" + elementalAdvantageEnabled + ", decreasedAttackBuffEnabled="
                + decreasedAttackBuffEnabled + ", attackBuffEnabled=" + attackBuffEnabled
                + ", greaterAttackBuffEnabled=" + greaterAttackBuffEnabled + ", critDamageBuffEnabled="
                + critDamageBuffEnabled + ", vigorAttackBuffEnabled=" + vigorAttackBuffEnabled + ", skillEffect="
                + skillEffect + ", applyToAllSkills=" + applyToAllSkills + ", targetDefense=" + targetDefense
                + ", targetDefenseIncreasePercent=" + targetDefenseIncreasePercent + ", targetDamageReductionPercent="
                + targetDamageReductionPercent + ", targetDamageTransferPercent=" + targetDamageTransferPercent
                + ", targetDefenseBuffEnabled=" + targetDefenseBuffEnabled + ", targetVigorDefenseBuffEnabled="
                + targetVigorDefenseBuffEnabled + ", targetDefenseBreakBuffEnabled=" + targetDefenseBreakBuffEnabled
                + ", targetTargetBuffEnabled=" + targetTargetBuffEnabled + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SingleSkillOptions singleSkillOptions;

        public Builder() {
            singleSkillOptions = new SingleSkillOptions();
        }

        public SingleSkillOptions build() {
            return singleSkillOptions;
        }
    }
}
