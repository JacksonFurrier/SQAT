package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

public class WalrusTest {

    private Walrus walrus;

    /**
     * Initializes the walrus instance before each test case.
     */
    @Before
    public void setUp() {
        walrus = new Walrus();
    }

    /**
     * Test to see if a walrus will eat WalrusFood.
     * <p>
     * This test case is used to verify that the walrus will eat WalrusFood.
     */
    @Test
    public void testToSeeWalrusCanEatWalrusFood() {
        WalrusFood walrusFood = new WalrusFood();
        walrus.addToStomach(walrusFood);

        assertTrue(
            walrus.hasEaten(walrusFood)
        );
    }

    /**
     * Verifies that a walrus can eat a large quantity of food.
     * <p>
     * This test case is used to verify that the walrus can eat a large
     * quantity of food without any problems.
     */
    @Test
    public void testToSeeWalrusCanEatLargeQuantityOfFood() {
        for (int i = 0; i < 10000; i++) {
            WalrusFood walrusFood = new WalrusFood();
            walrus.addToStomach(walrusFood);

            assertTrue(
                walrus.hasEaten(walrusFood)
            );
        }
    }

    /**
     * Verifies that a walrus has not eaten food that was not given to it.
     * <p>
     * This test case is used to verify that the walrus will not incorrectly
     * report that it has eaten food that was not given to it.
     */
    @Test
    public void testToSeeWalrusHasNotEatenFoodThatWasNotGiven() {
        WalrusFood notGivenFood = new WalrusFood();

        assertFalse(
            walrus.hasEaten(notGivenFood)
        );
    }

    /**
     * Tests that the contents of CannedWalrusFood are correctly extracted.
     * <p>
     * This test verifies that when a WalrusFood object is encapsulated within
     * a CannedWalrusFood, it can be successfully extracted back as the same
     * object.
     */
    @Test
    public void testToSeeCannedWalrusFoodExtractsContents() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(food);

        assertEquals(
            food,
            cannedFood.extractContents()
        );
    }

    /**
     * Tests that a walrus can eat food from a can.
     * <p>
     * This test verifies that when a WalrusFood object is encapsulated within
     * a CannedWalrusFood and opened using an OpensCan instance, the walrus will
     * successfully consume the food and it will be present in its stomach.
     */
    @Test
    public void testToSeeWalrusCanEatFoodFromCan() {
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(walrusFood);
        OpensCan canOpener = new OpensCan();
        walrus.addToStomach(
            canOpener.open(cannedFood)
        );

        assertTrue(
            walrus.hasEaten(walrusFood)
        );
    }

    /**
     * Tests that a walrus can eat non-standard WalrusFood.
     * <p>
     * This test verifies that when a subclass of WalrusFood, NonWalrusFood,
     * is added to the walrus's stomach, it is correctly recognized as eaten
     * by the walrus.
     */
    @Test
    public void testToSeeWalrusCanEatNonStandardWalrusFood() {
        class NonStandardWalrusFood extends WalrusFood {}

        NonStandardWalrusFood nonStandardWalrusFood = new NonStandardWalrusFood();
        walrus.addToStomach(nonStandardWalrusFood);

        assertTrue(
            walrus.hasEaten(nonStandardWalrusFood)
        );
    }
}