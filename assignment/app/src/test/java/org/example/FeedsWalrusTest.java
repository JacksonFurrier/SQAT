package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FeedsWalrusTest {

    private FeedsWalrus feeder;
    private Walrus walrus;
    private WalrusFood food;
    private CannedWalrusFood can;

    @Before
    public void setUp() {
        feeder = new FeedsWalrus();
        walrus = new Walrus();
        food = new WalrusFood();
        can = new CannedWalrusFood(food);
    }

    @Test
    public void testFeedAddsFoodToWalrus() {
        // Before feeding, walrus should not have eaten this food.
        assertFalse("Before feeding, walrus should not have eaten the food", walrus.hasEaten(food));
        feeder.feed(walrus, can);
        // After feeding, walrus should have eaten the food.
        assertTrue("After feeding, walrus should have eaten the food", walrus.hasEaten(food));
    }
}
