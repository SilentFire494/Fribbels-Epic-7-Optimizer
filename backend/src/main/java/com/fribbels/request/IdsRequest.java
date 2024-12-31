package com.fribbels.request;

import com.fribbels.model.Request;

import java.util.List;

public class IdsRequest extends Request {

    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "IdsRequest [ids=" + ids + "]";
    }

    
}
