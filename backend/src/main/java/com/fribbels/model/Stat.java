package com.fribbels.model;

import com.fribbels.enums.StatType;

public record Stat(StatType type, Integer value, Integer rolls, Integer ingameRolls, Boolean modified) {

    @Override
    public String toString() {
        return "Stat []";
    }
}