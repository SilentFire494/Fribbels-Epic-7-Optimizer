package com.fribbels.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Objects;
import java.util.Optional;

import com.fribbels.enums.OptimizationColumn;
import com.fribbels.enums.SortOrder;
import com.fribbels.model.HeroStats;

public class Sorter {
    private static final EnumMap<OptimizationColumn, Comparator<HeroStats>> comparators;

    static {
        comparators = new EnumMap<>(OptimizationColumn.class);
        comparators.put(OptimizationColumn.ATK, Comparator.comparingInt(HeroStats::getAtk));
        comparators.put(OptimizationColumn.DEF, Comparator.comparingInt(HeroStats::getDef));
        comparators.put(OptimizationColumn.HP, Comparator.comparingInt(HeroStats::getHp));
        comparators.put(OptimizationColumn.SPD, Comparator.comparingInt(HeroStats::getSpd));
        comparators.put(OptimizationColumn.CR, Comparator.comparingInt(HeroStats::getCr));
        comparators.put(OptimizationColumn.CD, Comparator.comparingInt(HeroStats::getCd));
        comparators.put(OptimizationColumn.EFF, Comparator.comparingInt(HeroStats::getEff));
        comparators.put(OptimizationColumn.RES, Comparator.comparingInt(HeroStats::getRes));
        comparators.put(OptimizationColumn.CP, Comparator.comparingInt(HeroStats::getCp));
        comparators.put(OptimizationColumn.HPPS, Comparator.comparingInt(HeroStats::getHpps));
        comparators.put(OptimizationColumn.EHP, Comparator.comparingInt(HeroStats::getEhp));
        comparators.put(OptimizationColumn.EHPPS, Comparator.comparingInt(HeroStats::getEhpps));
        comparators.put(OptimizationColumn.DMG, Comparator.comparingInt(HeroStats::getDmg));
        comparators.put(OptimizationColumn.DMGPS, Comparator.comparingInt(HeroStats::getDmgps));
        comparators.put(OptimizationColumn.MCDMG, Comparator.comparingInt(HeroStats::getMcdmg));
        comparators.put(OptimizationColumn.MCDMGPS, Comparator.comparingInt(HeroStats::getMcdmgps));
        comparators.put(OptimizationColumn.DMGH, Comparator.comparingInt(HeroStats::getDmgh));
        comparators.put(OptimizationColumn.DMGD, Comparator.comparingInt(HeroStats::getDmgd));
        comparators.put(OptimizationColumn.S1, Comparator.comparingInt(HeroStats::getS1));
        comparators.put(OptimizationColumn.S2, Comparator.comparingInt(HeroStats::getS2));
        comparators.put(OptimizationColumn.S3, Comparator.comparingInt(HeroStats::getS3));
        comparators.put(OptimizationColumn.SCORE, Comparator.comparingInt(HeroStats::getScore));
        comparators.put(OptimizationColumn.BS, Comparator.comparingInt(HeroStats::getBs));
        comparators.put(OptimizationColumn.PRIORITY, Comparator.comparingInt(HeroStats::getPriority));
        comparators.put(OptimizationColumn.EQ, Comparator.comparingInt(HeroStats::getEq));
        comparators.put(OptimizationColumn.UPGRADES, Comparator.comparingInt(HeroStats::getUpgrades));
    }

    private Sorter() {
    }

    public static void sortHeroes(final HeroStats[] data, final OptimizationColumn column, final SortOrder order) {
        Objects.requireNonNull(data, "Data array cannot be null");
        Objects.requireNonNull(column, "Column cannot be null");
        Objects.requireNonNull(order, "Order cannot be null");

        if (data.length <= 1) {
            return;
        }

        Comparator<HeroStats> comparator = Sorter.getComparator(column);

        comparator = switch (order) {
            case ASC -> comparator;
            case DESC -> comparator.reversed();
            default -> throw new IllegalArgumentException("Invalid sort order: " + order);
        };

        System.out.println("The data is being sorted by " + column + " in " + order + " order. With a total of "
                + data.length + " heroes.");

        Arrays.sort(data, comparator);
    }

    private static Comparator<HeroStats> getComparator(final OptimizationColumn column) {
        return Optional.ofNullable(comparators.get(column))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported Column: " + column));
    }
}