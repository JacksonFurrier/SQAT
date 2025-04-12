package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

/**
 * Tests different eating behaviors of a Walrus.
 */
public class WalrusTest {

    private Walrus walrus;
    private FeedsWalrus feeder;

    @Before
    public void initWalrus() {
        walrus = new Walrus();
        feeder = new FeedsWalrus();
    }

    @Test
    public void testWalrusCanEatLargeAmountOfFood() {
        int foodLimit = 500;
        for (int i = 0; i < foodLimit; i++) {
            WalrusFood bite = new WalrusFood();
            walrus.addToStomach(bite);
            assertTrue("Food number " + (i + 1) + " wasn't eaten", walrus.hasEaten(bite));
        }
    }

    @Test
    public void testWalrusReceivesCorrectFoodFromCan() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);

        feeder.feed(walrus, can);

        assertTrue("Walrus should have received the correct food", walrus.hasEaten(food));
    }

    @Test
    public void testCanOpeningRevealsFood() {
        WalrusFood foodInside = new WalrusFood();
        CannedWalrusFood sealedCan = new CannedWalrusFood(foodInside);
        OpensCan opener = new OpensCan();

        WalrusFood result = opener.open(sealedCan);

        assertEquals("The opened can should return the correct food", foodInside, result);
    }

    @Test
    public void testFeedingProcessWorksProperly() {
        WalrusFood fish = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(fish);

        feeder.feed(walrus, can);

        assertTrue("Feeding process failed", walrus.hasEaten(fish));
    }

    @Test
    public void testWalrusCanAcceptOtherObjectsAsFood() {
        Object unknownFood = new Object(); // Generic non-WalrusFood

        walrus.addToStomach(unknownFood);

        assertTrue("Walrus should accept non-Walrus food", walrus.hasEaten(unknownFood));
    }
}
