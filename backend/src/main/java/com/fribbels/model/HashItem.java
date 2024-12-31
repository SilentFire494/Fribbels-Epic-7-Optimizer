package com.fribbels.model;

import com.fribbels.enums.Gear;
import com.fribbels.enums.Rank;
import com.fribbels.enums.Set;
import com.google.gson.Gson;

public class HashItem {

    private Gear gear;
    private Rank rank;
    private Set set;

    private Integer enhance;
    private Integer level;

    private Stat main;
    private AugmentedStats augmentedStats;

    public HashItem(Gear gear, Rank rank, Set set, Integer enhance, Integer level, Stat main,
            AugmentedStats augmentedStats) {
        this.gear = gear;
        this.rank = rank;
        this.set = set;
        this.enhance = enhance;
        this.level = level;
        this.main = main;
        this.augmentedStats = augmentedStats;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Integer getEnhance() {
        return enhance;
    }

    public void setEnhance(Integer enhance) {
        this.enhance = enhance;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Stat getMain() {
        return main;
    }

    public void setMain(Stat main) {
        this.main = main;
    }

    public AugmentedStats getAugmentedStats() {
        return augmentedStats;
    }

    public void setAugmentedStats(AugmentedStats augmentedStats) {
        this.augmentedStats = augmentedStats;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gear == null) ? 0 : gear.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((set == null) ? 0 : set.hashCode());
        result = prime * result + ((enhance == null) ? 0 : enhance.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((main == null) ? 0 : main.hashCode());
        result = prime * result + ((augmentedStats == null) ? 0 : augmentedStats.hashCode());
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
        HashItem other = (HashItem) obj;
        if (gear != other.gear)
            return false;
        if (rank != other.rank)
            return false;
        if (set != other.set)
            return false;
        if (enhance == null) {
            if (other.enhance != null)
                return false;
        } else if (!enhance.equals(other.enhance))
            return false;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (main == null) {
            if (other.main != null)
                return false;
        } else if (!main.equals(other.main))
            return false;
        if (augmentedStats == null) {
            if (other.augmentedStats != null)
                return false;
        } else if (!augmentedStats.equals(other.augmentedStats))
            return false;
        return true;
    }

}
