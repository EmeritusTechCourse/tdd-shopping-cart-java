package com.allisnoba.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map((i) -> i.getPrice())
                .reduce(new BigDecimal(0), (acc, st) -> acc.add(st));
    }

    public void addItem(Item item, int quantity) {
        for(int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
