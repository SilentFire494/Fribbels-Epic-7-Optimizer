package com.fribbels.model;

public record BaseStats(HeroStats lv50FiveStarFullyAwakened, HeroStats lv60SixStarFullyAwakened, HeroSkills skills) {

    @Override
    public String toString() {
        return "BaseStats []";
    }
}
