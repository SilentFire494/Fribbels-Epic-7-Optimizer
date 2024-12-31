package com.fribbels.response;

import com.fribbels.model.Item;

import java.util.List;

public class GetAllItemsResponse extends Response {

    private List<Item> items;

    public GetAllItemsResponse(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GetAllItemsResponse [items=" + items + "]";
    }

}
