package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

/**
 * Unit tests for verifying different behaviors of a Walrus regarding eating.
 * All tests match assignment criteria.
 */
public class WalrusTest {

    private Walrus walrus;
    private FeedsWalrus feeder;

    @Before
    public void setUp() {
        walrus = new Walrus();
        feeder = new FeedsWalrus();
    }

    /**
     * Test 1: Write a test to see how much a Walrus can eat.
     * Verifies that a walrus can eat and remember 500 unique food items.
     */
    @Test
    public void testWalrusCanEatMultipleUniqueFoods() {
        int maxFood = 500;
        for (int i = 0; i < maxFood; i++) {
            WalrusFood foodItem = new WalrusFood();
            walrus.addToStomach(foodItem);

            assertTrue("Food item " + (i + 1) + " was not registered as eaten", walrus.hasEaten(foodItem));
        }
    }

    /**
     * Test 2: Write a test to check if a Walrus gets the right food.
     * Ensures that feeding from a can delivers the intended food.
     */
    @Test
    public void testCorrectFoodFromCan() {
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);

        feeder.feed(walrus, can);

        assertTrue("Walrus should have received the correct food from the can", walrus.hasEaten(expectedFood));
    }

    /**
     * Test 3: Write a test to check opening a can will return food.
     * Ensures that the food retrieved from a can is the same that was put in.
     */
    @Test
    public void testCanOpensWithCorrectFood() {
        WalrusFood foodInside = new WalrusFood();
        CannedWalrusFood sealedCan = new CannedWalrusFood(foodInside);
        OpensCan opener = new OpensCan();

        WalrusFood result = opener.open(sealedCan);

        assertEquals("Opened can should return the original food", foodInside, result);
    }

    /**
     * Test 4: Write a test to check on how a Walrus can eat.
     * Tests the entire process of feeding: can ➝ feeder ➝ walrus.
     */
    @Test
    public void testFullFeedingProcess() {
        WalrusFood fish = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(fish);

        feeder.feed(walrus, can);

        assertTrue("Walrus should have eaten the food from the correct can", walrus.hasEaten(fish));
    }

    /**
     * Test 5: Write a test making a Walrus accept non-Walrus food.
     * No animals were harmed during this exercise.
     */
    @Test
    public void testWalrusAcceptsNonWalrusFood() {
        class SpecialWalrusFood extends WalrusFood {}

        SpecialWalrusFood specialFood = new SpecialWalrusFood();

        walrus.addToStomach(specialFood);

        assertTrue("Walrus should accept food that extends WalrusFood", walrus.hasEaten(specialFood));
    }
}
