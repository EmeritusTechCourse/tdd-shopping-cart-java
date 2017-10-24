package com.allisnoba.models;

import com.allisnoba.models.Item;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartTest {
    @Test
    public void cartShouldInitializeEmpty() {
        // Setup
        Cart cart = new Cart();
        int expected = 0;

        // Exercise
        int actual = cart.getItems().size();

        // Assert
        assertEquals("when I begin shopping, then I expect my cart to be empty", 0, actual);
    }

    @Test
    public void emptyCartShouldCostZero() {
        // Setup (Given I have an empty cart)
        Cart cart = new Cart();
        Item item = new Item("Wumpus", new BigDecimal("100"), false);
        BigDecimal expected = new BigDecimal("100");

        // Exercise (when I add an Item)
        cart.addItem(item, 1);

        // Assert
        BigDecimal actual = cart.getTotalPrice();
        assertEquals("I expect to see `totalPrice` reflect the sum of all the Items in my cart, times the quantities of each item.", expected, actual);
    }

    @Test
    public void itemQuantitiesShouldUpdate() {
        // Setup (Given I have an empty cart)
        Cart cart = new Cart();
        Item item = new Item("Wumpus", new BigDecimal("100"), false);
        List<String> expected = Arrays.asList("Wumpus - x2");

        // Exercise (when I add more than one of an item)
        cart.addItem(item, 2);
        List<String> quantities = cart.itemQuantities();

        // Assert
        assertEquals("I expect `itemQuantities()` to show the number of items I have added.", expected, quantities);
    }

    @Test
    public void itemizedListShouldReflectPriceAndQuantity() {
        // Setup (Given I have an empty cart)
        Cart cart = new Cart();
        List<String> expected = Arrays.asList("Handbag x1 - $500.00", "Watch x2 - $40,000.00");

        // Exercise (when I add items)
        cart.addItem(new Item("Handbag", new BigDecimal("500"), false), 1);
        cart.addItem(new Item("Watch", new BigDecimal("20000"), false), 2);
        List<String> quantities = cart.itemizedList();

        // Assert
        assertEquals("I expect itemizedList() reflect the items I have added along with their price and quantity.", expected, quantities);
    }

    @Test
    public void totalPriceShouldReflectQuantity() {
        // Setup (Given I have an empty cart)
        Cart cart = new Cart();
        BigDecimal expected = new BigDecimal("40500");

        // Exercise (when I add more than one of an item)
        cart.addItem(new Item("Handbag", new BigDecimal("500"), false), 1);
        cart.addItem(new Item("Watch", new BigDecimal("20000"), false), 2);
        BigDecimal actual = cart.getTotalPrice();

        // Assert
        assertEquals("then I expect totalPrice to reflect both the item price and quantity.", expected, actual);
    }

    @Test
    public void onSaleItemsShouldFilter() {
        // Setup (Given I have a cart with items that are not on sale)
        Cart cart = new Cart();
        List<String> expected = Arrays.asList("Watch x2 - $40,000.00");
        cart.addItem(new Item("Handbag", new BigDecimal("500"), false), 1);
        cart.addItem(new Item("Watch", new BigDecimal("20000"), true), 2);

        // Exercise (when I add items that are on sale)
        List<String> quantities = cart.onSaleItems();

        // Assert
        assertEquals("I expect onSaleItems() to include only the items on sale.", expected, quantities);
    }
}
