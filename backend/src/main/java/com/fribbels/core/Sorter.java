package com.fribbels.core;

import com.fribbels.enums.OptimizationColumn;
import com.fribbels.enums.SortOrder;
import com.fribbels.model.HeroStats;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The {@code Sorter} class provides a utility method for sorting an array of {@link HeroStats}
 * objects based on a specific optimization column and sort order (ascending or descending).
 */
public class Sorter {
    private Sorter() {}

    /**
     * Sorts an array of {@link HeroStats} objects based on the specified optimization column and sort order.
     *
     * @param data   The array of {@link HeroStats} objects to be sorted.
     * @param column The optimization column by which to sort the heroes.
     * @param order  The sort order, either ascending or descending.
     * @throws IllegalArgumentException If an invalid sort order is provided.
     */
    public static void sortHeroes(final HeroStats[] data, final OptimizationColumn column, final SortOrder order) {
        System.out.println("SORTING HEROES BY " + column + " " + order);

        Comparator<HeroStats> comparator = getComparator(column);

        if (order == SortOrder.DESC) {
            comparator = comparator.reversed();
        } else if (order != SortOrder.ASC) {
            throw new IllegalArgumentException("Invalid sort order: " + order);
        }

        Arrays.sort(data, comparator);
    }

    /**
     * Returns a comparator that compares {@link HeroStats} based on the specified optimization column.
     *
     * @param column The optimization column by which to compare the heroes.
     * @return A comparator that compares {@link HeroStats} based on the specified column.
     * @throws IllegalStateException If the column is not recognized.
     */
    private static Comparator<HeroStats> getComparator(final OptimizationColumn column) {
        return switch (column) {
            case ATK -> Comparator.comparingInt(HeroStats::getAtk);
            case HP -> Comparator.comparingInt(HeroStats::getHp);
            case DEF -> Comparator.comparingInt(HeroStats::getDef);
            case SPD -> Comparator.comparingInt(HeroStats::getSpd);
            case CR -> Comparator.comparingInt(HeroStats::getCr);
            case CD -> Comparator.comparingInt(HeroStats::getCd);
            case EFF -> Comparator.comparingInt(HeroStats::getEff);
            case RES -> Comparator.comparingInt(HeroStats::getRes);
            case DAC -> Comparator.comparingInt(HeroStats::getDac);
            case CP -> Comparator.comparingInt(HeroStats::getCp);
            case HPPS -> Comparator.comparingInt(HeroStats::getHpps);
            case EHP -> Comparator.comparingInt(HeroStats::getEhp);
            case EHPPS -> Comparator.comparingInt(HeroStats::getEhpps);
            case DMG -> Comparator.comparingInt(HeroStats::getDmg);
            case DMGPS -> Comparator.comparingInt(HeroStats::getDmgps);
            case MCDMG -> Comparator.comparingInt(HeroStats::getMcdmg);
            case MCDMGPS -> Comparator.comparingInt(HeroStats::getMcdmgps);
            case DMGH -> Comparator.comparingInt(HeroStats::getDmgh);
            case DMGD -> Comparator.comparingInt(HeroStats::getDmgd);
            case S1 -> Comparator.comparingInt(HeroStats::getS1);
            case S2 -> Comparator.comparingInt(HeroStats::getS2);
            case S3 -> Comparator.comparingInt(HeroStats::getS3);
            case UPGRADES -> Comparator.comparingInt(HeroStats::getUpgrades);
            case SCORE -> Comparator.comparingInt(HeroStats::getScore);
            case BS -> Comparator.comparingInt(HeroStats::getBs);
            case PRIORITY -> Comparator.comparingInt(HeroStats::getPriority);
            case CONVERSIONS -> Comparator.comparingInt(HeroStats::getConversions);
            case EQ -> Comparator.comparingInt(HeroStats::getEq);
            default -> throw new IllegalStateException("Unexpected value: " + column);
        };
    }
}