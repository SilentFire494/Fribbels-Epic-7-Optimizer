package com.fribbels.request;

import com.fribbels.enums.Set;
import com.fribbels.enums.StatType;
import com.fribbels.model.DamageMultipliers;
import com.fribbels.model.Hero;
import com.fribbels.model.Item;
import com.fribbels.model.Request;
import java.util.Arrays;
import java.util.List;

public class OptimizationRequest extends Request {

    private String executionId;

    private String heroId;
    private Hero hero;
    private DamageMultipliers damageMultipliers;
    private List<Item> items;

    private List<List<Set>> inputSets;
    private List<Set> inputSetsOne;
    private List<Set> inputSetsTwo;
    private List<Set> inputSetsThree;
    private List<Set> inputExcludeSet;

    private List<String> excludeFilter;
    private List<String> excludedGearIds;

    private List<StatType> inputNecklaceStat;
    private List<StatType> inputRingStat;
    private List<StatType> inputBootsStat;

    private Boolean inputPredictReforges;
    private Boolean inputSubstatMods;
    private Boolean inputAllowLockedItems;
    private Boolean inputAllowEquippedItems;
    private Boolean inputOrderedHeroPriority;
    private Boolean inputKeepCurrentItems;
    private Boolean inputOnlyMaxedGear;

    private int atk;
    private int hp;
    private int def;
    private int cr;
    private int cd;
    private int eff;
    private int res;
    private int spd;
    private int dac;

    private float artifactAttack;
    private float artifactHealth;

    private int inputAtkMinLimit;
    private int inputAtkMaxLimit = Integer.MAX_VALUE;
    private int inputHpMinLimit;
    private int inputHpMaxLimit = Integer.MAX_VALUE;
    private int inputDefMinLimit;
    private int inputDefMaxLimit = Integer.MAX_VALUE;
    private int inputSpdMinLimit;
    private int inputSpdMaxLimit = Integer.MAX_VALUE;
    private int inputCrMinLimit;
    private int inputCrMaxLimit = Integer.MAX_VALUE;
    private int inputCdMinLimit;
    private int inputCdMaxLimit = Integer.MAX_VALUE;
    private int inputEffMinLimit;
    private int inputEffMaxLimit = Integer.MAX_VALUE;
    private int inputResMinLimit;
    private int inputResMaxLimit = Integer.MAX_VALUE;
    private int inputMinCpLimit;
    private int inputMaxCpLimit = Integer.MAX_VALUE;
    private int inputMinHppsLimit;
    private int inputMaxHppsLimit = Integer.MAX_VALUE;
    private int inputMinEhpLimit;
    private int inputMaxEhpLimit = Integer.MAX_VALUE;
    private int inputMinEhppsLimit;
    private int inputMaxEhppsLimit = Integer.MAX_VALUE;
    private int inputMinDmgLimit;
    private int inputMaxDmgLimit = Integer.MAX_VALUE;
    private int inputMinDmgpsLimit;
    private int inputMaxDmgpsLimit = Integer.MAX_VALUE;
    private int inputMinMcdmgLimit;
    private int inputMaxMcdmgLimit = Integer.MAX_VALUE;
    private int inputMinMcdmgpsLimit;
    private int inputMaxMcdmgpsLimit = Integer.MAX_VALUE;

    private int inputMinDmgHLimit;
    private int inputMaxDmgHLimit = Integer.MAX_VALUE;
    private int inputMinDmgDLimit;
    private int inputMaxDmgDLimit = Integer.MAX_VALUE;

    private int inputMinS1Limit;
    private int inputMaxS1Limit = Integer.MAX_VALUE;
    private int inputMinS2Limit;
    private int inputMaxS2Limit = Integer.MAX_VALUE;
    private int inputMinS3Limit;
    private int inputMaxS3Limit = Integer.MAX_VALUE;

    private int inputMinUpgradesLimit;
    private int inputMaxUpgradesLimit = Integer.MAX_VALUE;
    private int inputMinConversionsLimit;
    private int inputMaxConversionsLimit = Integer.MAX_VALUE;
    private int inputMinEquippedLimit;
    private int inputMaxEquippedLimit = Integer.MAX_VALUE;
    private int inputMinScoreLimit;
    private int inputMaxScoreLimit = Integer.MAX_VALUE;
    private int inputMinBSLimit;
    private int inputMaxBSLimit = Integer.MAX_VALUE;
    private int inputMinPriorityLimit;
    private int inputMaxPriorityLimit = Integer.MAX_VALUE;

    private Integer inputAtkMinForce;
    private Integer inputAtkMaxForce;
    private Integer inputAtkPercentMinForce;
    private Integer inputAtkPercentMaxForce;
    private Integer inputSpdMinForce;
    private Integer inputSpdMaxForce;
    private Integer inputCrMinForce;
    private Integer inputCrMaxForce;
    private Integer inputCdMinForce;
    private Integer inputCdMaxForce;
    private Integer inputHpMinForce;
    private Integer inputHpMaxForce;
    private Integer inputHpPercentMinForce;
    private Integer inputHpPercentMaxForce;
    private Integer inputDefMinForce;
    private Integer inputDefMaxForce;
    private Integer inputDefPercentMinForce;
    private Integer inputDefPercentMaxForce;
    private Integer inputEffMinForce;
    private Integer inputEffMaxForce;
    private Integer inputResMinForce;
    private Integer inputResMaxForce;

    private Integer inputForceNumberSelect;
    private Integer inputForceMode;
    private Integer inputFilterPriority;
    private Integer inputAtkPriority;
    private Integer inputHpPriority;
    private Integer inputDefPriority;
    private Integer inputSpdPriority;
    private Integer inputCrPriority;
    private Integer inputCdPriority;
    private Integer inputEffPriority;
    private Integer inputResPriority;

    // calculated fields
    private boolean[] boolArr;
    private int[] setPermutationIndicesPlusOne;
    private int[] setSolutionCounters;
    private int setFormat;

    public OptimizationRequest() {
    }

    public OptimizationRequest(String executionId, String heroId, Hero hero, DamageMultipliers damageMultipliers,
            List<Item> items, List<List<Set>> inputSets, List<Set> inputSetsOne, List<Set> inputSetsTwo,
            List<Set> inputSetsThree, List<Set> inputExcludeSet, List<String> excludeFilter,
            List<String> excludedGearIds, List<StatType> inputNecklaceStat, List<StatType> inputRingStat,
            List<StatType> inputBootsStat, Boolean inputPredictReforges, Boolean inputSubstatMods,
            Boolean inputAllowLockedItems, Boolean inputAllowEquippedItems, Boolean inputOrderedHeroPriority,
            Boolean inputKeepCurrentItems, Boolean inputOnlyMaxedGear, int atk, int hp, int def, int cr, int cd,
            int eff, int res, int spd, int dac, float artifactAttack, float artifactHealth, int inputAtkMinLimit,
            int inputAtkMaxLimit, int inputHpMinLimit, int inputHpMaxLimit, int inputDefMinLimit, int inputDefMaxLimit,
            int inputSpdMinLimit, int inputSpdMaxLimit, int inputCrMinLimit, int inputCrMaxLimit, int inputCdMinLimit,
            int inputCdMaxLimit, int inputEffMinLimit, int inputEffMaxLimit, int inputResMinLimit, int inputResMaxLimit,
            int inputMinCpLimit, int inputMaxCpLimit, int inputMinHppsLimit, int inputMaxHppsLimit,
            int inputMinEhpLimit, int inputMaxEhpLimit, int inputMinEhppsLimit, int inputMaxEhppsLimit,
            int inputMinDmgLimit, int inputMaxDmgLimit, int inputMinDmgpsLimit, int inputMaxDmgpsLimit,
            int inputMinMcdmgLimit, int inputMaxMcdmgLimit, int inputMinMcdmgpsLimit, int inputMaxMcdmgpsLimit,
            int inputMinDmgHLimit, int inputMaxDmgHLimit, int inputMinDmgDLimit, int inputMaxDmgDLimit,
            int inputMinS1Limit, int inputMaxS1Limit, int inputMinS2Limit, int inputMaxS2Limit, int inputMinS3Limit,
            int inputMaxS3Limit, int inputMinUpgradesLimit, int inputMaxUpgradesLimit, int inputMinConversionsLimit,
            int inputMaxConversionsLimit, int inputMinEquippedLimit, int inputMaxEquippedLimit, int inputMinScoreLimit,
            int inputMaxScoreLimit, int inputMinBSLimit, int inputMaxBSLimit, int inputMinPriorityLimit,
            int inputMaxPriorityLimit, Integer inputAtkMinForce, Integer inputAtkMaxForce,
            Integer inputAtkPercentMinForce, Integer inputAtkPercentMaxForce, Integer inputSpdMinForce,
            Integer inputSpdMaxForce, Integer inputCrMinForce, Integer inputCrMaxForce, Integer inputCdMinForce,
            Integer inputCdMaxForce, Integer inputHpMinForce, Integer inputHpMaxForce, Integer inputHpPercentMinForce,
            Integer inputHpPercentMaxForce, Integer inputDefMinForce, Integer inputDefMaxForce,
            Integer inputDefPercentMinForce, Integer inputDefPercentMaxForce, Integer inputEffMinForce,
            Integer inputEffMaxForce, Integer inputResMinForce, Integer inputResMaxForce,
            Integer inputForceNumberSelect, Integer inputForceMode, Integer inputFilterPriority,
            Integer inputAtkPriority, Integer inputHpPriority, Integer inputDefPriority, Integer inputSpdPriority,
            Integer inputCrPriority, Integer inputCdPriority, Integer inputEffPriority, Integer inputResPriority,
            boolean[] boolArr, int[] setPermutationIndicesPlusOne, int[] setSolutionCounters, int setFormat) {
        this.executionId = executionId;
        this.heroId = heroId;
        this.hero = hero;
        this.damageMultipliers = damageMultipliers;
        this.items = items;
        this.inputSets = inputSets;
        this.inputSetsOne = inputSetsOne;
        this.inputSetsTwo = inputSetsTwo;
        this.inputSetsThree = inputSetsThree;
        this.inputExcludeSet = inputExcludeSet;
        this.excludeFilter = excludeFilter;
        this.excludedGearIds = excludedGearIds;
        this.inputNecklaceStat = inputNecklaceStat;
        this.inputRingStat = inputRingStat;
        this.inputBootsStat = inputBootsStat;
        this.inputPredictReforges = inputPredictReforges;
        this.inputSubstatMods = inputSubstatMods;
        this.inputAllowLockedItems = inputAllowLockedItems;
        this.inputAllowEquippedItems = inputAllowEquippedItems;
        this.inputOrderedHeroPriority = inputOrderedHeroPriority;
        this.inputKeepCurrentItems = inputKeepCurrentItems;
        this.inputOnlyMaxedGear = inputOnlyMaxedGear;
        this.atk = atk;
        this.hp = hp;
        this.def = def;
        this.cr = cr;
        this.cd = cd;
        this.eff = eff;
        this.res = res;
        this.spd = spd;
        this.dac = dac;
        this.artifactAttack = artifactAttack;
        this.artifactHealth = artifactHealth;
        this.inputAtkMinLimit = inputAtkMinLimit;
        this.inputAtkMaxLimit = inputAtkMaxLimit;
        this.inputHpMinLimit = inputHpMinLimit;
        this.inputHpMaxLimit = inputHpMaxLimit;
        this.inputDefMinLimit = inputDefMinLimit;
        this.inputDefMaxLimit = inputDefMaxLimit;
        this.inputSpdMinLimit = inputSpdMinLimit;
        this.inputSpdMaxLimit = inputSpdMaxLimit;
        this.inputCrMinLimit = inputCrMinLimit;
        this.inputCrMaxLimit = inputCrMaxLimit;
        this.inputCdMinLimit = inputCdMinLimit;
        this.inputCdMaxLimit = inputCdMaxLimit;
        this.inputEffMinLimit = inputEffMinLimit;
        this.inputEffMaxLimit = inputEffMaxLimit;
        this.inputResMinLimit = inputResMinLimit;
        this.inputResMaxLimit = inputResMaxLimit;
        this.inputMinCpLimit = inputMinCpLimit;
        this.inputMaxCpLimit = inputMaxCpLimit;
        this.inputMinHppsLimit = inputMinHppsLimit;
        this.inputMaxHppsLimit = inputMaxHppsLimit;
        this.inputMinEhpLimit = inputMinEhpLimit;
        this.inputMaxEhpLimit = inputMaxEhpLimit;
        this.inputMinEhppsLimit = inputMinEhppsLimit;
        this.inputMaxEhppsLimit = inputMaxEhppsLimit;
        this.inputMinDmgLimit = inputMinDmgLimit;
        this.inputMaxDmgLimit = inputMaxDmgLimit;
        this.inputMinDmgpsLimit = inputMinDmgpsLimit;
        this.inputMaxDmgpsLimit = inputMaxDmgpsLimit;
        this.inputMinMcdmgLimit = inputMinMcdmgLimit;
        this.inputMaxMcdmgLimit = inputMaxMcdmgLimit;
        this.inputMinMcdmgpsLimit = inputMinMcdmgpsLimit;
        this.inputMaxMcdmgpsLimit = inputMaxMcdmgpsLimit;
        this.inputMinDmgHLimit = inputMinDmgHLimit;
        this.inputMaxDmgHLimit = inputMaxDmgHLimit;
        this.inputMinDmgDLimit = inputMinDmgDLimit;
        this.inputMaxDmgDLimit = inputMaxDmgDLimit;
        this.inputMinS1Limit = inputMinS1Limit;
        this.inputMaxS1Limit = inputMaxS1Limit;
        this.inputMinS2Limit = inputMinS2Limit;
        this.inputMaxS2Limit = inputMaxS2Limit;
        this.inputMinS3Limit = inputMinS3Limit;
        this.inputMaxS3Limit = inputMaxS3Limit;
        this.inputMinUpgradesLimit = inputMinUpgradesLimit;
        this.inputMaxUpgradesLimit = inputMaxUpgradesLimit;
        this.inputMinConversionsLimit = inputMinConversionsLimit;
        this.inputMaxConversionsLimit = inputMaxConversionsLimit;
        this.inputMinEquippedLimit = inputMinEquippedLimit;
        this.inputMaxEquippedLimit = inputMaxEquippedLimit;
        this.inputMinScoreLimit = inputMinScoreLimit;
        this.inputMaxScoreLimit = inputMaxScoreLimit;
        this.inputMinBSLimit = inputMinBSLimit;
        this.inputMaxBSLimit = inputMaxBSLimit;
        this.inputMinPriorityLimit = inputMinPriorityLimit;
        this.inputMaxPriorityLimit = inputMaxPriorityLimit;
        this.inputAtkMinForce = inputAtkMinForce;
        this.inputAtkMaxForce = inputAtkMaxForce;
        this.inputAtkPercentMinForce = inputAtkPercentMinForce;
        this.inputAtkPercentMaxForce = inputAtkPercentMaxForce;
        this.inputSpdMinForce = inputSpdMinForce;
        this.inputSpdMaxForce = inputSpdMaxForce;
        this.inputCrMinForce = inputCrMinForce;
        this.inputCrMaxForce = inputCrMaxForce;
        this.inputCdMinForce = inputCdMinForce;
        this.inputCdMaxForce = inputCdMaxForce;
        this.inputHpMinForce = inputHpMinForce;
        this.inputHpMaxForce = inputHpMaxForce;
        this.inputHpPercentMinForce = inputHpPercentMinForce;
        this.inputHpPercentMaxForce = inputHpPercentMaxForce;
        this.inputDefMinForce = inputDefMinForce;
        this.inputDefMaxForce = inputDefMaxForce;
        this.inputDefPercentMinForce = inputDefPercentMinForce;
        this.inputDefPercentMaxForce = inputDefPercentMaxForce;
        this.inputEffMinForce = inputEffMinForce;
        this.inputEffMaxForce = inputEffMaxForce;
        this.inputResMinForce = inputResMinForce;
        this.inputResMaxForce = inputResMaxForce;
        this.inputForceNumberSelect = inputForceNumberSelect;
        this.inputForceMode = inputForceMode;
        this.inputFilterPriority = inputFilterPriority;
        this.inputAtkPriority = inputAtkPriority;
        this.inputHpPriority = inputHpPriority;
        this.inputDefPriority = inputDefPriority;
        this.inputSpdPriority = inputSpdPriority;
        this.inputCrPriority = inputCrPriority;
        this.inputCdPriority = inputCdPriority;
        this.inputEffPriority = inputEffPriority;
        this.inputResPriority = inputResPriority;
        this.boolArr = boolArr;
        this.setPermutationIndicesPlusOne = setPermutationIndicesPlusOne;
        this.setSolutionCounters = setSolutionCounters;
        this.setFormat = setFormat;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public DamageMultipliers getDamageMultipliers() {
        return damageMultipliers;
    }

    public void setDamageMultipliers(DamageMultipliers damageMultipliers) {
        this.damageMultipliers = damageMultipliers;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<List<Set>> getInputSets() {
        return inputSets;
    }

    public void setInputSets(List<List<Set>> inputSets) {
        this.inputSets = inputSets;
    }

    public List<Set> getInputSetsOne() {
        return inputSetsOne;
    }

    public void setInputSetsOne(List<Set> inputSetsOne) {
        this.inputSetsOne = inputSetsOne;
    }

    public List<Set> getInputSetsTwo() {
        return inputSetsTwo;
    }

    public void setInputSetsTwo(List<Set> inputSetsTwo) {
        this.inputSetsTwo = inputSetsTwo;
    }

    public List<Set> getInputSetsThree() {
        return inputSetsThree;
    }

    public void setInputSetsThree(List<Set> inputSetsThree) {
        this.inputSetsThree = inputSetsThree;
    }

    public List<Set> getInputExcludeSet() {
        return inputExcludeSet;
    }

    public void setInputExcludeSet(List<Set> inputExcludeSet) {
        this.inputExcludeSet = inputExcludeSet;
    }

    public List<String> getExcludeFilter() {
        return excludeFilter;
    }

    public void setExcludeFilter(List<String> excludeFilter) {
        this.excludeFilter = excludeFilter;
    }

    public List<String> getExcludedGearIds() {
        return excludedGearIds;
    }

    public void setExcludedGearIds(List<String> excludedGearIds) {
        this.excludedGearIds = excludedGearIds;
    }

    public List<StatType> getInputNecklaceStat() {
        return inputNecklaceStat;
    }

    public void setInputNecklaceStat(List<StatType> inputNecklaceStat) {
        this.inputNecklaceStat = inputNecklaceStat;
    }

    public List<StatType> getInputRingStat() {
        return inputRingStat;
    }

    public void setInputRingStat(List<StatType> inputRingStat) {
        this.inputRingStat = inputRingStat;
    }

    public List<StatType> getInputBootsStat() {
        return inputBootsStat;
    }

    public void setInputBootsStat(List<StatType> inputBootsStat) {
        this.inputBootsStat = inputBootsStat;
    }

    public Boolean getInputPredictReforges() {
        return inputPredictReforges;
    }

    public void setInputPredictReforges(Boolean inputPredictReforges) {
        this.inputPredictReforges = inputPredictReforges;
    }

    public Boolean getInputSubstatMods() {
        return inputSubstatMods;
    }

    public void setInputSubstatMods(Boolean inputSubstatMods) {
        this.inputSubstatMods = inputSubstatMods;
    }

    public Boolean getInputAllowLockedItems() {
        return inputAllowLockedItems;
    }

    public void setInputAllowLockedItems(Boolean inputAllowLockedItems) {
        this.inputAllowLockedItems = inputAllowLockedItems;
    }

    public Boolean getInputAllowEquippedItems() {
        return inputAllowEquippedItems;
    }

    public void setInputAllowEquippedItems(Boolean inputAllowEquippedItems) {
        this.inputAllowEquippedItems = inputAllowEquippedItems;
    }

    public Boolean getInputOrderedHeroPriority() {
        return inputOrderedHeroPriority;
    }

    public void setInputOrderedHeroPriority(Boolean inputOrderedHeroPriority) {
        this.inputOrderedHeroPriority = inputOrderedHeroPriority;
    }

    public Boolean getInputKeepCurrentItems() {
        return inputKeepCurrentItems;
    }

    public void setInputKeepCurrentItems(Boolean inputKeepCurrentItems) {
        this.inputKeepCurrentItems = inputKeepCurrentItems;
    }

    public Boolean getInputOnlyMaxedGear() {
        return inputOnlyMaxedGear;
    }

    public void setInputOnlyMaxedGear(Boolean inputOnlyMaxedGear) {
        this.inputOnlyMaxedGear = inputOnlyMaxedGear;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getEff() {
        return eff;
    }

    public void setEff(int eff) {
        this.eff = eff;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getDac() {
        return dac;
    }

    public void setDac(int dac) {
        this.dac = dac;
    }

    public float getArtifactAttack() {
        return artifactAttack;
    }

    public void setArtifactAttack(float artifactAttack) {
        this.artifactAttack = artifactAttack;
    }

    public float getArtifactHealth() {
        return artifactHealth;
    }

    public void setArtifactHealth(float artifactHealth) {
        this.artifactHealth = artifactHealth;
    }

    public int getInputAtkMinLimit() {
        return inputAtkMinLimit;
    }

    public void setInputAtkMinLimit(int inputAtkMinLimit) {
        this.inputAtkMinLimit = inputAtkMinLimit;
    }

    public int getInputAtkMaxLimit() {
        return inputAtkMaxLimit;
    }

    public void setInputAtkMaxLimit(int inputAtkMaxLimit) {
        this.inputAtkMaxLimit = inputAtkMaxLimit;
    }

    public int getInputHpMinLimit() {
        return inputHpMinLimit;
    }

    public void setInputHpMinLimit(int inputHpMinLimit) {
        this.inputHpMinLimit = inputHpMinLimit;
    }

    public int getInputHpMaxLimit() {
        return inputHpMaxLimit;
    }

    public void setInputHpMaxLimit(int inputHpMaxLimit) {
        this.inputHpMaxLimit = inputHpMaxLimit;
    }

    public int getInputDefMinLimit() {
        return inputDefMinLimit;
    }

    public void setInputDefMinLimit(int inputDefMinLimit) {
        this.inputDefMinLimit = inputDefMinLimit;
    }

    public int getInputDefMaxLimit() {
        return inputDefMaxLimit;
    }

    public void setInputDefMaxLimit(int inputDefMaxLimit) {
        this.inputDefMaxLimit = inputDefMaxLimit;
    }

    public int getInputSpdMinLimit() {
        return inputSpdMinLimit;
    }

    public void setInputSpdMinLimit(int inputSpdMinLimit) {
        this.inputSpdMinLimit = inputSpdMinLimit;
    }

    public int getInputSpdMaxLimit() {
        return inputSpdMaxLimit;
    }

    public void setInputSpdMaxLimit(int inputSpdMaxLimit) {
        this.inputSpdMaxLimit = inputSpdMaxLimit;
    }

    public int getInputCrMinLimit() {
        return inputCrMinLimit;
    }

    public void setInputCrMinLimit(int inputCrMinLimit) {
        this.inputCrMinLimit = inputCrMinLimit;
    }

    public int getInputCrMaxLimit() {
        return inputCrMaxLimit;
    }

    public void setInputCrMaxLimit(int inputCrMaxLimit) {
        this.inputCrMaxLimit = inputCrMaxLimit;
    }

    public int getInputCdMinLimit() {
        return inputCdMinLimit;
    }

    public void setInputCdMinLimit(int inputCdMinLimit) {
        this.inputCdMinLimit = inputCdMinLimit;
    }

    public int getInputCdMaxLimit() {
        return inputCdMaxLimit;
    }

    public void setInputCdMaxLimit(int inputCdMaxLimit) {
        this.inputCdMaxLimit = inputCdMaxLimit;
    }

    public int getInputEffMinLimit() {
        return inputEffMinLimit;
    }

    public void setInputEffMinLimit(int inputEffMinLimit) {
        this.inputEffMinLimit = inputEffMinLimit;
    }

    public int getInputEffMaxLimit() {
        return inputEffMaxLimit;
    }

    public void setInputEffMaxLimit(int inputEffMaxLimit) {
        this.inputEffMaxLimit = inputEffMaxLimit;
    }

    public int getInputResMinLimit() {
        return inputResMinLimit;
    }

    public void setInputResMinLimit(int inputResMinLimit) {
        this.inputResMinLimit = inputResMinLimit;
    }

    public int getInputResMaxLimit() {
        return inputResMaxLimit;
    }

    public void setInputResMaxLimit(int inputResMaxLimit) {
        this.inputResMaxLimit = inputResMaxLimit;
    }

    public int getInputMinCpLimit() {
        return inputMinCpLimit;
    }

    public void setInputMinCpLimit(int inputMinCpLimit) {
        this.inputMinCpLimit = inputMinCpLimit;
    }

    public int getInputMaxCpLimit() {
        return inputMaxCpLimit;
    }

    public void setInputMaxCpLimit(int inputMaxCpLimit) {
        this.inputMaxCpLimit = inputMaxCpLimit;
    }

    public int getInputMinHppsLimit() {
        return inputMinHppsLimit;
    }

    public void setInputMinHppsLimit(int inputMinHppsLimit) {
        this.inputMinHppsLimit = inputMinHppsLimit;
    }

    public int getInputMaxHppsLimit() {
        return inputMaxHppsLimit;
    }

    public void setInputMaxHppsLimit(int inputMaxHppsLimit) {
        this.inputMaxHppsLimit = inputMaxHppsLimit;
    }

    public int getInputMinEhpLimit() {
        return inputMinEhpLimit;
    }

    public void setInputMinEhpLimit(int inputMinEhpLimit) {
        this.inputMinEhpLimit = inputMinEhpLimit;
    }

    public int getInputMaxEhpLimit() {
        return inputMaxEhpLimit;
    }

    public void setInputMaxEhpLimit(int inputMaxEhpLimit) {
        this.inputMaxEhpLimit = inputMaxEhpLimit;
    }

    public int getInputMinEhppsLimit() {
        return inputMinEhppsLimit;
    }

    public void setInputMinEhppsLimit(int inputMinEhppsLimit) {
        this.inputMinEhppsLimit = inputMinEhppsLimit;
    }

    public int getInputMaxEhppsLimit() {
        return inputMaxEhppsLimit;
    }

    public void setInputMaxEhppsLimit(int inputMaxEhppsLimit) {
        this.inputMaxEhppsLimit = inputMaxEhppsLimit;
    }

    public int getInputMinDmgLimit() {
        return inputMinDmgLimit;
    }

    public void setInputMinDmgLimit(int inputMinDmgLimit) {
        this.inputMinDmgLimit = inputMinDmgLimit;
    }

    public int getInputMaxDmgLimit() {
        return inputMaxDmgLimit;
    }

    public void setInputMaxDmgLimit(int inputMaxDmgLimit) {
        this.inputMaxDmgLimit = inputMaxDmgLimit;
    }

    public int getInputMinDmgpsLimit() {
        return inputMinDmgpsLimit;
    }

    public void setInputMinDmgpsLimit(int inputMinDmgpsLimit) {
        this.inputMinDmgpsLimit = inputMinDmgpsLimit;
    }

    public int getInputMaxDmgpsLimit() {
        return inputMaxDmgpsLimit;
    }

    public void setInputMaxDmgpsLimit(int inputMaxDmgpsLimit) {
        this.inputMaxDmgpsLimit = inputMaxDmgpsLimit;
    }

    public int getInputMinMcdmgLimit() {
        return inputMinMcdmgLimit;
    }

    public void setInputMinMcdmgLimit(int inputMinMcdmgLimit) {
        this.inputMinMcdmgLimit = inputMinMcdmgLimit;
    }

    public int getInputMaxMcdmgLimit() {
        return inputMaxMcdmgLimit;
    }

    public void setInputMaxMcdmgLimit(int inputMaxMcdmgLimit) {
        this.inputMaxMcdmgLimit = inputMaxMcdmgLimit;
    }

    public int getInputMinMcdmgpsLimit() {
        return inputMinMcdmgpsLimit;
    }

    public void setInputMinMcdmgpsLimit(int inputMinMcdmgpsLimit) {
        this.inputMinMcdmgpsLimit = inputMinMcdmgpsLimit;
    }

    public int getInputMaxMcdmgpsLimit() {
        return inputMaxMcdmgpsLimit;
    }

    public void setInputMaxMcdmgpsLimit(int inputMaxMcdmgpsLimit) {
        this.inputMaxMcdmgpsLimit = inputMaxMcdmgpsLimit;
    }

    public int getInputMinDmgHLimit() {
        return inputMinDmgHLimit;
    }

    public void setInputMinDmgHLimit(int inputMinDmgHLimit) {
        this.inputMinDmgHLimit = inputMinDmgHLimit;
    }

    public int getInputMaxDmgHLimit() {
        return inputMaxDmgHLimit;
    }

    public void setInputMaxDmgHLimit(int inputMaxDmgHLimit) {
        this.inputMaxDmgHLimit = inputMaxDmgHLimit;
    }

    public int getInputMinDmgDLimit() {
        return inputMinDmgDLimit;
    }

    public void setInputMinDmgDLimit(int inputMinDmgDLimit) {
        this.inputMinDmgDLimit = inputMinDmgDLimit;
    }

    public int getInputMaxDmgDLimit() {
        return inputMaxDmgDLimit;
    }

    public void setInputMaxDmgDLimit(int inputMaxDmgDLimit) {
        this.inputMaxDmgDLimit = inputMaxDmgDLimit;
    }

    public int getInputMinS1Limit() {
        return inputMinS1Limit;
    }

    public void setInputMinS1Limit(int inputMinS1Limit) {
        this.inputMinS1Limit = inputMinS1Limit;
    }

    public int getInputMaxS1Limit() {
        return inputMaxS1Limit;
    }

    public void setInputMaxS1Limit(int inputMaxS1Limit) {
        this.inputMaxS1Limit = inputMaxS1Limit;
    }

    public int getInputMinS2Limit() {
        return inputMinS2Limit;
    }

    public void setInputMinS2Limit(int inputMinS2Limit) {
        this.inputMinS2Limit = inputMinS2Limit;
    }

    public int getInputMaxS2Limit() {
        return inputMaxS2Limit;
    }

    public void setInputMaxS2Limit(int inputMaxS2Limit) {
        this.inputMaxS2Limit = inputMaxS2Limit;
    }

    public int getInputMinS3Limit() {
        return inputMinS3Limit;
    }

    public void setInputMinS3Limit(int inputMinS3Limit) {
        this.inputMinS3Limit = inputMinS3Limit;
    }

    public int getInputMaxS3Limit() {
        return inputMaxS3Limit;
    }

    public void setInputMaxS3Limit(int inputMaxS3Limit) {
        this.inputMaxS3Limit = inputMaxS3Limit;
    }

    public int getInputMinUpgradesLimit() {
        return inputMinUpgradesLimit;
    }

    public void setInputMinUpgradesLimit(int inputMinUpgradesLimit) {
        this.inputMinUpgradesLimit = inputMinUpgradesLimit;
    }

    public int getInputMaxUpgradesLimit() {
        return inputMaxUpgradesLimit;
    }

    public void setInputMaxUpgradesLimit(int inputMaxUpgradesLimit) {
        this.inputMaxUpgradesLimit = inputMaxUpgradesLimit;
    }

    public int getInputMinConversionsLimit() {
        return inputMinConversionsLimit;
    }

    public void setInputMinConversionsLimit(int inputMinConversionsLimit) {
        this.inputMinConversionsLimit = inputMinConversionsLimit;
    }

    public int getInputMaxConversionsLimit() {
        return inputMaxConversionsLimit;
    }

    public void setInputMaxConversionsLimit(int inputMaxConversionsLimit) {
        this.inputMaxConversionsLimit = inputMaxConversionsLimit;
    }

    public int getInputMinEquippedLimit() {
        return inputMinEquippedLimit;
    }

    public void setInputMinEquippedLimit(int inputMinEquippedLimit) {
        this.inputMinEquippedLimit = inputMinEquippedLimit;
    }

    public int getInputMaxEquippedLimit() {
        return inputMaxEquippedLimit;
    }

    public void setInputMaxEquippedLimit(int inputMaxEquippedLimit) {
        this.inputMaxEquippedLimit = inputMaxEquippedLimit;
    }

    public int getInputMinScoreLimit() {
        return inputMinScoreLimit;
    }

    public void setInputMinScoreLimit(int inputMinScoreLimit) {
        this.inputMinScoreLimit = inputMinScoreLimit;
    }

    public int getInputMaxScoreLimit() {
        return inputMaxScoreLimit;
    }

    public void setInputMaxScoreLimit(int inputMaxScoreLimit) {
        this.inputMaxScoreLimit = inputMaxScoreLimit;
    }

    public int getInputMinBSLimit() {
        return inputMinBSLimit;
    }

    public void setInputMinBSLimit(int inputMinBSLimit) {
        this.inputMinBSLimit = inputMinBSLimit;
    }

    public int getInputMaxBSLimit() {
        return inputMaxBSLimit;
    }

    public void setInputMaxBSLimit(int inputMaxBSLimit) {
        this.inputMaxBSLimit = inputMaxBSLimit;
    }

    public int getInputMinPriorityLimit() {
        return inputMinPriorityLimit;
    }

    public void setInputMinPriorityLimit(int inputMinPriorityLimit) {
        this.inputMinPriorityLimit = inputMinPriorityLimit;
    }

    public int getInputMaxPriorityLimit() {
        return inputMaxPriorityLimit;
    }

    public void setInputMaxPriorityLimit(int inputMaxPriorityLimit) {
        this.inputMaxPriorityLimit = inputMaxPriorityLimit;
    }

    public Integer getInputAtkMinForce() {
        return inputAtkMinForce;
    }

    public void setInputAtkMinForce(Integer inputAtkMinForce) {
        this.inputAtkMinForce = inputAtkMinForce;
    }

    public Integer getInputAtkMaxForce() {
        return inputAtkMaxForce;
    }

    public void setInputAtkMaxForce(Integer inputAtkMaxForce) {
        this.inputAtkMaxForce = inputAtkMaxForce;
    }

    public Integer getInputAtkPercentMinForce() {
        return inputAtkPercentMinForce;
    }

    public void setInputAtkPercentMinForce(Integer inputAtkPercentMinForce) {
        this.inputAtkPercentMinForce = inputAtkPercentMinForce;
    }

    public Integer getInputAtkPercentMaxForce() {
        return inputAtkPercentMaxForce;
    }

    public void setInputAtkPercentMaxForce(Integer inputAtkPercentMaxForce) {
        this.inputAtkPercentMaxForce = inputAtkPercentMaxForce;
    }

    public Integer getInputSpdMinForce() {
        return inputSpdMinForce;
    }

    public void setInputSpdMinForce(Integer inputSpdMinForce) {
        this.inputSpdMinForce = inputSpdMinForce;
    }

    public Integer getInputSpdMaxForce() {
        return inputSpdMaxForce;
    }

    public void setInputSpdMaxForce(Integer inputSpdMaxForce) {
        this.inputSpdMaxForce = inputSpdMaxForce;
    }

    public Integer getInputCrMinForce() {
        return inputCrMinForce;
    }

    public void setInputCrMinForce(Integer inputCrMinForce) {
        this.inputCrMinForce = inputCrMinForce;
    }

    public Integer getInputCrMaxForce() {
        return inputCrMaxForce;
    }

    public void setInputCrMaxForce(Integer inputCrMaxForce) {
        this.inputCrMaxForce = inputCrMaxForce;
    }

    public Integer getInputCdMinForce() {
        return inputCdMinForce;
    }

    public void setInputCdMinForce(Integer inputCdMinForce) {
        this.inputCdMinForce = inputCdMinForce;
    }

    public Integer getInputCdMaxForce() {
        return inputCdMaxForce;
    }

    public void setInputCdMaxForce(Integer inputCdMaxForce) {
        this.inputCdMaxForce = inputCdMaxForce;
    }

    public Integer getInputHpMinForce() {
        return inputHpMinForce;
    }

    public void setInputHpMinForce(Integer inputHpMinForce) {
        this.inputHpMinForce = inputHpMinForce;
    }

    public Integer getInputHpMaxForce() {
        return inputHpMaxForce;
    }

    public void setInputHpMaxForce(Integer inputHpMaxForce) {
        this.inputHpMaxForce = inputHpMaxForce;
    }

    public Integer getInputHpPercentMinForce() {
        return inputHpPercentMinForce;
    }

    public void setInputHpPercentMinForce(Integer inputHpPercentMinForce) {
        this.inputHpPercentMinForce = inputHpPercentMinForce;
    }

    public Integer getInputHpPercentMaxForce() {
        return inputHpPercentMaxForce;
    }

    public void setInputHpPercentMaxForce(Integer inputHpPercentMaxForce) {
        this.inputHpPercentMaxForce = inputHpPercentMaxForce;
    }

    public Integer getInputDefMinForce() {
        return inputDefMinForce;
    }

    public void setInputDefMinForce(Integer inputDefMinForce) {
        this.inputDefMinForce = inputDefMinForce;
    }

    public Integer getInputDefMaxForce() {
        return inputDefMaxForce;
    }

    public void setInputDefMaxForce(Integer inputDefMaxForce) {
        this.inputDefMaxForce = inputDefMaxForce;
    }

    public Integer getInputDefPercentMinForce() {
        return inputDefPercentMinForce;
    }

    public void setInputDefPercentMinForce(Integer inputDefPercentMinForce) {
        this.inputDefPercentMinForce = inputDefPercentMinForce;
    }

    public Integer getInputDefPercentMaxForce() {
        return inputDefPercentMaxForce;
    }

    public void setInputDefPercentMaxForce(Integer inputDefPercentMaxForce) {
        this.inputDefPercentMaxForce = inputDefPercentMaxForce;
    }

    public Integer getInputEffMinForce() {
        return inputEffMinForce;
    }

    public void setInputEffMinForce(Integer inputEffMinForce) {
        this.inputEffMinForce = inputEffMinForce;
    }

    public Integer getInputEffMaxForce() {
        return inputEffMaxForce;
    }

    public void setInputEffMaxForce(Integer inputEffMaxForce) {
        this.inputEffMaxForce = inputEffMaxForce;
    }

    public Integer getInputResMinForce() {
        return inputResMinForce;
    }

    public void setInputResMinForce(Integer inputResMinForce) {
        this.inputResMinForce = inputResMinForce;
    }

    public Integer getInputResMaxForce() {
        return inputResMaxForce;
    }

    public void setInputResMaxForce(Integer inputResMaxForce) {
        this.inputResMaxForce = inputResMaxForce;
    }

    public Integer getInputForceNumberSelect() {
        return inputForceNumberSelect;
    }

    public void setInputForceNumberSelect(Integer inputForceNumberSelect) {
        this.inputForceNumberSelect = inputForceNumberSelect;
    }

    public Integer getInputForceMode() {
        return inputForceMode;
    }

    public void setInputForceMode(Integer inputForceMode) {
        this.inputForceMode = inputForceMode;
    }

    public Integer getInputFilterPriority() {
        return inputFilterPriority;
    }

    public void setInputFilterPriority(Integer inputFilterPriority) {
        this.inputFilterPriority = inputFilterPriority;
    }

    public Integer getInputAtkPriority() {
        return inputAtkPriority;
    }

    public void setInputAtkPriority(Integer inputAtkPriority) {
        this.inputAtkPriority = inputAtkPriority;
    }

    public Integer getInputHpPriority() {
        return inputHpPriority;
    }

    public void setInputHpPriority(Integer inputHpPriority) {
        this.inputHpPriority = inputHpPriority;
    }

    public Integer getInputDefPriority() {
        return inputDefPriority;
    }

    public void setInputDefPriority(Integer inputDefPriority) {
        this.inputDefPriority = inputDefPriority;
    }

    public Integer getInputSpdPriority() {
        return inputSpdPriority;
    }

    public void setInputSpdPriority(Integer inputSpdPriority) {
        this.inputSpdPriority = inputSpdPriority;
    }

    public Integer getInputCrPriority() {
        return inputCrPriority;
    }

    public void setInputCrPriority(Integer inputCrPriority) {
        this.inputCrPriority = inputCrPriority;
    }

    public Integer getInputCdPriority() {
        return inputCdPriority;
    }

    public void setInputCdPriority(Integer inputCdPriority) {
        this.inputCdPriority = inputCdPriority;
    }

    public Integer getInputEffPriority() {
        return inputEffPriority;
    }

    public void setInputEffPriority(Integer inputEffPriority) {
        this.inputEffPriority = inputEffPriority;
    }

    public Integer getInputResPriority() {
        return inputResPriority;
    }

    public void setInputResPriority(Integer inputResPriority) {
        this.inputResPriority = inputResPriority;
    }

    public boolean[] getBoolArr() {
        return boolArr;
    }

    public void setBoolArr(boolean[] boolArr) {
        this.boolArr = boolArr;
    }

    public int[] getSetPermutationIndicesPlusOne() {
        return setPermutationIndicesPlusOne;
    }

    public void setSetPermutationIndicesPlusOne(int[] setPermutationIndicesPlusOne) {
        this.setPermutationIndicesPlusOne = setPermutationIndicesPlusOne;
    }

    public int[] getSetSolutionCounters() {
        return setSolutionCounters;
    }

    public void setSetSolutionCounters(int[] setSolutionCounters) {
        this.setSolutionCounters = setSolutionCounters;
    }

    public int getSetFormat() {
        return setFormat;
    }

    public void setSetFormat(int setFormat) {
        this.setFormat = setFormat;
    }

    @Override
    public String toString() {
        return "OptimizationRequest [executionId=" + executionId + ", heroId=" + heroId + ", hero=" + hero
                + ", damageMultipliers=" + damageMultipliers + ", items=" + items + ", inputSets=" + inputSets
                + ", inputSetsOne=" + inputSetsOne + ", inputSetsTwo=" + inputSetsTwo + ", inputSetsThree="
                + inputSetsThree + ", inputExcludeSet=" + inputExcludeSet + ", excludeFilter=" + excludeFilter
                + ", excludedGearIds=" + excludedGearIds + ", inputNecklaceStat=" + inputNecklaceStat
                + ", inputRingStat=" + inputRingStat + ", inputBootsStat=" + inputBootsStat + ", inputPredictReforges="
                + inputPredictReforges + ", inputSubstatMods=" + inputSubstatMods + ", inputAllowLockedItems="
                + inputAllowLockedItems + ", inputAllowEquippedItems=" + inputAllowEquippedItems
                + ", inputOrderedHeroPriority=" + inputOrderedHeroPriority + ", inputKeepCurrentItems="
                + inputKeepCurrentItems + ", inputOnlyMaxedGear=" + inputOnlyMaxedGear + ", atk=" + atk + ", hp=" + hp
                + ", def=" + def + ", cr=" + cr + ", cd=" + cd + ", eff=" + eff + ", res=" + res + ", spd=" + spd
                + ", dac=" + dac + ", artifactAttack=" + artifactAttack + ", artifactHealth=" + artifactHealth
                + ", inputAtkMinLimit=" + inputAtkMinLimit + ", inputAtkMaxLimit=" + inputAtkMaxLimit
                + ", inputHpMinLimit=" + inputHpMinLimit + ", inputHpMaxLimit=" + inputHpMaxLimit
                + ", inputDefMinLimit=" + inputDefMinLimit + ", inputDefMaxLimit=" + inputDefMaxLimit
                + ", inputSpdMinLimit=" + inputSpdMinLimit + ", inputSpdMaxLimit=" + inputSpdMaxLimit
                + ", inputCrMinLimit=" + inputCrMinLimit + ", inputCrMaxLimit=" + inputCrMaxLimit + ", inputCdMinLimit="
                + inputCdMinLimit + ", inputCdMaxLimit=" + inputCdMaxLimit + ", inputEffMinLimit=" + inputEffMinLimit
                + ", inputEffMaxLimit=" + inputEffMaxLimit + ", inputResMinLimit=" + inputResMinLimit
                + ", inputResMaxLimit=" + inputResMaxLimit + ", inputMinCpLimit=" + inputMinCpLimit
                + ", inputMaxCpLimit=" + inputMaxCpLimit + ", inputMinHppsLimit=" + inputMinHppsLimit
                + ", inputMaxHppsLimit=" + inputMaxHppsLimit + ", inputMinEhpLimit=" + inputMinEhpLimit
                + ", inputMaxEhpLimit=" + inputMaxEhpLimit + ", inputMinEhppsLimit=" + inputMinEhppsLimit
                + ", inputMaxEhppsLimit=" + inputMaxEhppsLimit + ", inputMinDmgLimit=" + inputMinDmgLimit
                + ", inputMaxDmgLimit=" + inputMaxDmgLimit + ", inputMinDmgpsLimit=" + inputMinDmgpsLimit
                + ", inputMaxDmgpsLimit=" + inputMaxDmgpsLimit + ", inputMinMcdmgLimit=" + inputMinMcdmgLimit
                + ", inputMaxMcdmgLimit=" + inputMaxMcdmgLimit + ", inputMinMcdmgpsLimit=" + inputMinMcdmgpsLimit
                + ", inputMaxMcdmgpsLimit=" + inputMaxMcdmgpsLimit + ", inputMinDmgHLimit=" + inputMinDmgHLimit
                + ", inputMaxDmgHLimit=" + inputMaxDmgHLimit + ", inputMinDmgDLimit=" + inputMinDmgDLimit
                + ", inputMaxDmgDLimit=" + inputMaxDmgDLimit + ", inputMinS1Limit=" + inputMinS1Limit
                + ", inputMaxS1Limit=" + inputMaxS1Limit + ", inputMinS2Limit=" + inputMinS2Limit + ", inputMaxS2Limit="
                + inputMaxS2Limit + ", inputMinS3Limit=" + inputMinS3Limit + ", inputMaxS3Limit=" + inputMaxS3Limit
                + ", inputMinUpgradesLimit=" + inputMinUpgradesLimit + ", inputMaxUpgradesLimit="
                + inputMaxUpgradesLimit + ", inputMinConversionsLimit=" + inputMinConversionsLimit
                + ", inputMaxConversionsLimit=" + inputMaxConversionsLimit + ", inputMinEquippedLimit="
                + inputMinEquippedLimit + ", inputMaxEquippedLimit=" + inputMaxEquippedLimit + ", inputMinScoreLimit="
                + inputMinScoreLimit + ", inputMaxScoreLimit=" + inputMaxScoreLimit + ", inputMinBSLimit="
                + inputMinBSLimit + ", inputMaxBSLimit=" + inputMaxBSLimit + ", inputMinPriorityLimit="
                + inputMinPriorityLimit + ", inputMaxPriorityLimit=" + inputMaxPriorityLimit + ", inputAtkMinForce="
                + inputAtkMinForce + ", inputAtkMaxForce=" + inputAtkMaxForce + ", inputAtkPercentMinForce="
                + inputAtkPercentMinForce + ", inputAtkPercentMaxForce=" + inputAtkPercentMaxForce
                + ", inputSpdMinForce=" + inputSpdMinForce + ", inputSpdMaxForce=" + inputSpdMaxForce
                + ", inputCrMinForce=" + inputCrMinForce + ", inputCrMaxForce=" + inputCrMaxForce + ", inputCdMinForce="
                + inputCdMinForce + ", inputCdMaxForce=" + inputCdMaxForce + ", inputHpMinForce=" + inputHpMinForce
                + ", inputHpMaxForce=" + inputHpMaxForce + ", inputHpPercentMinForce=" + inputHpPercentMinForce
                + ", inputHpPercentMaxForce=" + inputHpPercentMaxForce + ", inputDefMinForce=" + inputDefMinForce
                + ", inputDefMaxForce=" + inputDefMaxForce + ", inputDefPercentMinForce=" + inputDefPercentMinForce
                + ", inputDefPercentMaxForce=" + inputDefPercentMaxForce + ", inputEffMinForce=" + inputEffMinForce
                + ", inputEffMaxForce=" + inputEffMaxForce + ", inputResMinForce=" + inputResMinForce
                + ", inputResMaxForce=" + inputResMaxForce + ", inputForceNumberSelect=" + inputForceNumberSelect
                + ", inputForceMode=" + inputForceMode + ", inputFilterPriority=" + inputFilterPriority
                + ", inputAtkPriority=" + inputAtkPriority + ", inputHpPriority=" + inputHpPriority
                + ", inputDefPriority=" + inputDefPriority + ", inputSpdPriority=" + inputSpdPriority
                + ", inputCrPriority=" + inputCrPriority + ", inputCdPriority=" + inputCdPriority
                + ", inputEffPriority=" + inputEffPriority + ", inputResPriority=" + inputResPriority + ", boolArr="
                + Arrays.toString(boolArr) + ", setPermutationIndicesPlusOne="
                + Arrays.toString(setPermutationIndicesPlusOne) + ", setSolutionCounters="
                + Arrays.toString(setSolutionCounters) + ", setFormat=" + setFormat + "]";
    }

    public OptimizationRequest withHero(Hero newHero) {
        return this.hero == newHero ? this
                : new OptimizationRequest(executionId, heroId, newHero, damageMultipliers,
                        items, inputSets, inputSetsOne, inputSetsTwo, inputSetsThree, inputExcludeSet, excludeFilter,
                        excludedGearIds, inputNecklaceStat, inputRingStat,
                        inputBootsStat, inputPredictReforges, inputSubstatMods,
                        inputAllowLockedItems, inputAllowEquippedItems, inputOrderedHeroPriority,
                        inputKeepCurrentItems, inputOnlyMaxedGear, atk, hp, def, cr, cd,
                        eff, res, spd, dac, artifactAttack, artifactHealth, inputAtkMinLimit,
                        inputAtkMaxLimit, inputHpMinLimit, inputHpMaxLimit, inputDefMinLimit, inputDefMaxLimit,
                        inputSpdMinLimit, inputSpdMaxLimit, inputCrMinLimit, inputCrMaxLimit, inputCdMinLimit,
                        inputCdMaxLimit, inputEffMinLimit, inputEffMaxLimit, inputResMinLimit, inputResMaxLimit,
                        inputMinCpLimit, inputMaxCpLimit, inputMinHppsLimit, inputMaxHppsLimit,
                        inputMinEhpLimit, inputMaxEhpLimit, inputMinEhppsLimit, inputMaxEhppsLimit,
                        inputMinDmgLimit, inputMaxDmgLimit, inputMinDmgpsLimit, inputMaxDmgpsLimit,
                        inputMinMcdmgLimit, inputMaxMcdmgLimit, inputMinMcdmgpsLimit, inputMaxMcdmgpsLimit,
                        inputMinDmgHLimit, inputMaxDmgHLimit, inputMinDmgDLimit, inputMaxDmgDLimit,
                        inputMinS1Limit, inputMaxS1Limit, inputMinS2Limit, inputMaxS2Limit, inputMinS3Limit,
                        inputMaxS3Limit, inputMinUpgradesLimit, inputMaxUpgradesLimit, inputMinConversionsLimit,
                        inputMaxConversionsLimit, inputMinEquippedLimit, inputMaxEquippedLimit, inputMinScoreLimit,
                        inputMaxScoreLimit, inputMinBSLimit, inputMaxBSLimit, inputMinPriorityLimit,
                        inputMaxPriorityLimit, inputAtkMinForce, inputAtkMaxForce,
                        inputAtkPercentMinForce, inputAtkPercentMaxForce, inputSpdMinForce,
                        inputSpdMaxForce, inputCrMinForce, inputCrMaxForce, inputCdMinForce,
                        inputCdMaxForce, inputHpMinForce, inputHpMaxForce, inputHpPercentMinForce,
                        inputHpPercentMaxForce, inputDefMinForce, inputDefMaxForce,
                        inputDefPercentMinForce, inputDefPercentMaxForce, inputEffMinForce,
                        inputEffMaxForce, inputResMinForce, inputResMaxForce,
                        inputForceNumberSelect, inputForceMode, inputFilterPriority,
                        inputAtkPriority, inputHpPriority, inputDefPriority, inputSpdPriority,
                        inputCrPriority, inputCdPriority, inputEffPriority, inputResPriority,
                        boolArr, setPermutationIndicesPlusOne, setSolutionCounters, setFormat);
    }

    public OptimizationRequest withItems(List<Item> newItems) {
        return this.items == newItems ? this
                : new OptimizationRequest(executionId, heroId, hero, damageMultipliers,
                        newItems, inputSets, inputSetsOne, inputSetsTwo, inputSetsThree, inputExcludeSet, excludeFilter,
                        excludedGearIds, inputNecklaceStat, inputRingStat,
                        inputBootsStat, inputPredictReforges, inputSubstatMods,
                        inputAllowLockedItems, inputAllowEquippedItems, inputOrderedHeroPriority,
                        inputKeepCurrentItems, inputOnlyMaxedGear, atk, hp, def, cr, cd,
                        eff, res, spd, dac, artifactAttack, artifactHealth, inputAtkMinLimit,
                        inputAtkMaxLimit, inputHpMinLimit, inputHpMaxLimit, inputDefMinLimit, inputDefMaxLimit,
                        inputSpdMinLimit, inputSpdMaxLimit, inputCrMinLimit, inputCrMaxLimit, inputCdMinLimit,
                        inputCdMaxLimit, inputEffMinLimit, inputEffMaxLimit, inputResMinLimit, inputResMaxLimit,
                        inputMinCpLimit, inputMaxCpLimit, inputMinHppsLimit, inputMaxHppsLimit,
                        inputMinEhpLimit, inputMaxEhpLimit, inputMinEhppsLimit, inputMaxEhppsLimit,
                        inputMinDmgLimit, inputMaxDmgLimit, inputMinDmgpsLimit, inputMaxDmgpsLimit,
                        inputMinMcdmgLimit, inputMaxMcdmgLimit, inputMinMcdmgpsLimit, inputMaxMcdmgpsLimit,
                        inputMinDmgHLimit, inputMaxDmgHLimit, inputMinDmgDLimit, inputMaxDmgDLimit,
                        inputMinS1Limit, inputMaxS1Limit, inputMinS2Limit, inputMaxS2Limit, inputMinS3Limit,
                        inputMaxS3Limit, inputMinUpgradesLimit, inputMaxUpgradesLimit, inputMinConversionsLimit,
                        inputMaxConversionsLimit, inputMinEquippedLimit, inputMaxEquippedLimit, inputMinScoreLimit,
                        inputMaxScoreLimit, inputMinBSLimit, inputMaxBSLimit, inputMinPriorityLimit,
                        inputMaxPriorityLimit, inputAtkMinForce, inputAtkMaxForce,
                        inputAtkPercentMinForce, inputAtkPercentMaxForce, inputSpdMinForce,
                        inputSpdMaxForce, inputCrMinForce, inputCrMaxForce, inputCdMinForce,
                        inputCdMaxForce, inputHpMinForce, inputHpMaxForce, inputHpPercentMinForce,
                        inputHpPercentMaxForce, inputDefMinForce, inputDefMaxForce,
                        inputDefPercentMinForce, inputDefPercentMaxForce, inputEffMinForce,
                        inputEffMaxForce, inputResMinForce, inputResMaxForce,
                        inputForceNumberSelect, inputForceMode, inputFilterPriority,
                        inputAtkPriority, inputHpPriority, inputDefPriority, inputSpdPriority,
                        inputCrPriority, inputCdPriority, inputEffPriority, inputResPriority,
                        boolArr, setPermutationIndicesPlusOne, setSolutionCounters, setFormat);
    }

    public OptimizationRequest withBoolArr(boolean[] newBoolArr) {
        return this.boolArr == newBoolArr ? this
                : new OptimizationRequest(executionId, heroId, hero, damageMultipliers,
                        items, inputSets, inputSetsOne, inputSetsTwo, inputSetsThree, inputExcludeSet, excludeFilter,
                        excludedGearIds, inputNecklaceStat, inputRingStat,
                        inputBootsStat, inputPredictReforges, inputSubstatMods,
                        inputAllowLockedItems, inputAllowEquippedItems, inputOrderedHeroPriority,
                        inputKeepCurrentItems, inputOnlyMaxedGear, atk, hp, def, cr, cd,
                        eff, res, spd, dac, artifactAttack, artifactHealth, inputAtkMinLimit,
                        inputAtkMaxLimit, inputHpMinLimit, inputHpMaxLimit, inputDefMinLimit, inputDefMaxLimit,
                        inputSpdMinLimit, inputSpdMaxLimit, inputCrMinLimit, inputCrMaxLimit, inputCdMinLimit,
                        inputCdMaxLimit, inputEffMinLimit, inputEffMaxLimit, inputResMinLimit, inputResMaxLimit,
                        inputMinCpLimit, inputMaxCpLimit, inputMinHppsLimit, inputMaxHppsLimit,
                        inputMinEhpLimit, inputMaxEhpLimit, inputMinEhppsLimit, inputMaxEhppsLimit,
                        inputMinDmgLimit, inputMaxDmgLimit, inputMinDmgpsLimit, inputMaxDmgpsLimit,
                        inputMinMcdmgLimit, inputMaxMcdmgLimit, inputMinMcdmgpsLimit, inputMaxMcdmgpsLimit,
                        inputMinDmgHLimit, inputMaxDmgHLimit, inputMinDmgDLimit, inputMaxDmgDLimit,
                        inputMinS1Limit, inputMaxS1Limit, inputMinS2Limit, inputMaxS2Limit, inputMinS3Limit,
                        inputMaxS3Limit, inputMinUpgradesLimit, inputMaxUpgradesLimit, inputMinConversionsLimit,
                        inputMaxConversionsLimit, inputMinEquippedLimit, inputMaxEquippedLimit, inputMinScoreLimit,
                        inputMaxScoreLimit, inputMinBSLimit, inputMaxBSLimit, inputMinPriorityLimit,
                        inputMaxPriorityLimit, inputAtkMinForce, inputAtkMaxForce,
                        inputAtkPercentMinForce, inputAtkPercentMaxForce, inputSpdMinForce,
                        inputSpdMaxForce, inputCrMinForce, inputCrMaxForce, inputCdMinForce,
                        inputCdMaxForce, inputHpMinForce, inputHpMaxForce, inputHpPercentMinForce,
                        inputHpPercentMaxForce, inputDefMinForce, inputDefMaxForce,
                        inputDefPercentMinForce, inputDefPercentMaxForce, inputEffMinForce,
                        inputEffMaxForce, inputResMinForce, inputResMaxForce,
                        inputForceNumberSelect, inputForceMode, inputFilterPriority,
                        inputAtkPriority, inputHpPriority, inputDefPriority, inputSpdPriority,
                        inputCrPriority, inputCdPriority, inputEffPriority, inputResPriority,
                        newBoolArr, setPermutationIndicesPlusOne, setSolutionCounters, setFormat);
    }

}
