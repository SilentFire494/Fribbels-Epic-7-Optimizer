package com.fribbels.db;

import com.fribbels.core.Sorter;
import com.fribbels.enums.OptimizationColumn;
import com.fribbels.enums.SortOrder;
import com.fribbels.model.HeroStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The OptimizationDb class manages a collection of HeroStats and provides functionalities 
 * for sorting, filtering, and retrieving specific hero stats within an optimization context.
 */
public class OptimizationDb {

    private HeroStats[] resultHeroStats;
    private int[] filteredIndices;
    private Set<String> filteredIds;
    private long maximum;
    private long filteredMaximum;
    private boolean filtered;
    private OptimizationColumn column;
    private SortOrder order;

    public OptimizationDb() {
        resultHeroStats = new HeroStats[]{};
        filteredIndices = new int[]{};
        filteredIds = new HashSet<>();
        maximum = 0;
        filteredMaximum = 0;
        filtered = false;
    }

    /**
     * Sets the result heroes and their maximum number.
     * This will reset the filtered heroes.
     *
     * @param newResultHeroStats The array of new hero stats to set.
     * @param newMaximum The maximum number of heroes.
     */
    public void setResultHeroes(final HeroStats[] newResultHeroStats, final long newMaximum) {
        resultHeroStats = Arrays.copyOfRange(newResultHeroStats, 0, (int) newMaximum);
        maximum = newMaximum;
        filteredMaximum = 0;
        filteredIds = new HashSet<>();
        filteredIndices = new int[]{};
        filtered = false;
    }

    /**
     * Sets the filtered hero IDs and the filtered maximum count.
     * This also calculates the filtered indices.
     *
     * @param newFilteredIds The set of filtered hero IDs.
     * @param newFilteredMaximum The maximum number of filtered heroes.
     */
    public void setFilteredIds(final Set<String> newFilteredIds, final int newFilteredMaximum) {
        filtered = true;
        filteredIds = newFilteredIds;
        filteredMaximum = newFilteredMaximum;

        int count = 0;
        final int[] sortedFilteredIndices = new int[newFilteredMaximum];
        for (int i = 0; i < maximum; i++) {
            if (filteredIds.contains(resultHeroStats[i].getId())) {
                sortedFilteredIndices[count] = i;
                count++;
            }
        }

        filteredIndices = sortedFilteredIndices;
    }

    /**
     * Retrieves a subset of hero stats between the specified rows, considering any applied filtering.
     *
     * @param startRow The start index (inclusive).
     * @param endRow The end index (exclusive).
     * @return An array of HeroStats between the specified rows.
     */
    public HeroStats[] getRows(final int startRow, final int endRow) {
        if (filteredIds.isEmpty()) {
            return Arrays.copyOfRange(resultHeroStats, startRow, endRow);
        }

        final List<HeroStats> results = new ArrayList<>();
        for (int i = startRow; i < endRow; i++) {
            if (i >= filteredIndices.length) {
                break;
            }
            final int index = filteredIndices[i];
            final HeroStats heroStats = resultHeroStats[index];
            results.add(heroStats);
        }

        return results.toArray(new HeroStats[0]);
    }

    /**
     * Retrieves all the hero stats in the result.
     *
     * @return An array of all hero stats.
     */
    public HeroStats[] getAllHeroStats() {
        return resultHeroStats;
    }

    /**
     * Retrieves the current maximum number of heroes (filtered or unfiltered).
     *
     * @return The maximum number of heroes.
     */
    public long getMaximum() {
        return filtered ? filteredMaximum : maximum;
    }

    /**
     * Sorts the hero stats based on the specified column and order.
     * After sorting, it updates the filtered indices if filtering is applied.
     *
     * @param newColumn The column to sort by.
     * @param newOrder The order of sorting (ascending or descending).
     */
    public void sort(final OptimizationColumn newColumn, final SortOrder newOrder) {
        if (newColumn == null || newOrder == null || (newColumn == column && newOrder == order)) {
            return;
        }

        Sorter.sortHeroes(resultHeroStats, newColumn, newOrder);

        int count = 0;
        final int[] sortedFilteredIndices = new int[(int) maximum];
        for (int i = 0; i < maximum; i++) {
            if (filteredIds.contains(resultHeroStats[i].getId())) {
                sortedFilteredIndices[count] = i;
                count++;
            }
        }

        filteredIndices = sortedFilteredIndices;

        column = newColumn;
        order = newOrder;
    }
}
