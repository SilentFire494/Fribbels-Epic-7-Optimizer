package com.fribbels.response;

import com.fribbels.model.Hero;
import com.fribbels.model.HeroStats;

public class GetHeroByIdResponse extends Response {

    private Hero hero;
    private HeroStats baseStats;

    public GetHeroByIdResponse() {
    }

    public GetHeroByIdResponse(Hero hero, HeroStats baseStats) {
        this.hero = hero;
        this.baseStats = baseStats;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public HeroStats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(HeroStats baseStats) {
        this.baseStats = baseStats;
    }

    @Override
    public String toString() {
        return "GetHeroByIdResponse [hero=" + hero + ", baseStats=" + baseStats + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private GetHeroByIdResponse response;

        public Builder() {
            response = new GetHeroByIdResponse();
        }

        public Builder hero(Hero hero) {
            response.setHero(hero);
            return this;
        }

        public Builder baseStats(HeroStats baseStats) {
            response.setBaseStats(baseStats);
            return this;
        }

        public GetHeroByIdResponse build() {
            return response;
        }
    }

}
