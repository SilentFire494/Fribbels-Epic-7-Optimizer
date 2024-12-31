package com.fribbels.request;

import com.fribbels.enums.StatType;
import com.fribbels.model.Request;

import java.util.List;

public class ModStatsRequest extends Request {

    private String modGrade;
    private String keepStatOptions;
    private Float rollQuality;
    private Integer limitRolls;
    private List<StatType> keepStats;
    private List<StatType> ignoreStats;
    private List<StatType> discardStats;
    private String heroId;

    public String getModGrade() {
        return modGrade;
    }

    public void setModGrade(String modGrade) {
        this.modGrade = modGrade;
    }

    public String getKeepStatOptions() {
        return keepStatOptions;
    }

    public void setKeepStatOptions(String keepStatOptions) {
        this.keepStatOptions = keepStatOptions;
    }

    public Float getRollQuality() {
        return rollQuality;
    }

    public void setRollQuality(Float rollQuality) {
        this.rollQuality = rollQuality;
    }

    public Integer getLimitRolls() {
        return limitRolls;
    }

    public void setLimitRolls(Integer limitRolls) {
        this.limitRolls = limitRolls;
    }

    public List<StatType> getKeepStats() {
        return keepStats;
    }

    public void setKeepStats(List<StatType> keepStats) {
        this.keepStats = keepStats;
    }

    public List<StatType> getIgnoreStats() {
        return ignoreStats;
    }

    public void setIgnoreStats(List<StatType> ignoreStats) {
        this.ignoreStats = ignoreStats;
    }

    public List<StatType> getDiscardStats() {
        return discardStats;
    }

    public void setDiscardStats(List<StatType> discardStats) {
        this.discardStats = discardStats;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    @Override
    public String toString() {
        return "ModStatsRequest [modGrade=" + modGrade + ", keepStatOptions=" + keepStatOptions + ", rollQuality="
                + rollQuality + ", limitRolls=" + limitRolls + ", keepStats=" + keepStats + ", ignoreStats="
                + ignoreStats + ", discardStats=" + discardStats + ", heroId=" + heroId + "]";
    }

}
