package com.example.findmeabar.findmeabar;


import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("Person")
public class Food {

    @ServerProperty("FirstName")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ServerProperty("LastName")
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Food(String name, String price) {
        this.setName(name);
        this.setPrice(price);
    }
}
