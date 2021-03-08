package com.example.onlineshop;

import java.util.Date;

public class Food {
    private String name;

    private String description;

    private float price;

    private Date expirationDate;

    public Food(String name, String description, float price, Date expirationDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
