package com.fribbels.response;

import com.fribbels.model.HeroStats;

public class HeroStatsResponse extends Response {

    private HeroStats heroStats;

    public HeroStats getHeroStats() {
        return heroStats;
    }

    public void setHeroStats(HeroStats heroStats) {
        this.heroStats = heroStats;
    }

    @Override
    public String toString() {
        return "HeroStatsResponse [heroStats=" + heroStats + "]";
    }

}
