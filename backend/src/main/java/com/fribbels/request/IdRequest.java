package com.fribbels.request;

import com.fribbels.model.Request;

public class IdRequest extends Request {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdRequest [id=" + id + "]";
    }

}
