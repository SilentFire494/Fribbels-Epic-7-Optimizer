package com.fribbels.model;

import com.fribbels.enums.StatType;
import com.google.gson.Gson;

public class Mod {

    private StatType originalType;
    private StatType type;
    private Integer originalValue;
    private Integer value;
    private Integer index;

    public Mod(StatType originalType, StatType type, Integer originalValue, Integer value, Integer index) {
        this.originalType = originalType;
        this.type = type;
        this.originalValue = originalValue;
        this.value = value;
        this.index = index;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public void modifyAugmentedStats(final AugmentedStats stats) {
        // Clear old stat
        if (originalType == StatType.ATTACK) {
            stats.setAttack(0);
        }
        if (originalType == StatType.ATTACKPERCENT) {
            stats.setAttackPercent(0);
        }
        if (originalType == StatType.CRITRATE) {
            stats.setCritRate(0);
        }
        if (originalType == StatType.CRITDAMAGE) {
            stats.setCritDamage(0);
        }
        if (originalType == StatType.DEFENSE) {
            stats.setDefense(0);
        }
        if (originalType == StatType.DEFENSEPERCENT) {
            stats.setDefensePercent(0);
        }
        if (originalType == StatType.EFFECTRESISTANCE) {
            stats.setEffectResistance(0);
        }
        if (originalType == StatType.EFFECTIVENESS) {
            stats.setEffectiveness(0);
        }
        if (originalType == StatType.HEALTH) {
            stats.setHealth(0);
        }
        if (originalType == StatType.HEALTHPERCENT) {
            stats.setHealthPercent(0);
        }
        if (originalType == StatType.SPEED) {
            stats.setSpeed(0);
        }

        // New stats
        if (type == StatType.ATTACK) {
            stats.setAttack(value);
        }
        if (type == StatType.ATTACKPERCENT) {
            stats.setAttackPercent(value);
        }
        if (type == StatType.CRITRATE) {
            stats.setCritRate(value);
        }
        if (type == StatType.CRITDAMAGE) {
            stats.setCritDamage(value);
        }
        if (type == StatType.DEFENSE) {
            stats.setDefense(value);
        }
        if (type == StatType.DEFENSEPERCENT) {
            stats.setDefensePercent(value);
        }
        if (type == StatType.EFFECTRESISTANCE) {
            stats.setEffectResistance(value);
        }
        if (type == StatType.EFFECTIVENESS) {
            stats.setEffectiveness(value);
        }
        if (type == StatType.HEALTH) {
            stats.setHealth(value);
        }
        if (type == StatType.HEALTHPERCENT) {
            stats.setHealthPercent(value);
        }
        if (type == StatType.SPEED) {
            stats.setSpeed(value);
        }

    }

    public StatType getOriginalType() {
        return originalType;
    }

    public void setOriginalType(StatType originalType) {
        this.originalType = originalType;
    }

    public StatType getType() {
        return type;
    }

    public void setType(StatType type) {
        this.type = type;
    }

    public Integer getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(Integer originalValue) {
        this.originalValue = originalValue;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((originalType == null) ? 0 : originalType.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((originalValue == null) ? 0 : originalValue.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((index == null) ? 0 : index.hashCode());
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
        Mod other = (Mod) obj;
        if (originalType != other.originalType)
            return false;
        if (type != other.type)
            return false;
        if (originalValue == null) {
            if (other.originalValue != null)
                return false;
        } else if (!originalValue.equals(other.originalValue))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (index == null) {
            if (other.index != null)
                return false;
        } else if (!index.equals(other.index))
            return false;
        return true;
    }

}
