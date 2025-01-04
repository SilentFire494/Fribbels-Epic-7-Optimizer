package com.fribbels.core;

import com.fribbels.model.HeroStats;

/**
 * The {@code SpecialStats} class provides methods for applying special bonus stats
 * to a {@link HeroStats} object, modifying various stat attributes based on available overrides.
 */
public class SpecialStats {
    private SpecialStats() {}

    /**
     * Sets the bonus stats for a given hero, applying overrides for various stat attributes.
     *
     * @param hero The {@link HeroStats} object to apply the bonus stats to.
     * @return The updated {@link HeroStats} object with applied bonus stats.
     */
    public static HeroStats setScBonusStats(final HeroStats hero) {
        // Check if bonus stats are available
        if (hero.getBonusStats() != null) {
            applyStatOverrides(hero);
        }

        return hero;
    }

    /**
     * Applies the stat overrides for various attributes of the hero, including attack, defense, health, etc.
     *
     * @param hero The {@link HeroStats} object to apply stat overrides to.
     */
    private static void applyStatOverrides(final HeroStats hero) {
        // Apply overrides for attack, defense, and health if they are not zero
        applyOverride(hero::setAtk, hero.getBonusStats()::getOverrideAtk);
        applyOverride(hero::setDef, hero.getBonusStats()::getOverrideDef);
        applyOverride(hero::setHp, hero.getBonusStats()::getOverrideHp);
        
        // Apply additional stat overrides for crit, cooldown, speed, effectiveness, and resistance
        applyAdditionalOverride(hero::setCr, hero.getCr(), hero.getBonusStats()::getOverrideAdditionalCr);
        applyAdditionalOverride(hero::setCd, hero.getCd(), hero.getBonusStats()::getOverrideAdditionalCd);
        applyAdditionalOverride(hero::setSpd, hero.getSpd(), hero.getBonusStats()::getOverrideAdditionalSpd);
        applyAdditionalOverride(hero::setEff, hero.getEff(), hero.getBonusStats()::getOverrideAdditionalEff);
        applyAdditionalOverride(hero::setRes, hero.getRes(), hero.getBonusStats()::getOverrideAdditionalRes);
    }

    /**
     * Helper method to apply direct stat overrides if the override value is non-zero.
     *
     * @param setter A functional interface for setting the stat value.
     * @param getter A functional interface for getting the override value.
     */
    private static void applyOverride(final StatSetter setter, final StatGetter getter) {
        if (getter.get() != 0) {
            setter.set(getter.get());
        }
    }

    /**
     * Helper method to apply additional stat overrides (e.g., crit, cooldown) if the override value is non-zero.
     *
     * @param setter      A functional interface for setting the stat value.
     * @param currentStat The current value of the stat before applying the override.
     * @param getter      A functional interface for getting the additional override value.
     */
    private static void applyAdditionalOverride(final AdditionalStatSetter setter, final int currentStat, final StatGetter getter) {
        if (getter.get() != 0) {
            setter.set(currentStat + getter.get());
        }
    }

    /**
     * Functional interface for setting a stat value.
     */
    @FunctionalInterface
    interface StatSetter {
        void set(int value);
    }

    /**
     * Functional interface for getting a stat value.
     */
    @FunctionalInterface
    interface StatGetter {
        int get();
    }

    /**
     * Functional interface for setting an additional stat value.
     */
    @FunctionalInterface
    interface AdditionalStatSetter {
        void set(int value);
    }
}
