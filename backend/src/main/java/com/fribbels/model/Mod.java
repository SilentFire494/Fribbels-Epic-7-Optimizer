package com.fribbels.model;

import com.fribbels.enums.StatType;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Mod {

    private StatType originalType;
    private StatType type;
    private Integer originalValue;
    private Integer value;
    private Integer index;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public void modifyAugmentedStats(final AugmentedStats stats) {
        if (this.originalType == StatType.ATTACK) {
            stats.setAttack(0);
        }
        if (this.originalType == StatType.ATTACKPERCENT) {
            stats.setAttackPercent(0);
        }
        if (this.originalType == StatType.CRITRATE) {
            stats.setCritRate(0);
        }
        if (this.originalType == StatType.CRITDAMAGE) {
            stats.setCritDamage(0);
        }
        if (this.originalType == StatType.DEFENSE) {
            stats.setDefense(0);
        }
        if (this.originalType == StatType.DEFENSEPERCENT) {
            stats.setDefensePercent(0);
        }
        if (this.originalType == StatType.EFFECTRESISTANCE) {
            stats.setEffectResistance(0);
        }
        if (this.originalType == StatType.EFFECTIVENESS) {
            stats.setEffectiveness(0);
        }
        if (this.originalType == StatType.HEALTH) {
            stats.setHealth(0);
        }
        if (this.originalType == StatType.HEALTHPERCENT) {
            stats.setHealthPercent(0);
        }
        if (this.originalType == StatType.SPEED) {
            stats.setSpeed(0);
        }

        if (this.type == StatType.ATTACK) {
            stats.setAttack(this.value);
        }
        if (this.type == StatType.ATTACKPERCENT) {
            stats.setAttackPercent(this.value);
        }
        if (this.type == StatType.CRITRATE) {
            stats.setCritRate(this.value);
        }
        if (this.type == StatType.CRITDAMAGE) {
            stats.setCritDamage(this.value);
        }
        if (this.type == StatType.DEFENSE) {
            stats.setDefense(this.value);
        }
        if (this.type == StatType.DEFENSEPERCENT) {
            stats.setDefensePercent(this.value);
        }
        if (this.type == StatType.EFFECTRESISTANCE) {
            stats.setEffectResistance(this.value);
        }
        if (this.type == StatType.EFFECTIVENESS) {
            stats.setEffectiveness(this.value);
        }
        if (this.type == StatType.HEALTH) {
            stats.setHealth(this.value);
        }
        if (this.type == StatType.HEALTHPERCENT) {
            stats.setHealthPercent(this.value);
        }
        if (this.type == StatType.SPEED) {
            stats.setSpeed(this.value);
        }
    }
}
