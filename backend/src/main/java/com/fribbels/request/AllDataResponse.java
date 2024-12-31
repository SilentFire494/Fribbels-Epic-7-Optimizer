package com.fribbels.request;

import com.fribbels.model.Hero;
import com.fribbels.model.Item;
import com.fribbels.model.Request;

import java.util.List;

public class AllDataResponse extends Request {

    private List<Hero> heroes;
    private List<Item> items;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "AllDataResponse [heroes=" + heroes + ", items=" + items + "]";
    }
}
