package com.fribbels.request;

import com.fribbels.model.Item;
import com.fribbels.model.Request;

import java.util.List;

public class ItemsRequest extends Request {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemsRequest [items=" + items + "]";
    }

}
