package com.fribbels.model;

import com.fribbels.enums.Gear;
import com.fribbels.enums.Material;
import com.fribbels.enums.Rank;
import com.fribbels.enums.Set;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Item {

    private Gear gear;
    private Rank rank;
    private Set set;

    private Integer enhance;
    private Integer level;

    private Stat main;
    private List<Stat> substats;
    private List<List<String>> op;
    private Boolean storage;
    private Mod mod;

    private String name;

    private AugmentedStats augmentedStats;
    private AugmentedStats reforgedStats;
    private Material material;
    private String mconfidence;

    private String id;
    private String modId;
    private String ingameId;
    private String ingameEquippedId;

    private String equippedById;
    private String equippedByName;
    private String heroName;

    private boolean locked;
    private boolean disableMods;

    private int reforgeable;
    private int upgradeable;
    private int convertable;
    private int alreadyEquipped;
    private int priority;
    private int wss;
    private int reforgedWss;
    private int dpsWss;
    private int supportWss;
    private int combatWss;

    private String duplicateId;
    private String allowedMods;

    private float[] tempStatAccArr;

    public Item(Gear gear, Rank rank, Set set, Integer enhance, Integer level, Stat main, List<Stat> substats,
            List<List<String>> op, Boolean storage, Mod mod, String name, AugmentedStats augmentedStats,
            AugmentedStats reforgedStats, Material material, String mconfidence, String id, String modId,
            String ingameId, String ingameEquippedId, String equippedById, String equippedByName, String heroName,
            boolean locked, boolean disableMods, int reforgeable, int upgradeable, int convertable, int alreadyEquipped,
            int priority, int wss, int reforgedWss, int dpsWss, int supportWss, int combatWss, String duplicateId,
            String allowedMods, float[] tempStatAccArr) {
        this.gear = gear;
        this.rank = rank;
        this.set = set;
        this.enhance = enhance;
        this.level = level;
        this.main = main;
        this.substats = substats;
        this.op = op;
        this.storage = storage;
        this.mod = mod;
        this.name = name;
        this.augmentedStats = augmentedStats;
        this.reforgedStats = reforgedStats;
        this.material = material;
        this.mconfidence = mconfidence;
        this.id = id;
        this.modId = modId;
        this.ingameId = ingameId;
        this.ingameEquippedId = ingameEquippedId;
        this.equippedById = equippedById;
        this.equippedByName = equippedByName;
        this.heroName = heroName;
        this.locked = locked;
        this.disableMods = disableMods;
        this.reforgeable = reforgeable;
        this.upgradeable = upgradeable;
        this.convertable = convertable;
        this.alreadyEquipped = alreadyEquipped;
        this.priority = priority;
        this.wss = wss;
        this.reforgedWss = reforgedWss;
        this.dpsWss = dpsWss;
        this.supportWss = supportWss;
        this.combatWss = combatWss;
        this.duplicateId = duplicateId;
        this.allowedMods = allowedMods;
        this.tempStatAccArr = tempStatAccArr;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Integer getEnhance() {
        return enhance;
    }

    public void setEnhance(Integer enhance) {
        this.enhance = enhance;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Stat getMain() {
        return main;
    }

    public void setMain(Stat main) {
        this.main = main;
    }

    public List<Stat> getSubstats() {
        return substats;
    }

    public void setSubstats(List<Stat> substats) {
        this.substats = substats;
    }

    public List<List<String>> getOp() {
        return op;
    }

    public void setOp(List<List<String>> op) {
        this.op = op;
    }

    public Boolean getStorage() {
        return storage;
    }

    public void setStorage(Boolean storage) {
        this.storage = storage;
    }

    public Mod getMod() {
        return mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AugmentedStats getAugmentedStats() {
        return augmentedStats;
    }

    public void setAugmentedStats(AugmentedStats augmentedStats) {
        this.augmentedStats = augmentedStats;
    }

    public AugmentedStats getReforgedStats() {
        return reforgedStats;
    }

    public void setReforgedStats(AugmentedStats reforgedStats) {
        this.reforgedStats = reforgedStats;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getMconfidence() {
        return mconfidence;
    }

    public void setMconfidence(String mconfidence) {
        this.mconfidence = mconfidence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public String getIngameId() {
        return ingameId;
    }

    public void setIngameId(String ingameId) {
        this.ingameId = ingameId;
    }

    public String getIngameEquippedId() {
        return ingameEquippedId;
    }

    public void setIngameEquippedId(String ingameEquippedId) {
        this.ingameEquippedId = ingameEquippedId;
    }

    public String getEquippedById() {
        return equippedById;
    }

    public void setEquippedById(String equippedById) {
        this.equippedById = equippedById;
    }

    public String getEquippedByName() {
        return equippedByName;
    }

    public void setEquippedByName(String equippedByName) {
        this.equippedByName = equippedByName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isDisableMods() {
        return disableMods;
    }

    public void setDisableMods(boolean disableMods) {
        this.disableMods = disableMods;
    }

    public int getReforgeable() {
        return reforgeable;
    }

    public void setReforgeable(int reforgeable) {
        this.reforgeable = reforgeable;
    }

    public int getUpgradeable() {
        return upgradeable;
    }

    public void setUpgradeable(int upgradeable) {
        this.upgradeable = upgradeable;
    }

    public int getConvertable() {
        return convertable;
    }

    public void setConvertable(int convertable) {
        this.convertable = convertable;
    }

    public int getAlreadyEquipped() {
        return alreadyEquipped;
    }

    public void setAlreadyEquipped(int alreadyEquipped) {
        this.alreadyEquipped = alreadyEquipped;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWss() {
        return wss;
    }

    public void setWss(int wss) {
        this.wss = wss;
    }

    public int getReforgedWss() {
        return reforgedWss;
    }

    public void setReforgedWss(int reforgedWss) {
        this.reforgedWss = reforgedWss;
    }

    public int getDpsWss() {
        return dpsWss;
    }

    public void setDpsWss(int dpsWss) {
        this.dpsWss = dpsWss;
    }

    public int getSupportWss() {
        return supportWss;
    }

    public void setSupportWss(int supportWss) {
        this.supportWss = supportWss;
    }

    public int getCombatWss() {
        return combatWss;
    }

    public void setCombatWss(int combatWss) {
        this.combatWss = combatWss;
    }

    public String getDuplicateId() {
        return duplicateId;
    }

    public void setDuplicateId(String duplicateId) {
        this.duplicateId = duplicateId;
    }

    public String getAllowedMods() {
        return allowedMods;
    }

    public void setAllowedMods(String allowedMods) {
        this.allowedMods = allowedMods;
    }

    public float[] getTempStatAccArr() {
        return tempStatAccArr;
    }

    public void setTempStatAccArr(float[] tempStatAccArr) {
        this.tempStatAccArr = tempStatAccArr;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public int getHash() {
        final HashItem hashItem = new HashItem(gear, rank, set, 0, level, main, augmentedStats);
        return hashItem.hashCode();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gear == null) ? 0 : gear.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((set == null) ? 0 : set.hashCode());
        result = prime * result + ((enhance == null) ? 0 : enhance.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((main == null) ? 0 : main.hashCode());
        result = prime * result + ((substats == null) ? 0 : substats.hashCode());
        result = prime * result + ((op == null) ? 0 : op.hashCode());
        result = prime * result + ((storage == null) ? 0 : storage.hashCode());
        result = prime * result + ((mod == null) ? 0 : mod.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((augmentedStats == null) ? 0 : augmentedStats.hashCode());
        result = prime * result + ((reforgedStats == null) ? 0 : reforgedStats.hashCode());
        result = prime * result + ((material == null) ? 0 : material.hashCode());
        result = prime * result + ((mconfidence == null) ? 0 : mconfidence.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modId == null) ? 0 : modId.hashCode());
        result = prime * result + ((ingameId == null) ? 0 : ingameId.hashCode());
        result = prime * result + ((ingameEquippedId == null) ? 0 : ingameEquippedId.hashCode());
        result = prime * result + ((equippedById == null) ? 0 : equippedById.hashCode());
        result = prime * result + ((equippedByName == null) ? 0 : equippedByName.hashCode());
        result = prime * result + ((heroName == null) ? 0 : heroName.hashCode());
        result = prime * result + (locked ? 1231 : 1237);
        result = prime * result + (disableMods ? 1231 : 1237);
        result = prime * result + reforgeable;
        result = prime * result + upgradeable;
        result = prime * result + convertable;
        result = prime * result + alreadyEquipped;
        result = prime * result + priority;
        result = prime * result + wss;
        result = prime * result + reforgedWss;
        result = prime * result + dpsWss;
        result = prime * result + supportWss;
        result = prime * result + combatWss;
        result = prime * result + ((duplicateId == null) ? 0 : duplicateId.hashCode());
        result = prime * result + ((allowedMods == null) ? 0 : allowedMods.hashCode());
        result = prime * result + Arrays.hashCode(tempStatAccArr);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (gear != other.gear)
            return false;
        if (rank != other.rank)
            return false;
        if (set != other.set)
            return false;
        if (enhance == null) {
            if (other.enhance != null)
                return false;
        } else if (!enhance.equals(other.enhance))
            return false;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (main == null) {
            if (other.main != null)
                return false;
        } else if (!main.equals(other.main))
            return false;
        if (substats == null) {
            if (other.substats != null)
                return false;
        } else if (!substats.equals(other.substats))
            return false;
        if (op == null) {
            if (other.op != null)
                return false;
        } else if (!op.equals(other.op))
            return false;
        if (storage == null) {
            if (other.storage != null)
                return false;
        } else if (!storage.equals(other.storage))
            return false;
        if (mod == null) {
            if (other.mod != null)
                return false;
        } else if (!mod.equals(other.mod))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (augmentedStats == null) {
            if (other.augmentedStats != null)
                return false;
        } else if (!augmentedStats.equals(other.augmentedStats))
            return false;
        if (reforgedStats == null) {
            if (other.reforgedStats != null)
                return false;
        } else if (!reforgedStats.equals(other.reforgedStats))
            return false;
        if (material != other.material)
            return false;
        if (mconfidence == null) {
            if (other.mconfidence != null)
                return false;
        } else if (!mconfidence.equals(other.mconfidence))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (modId == null) {
            if (other.modId != null)
                return false;
        } else if (!modId.equals(other.modId))
            return false;
        if (ingameId == null) {
            if (other.ingameId != null)
                return false;
        } else if (!ingameId.equals(other.ingameId))
            return false;
        if (ingameEquippedId == null) {
            if (other.ingameEquippedId != null)
                return false;
        } else if (!ingameEquippedId.equals(other.ingameEquippedId))
            return false;
        if (equippedById == null) {
            if (other.equippedById != null)
                return false;
        } else if (!equippedById.equals(other.equippedById))
            return false;
        if (equippedByName == null) {
            if (other.equippedByName != null)
                return false;
        } else if (!equippedByName.equals(other.equippedByName))
            return false;
        if (heroName == null) {
            if (other.heroName != null)
                return false;
        } else if (!heroName.equals(other.heroName))
            return false;
        if (locked != other.locked)
            return false;
        if (disableMods != other.disableMods)
            return false;
        if (reforgeable != other.reforgeable)
            return false;
        if (upgradeable != other.upgradeable)
            return false;
        if (convertable != other.convertable)
            return false;
        if (alreadyEquipped != other.alreadyEquipped)
            return false;
        if (priority != other.priority)
            return false;
        if (wss != other.wss)
            return false;
        if (reforgedWss != other.reforgedWss)
            return false;
        if (dpsWss != other.dpsWss)
            return false;
        if (supportWss != other.supportWss)
            return false;
        if (combatWss != other.combatWss)
            return false;
        if (duplicateId == null) {
            if (other.duplicateId != null)
                return false;
        } else if (!duplicateId.equals(other.duplicateId))
            return false;
        if (allowedMods == null) {
            if (other.allowedMods != null)
                return false;
        } else if (!allowedMods.equals(other.allowedMods))
            return false;
        if (!Arrays.equals(tempStatAccArr, other.tempStatAccArr))
            return false;
        return true;
    }

    public Item withReforgedStats(AugmentedStats reforgedStats) {
        return this.reforgedStats == reforgedStats ? this
                : new Item(gear, rank, set, enhance, level, main, substats, op, storage, mod, name, augmentedStats,
                        reforgedStats, material, mconfidence, id, modId, ingameId, ingameEquippedId, equippedById,
                        equippedByName, heroName, locked, disableMods, reforgeable, upgradeable, convertable,
                        alreadyEquipped, priority, wss, reforgedWss, dpsWss, supportWss, combatWss, duplicateId,
                        allowedMods, tempStatAccArr);
    }
}
