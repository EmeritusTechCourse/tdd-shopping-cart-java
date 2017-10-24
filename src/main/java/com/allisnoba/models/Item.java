package com.allisnoba.models;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price; // http://vanillajava.blogspot.de/2011/08/double-your-money-again.html
    private boolean onSale;

    public Item(String name, BigDecimal price, boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }
}
