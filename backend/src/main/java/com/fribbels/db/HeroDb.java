package com.fribbels.db;

import com.fribbels.enums.Gear;
import com.fribbels.model.Hero;
import com.fribbels.model.HeroStats;
import com.fribbels.request.OptimizationRequest;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The HeroDb class manages a collection of heroes, allowing operations such as adding heroes,
 * retrieving hero details, saving optimization requests, and managing builds for individual heroes.
 */
public class HeroDb {

    private BaseStatsDb baseStatsDb;

    private List<Hero> heroes;

    public HeroDb(final BaseStatsDb baseStatsDb) {
        heroes = new ArrayList<>();
        this.baseStatsDb = baseStatsDb;
    }

    /**
     * Adds a list of heroes to the database, sanitizing each hero's data.
     * The hero's index is set based on its position in the list.
     *
     * @param newHeroes A list of new heroes to add.
     */
    public void addHeroes(final List<Hero> newHeroes) {
        newHeroes.forEach(this::sanitizeHero);
        heroes.addAll(newHeroes);
        for (int i = 0; i < heroes.size(); i++) {
            final Hero hero = heroes.get(i);
            hero.setIndex(i + 1);
        }
    }

    /**
     * Ensures that each hero has valid equipment and build lists.
     * Initializes missing fields with default values.
     *
     * @param hero The hero to sanitize.
     */
    private void sanitizeHero(final Hero hero) {
        if (hero.getEquipment() == null) {
            hero.setEquipment(new EnumMap<>(Gear.class));
        }
        if (hero.getBuilds() == null) {
            hero.setBuilds(new ArrayList<>());
        }
    }

    /**
     * Retrieves all heroes in the database.
     *
     * @return A list of all heroes.
     */
    public List<Hero> getAllHeroes() {
        return heroes.stream().toList();
    }

    /**
     * Replaces the existing list of heroes with a new list.
     * Each hero's skills are updated based on the BaseStatsDb.
     * The hero's index is reset to its new position in the list.
     *
     * @param newHeroes A list of new heroes to replace the current list.
     */
    public void setHeroes(final List<Hero> newHeroes) {
        if (newHeroes.isEmpty()) {
            heroes = new ArrayList<>();
            return;
        }
        for (int i = 0; i < newHeroes.size(); i++) {
            final Hero newHero = newHeroes.get(i);
            newHero.setSkills(baseStatsDb.getBaseStatsByName(newHero.getName()).skills());
            sanitizeHero(newHero);
            newHero.setIndex(i + 1);
        }
        heroes = newHeroes;
    }

    /**
     * Retrieves a hero by their unique ID.
     *
     * @param id The unique ID of the hero.
     * @return The Hero object corresponding to the ID, or null if not found.
     */
    public Hero getHeroById(final String id) {
        return heroes.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Saves an optimization request for a specific hero. The request must contain the hero's ID.
     * The optimization request is linked to the hero, excluding sensitive details (items, hero object, etc.).
     *
     * @param request The OptimizationRequest to save.
     */
    public void saveOptimizationRequest(final OptimizationRequest request) {
        if (request.getHero() == null || request.getHero().getId() == null) {
            return;
        }

        final String heroId = request.getHero().getId();
        final Hero hero = getHeroById(heroId);

        if (hero == null) {
            return;
        }

        hero.setOptimizationRequest(request
                .withHero(null)
                .withItems(null)
                .withBoolArr(null));
    }

    /**
     * Retrieves the builds associated with a hero by their ID.
     *
     * @param heroId The unique ID of the hero.
     * @return A list of HeroStats representing the builds, or an empty list if no builds are found.
     */
    public List<HeroStats> getBuildsForHero(final String heroId) {
        if (heroId == null) {
            return List.of();
        }

        final Hero hero = getHeroById(heroId);
        if (hero == null) {
            return List.of();
        }

        if (hero.getBuilds() == null) {
            hero.setBuilds(new ArrayList<>());
        }

        return hero.getBuilds();
    }

    /**
     * Adds a new build to a hero's list of builds. The build is only added if it does not already exist
     * in the hero's build list.
     *
     * @param heroId The unique ID of the hero.
     * @param build  The HeroStats build to add.
     */
    public void addBuildToHero(final String heroId, final HeroStats build) {
        if (heroId == null || build == null || build.getBuildHash() == null) {
            return;
        }

        final Hero hero = getHeroById(heroId);
        if (hero == null) {
            return;
        }

        if (hero.getBuilds() == null) {
            hero.setBuilds(new ArrayList<>());
        }

        if (!hero.getBuilds().stream()
                .map(HeroStats::getBuildHash)
                .collect(Collectors.toSet())
                .contains(build.getBuildHash())) {
            hero.getBuilds().add(build);
            System.out.println("Found new build. Adding to hero: " + hero);
        }

        System.out.println("Done adding");
    }
}
