package com.fribbels.request;

import com.fribbels.model.Request;

public class Ocr2Request extends Request {

    private String id;
    private boolean shifted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getShifted() {
        return shifted;
    }

    public void setShifted(Boolean shifted) {
        this.shifted = shifted;
    }

    @Override
    public String toString() {
        return "Ocr2Request [id=" + id + ", shifted=" + shifted + "]";
    }

}
