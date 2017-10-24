package com.allisnoba.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private List<LineItem> items = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map((i) -> i.getSubTotal())
                .reduce(new BigDecimal(0), (acc, st) -> acc.add(st));
    }

    public void addItem(Item item, int quantity) {
        items.add(new LineItem(item, quantity));
    }

    public List<LineItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<String> itemQuantities() {
        List<String> lineItems = new ArrayList<>();
        for(LineItem item : items) {
            lineItems.add(String.format("%s - x%s", item.getItem().getName(), item.getQuantity()));
        }
        return lineItems;
    }
}
