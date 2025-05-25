package com.fribbels.core;

import java.util.Arrays;
import java.util.Comparator;

import com.fribbels.enums.OptimizationColumn;
import com.fribbels.enums.SortOrder;
import com.fribbels.model.HeroStats;

public class Sorter {

    private Sorter() {}

    public static void sortHeroes(final HeroStats[] data, final OptimizationColumn column, final SortOrder order) {
        if (data.length <= 1) {
            return;
        }

        Comparator<HeroStats> comparator = Sorter.getComparator(column);

        if (order == SortOrder.DESC) {
            comparator = comparator.reversed();
        } else if (order != SortOrder.ASC) {
            throw new IllegalArgumentException("Invalid sort order: " + order);
        }

        Arrays.sort(data, comparator);
    }

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