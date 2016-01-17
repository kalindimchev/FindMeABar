package com.example.findmeabar.findmeabar;

import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("Restaurant")
public class Bar extends DataItem {

    @ServerProperty("Name")
    private String name;

    @ServerProperty("Address")
    private String address;

    @ServerProperty("Description")
    private String Description;

    @ServerProperty("Phone")
    private String phone;

//    @ServerProperty("ImageLink")
//    private String picture;

    @ServerProperty("Rating")
    private String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getPicture() {
//        return picture;
//    }
//
//    public void setPicture(String picture) {
//        this.picture = picture;
//    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
