package com.allisnoba.models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Cart {
    private List<LineItem> items = new ArrayList<>();

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(LineItem::getSubTotal)
                .reduce(new BigDecimal(0), BigDecimal::add);
    }

    public void addItem(Item item, int quantity) {
        items.add(new LineItem(item, quantity));
    }

    public List<LineItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<String> itemQuantities() {
        List<String> lineItems = new ArrayList<>();
        return items.stream()
                .map((item) -> String.format("%s - x%s", item.getItem().getName(), item.getQuantity()))
                .collect(Collectors.toList());
    }

    public List<String> itemizedList() {
        return items.stream()
                .map(Cart::itemizedFormat)
                .collect(Collectors.toList());
    }

    public List<String> onSaleItems() {
        return items.stream()
                .filter((item) -> item.getItem().isOnSale())
                .map(Cart::itemizedFormat)
                .collect(Collectors.toList());
    }

    private static String itemizedFormat(LineItem item) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return String.format("%s x%d - %s",
                item.getItem().getName(),
                item.getQuantity(),
                formatter.format(item.getSubTotal()));
    }
}
