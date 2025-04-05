package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test;

public class FeedsWalrusTest {
    @Test public void walrusEatsRight() {
        Walrus walrus = new Walrus();
        
        FeedsWalrus feedWalrus = new FeedsWalrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(food);
        assertFalse(walrus.hasEaten(food));
        feedWalrus.feed(walrus, cannedFood);
        assertTrue(walrus.hasEaten(food));
    }

    @Test(expected = NullPointerException.class)
    public void walrusShouldntEatNull() {
        Walrus walrus = new Walrus();
        
        FeedsWalrus feedWalrus = new FeedsWalrus();
        feedWalrus.feed(walrus, null);
    }
}
