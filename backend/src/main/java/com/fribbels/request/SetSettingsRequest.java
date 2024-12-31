package com.fribbels.request;

import com.fribbels.model.Request;

public class SetSettingsRequest extends Request {

    private boolean settingUnlockOnUnequip;
    private boolean settingRageSet;
    private boolean settingPenSet;
    private boolean settingGpu;
    private Integer settingMaxResults;
    private Integer settingPenDefense;

    public SetSettingsRequest() {
    }

    public SetSettingsRequest(boolean settingUnlockOnUnequip, boolean settingRageSet, boolean settingPenSet,
            boolean settingGpu, Integer settingMaxResults, Integer settingPenDefense) {
        this.settingUnlockOnUnequip = settingUnlockOnUnequip;
        this.settingRageSet = settingRageSet;
        this.settingPenSet = settingPenSet;
        this.settingGpu = settingGpu;
        this.settingMaxResults = settingMaxResults;
        this.settingPenDefense = settingPenDefense;
    }

    public boolean isSettingUnlockOnUnequip() {
        return settingUnlockOnUnequip;
    }

    public void setSettingUnlockOnUnequip(boolean settingUnlockOnUnequip) {
        this.settingUnlockOnUnequip = settingUnlockOnUnequip;
    }

    public boolean isSettingRageSet() {
        return settingRageSet;
    }

    public void setSettingRageSet(boolean settingRageSet) {
        this.settingRageSet = settingRageSet;
    }

    public boolean isSettingPenSet() {
        return settingPenSet;
    }

    public void setSettingPenSet(boolean settingPenSet) {
        this.settingPenSet = settingPenSet;
    }

    public boolean isSettingGpu() {
        return settingGpu;
    }

    public void setSettingGpu(boolean settingGpu) {
        this.settingGpu = settingGpu;
    }

    public Integer getSettingMaxResults() {
        return settingMaxResults;
    }

    public void setSettingMaxResults(Integer settingMaxResults) {
        this.settingMaxResults = settingMaxResults;
    }

    public Integer getSettingPenDefense() {
        return settingPenDefense;
    }

    public void setSettingPenDefense(Integer settingPenDefense) {
        this.settingPenDefense = settingPenDefense;
    }

}
