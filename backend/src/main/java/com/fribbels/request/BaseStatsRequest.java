package com.fribbels.request;

import com.fribbels.model.BaseStats;
import com.fribbels.model.Request;

import java.util.Map;

public class BaseStatsRequest extends Request {

    private Map<String, BaseStats> baseStatsByName;

    public Map<String, BaseStats> getBaseStatsByName() {
        return baseStatsByName;
    }

    public void setBaseStatsByName(Map<String, BaseStats> baseStatsByName) {
        this.baseStatsByName = baseStatsByName;
    }

    @Override
    public String toString() {
        return "BaseStatsRequest [baseStatsByName=" + baseStatsByName + "]";
    }

}
