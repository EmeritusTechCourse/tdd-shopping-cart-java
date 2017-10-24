package com.allisnoba.models;

import com.allisnoba.models.Item;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
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
        BigDecimal expected = new BigDecimal("200");

        // Exercise (when I add an Item)
        cart.addItem(item, 2);

        // Assert
        BigDecimal actual = cart.getTotalPrice();
        assertEquals("I expect to see `totalPrice` reflect the sum of all the Items in my cart, times the quantities of each item.", expected, actual);
    }
}
