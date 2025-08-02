package com.fribbels.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.fribbels.core.StatCalculator;
import com.fribbels.db.ArtifactStatsDb;
import com.fribbels.db.BaseStatsDb;
import com.fribbels.db.HeroDb;
import com.fribbels.db.ItemDb;
import com.fribbels.enums.Gear;
import com.fribbels.model.ArtifactStats;
import com.fribbels.model.AugmentedStats;
import com.fribbels.model.BaseStats;
import com.fribbels.model.Hero;
import com.fribbels.model.HeroStats;
import com.fribbels.model.Item;
import com.fribbels.model.Mod;
import com.fribbels.request.ArtifactStatsRequest;
import com.fribbels.request.BaseStatsRequest;
import com.fribbels.request.BonusStatsRequest;
import com.fribbels.request.BuildsRequest;
import com.fribbels.request.EquipItemsOnHeroRequest;
import com.fribbels.request.GetAllHeroesRequest;
import com.fribbels.request.GetHeroByIdRequest;
import com.fribbels.request.HeroesRequest;
import com.fribbels.request.IdRequest;
import com.fribbels.request.IdsRequest;
import com.fribbels.request.ModStatsRequest;
import com.fribbels.request.OptimizationRequest;
import com.fribbels.request.ReorderRequest;
import com.fribbels.request.SkillOptionsRequest;
import com.fribbels.response.GetAllHeroesResponse;
import com.fribbels.response.GetHeroByIdResponse;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HeroesRequestHandler extends RequestHandler implements HttpHandler {

    private static boolean settingUnlockOnUnequip = false;

    private final HeroDb heroDb;
    private final BaseStatsDb baseStatsDb;
    private final ArtifactStatsDb artifactStatsDb;
    private final ItemDb itemDb;
    private final StatCalculator statCalculator;

    @Override
    public synchronized void handle(final HttpExchange exchange) throws IOException {
        System.out.println("===================== HeroesRequestHandler =====================");
        final String path = exchange.getRequestURI().getPath();

        System.out.println("Path: " + path);
        try {
            switch (path) {
                case "/heroes/addHeroes":
                    final HeroesRequest heroesRequest = this.parseRequest(exchange, HeroesRequest.class);
                    this.sendResponse(exchange, this.addHeroes(heroesRequest));
                    return;
                case "/heroes/setHeroes":
                    final HeroesRequest setHeroesRequest = this.parseRequest(exchange, HeroesRequest.class);
                    this.sendResponse(exchange, this.setHeroes(setHeroesRequest));
                    return;
                case "/heroes/getAllHeroes":
                    final GetAllHeroesRequest getAllHeroesRequest = this.parseRequest(exchange, GetAllHeroesRequest.class);
                    this.sendResponse(exchange, this.getAllHeroes(getAllHeroesRequest));
                    return;
                case "/heroes/removeHeroById":
                    final IdRequest removeHeroByIdRequest = this.parseRequest(exchange, IdRequest.class);
                    this.sendResponse(exchange, this.removeHeroById(removeHeroByIdRequest));
                    return;
                case "/heroes/unequipHeroById":
                    final IdRequest unequipHeroByIdRequest = this.parseRequest(exchange, IdRequest.class);
                    this.sendResponse(exchange, this.unequipHeroById(unequipHeroByIdRequest));
                    return;
                case "/heroes/unlockHeroById":
                    final IdRequest unlockHeroByIdRequest = this.parseRequest(exchange, IdRequest.class);
                    this.sendResponse(exchange, this.toggleLockHeroById(unlockHeroByIdRequest, false));
                    return;
                case "/heroes/lockHeroById":
                    final IdRequest lockHeroByIdRequest = this.parseRequest(exchange, IdRequest.class);
                    this.sendResponse(exchange, this.toggleLockHeroById(lockHeroByIdRequest, true));
                    return;
                case "/heroes/unequipItems":
                    final IdsRequest unequipItemsRequest = this.parseRequest(exchange, IdsRequest.class);
                    this.sendResponse(exchange, this.unequipItems(unequipItemsRequest));
                    return;
                case "/heroes/getHeroById":
                    final GetHeroByIdRequest getHeroByIdRequest = this.parseRequest(exchange, GetHeroByIdRequest.class);
                    this.sendResponse(exchange, this.getHeroById(getHeroByIdRequest));
                    return;
                case "/heroes/getBaseStats":
                    final IdRequest getBaseStatsRequest = this.parseRequest(exchange, IdRequest.class);
                    this.sendResponse(exchange, this.getBaseStats(getBaseStatsRequest));
                    return;
                case "/heroes/equipItemsOnHero":
                    final EquipItemsOnHeroRequest equipItemsOnHeroRequest = this.parseRequest(exchange,
                            EquipItemsOnHeroRequest.class);
                    this.sendResponse(exchange, this.equipItemsOnHero(equipItemsOnHeroRequest));
                    return;
                case "/heroes/setBaseStats":
                    final BaseStatsRequest baseStatsRequest = this.parseRequest(exchange, BaseStatsRequest.class);
                    this.sendResponse(exchange, this.setBaseStats(baseStatsRequest));
                    return;
                case "/heroes/setArtifactStats":
                    final ArtifactStatsRequest artifactStatsRequest = this.parseRequest(exchange,
                            ArtifactStatsRequest.class);
                    this.sendResponse(exchange, this.setArtifactsStats(artifactStatsRequest));
                    return;
                case "/heroes/setBonusStats":
                    final BonusStatsRequest bonusStatsRequest = this.parseRequest(exchange, BonusStatsRequest.class);
                    this.sendResponse(exchange, this.setBonusStats(bonusStatsRequest));
                    return;
                case "/heroes/setSkillOptions":
                    final SkillOptionsRequest skillOptionsRequest = this.parseRequest(exchange, SkillOptionsRequest.class);
                    this.sendResponse(exchange, this.setSkillOptions(skillOptionsRequest));
                    return;
                case "/heroes/setModStats":
                    final ModStatsRequest modStatsRequest = this.parseRequest(exchange, ModStatsRequest.class);
                    this.sendResponse(exchange, this.setModStats(modStatsRequest));
                    return;
                case "/heroes/addBuild":
                    final BuildsRequest addBuildRequest = this.parseRequest(exchange, BuildsRequest.class);
                    this.sendResponse(exchange, this.addBuild(addBuildRequest));
                    return;
                case "/heroes/editBuild":
                    final BuildsRequest editBuildRequest = this.parseRequest(exchange, BuildsRequest.class);
                    this.sendResponse(exchange, this.editBuild(editBuildRequest));
                    return;
                case "/heroes/removeBuild":
                    final BuildsRequest removeBuildRequest = this.parseRequest(exchange, BuildsRequest.class);
                    this.sendResponse(exchange, this.removeBuild(removeBuildRequest));
                    return;
                case "/heroes/reorderHeroes":
                    final ReorderRequest reorderRequest = this.parseRequest(exchange, ReorderRequest.class);
                    this.sendResponse(exchange, this.reorderHeroes(reorderRequest));
                    return;
                case "/heroes/saveOptimizationRequest":
                    final OptimizationRequest optimizationRequest = this.parseRequest(exchange, OptimizationRequest.class);
                    this.sendResponse(exchange, this.saveOptimizationRequest(optimizationRequest));
                    return;

                default:
                    System.out.println("No handler found for " + path);
            }

            this.sendResponse(exchange, "ERROR");
        } catch (final Exception e) {
            e.printStackTrace();
            throw (e);
        }
    }

    String addHeroes(final HeroesRequest request) {
        this.heroDb.addHeroes(request.getHeroes());
        return "";
    }

    boolean addStatsToBuild(final Hero hero, final HeroStats baseStats, final HeroStats build,
            final boolean useReforgeStats) {
        final ArtifactStats artifactStats = this.artifactStatsDb.getArtifactStats(hero.getArtifactName(),
                this.parseArtifactLevel(hero.getArtifactLevel()));

        hero.setArtifactHealth(artifactStats.getHealth());
        hero.setArtifactAttack(artifactStats.getAttack());
        hero.setArtifactDefense(artifactStats.getDefense());

        final List<String> itemIds = build.getItems();
        final List<Item> items = this.itemDb.getItemsById(itemIds);

        for (final Item item : items) {
            if (item == null) {
                return false;
            }
        }
        
        final int[] setsArr = this.statCalculator.buildSetsArr(items.toArray(new Item[0]));

        final float[][] statAccumulatorArrs = new float[6][];
        for (int i = 0; i < 6; i++) {
            final Item item = items.get(i);
            final Mod mod = build.getMods() == null ? null : build.getMods().get(i);

            if (mod != null) {
                final AugmentedStats clonedReforgedStats = item.getReforgedStats().withAttack(-1);
                clonedReforgedStats.setAttack(item.getReforgedStats().getAttack());
                final Item clonedItem = item.withReforgedStats(clonedReforgedStats);

                mod.modifyAugmentedStats(clonedReforgedStats);

                final float[] acc = this.statCalculator.createStatAccumulator(baseStats, clonedItem, useReforgeStats);
                statAccumulatorArrs[i] = acc;
            } else {
                final float[] acc = this.statCalculator.createStatAccumulator(baseStats, item, useReforgeStats);
                statAccumulatorArrs[i] = acc;
            }

        }

        this.statCalculator.calculateBaseValues(baseStats, hero);
        final int upgrades = items.stream().mapToInt(Item::getUpgradeable).sum();
        final int conversions = items.stream().mapToInt(Item::getConvertable).sum();
        final int priority = items.stream().mapToInt(Item::getPriority).sum();
        final HeroStats finalStats = this.statCalculator.addAccumulatorArrsToHero(baseStats, statAccumulatorArrs, setsArr,
                hero, upgrades, conversions, 0, priority);
        build.setAtk(finalStats.getAtk());
        build.setHp(finalStats.getHp());
        build.setDef(finalStats.getDef());
        build.setCr(finalStats.getCr());
        build.setCd(finalStats.getCd());
        build.setEff(finalStats.getEff());
        build.setRes(finalStats.getRes());
        build.setSpd(finalStats.getSpd());
        build.setCp(finalStats.getCp());
        build.setEhp(finalStats.getEhp());
        build.setHpps(finalStats.getHpps());
        build.setEhpps(finalStats.getEhpps());
        build.setDmg(finalStats.getDmg());
        build.setDmgps(finalStats.getDmgps());
        build.setMcdmg(finalStats.getMcdmg());
        build.setMcdmgps(finalStats.getMcdmgps());
        build.setDmgh(finalStats.getDmgh());
        build.setDmgd(finalStats.getDmgd());
        build.setS1(finalStats.getS1());
        build.setS2(finalStats.getS2());
        build.setS3(finalStats.getS3());
        build.setUpgrades(finalStats.getUpgrades());
        build.setScore(finalStats.getScore());
        build.setBs(finalStats.getBs());
        build.setPriority(finalStats.getPriority());
        build.setConversions(finalStats.getConversions());
        build.setEq(finalStats.getEq());

        return true;
    }

    String equipItemsOnHero(final EquipItemsOnHeroRequest request) {
        final String heroId = request.getHeroId();
        if (this.heroDb.getHeroById(heroId) == null)
            return "";

        final List<String> itemIds = request.getItemIds();
        final List<Item> items = itemIds.stream()
                .map(this.itemDb::getItemById)
                .toList();

        for (final Item item : items) {
            this.itemDb.equipItemOnHero(item.getId(), heroId);
        }

        final Hero hero = this.heroDb.getHeroById(heroId);
        this.addStatsToHero(hero, request.isUseReforgeStats());
        final GetHeroByIdResponse response = GetHeroByIdResponse.builder()
                .hero(hero)
                .build();

        return this.toJson(response);
    }

    private String addBuild(final BuildsRequest request) {
        this.heroDb.addBuildToHero(request.getHeroId(), request.getBuild());
        return "";
    }

    private String editBuild(final BuildsRequest request) {
        final HeroStats build = request.getBuild();
        final List<HeroStats> builds = this.heroDb.getBuildsForHero(request.getHeroId());

        if (builds == null || build == null)
            return "";

        final String buildHash = build.getBuildHash();
        final HeroStats matchingBuild = builds.stream()
                .filter(x -> x.getBuildHash().equals(buildHash))
                .findFirst()
                .orElse(null);

        if (matchingBuild == null)
            return "";

        matchingBuild.setName(build.getName());

        return "";
    }

    private String removeBuild(final BuildsRequest request) {
        final HeroStats build = request.getBuild();
        final Hero hero = this.heroDb.getHeroById(request.getHeroId());
        final List<HeroStats> builds = this.heroDb.getBuildsForHero(request.getHeroId());

        if (builds == null || build == null || hero == null)
            return "";

        final String buildHash = build.getBuildHash();
        final List<HeroStats> changedBuilds = builds.stream()
                .filter(x -> !x.getBuildHash().equals(buildHash))
                .collect(Collectors.toCollection(ArrayList::new));

        hero.setBuilds(changedBuilds);

        return "";
    }

    private String reorderHeroes(final ReorderRequest request) {
        final List<Hero> heroes = this.heroDb.getAllHeroes();
        final Hero dragHero = this.heroDb.getHeroById(request.getId());
        Integer destinationIndex = request.getDestinationIndex();
        // Rank is 1 indexed on the UI
        if (destinationIndex == null)
            return "";

        if (destinationIndex >= heroes.size())
            destinationIndex = heroes.size();

        if (destinationIndex <= 0)
            destinationIndex = 1;

        destinationIndex--;

        final Hero destinationHero = heroes.get(destinationIndex);

        System.out.println(destinationHero.getName());

        if (dragHero == null || dragHero == destinationHero)
            return "";

        heroes.remove(dragHero);
        heroes.add(destinationIndex, dragHero);

        this.heroDb.setHeroes(heroes);
        return "";
    }

    private String saveOptimizationRequest(final OptimizationRequest request) {
        this.heroDb.saveOptimizationRequest(request);
        return "";
    }

    private String setBaseStats(final BaseStatsRequest request) {
        this.baseStatsDb.setBaseStatsByName(request.getBaseStatsByName());
        return "";
    }

    private String setArtifactsStats(final ArtifactStatsRequest request) {
        this.artifactStatsDb.setArtifactStatsByName(request.getArtifactStatsByName());
        return "";
    }

    private String setBonusStats(final BonusStatsRequest request) {
        final Hero hero = this.heroDb.getHeroById(request.getHeroId());
        if (hero == null)
            return "";

        hero.setBonusStats(request);

        return "";
    }

    private String setSkillOptions(final SkillOptionsRequest request) {
        System.out.println(request);
        final Hero hero = this.heroDb.getHeroById(request.getHeroId());
        if (hero == null)
            return "";

        hero.setSkillOptions(request);

        return "";
    }

    private String setModStats(final ModStatsRequest request) {
        final Hero hero = this.heroDb.getHeroById(request.getHeroId());
        if (hero == null)
            return "";

        hero.setModStats(request);

        return "";
    }

    private String setHeroes(final HeroesRequest request) {
        this.heroDb.setHeroes(request.getHeroes());
        return "";
    }

    private String getAllHeroes(final GetAllHeroesRequest request) {
        try {
            final List<Hero> rawHeroes = this.heroDb.getAllHeroes();
            final List<Hero> heroes = rawHeroes.stream().map(x -> x.withCp(x.getCp())).toList();

            for (final Hero hero : heroes) {
                this.addStatsToHero(hero, request.isUseReforgeStats());
            }

            final GetAllHeroesResponse response = GetAllHeroesResponse.builder().heroes(heroes).build();

            return this.toJson(response);
        } catch (final RuntimeException e) {
            System.err.println("err" + e);
            e.printStackTrace();
            throw (e);
        }
    }

    private int parseArtifactLevel(final String artifactLevel) {
        if (StringUtils.isNumeric(artifactLevel)) {
            return Integer.parseInt(artifactLevel);
        }
        return 0;
    }

    private void addStatsToHero(final Hero hero, final boolean useReforgeStats) {
        final HeroStats baseStats = this.baseStatsDb.getBaseStatsByName(hero.getName(), hero.getStars());

        final ArtifactStats artifactStats = this.artifactStatsDb.getArtifactStats(hero.getArtifactName(),
                this.parseArtifactLevel(hero.getArtifactLevel()));

        hero.setArtifactHealth(artifactStats.getHealth());
        hero.setArtifactAttack(artifactStats.getAttack());
        hero.setArtifactDefense(artifactStats.getDefense());

        final Map<Gear, Item> equipment = hero.getEquipment();
        equipment.entrySet()
                .stream()
                .forEach(x -> {
                    final Item item = this.itemDb.getItemById(x.getValue().getId());
                    if (item == null)
                        return;

                    equipment.put(x.getKey(), item);
                });

        if (equipment.values().size() != 6) {
            hero.setStats(new HeroStats());
            this.clearNullBuilds(hero, baseStats, useReforgeStats);
            return;
        }

        final Item[] items = Iterables.toArray(equipment.values(), Item.class);

        final int[] setsArr = this.statCalculator.buildSetsArr(items);
        final List<float[]> statAccumulators = equipment.values()
                .stream()
                .map(item -> this.statCalculator.createStatAccumulator(baseStats, item, useReforgeStats))
                .toList();
        final float[][] statAccumulatorArrs = Iterables.toArray(statAccumulators, float[].class);

        this.statCalculator.calculateBaseValues(baseStats, hero);
        final int upgrades = equipment.values().stream().mapToInt(Item::getUpgradeable).sum();
        final int conversions = equipment.values().stream().mapToInt(Item::getConvertable).sum();
        final int priority = equipment.values().stream().mapToInt(Item::getPriority).sum();
        final HeroStats finalStats = this.statCalculator.addAccumulatorArrsToHero(baseStats, statAccumulatorArrs, setsArr,
                hero, upgrades, conversions, 0, priority);
        hero.setStats(finalStats);
        this.clearNullBuilds(hero, baseStats, useReforgeStats);

    }

    private void clearNullBuilds(final Hero hero, final HeroStats baseStats, final boolean useReforgeStats) {
        final List<HeroStats> builds = hero.getBuilds();

        if (builds == null || builds.isEmpty())
            return;

        final List<HeroStats> validBuilds = builds.stream()
                .filter(build -> this.addStatsToBuild(hero, baseStats, build, useReforgeStats))
                .collect(Collectors.toCollection(ArrayList::new));

        hero.setBuilds(validBuilds);
    }

    private String getHeroById(final GetHeroByIdRequest request) {
        if (request.getId() == null)
            return "";

        final Hero hero = this.heroDb.getHeroById(request.getId());
        if (hero == null)
            return "";

        final HeroStats baseStats = this.baseStatsDb.getBaseStatsByName(hero.getName(), hero.getStars());
        if (baseStats == null)
            return "";

        this.addStatsToHero(hero, request.isUseReforgeStats());
        final GetHeroByIdResponse response = GetHeroByIdResponse.builder()
                .hero(hero)
                .baseStats(baseStats)
                .build();

        return this.toJson(response);
    }

    private String getBaseStats(final IdRequest request) {
        if (request.getId() == null)
            return "";

        final BaseStats baseStats = this.baseStatsDb.getBaseStatsByName(request.getId());

        return new Gson().toJson(baseStats);
    }

    private String removeHeroById(final IdRequest request) {
        System.out.println(request);
        final String id = request.getId();
        final Hero hero = this.heroDb.getHeroById(id);

        if (hero == null)
            return "";

        if (hero.getEquipment() != null) {
            final Item[] equipment = hero.getEquipment().values().toArray(new Item[0]);
            for (int i = 0; i < equipment.length; i++) {
                final Item previousItem = equipment[i];

                if (previousItem == null) {
                    continue;
                }

                final Item dbItem = this.itemDb.getItemById(previousItem.getId());

                dbItem.setEquippedById(null);
                dbItem.setEquippedByName(null);

                if (settingUnlockOnUnequip) {
                    dbItem.setLocked(false);
                }
            }
            hero.setEquipment(new EnumMap<>(Gear.class));
        }

        final List<Hero> heroes = this.heroDb.getAllHeroes();
        final List<Hero> newHeroes = heroes.stream()
                .filter(x -> !x.getId().equals(request.getId()))
                .toList();
        this.heroDb.setHeroes(newHeroes);

        final GetAllHeroesResponse response = GetAllHeroesResponse.builder()
                .heroes(newHeroes)
                .build();

        return this.toJson(response);
    }

    private String unequipHeroById(final IdRequest request) {
        System.out.println(request);
        final String id = request.getId();
        final Hero hero = this.heroDb.getHeroById(id);

        if (hero == null)
            return "";

        if (hero.getEquipment() != null) {
            final Item[] equipment = hero.getEquipment().values().toArray(new Item[0]);
            for (int i = 0; i < equipment.length; i++) {
                final Item previousItem = equipment[i];

                if (previousItem == null) {
                    continue;
                }

                final Item dbItem = this.itemDb.getItemById(previousItem.getId());

                dbItem.setEquippedById(null);
                dbItem.setEquippedByName(null);

                if (settingUnlockOnUnequip) {
                    dbItem.setLocked(false);
                }
            }
            hero.setEquipment(new EnumMap<>(Gear.class));
        }

        return "";
    }

    private String toggleLockHeroById(final IdRequest request, final boolean locked) {
        System.out.println(request);
        final String id = request.getId();
        final Hero hero = this.heroDb.getHeroById(id);

        if (hero == null)
            return "";

        if (hero.getEquipment() != null) {
            final Item[] equipment = hero.getEquipment().values().toArray(new Item[0]);
            for (int i = 0; i < equipment.length; i++) {
                final Item item = equipment[i];

                if (item == null) {
                    continue;
                }

                final Item dbItem = this.itemDb.getItemById(item.getId());
                dbItem.setLocked(locked);
            }
        }

        return "";
    }

    private String unequipItems(final IdsRequest request) {
        System.out.println(request);
        final List<Item> items = this.itemDb.getItemsById(request.getIds());
        for (final Item item : items) {
            this.itemDb.unequipItem(item.getId());
        }

        return "";
    }

    public static boolean isSettingUnlockOnUnequip() {
        return settingUnlockOnUnequip;
    }

    public static void setSettingUnlockOnUnequip(boolean settingUnlockOnUnequip) {
        HeroesRequestHandler.settingUnlockOnUnequip = settingUnlockOnUnequip;
    }
}
