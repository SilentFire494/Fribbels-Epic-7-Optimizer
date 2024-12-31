package com.fribbels.model;

import com.fribbels.enums.StatType;
import com.google.gson.annotations.SerializedName;

public class AugmentedStats {

    @SerializedName("Attack")
    private int attack;
    @SerializedName("AttackPercent")
    private int attackPercent;
    @SerializedName("CriticalHitChancePercent")
    private int critRate;
    @SerializedName("CriticalHitDamagePercent")
    private int critDamage;
    @SerializedName("Defense")
    private int defense;
    @SerializedName("DefensePercent")
    private int defensePercent;
    @SerializedName("EffectResistancePercent")
    private int effectResistance;
    @SerializedName("EffectivenessPercent")
    private int effectiveness;
    @SerializedName("Health")
    private int health;
    @SerializedName("HealthPercent")
    private int healthPercent;
    @SerializedName("Speed")
    private int speed;
    private StatType mainType;
    private int mainValue;

    private AugmentedStats() {
    }

    public AugmentedStats(int attack, int attackPercent, int critRate, int critDamage, int defense, int defensePercent,
            int effectResistance, int effectiveness, int health, int healthPercent, int speed, StatType mainType,
            int mainValue) {
        this.attack = attack;
        this.attackPercent = attackPercent;
        this.critRate = critRate;
        this.critDamage = critDamage;
        this.defense = defense;
        this.defensePercent = defensePercent;
        this.effectResistance = effectResistance;
        this.effectiveness = effectiveness;
        this.health = health;
        this.healthPercent = healthPercent;
        this.speed = speed;
        this.mainType = mainType;
        this.mainValue = mainValue;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttackPercent() {
        return attackPercent;
    }

    public void setAttackPercent(int attackPercent) {
        this.attackPercent = attackPercent;
    }

    public int getCritRate() {
        return critRate;
    }

    public void setCritRate(int critRate) {
        this.critRate = critRate;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(int critDamage) {
        this.critDamage = critDamage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefensePercent() {
        return defensePercent;
    }

    public void setDefensePercent(int defensePercent) {
        this.defensePercent = defensePercent;
    }

    public int getEffectResistance() {
        return effectResistance;
    }

    public void setEffectResistance(int effectResistance) {
        this.effectResistance = effectResistance;
    }

    public int getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(int effectiveness) {
        this.effectiveness = effectiveness;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthPercent() {
        return healthPercent;
    }

    public void setHealthPercent(int healthPercent) {
        this.healthPercent = healthPercent;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public StatType getMainType() {
        return mainType;
    }

    public void setMainType(StatType mainType) {
        this.mainType = mainType;
    }

    public int getMainValue() {
        return mainValue;
    }

    public void setMainValue(int mainValue) {
        this.mainValue = mainValue;
    }

    @Override
    public String toString() {
        return "AugmentedStats [attack=" + attack + ", attackPercent=" + attackPercent + ", critRate=" + critRate
                + ", critDamage=" + critDamage + ", defense=" + defense + ", defensePercent=" + defensePercent
                + ", effectResistance=" + effectResistance + ", effectiveness=" + effectiveness + ", health=" + health
                + ", healthPercent=" + healthPercent + ", speed=" + speed + ", mainType=" + mainType + ", mainValue="
                + mainValue + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + attack;
        result = prime * result + attackPercent;
        result = prime * result + critRate;
        result = prime * result + critDamage;
        result = prime * result + defense;
        result = prime * result + defensePercent;
        result = prime * result + effectResistance;
        result = prime * result + effectiveness;
        result = prime * result + health;
        result = prime * result + healthPercent;
        result = prime * result + speed;
        result = prime * result + ((mainType == null) ? 0 : mainType.hashCode());
        result = prime * result + mainValue;
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
        AugmentedStats other = (AugmentedStats) obj;
        if (attack != other.attack)
            return false;
        if (attackPercent != other.attackPercent)
            return false;
        if (critRate != other.critRate)
            return false;
        if (critDamage != other.critDamage)
            return false;
        if (defense != other.defense)
            return false;
        if (defensePercent != other.defensePercent)
            return false;
        if (effectResistance != other.effectResistance)
            return false;
        if (effectiveness != other.effectiveness)
            return false;
        if (health != other.health)
            return false;
        if (healthPercent != other.healthPercent)
            return false;
        if (speed != other.speed)
            return false;
        if (mainType != other.mainType)
            return false;
        if (mainValue != other.mainValue)
            return false;
        return true;
    }

    public static class Builder {
        private AugmentedStats augmentedStats;

        public Builder() {
            augmentedStats = new AugmentedStats();
        }

        public Builder attack(int attack) {
            augmentedStats.attack = attack;
            return this;
        }

        public Builder attackPercent(int attackPercent) {
            augmentedStats.attackPercent = attackPercent;
            return this;
        }

        public Builder critRate(int critRate) {
            augmentedStats.critRate = critRate;
            return this;
        }

        public Builder critDamage(int critDamage) {
            augmentedStats.critDamage = critDamage;
            return this;
        }

        public Builder defense(int defense) {
            augmentedStats.defense = defense;
            return this;
        }

        public Builder defensePercent(int defensePercent) {
            augmentedStats.defensePercent = defensePercent;
            return this;
        }

        public Builder effectResistance(int effectResistance) {
            augmentedStats.effectResistance = effectResistance;
            return this;
        }

        public Builder effectiveness(int effectiveness) {
            augmentedStats.effectiveness = effectiveness;
            return this;
        }

        public Builder health(int health) {
            augmentedStats.health = health;
            return this;
        }

        public Builder healthPercent(int healthPercent) {
            augmentedStats.healthPercent = healthPercent;
            return this;
        }

        public Builder speed(int speed) {
            augmentedStats.speed = speed;
            return this;
        }

        public Builder mainType(StatType mainType) {
            augmentedStats.mainType = mainType;
            return this;
        }

        public Builder mainValue(int mainValue) {
            augmentedStats.mainValue = mainValue;
            return this;
        }

        public AugmentedStats build() {
            return augmentedStats;
        }
    }

    public AugmentedStats withAttack(int attack) {
        return this.attack == attack ? this
                : new AugmentedStats(attack, attackPercent, critRate, critDamage, defense, defensePercent,
                        effectResistance, effectiveness, health, healthPercent, speed, mainType, mainValue);
    }
}
