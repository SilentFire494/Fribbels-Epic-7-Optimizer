package com.fribbels.response;

import com.fribbels.model.Item;

public class GetItemByIdResponse extends Response {

    private Item item;

    public GetItemByIdResponse(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "GetItemByIdResponse [item=" + item + "]";
    }

}
