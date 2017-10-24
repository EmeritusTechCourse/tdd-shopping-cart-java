package com.allisnoba.models;

import com.allisnoba.models.Item;
import org.junit.Assert;
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
        Assert.assertEquals("when I begin shopping, then I expect my cart to be empty", 0, actual);

        // Teardown
    }
}
