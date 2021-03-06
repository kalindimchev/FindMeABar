package com.example.findmeabar.findmeabar;


import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("Food")
public class Food extends DataItem {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @ServerProperty("Name")
    private String name;

    @ServerProperty("PriceStr")
    private String price;

    public Food() {
    }



}
