package com.fribbels.request;

import com.fribbels.model.Request;

import java.util.List;

public class EquipItemsOnHeroRequest extends Request {

    private String heroId;
    private List<String> itemIds;
    private boolean useReforgeStats; // Optional

    public EquipItemsOnHeroRequest(String heroId, List<String> itemIds, boolean useReforgeStats) {
        this.heroId = heroId;
        this.itemIds = itemIds;
        this.useReforgeStats = useReforgeStats;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public boolean isUseReforgeStats() {
        return useReforgeStats;
    }

    public void setUseReforgeStats(boolean useReforgeStats) {
        this.useReforgeStats = useReforgeStats;
    }

    @Override
    public String toString() {
        return "EquipItemsOnHeroRequest [heroId=" + heroId + ", itemIds=" + itemIds + ", useReforgeStats="
                + useReforgeStats + "]";
    }

}
