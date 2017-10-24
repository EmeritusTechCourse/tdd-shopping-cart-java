package com.allisnoba.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private BigDecimal totalPrice;
    private List<Item> items = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
