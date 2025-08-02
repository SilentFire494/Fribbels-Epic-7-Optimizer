package com.fribbels.db;

import java.util.HashMap;
import java.util.Map;

import com.fribbels.core.SpecialStats;
import com.fribbels.model.BaseStats;
import com.fribbels.model.HeroStats;

public class BaseStatsDb {

    private Map<String, BaseStats> baseStatsByName;

    public BaseStatsDb() {
        this.baseStatsByName = new HashMap<>();
    }

    public BaseStats getBaseStatsByName(final String name) {
        final BaseStats baseStats = this.baseStatsByName.get(name);
        if (baseStats == null) {
            return null;
        }

        return BaseStats.builder()
                .lv50FiveStarFullyAwakened(this.getBaseStatsByName(name, 5))
                .lv60SixStarFullyAwakened(this.getBaseStatsByName(name, 6))
                .skills(baseStats.getSkills())
                .build();
    }

    public HeroStats getBaseStatsByName(final String name, final int stars) {
        final BaseStats baseStats = this.baseStatsByName.get(name);

        if (baseStats == null) {
            return null;
        }

        final HeroStats heroStats = stars == 5
                ? baseStats.getLv50FiveStarFullyAwakened()
                : baseStats.getLv60SixStarFullyAwakened();

        if (heroStats == null) {
            return null;
        }

        final HeroStats response = HeroStats.builder()
                .atk(heroStats.getAtk())
                .hp(heroStats.getHp())
                .def(heroStats.getDef())
                .cr(heroStats.getCr())
                .cd(heroStats.getCd())
                .eff(heroStats.getEff())
                .res(heroStats.getRes())
                .spd(heroStats.getSpd())
                .bonusStats(heroStats.getBonusStats())
                .name(name)
                .build();

        SpecialStats.setScBonusStats(response);
        return response;
    }

    public void setBaseStatsByName(final Map<String, BaseStats> baseStatsByName) {
        this.baseStatsByName = baseStatsByName;
    }
}
