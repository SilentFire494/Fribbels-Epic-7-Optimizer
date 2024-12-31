package com.fribbels.core;

import com.fribbels.model.HeroStats;

public class SpecialStats {

    private SpecialStats() {
    }

    public static HeroStats setScBonusStats(final HeroStats hero) {

        if (hero.getBonusStats() != null) {
            if (hero.getBonusStats().getOverrideAtk() != 0) {
                hero.setAtk(hero.getBonusStats().getOverrideAtk());
            }
            if (hero.getBonusStats().getOverrideDef() != 0) {
                hero.setDef(hero.getBonusStats().getOverrideDef());
            }
            if (hero.getBonusStats().getOverrideHp() != 0) {
                hero.setHp(hero.getBonusStats().getOverrideHp());
            }
            if (hero.getBonusStats().getOverrideAdditionalCr() != 0) {
                hero.setCr(hero.getCr() + hero.getBonusStats().getOverrideAdditionalCr());
            }
            if (hero.getBonusStats().getOverrideAdditionalCd() != 0) {
                hero.setCd(hero.getCd() + hero.getBonusStats().getOverrideAdditionalCd());
            }
            if (hero.getBonusStats().getOverrideAdditionalSpd() != 0) {
                hero.setSpd(hero.getSpd() + hero.getBonusStats().getOverrideAdditionalSpd());
            }
            if (hero.getBonusStats().getOverrideAdditionalEff() != 0) {
                hero.setEff(hero.getEff() + hero.getBonusStats().getOverrideAdditionalEff());
            }
            if (hero.getBonusStats().getOverrideAdditionalRes() != 0) {
                hero.setRes(hero.getRes() + hero.getBonusStats().getOverrideAdditionalRes());
            }
        }

        return hero;
    }
}