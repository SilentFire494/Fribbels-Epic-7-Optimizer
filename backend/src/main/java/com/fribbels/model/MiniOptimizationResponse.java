package com.fribbels.model;

import java.util.List;

public class MiniOptimizationResponse {

    private List<Integer> stats;
    private List<Integer> ids;

    public MiniOptimizationResponse(List<Integer> stats, List<Integer> ids) {
        this.stats = stats;
        this.ids = ids;
    }

    public List<Integer> getStats() {
        return stats;
    }

    public void setStats(List<Integer> stats) {
        this.stats = stats;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "MiniOptimizationResponse [stats=" + stats + ", ids=" + ids + "]";
    }

}
