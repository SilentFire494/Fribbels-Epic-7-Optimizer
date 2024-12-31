package com.fribbels.request;

import com.fribbels.model.Request;

public class GetAllHeroesRequest extends Request {

    private boolean useReforgeStats;

    public boolean isUseReforgeStats() {
        return useReforgeStats;
    }

    public void setUseReforgeStats(boolean useReforgeStats) {
        this.useReforgeStats = useReforgeStats;
    }

    @Override
    public String toString() {
        return "GetAllHeroesRequest [useReforgeStats=" + useReforgeStats + "]";
    }

}
