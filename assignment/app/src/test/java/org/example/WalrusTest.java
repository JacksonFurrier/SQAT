package org.example;

import org.example.values.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalrusTest {

    @Test
    public void testWalrusFoodItems() {
        Walrus walrus = new Walrus();
        int foodCount = 50;

        for (int i = 0; i < foodCount; i++) {
            WalrusFood food = new WalrusFood();
            walrus.addToStomach(food);
            assertTrue(walrus.hasEaten(food), "Walrus should have eaten food #" + i);
        }
    }

    @Test
    public void testWalrusGetsCorrectFood() {
        Walrus walrus = new Walrus();
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);

        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);

        assertTrue(walrus.hasEaten(expectedFood), "Walrus should have the exact food fed to it.");
    }

    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);

        OpensCan opener = new OpensCan();
        WalrusFood openedFood = opener.open(can);

        assertSame(food, openedFood, "Opened food should be the same instance as the one in the can.");
    }

    @Test
    public void testWalrusFeedingProcess() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);

        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);

        assertTrue(walrus.hasEaten(food), "Walrus should have eaten the food after feeding process.");
    }

    static class NonWalrusFood extends WalrusFood {}

    @Test
    public void testWalrusAcceptsNonWalrusFood() {
        Walrus walrus = new Walrus();
        WalrusFood alienFood = new NonWalrusFood();

        walrus.addToStomach(alienFood);

        assertTrue(walrus.hasEaten(alienFood), "Walrus should accept non-standard WalrusFood subclass.");
    }
}
