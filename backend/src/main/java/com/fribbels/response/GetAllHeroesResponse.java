package com.fribbels.response;

import com.fribbels.model.Hero;

import java.util.List;

public class GetAllHeroesResponse extends Response {

    private List<Hero> heroes;

    public GetAllHeroesResponse(List<Hero> heroes) {
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
        return "GetAllHeroesResponse [heroes=" + heroes + "]";
    }

}
