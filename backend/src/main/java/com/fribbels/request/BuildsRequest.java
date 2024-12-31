package com.fribbels.request;

import com.fribbels.model.HeroStats;
import com.fribbels.model.Request;

public class BuildsRequest extends Request {

    private String heroId;
    private HeroStats build;

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public HeroStats getBuild() {
        return build;
    }

    public void setBuild(HeroStats build) {
        this.build = build;
    }

    @Override
    public String toString() {
        return "BuildsRequest [heroId=" + heroId + ", build=" + build + "]";
    }

}
