package com.fribbels.request;

import com.fribbels.model.HeroSkillOptions;
import com.fribbels.model.Request;

public class SkillOptionsRequest extends Request {

    private String heroId;

    private HeroSkillOptions skillOptions;

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public HeroSkillOptions getSkillOptions() {
        return skillOptions;
    }

    public void setSkillOptions(HeroSkillOptions skillOptions) {
        this.skillOptions = skillOptions;
    }

    @Override
    public String toString() {
        return "SkillOptionsRequest [heroId=" + heroId + ", skillOptions=" + skillOptions + "]";
    }

}
