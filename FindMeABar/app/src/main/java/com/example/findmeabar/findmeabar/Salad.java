package com.example.findmeabar.findmeabar;

import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("Salad")
public class Salad extends DataItem {

    @ServerProperty("RestaurantName")
    private String restaurantName;

    @ServerProperty("Name")
    private String name;

    @ServerProperty("PriceStr")
    private String price;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

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

    public Salad() {
    }



}
