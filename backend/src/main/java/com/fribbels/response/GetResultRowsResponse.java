package com.fribbels.response;

import java.util.Arrays;

import com.fribbels.model.HeroStats;

public class GetResultRowsResponse extends Response {

    private HeroStats[] heroStats;
    private long maximum;

    public GetResultRowsResponse(HeroStats[] heroStats, long maximum) {
        this.heroStats = heroStats;
        this.maximum = maximum;
    }

    public HeroStats[] getHeroStats() {
        return heroStats;
    }

    public void setHeroStats(HeroStats[] heroStats) {
        this.heroStats = heroStats;
    }

    public long getMaximum() {
        return maximum;
    }

    public void setMaximum(long maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "GetResultRowsResponse [heroStats=" + Arrays.toString(heroStats) + ", maximum=" + maximum + "]";
    }

}
