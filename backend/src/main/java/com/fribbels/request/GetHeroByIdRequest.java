package com.fribbels.request;

import com.fribbels.model.Request;

public class GetHeroByIdRequest extends Request {

    private String id;
    private boolean useReforgeStats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isUseReforgeStats() {
        return useReforgeStats;
    }

    public void setUseReforgeStats(boolean useReforgeStats) {
        this.useReforgeStats = useReforgeStats;
    }

    @Override
    public String toString() {
        return "GetHeroByIdRequest [id=" + id + ", useReforgeStats=" + useReforgeStats + "]";
    }

}
