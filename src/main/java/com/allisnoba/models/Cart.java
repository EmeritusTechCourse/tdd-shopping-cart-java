package com.allisnoba.models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

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

    public List<String> itemizedList() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        List<String> lineItems = new ArrayList<>();
        for(LineItem item : items) {
            lineItems.add(String.format("%s x%d - %s",
                    item.getItem().getName(),
                    item.getQuantity(),
                    formatter.format(item.getSubTotal())));
        }
        return lineItems;
    }
}
