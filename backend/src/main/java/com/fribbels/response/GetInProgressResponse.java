package com.fribbels.response;

public class GetInProgressResponse extends Response {

    private boolean inProgress;

    public GetInProgressResponse(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    @Override
    public String toString() {
        return "GetInProgressResponse [inProgress=" + inProgress + "]";
    }

}
