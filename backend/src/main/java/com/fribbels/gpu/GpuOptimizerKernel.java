package com.fribbels.gpu;

import com.aparapi.Kernel;
import com.fribbels.model.DamageMultipliers;
import com.fribbels.model.Hero;
import com.fribbels.model.HeroStats;
import com.fribbels.request.OptimizationRequest;

public class GpuOptimizerKernel extends Kernel {

    @Constant
    final float[] flattenedWeaponAccs;
    @Constant
    final float[] flattenedHelmetAccs;
    @Constant
    final float[] flattenedArmorAccs;
    @Constant
    final float[] flattenedNecklaceAccs;
    @Constant
    final float[] flattenedRingAccs;
    @Constant
    final float[] flattenedBootAccs;

    @Constant
    final long wSize;
    @Constant
    final long hSize;
    @Constant
    final long aSize;
    @Constant
    final long nSize;
    @Constant
    final long rSize;
    @Constant
    final long bSize;

    @Constant
    final long argSize;

    @Constant
    final float bonusBaseAtk;
    @Constant
    final float bonusBaseHp;
    @Constant
    final float bonusBaseDef;

    @Constant
    final float atkSetBonus;
    @Constant
    final float hpSetBonus;
    @Constant
    final float defSetBonus;
    @Constant
    final float speedSetBonus;
    @Constant
    final float revengeSetBonus;
    @Constant
    final float penSetDmgBonus;

    @Constant
    final float targetDefense;

    @Constant
    final float bonusMaxAtk;
    @Constant
    final float bonusMaxHp;
    @Constant
    final float bonusMaxDef;

    @Constant
    final int SETTING_RAGE_SET;
    @Constant
    final int SETTING_PEN_SET;

    @Constant
    final float baseAtk;
    @Constant
    final float baseHp;
    @Constant
    final float baseDef;
    @Constant
    final float baseCr;
    @Constant
    final float baseCd;
    @Constant
    final float baseEff;
    @Constant
    final float baseRes;
    @Constant
    final float baseSpeed;

    @Constant
    final float bonusCr;
    @Constant
    final float bonusCd;
    @Constant
    final float bonusEff;
    @Constant
    final float bonusRes;
    @Constant
    final float bonusSpeed;

    @Constant
    final float aeiCr;
    @Constant
    final float aeiCd;
    @Constant
    final float aeiEff;
    @Constant
    final float aeiRes;
    @Constant
    final float aeiSpeed;

    @Constant
    final boolean[] boolArr;
    @Constant
    final int[] setPermutationIndicesPlusOne;
    final int[] setSolutionCounters;
    @Constant
    final long max;

    @Constant
    final int inputAtkMinLimit;
    @Constant
    final int inputAtkMaxLimit;
    @Constant
    final int inputHpMinLimit;
    @Constant
    final int inputHpMaxLimit;
    @Constant
    final int inputDefMinLimit;
    @Constant
    final int inputDefMaxLimit;
    @Constant
    final int inputSpdMinLimit;
    @Constant
    final int inputSpdMaxLimit;
    @Constant
    final int inputCrMinLimit;
    @Constant
    final int inputCrMaxLimit;
    @Constant
    final int inputCdMinLimit;
    @Constant
    final int inputCdMaxLimit;
    @Constant
    final int inputEffMinLimit;
    @Constant
    final int inputEffMaxLimit;
    @Constant
    final int inputResMinLimit;
    @Constant
    final int inputResMaxLimit;
    @Constant
    final int inputMinCpLimit;
    @Constant
    final int inputMaxCpLimit;
    @Constant
    final int inputMinHppsLimit;
    @Constant
    final int inputMaxHppsLimit;
    @Constant
    final int inputMinEhpLimit;
    @Constant
    final int inputMaxEhpLimit;
    @Constant
    final int inputMinEhppsLimit;
    @Constant
    final int inputMaxEhppsLimit;
    @Constant
    final int inputMinDmgLimit;
    @Constant
    final int inputMaxDmgLimit;
    @Constant
    final int inputMinDmgpsLimit;
    @Constant
    final int inputMaxDmgpsLimit;
    @Constant
    final int inputMinMcdmgLimit;
    @Constant
    final int inputMaxMcdmgLimit;
    @Constant
    final int inputMinMcdmgpsLimit;
    @Constant
    final int inputMaxMcdmgpsLimit;

    @Constant
    final int inputMinDmgHLimit;
    @Constant
    final int inputMaxDmgHLimit;
    @Constant
    final int inputMinDmgDLimit;
    @Constant
    final int inputMaxDmgDLimit;

    @Constant
    final int inputMinS1Limit;
    @Constant
    final int inputMaxS1Limit;
    @Constant
    final int inputMinS2Limit;
    @Constant
    final int inputMaxS2Limit;
    @Constant
    final int inputMinS3Limit;
    @Constant
    final int inputMaxS3Limit;

    @Constant
    final float[] rate;
    @Constant
    final float[] pow;
    @Constant
    final int[] targets;

    @Constant
    final float[] selfHpScaling;
    @Constant
    final float[] selfAtkScaling;
    @Constant
    final float[] selfDefScaling;
    @Constant
    final float[] selfSpdScaling;
    @Constant
    final float[] constantValue;
    @Constant
    final float[] selfAtkConstantValue;
    @Constant
    final float[] increasedValue;
    @Constant
    final float[] defDiffPen;
    @Constant
    final float[] defDiffPenMax;
    @Constant
    final float[] atkDiffPen;
    @Constant
    final float[] atkDiffPenMax;
    @Constant
    final float[] spdDiffPen;
    @Constant
    final float[] spdDiffPenMax;
    @Constant
    final float[] penetration;
    @Constant
    final float[] atkIncrease;
    @Constant
    final float[] cdmgIncrease;
    @Constant
    final float[] crit;
    @Constant
    final float[] damage;
    @Constant
    final float[] support;
    @Constant
    final float[] hitMulti;

    @Constant
    final float[] extraSelfAtkScaling;
    @Constant
    final float[] extraSelfDefScaling;
    @Constant
    final float[] extraSelfHpScaling;

    @Constant
    final float artifactHealth;
    @Constant
    final float artifactAttack;

    @Constant
    final int inputMinUpgradesLimit;
    @Constant
    final int inputMaxUpgradesLimit;
    @Constant
    final int inputMinConversionsLimit;
    @Constant
    final int inputMaxConversionsLimit;
    @Constant
    final int inputMinEquippedLimit;
    @Constant
    final int inputMaxEquippedLimit;
    @Constant
    final int inputMinScoreLimit;
    @Constant
    final int inputMaxScoreLimit;
    @Constant
    final int inputMinBSLimit;
    @Constant
    final int inputMaxBSLimit;
    @Constant
    final int inputMinPriorityLimit;
    @Constant
    final int inputMaxPriorityLimit;

    float[] debug;

    int iteration;
    boolean[] passes;
    @Constant
    final int[] setSolutionBitMasks;

    public GpuOptimizerKernel(final OptimizationRequest request, final float[] flattenedWeaponAccs,
            final float[] flattenedHelmetAccs, final float[] flattenedArmorAccs, final float[] flattenedNecklaceAccs,
            final float[] flattenedRingAccs, final float[] flattenedBootAccs, final float bonusBaseAtk,
            final float bonusBaseDef, final float bonusBaseHp, final float atkSetBonus, final float hpSetBonus,
            final float defSetBonus, final float speedSetBonus, final float revengeSetBonus, final float penSetDmgBonus,
            final float targetDefense, final float bonusMaxAtk, final float bonusMaxDef, final float bonusMaxHp,
            final int SETTING_RAGE_SET, final int SETTING_PEN_SET, final HeroStats base, final Hero hero,
            final long argSize, final long wSize, final long hSize, final long aSize, final long nSize,
            final long rSize, final long bSize, final long max, final int[] setSolutionBitMasks) {
        this.flattenedWeaponAccs = flattenedWeaponAccs;
        this.flattenedHelmetAccs = flattenedHelmetAccs;
        this.flattenedArmorAccs = flattenedArmorAccs;
        this.flattenedNecklaceAccs = flattenedNecklaceAccs;
        this.flattenedRingAccs = flattenedRingAccs;
        this.flattenedBootAccs = flattenedBootAccs;

        this.bonusBaseAtk = bonusBaseAtk;
        this.bonusBaseDef = bonusBaseDef;
        this.bonusBaseHp = bonusBaseHp;

        this.atkSetBonus = atkSetBonus;
        this.hpSetBonus = hpSetBonus;
        this.defSetBonus = defSetBonus;
        this.speedSetBonus = speedSetBonus;
        this.revengeSetBonus = revengeSetBonus;
        this.penSetDmgBonus = penSetDmgBonus;

        this.targetDefense = targetDefense;

        this.bonusMaxAtk = bonusMaxAtk;
        this.bonusMaxDef = bonusMaxDef;
        this.bonusMaxHp = bonusMaxHp;

        this.SETTING_RAGE_SET = SETTING_RAGE_SET;
        this.SETTING_PEN_SET = SETTING_PEN_SET;

        this.baseAtk = base.getAtk();
        this.baseHp = base.getHp();
        this.baseDef = base.getDef();
        this.baseCr = base.getCr();
        this.baseCd = base.getCd();
        this.baseEff = base.getEff();
        this.baseRes = base.getRes();
        this.baseSpeed = base.getSpd();

        this.bonusCr = hero.getBonusCr();
        this.bonusCd = hero.getBonusCd();
        this.bonusEff = hero.getBonusEff();
        this.bonusRes = hero.getBonusRes();
        this.bonusSpeed = hero.getBonusSpeed();

        this.aeiCr = hero.getAeiCr();
        this.aeiCd = hero.getAeiCd();
        this.aeiEff = hero.getAeiEff();
        this.aeiRes = hero.getAeiRes();
        this.aeiSpeed = hero.getAeiSpeed();

        this.argSize = argSize;
        this.wSize = wSize;
        this.hSize = hSize;
        this.aSize = aSize;
        this.nSize = nSize;
        this.rSize = rSize;
        this.bSize = bSize;

        inputAtkMinLimit = request.getInputAtkMinLimit();
        inputAtkMaxLimit = request.getInputAtkMaxLimit();
        inputDefMinLimit = request.getInputDefMinLimit();
        inputDefMaxLimit = request.getInputDefMaxLimit();
        inputHpMinLimit = request.getInputHpMinLimit();
        inputHpMaxLimit = request.getInputHpMaxLimit();
        inputSpdMinLimit = request.getInputSpdMinLimit();
        inputSpdMaxLimit = request.getInputSpdMaxLimit();
        inputCrMinLimit = request.getInputCrMinLimit();
        inputCrMaxLimit = request.getInputCrMaxLimit();
        inputCdMinLimit = request.getInputCdMinLimit();
        inputCdMaxLimit = request.getInputCdMaxLimit();
        inputEffMinLimit = request.getInputEffMinLimit();
        inputEffMaxLimit = request.getInputEffMaxLimit();
        inputResMinLimit = request.getInputResMinLimit();
        inputResMaxLimit = request.getInputResMaxLimit();
        inputMinCpLimit = request.getInputMinCpLimit();
        inputMaxCpLimit = request.getInputMaxCpLimit();
        inputMinHppsLimit = request.getInputMinHppsLimit();
        inputMaxHppsLimit = request.getInputMaxHppsLimit();
        inputMinEhpLimit = request.getInputMinEhpLimit();
        inputMaxEhpLimit = request.getInputMaxEhpLimit();
        inputMinEhppsLimit = request.getInputMinEhppsLimit();
        inputMaxEhppsLimit = request.getInputMaxEhppsLimit();
        inputMinDmgLimit = request.getInputMinDmgLimit();
        inputMaxDmgLimit = request.getInputMaxDmgLimit();
        inputMinDmgpsLimit = request.getInputMinDmgpsLimit();
        inputMaxDmgpsLimit = request.getInputMaxDmgpsLimit();
        inputMinMcdmgLimit = request.getInputMinMcdmgLimit();
        inputMaxMcdmgLimit = request.getInputMaxMcdmgLimit();
        inputMinMcdmgpsLimit = request.getInputMinMcdmgpsLimit();
        inputMaxMcdmgpsLimit = request.getInputMaxMcdmgpsLimit();

        inputMinDmgHLimit = request.getInputMinDmgHLimit();
        inputMaxDmgHLimit = request.getInputMaxDmgHLimit();
        inputMinDmgDLimit = request.getInputMinDmgDLimit();
        inputMaxDmgDLimit = request.getInputMaxDmgDLimit();

        inputMinS1Limit = request.getInputMinS1Limit();
        inputMaxS1Limit = request.getInputMaxS1Limit();
        inputMinS2Limit = request.getInputMinS2Limit();
        inputMaxS2Limit = request.getInputMaxS2Limit();
        inputMinS3Limit = request.getInputMinS3Limit();
        inputMaxS3Limit = request.getInputMaxS3Limit();

        artifactAttack = request.getHero().getArtifactAttack();
        artifactHealth = request.getHero().getArtifactHealth();

        inputMinUpgradesLimit = request.getInputMinUpgradesLimit();
        inputMaxUpgradesLimit = request.getInputMaxUpgradesLimit();
        inputMinConversionsLimit = request.getInputMinConversionsLimit();
        inputMaxConversionsLimit = request.getInputMaxConversionsLimit();
        inputMinEquippedLimit = request.getInputMinEquippedLimit();
        inputMaxEquippedLimit = request.getInputMaxEquippedLimit();
        inputMinScoreLimit = request.getInputMinScoreLimit();
        inputMaxScoreLimit = request.getInputMaxScoreLimit();
        inputMinBSLimit = request.getInputMinBSLimit();
        inputMaxBSLimit = request.getInputMaxBSLimit();
        inputMinPriorityLimit = request.getInputMinPriorityLimit();
        inputMaxPriorityLimit = request.getInputMaxPriorityLimit();

        this.max = max;
        this.boolArr = request.getBoolArr();
        this.setPermutationIndicesPlusOne = request.getSetPermutationIndicesPlusOne();
        this.setSolutionCounters = request.getSetSolutionCounters();
        this.setSolutionBitMasks = setSolutionBitMasks;

        final DamageMultipliers dm = hero.getDamageMultipliers();

        this.rate = floatArr(dm.getRate());
        this.pow = floatArr(dm.getPow());
        this.targets = flattenTargets(dm.getTargets());
        this.selfHpScaling = floatArr(dm.getSelfHpScaling());
        this.selfAtkScaling = floatArr(dm.getSelfAtkScaling());
        this.selfDefScaling = floatArr(dm.getSelfDefScaling());
        this.selfSpdScaling = floatArr(dm.getSelfSpdScaling());
        this.constantValue = floatArr(dm.getConstantValue());
        this.selfAtkConstantValue = floatArr(dm.getSelfAtkConstantValue());
        this.increasedValue = floatArr(dm.getIncreasedValue());
        this.defDiffPen = floatArr(dm.getDefDiffPen());
        this.defDiffPenMax = floatArr(dm.getDefDiffPenMax());
        this.atkDiffPen = floatArr(dm.getAtkDiffPen());
        this.atkDiffPenMax = floatArr(dm.getAtkDiffPenMax());
        this.spdDiffPen = floatArr(dm.getSpdDiffPen());
        this.spdDiffPenMax = floatArr(dm.getSpdDiffPenMax());
        this.penetration = floatArr(dm.getPenetration());
        this.atkIncrease = floatArr(dm.getAtkIncrease());
        this.cdmgIncrease = floatArr(dm.getCdmgIncrease());
        this.crit = floatArr(dm.getCrit());
        this.damage = floatArr(dm.getDamage());
        this.support = floatArr(dm.getSupport());
        this.hitMulti = floatArr(dm.getHitMulti());
        this.extraSelfAtkScaling = floatArr(dm.getExtraSelfAtkScaling());
        this.extraSelfDefScaling = floatArr(dm.getExtraSelfDefScaling());
        this.extraSelfHpScaling = floatArr(dm.getExtraSelfHpScaling());
    }

    private float[] floatArr(final Float[] arr) {
        if (arr == null) {
            return new float[] { 0, 0, 0 };
        }
        return new float[] { arr[0], arr[1], arr[2] };
    }

    private int[] flattenTargets(final Integer[] arr) {
        if (arr == null) {
            return new int[] { 0, 0, 0 };
        }
        return new int[] { zeroOrOne(arr[0]), zeroOrOne(arr[1]), zeroOrOne(arr[2]) };
    }

    private int zeroOrOne(final int i) {
        if (i == 1) {
            return 1;
        }
        return 0;
    }

    int oneIfNegativeElseZero(int a) {
        return ((a ^ 1) >> 31) * -1;
    }

    int negativeOneIfNegativeElseZero(int a) {
        return (a ^ 1) >> 31;
    }

    @Override
    public void run() {

    }

    public void setDebug(float[] debug) {
        this.debug = debug;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public void setPasses(boolean[] passes) {
        this.passes = passes;
    }

}