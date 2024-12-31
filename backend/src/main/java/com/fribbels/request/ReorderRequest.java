package com.fribbels.request;

import com.fribbels.model.Request;

public class ReorderRequest extends Request {

    private String id;
    private String destinationId;
    private Integer destinationIndex;

    public ReorderRequest() {
    }

    public ReorderRequest(String id, String destinationId, Integer destinationIndex) {
        this.id = id;
        this.destinationId = destinationId;
        this.destinationIndex = destinationIndex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }

    @Override
    public String toString() {
        return "ReorderRequest [id=" + id + ", destinationId=" + destinationId + ", destinationIndex="
                + destinationIndex + "]";
    }

}
