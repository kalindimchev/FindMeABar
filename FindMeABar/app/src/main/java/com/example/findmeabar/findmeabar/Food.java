package com.example.findmeabar.findmeabar;


public class Food {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
