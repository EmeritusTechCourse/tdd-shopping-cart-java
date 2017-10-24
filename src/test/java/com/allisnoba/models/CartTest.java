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

        // Teardown
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
}
