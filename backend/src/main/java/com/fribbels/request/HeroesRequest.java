package com.fribbels.request;

import com.fribbels.model.Hero;
import com.fribbels.model.Request;

import java.util.List;

public class HeroesRequest extends Request {

    private List<Hero> heroes;

    public HeroesRequest(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public String toString() {
        return "HeroesRequest [heroes=" + heroes + "]";
    }

}