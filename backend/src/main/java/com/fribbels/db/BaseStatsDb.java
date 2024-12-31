package com.fribbels.db;

import com.fribbels.model.BaseStats;
import com.fribbels.model.HeroStats;

import java.util.HashMap;
import java.util.Map;

public class BaseStatsDb {

    private Map<String, BaseStats> baseStatsByName;

    public BaseStatsDb() {
        baseStatsByName = new HashMap<>();
    }

    public BaseStats getBaseStatsByName(final String name) {
        if (!baseStatsByName.containsKey(name)) {
            return null;
        }
        return new BaseStats(getBaseStatsByName(name, 5), getBaseStatsByName(name, 6),
                baseStatsByName.get(name).skills());
    }

    public HeroStats getBaseStatsByName(final String name, final int stars) {
        if (!baseStatsByName.containsKey(name)) {
            return null;
        }

        final BaseStats baseStats = baseStatsByName.get(name);
        final HeroStats heroStats = stars == 5 ? baseStats.lv50FiveStarFullyAwakened()
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

    public void setBaseStatsByName(final Map<String, BaseStats> baseStatsByName) {
        this.baseStatsByName = baseStatsByName;
    }
}
