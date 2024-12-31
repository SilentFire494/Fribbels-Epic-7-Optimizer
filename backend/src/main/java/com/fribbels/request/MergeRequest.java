package com.fribbels.request;

import com.fribbels.enums.HeroFilter;
import com.fribbels.model.Item;
import com.fribbels.model.MergeHero;
import com.fribbels.model.Request;

import java.util.List;

public class MergeRequest extends Request {

    private List<Item> items;
    private List<MergeHero> mergeHeroes;
    private Integer enhanceLimit;
    private HeroFilter heroFilter;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<MergeHero> getMergeHeroes() {
        return mergeHeroes;
    }

    public void setMergeHeroes(List<MergeHero> mergeHeroes) {
        this.mergeHeroes = mergeHeroes;
    }

    public Integer getEnhanceLimit() {
        return enhanceLimit;
    }

    public void setEnhanceLimit(Integer enhanceLimit) {
        this.enhanceLimit = enhanceLimit;
    }

    public HeroFilter getHeroFilter() {
        return heroFilter;
    }

    public void setHeroFilter(HeroFilter heroFilter) {
        this.heroFilter = heroFilter;
    }

    @Override
    public String toString() {
        return "MergeRequest [items=" + items + ", mergeHeroes=" + mergeHeroes + ", enhanceLimit=" + enhanceLimit
                + ", heroFilter=" + heroFilter + "]";
    }

}
