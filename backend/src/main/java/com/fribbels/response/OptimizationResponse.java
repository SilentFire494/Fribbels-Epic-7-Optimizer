package com.fribbels.response;

public class OptimizationResponse extends Response {

    private long searched;
    private long results;

    public OptimizationResponse(long searched, long results) {
        this.searched = searched;
        this.results = results;
    }

    public long getSearched() {
        return searched;
    }

    public void setSearched(long searched) {
        this.searched = searched;
    }

    public long getResults() {
        return results;
    }

    public void setResults(long results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "OptimizationResponse [searched=" + searched + ", results=" + results + "]";
    }

}
