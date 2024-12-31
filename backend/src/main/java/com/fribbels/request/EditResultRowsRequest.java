package com.fribbels.request;

import com.fribbels.model.Request;

public class EditResultRowsRequest extends Request {

    private String executionId;
    private int index;
    private String property;

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "EditResultRowsRequest [executionId=" + executionId + ", index=" + index + ", property=" + property
                + "]";
    }

}
