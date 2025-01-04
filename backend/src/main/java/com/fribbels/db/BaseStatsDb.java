package com.fribbels.db;

import com.fribbels.model.BaseStats;
import com.fribbels.model.HeroStats;

import java.util.HashMap;
import java.util.Map;

/**
 * The BaseStatsDb class manages a collection of base stats for heroes,
 * providing methods to retrieve the hero's stats based on the name and star
 * rating.
 */
public class BaseStatsDb {

    private Map<String, BaseStats> baseStatsByName;

    public BaseStatsDb() {
        baseStatsByName = new HashMap<>();
    }

    /**
     * Retrieves the base stats for a given hero name.
     * 
     * @param name The name of the hero.
     * @return A new BaseStats object with 5 and 6 star stats, or null if the hero
     *         doesn't exist.
     */
    public BaseStats getBaseStatsByName(final String name) {
        if (!baseStatsByName.containsKey(name)) {
            return null;
        }

        final BaseStats baseStats = baseStatsByName.get(name);

        return new BaseStats(
                getBaseStatsByName(name, 5),
                getBaseStatsByName(name, 6),
                baseStats.skills());
    }

    /**
     * Retrieves the base stats for a given hero name and star rating.
     * 
     * @param name  The name of the hero.
     * @param stars The star rating of the hero (5 or 6).
     * @return A HeroStats object representing the hero's stats at the given star rating, or null if the hero doesn't exist.
     */
    public HeroStats getBaseStatsByName(final String name, final int stars) {
        if (!baseStatsByName.containsKey(name)) {
            return null;
        }

        final BaseStats baseStats = baseStatsByName.get(name);
        final HeroStats heroStats = (stars == 5)
                ? baseStats.lv50FiveStarFullyAwakened()
                : baseStats.lv60SixStarFullyAwakened();

        return HeroStats.builder()
                .atk(heroStats.getAtk())
                .hp(heroStats.getHp())
                .def(heroStats.getDef())
                .cr(heroStats.getCr())
                .cd(heroStats.getCd())
                .eff(heroStats.getEff())
                .res(heroStats.getRes())
                .dac(heroStats.getDac())
                .spd(heroStats.getSpd())
                .bonusStats(heroStats.getBonusStats())
                .name(name)
                .build();
    }

    /**
     * Sets the map of base stats by hero name.
     * 
     * @param baseStatsByName A map containing hero names as keys and their corresponding base stats.
     */
    public void setBaseStatsByName(final Map<String, BaseStats> baseStatsByName) {
        this.baseStatsByName = baseStatsByName;
    }
}
