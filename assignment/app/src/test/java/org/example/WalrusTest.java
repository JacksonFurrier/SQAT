package org.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;


import org.example.values.*; // Ensure you have all your relevant classes here

public class WalrusTest {

    private Walrus gary;  // The walrus we’ll feed
    private FeedsWalrus feeder = new FeedsWalrus();  // Feeder instance to feed the walrus

    // @Before method will run before each test method
    @Before
    public void init() {
        gary = new Walrus();  // Initialize walrus before each test
    }

    /*
     * ------ "Write a test to see how much a Walrus can eat" ------
     * Integer.MAX_VALUE is the maximum size of a set, but let's test with a smaller number
     */
    @Test
    public void testFeedMultiple() {
        List<WalrusFood> eatenFoods = new ArrayList<>();  // A list to track eaten food

        // Feed the walrus 999 different foods
        for (int i = 0; i < 999; i++) {
            WalrusFood food = new WalrusFood();  // Create new food
            CannedWalrusFood can = new CannedWalrusFood(food);  // Put it in a can
            feeder.feed(gary, can);  // Feed the walrus
            eatenFoods.add(food);  // Add food to the list
        }

        // Verify that the walrus ate all the foods
        for (WalrusFood food : eatenFoods) {
            assertTrue("Walrus should have eaten this food", gary.hasEaten(food));
        }
    }

    /*
     * ------ "Write a test to check if a Walrus gets the right food" ------
     */
    @Test
    public void testGetsRightFood() {
        WalrusFood expectedFood = new WalrusFood();  // Create expected food
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);  // Put food in a can

        feeder.feed(gary, can);  // Feed the walrus with the can

        // Assert that the walrus has eaten the exact food we expected
        assertTrue("Walrus should have the right food in its stomach", gary.hasEaten(expectedFood));
    }

    /*
     * ------ "Write a test to check opening a can will return food" ------
     */
    @Test
    public void testOpeningCan() {
        WalrusFood expectedFood = new WalrusFood();  // Create expected food
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);  // Put it in a can
        OpensCan opener = new OpensCan();  // Create a new can opener

        // Open the can and retrieve the food
        WalrusFood actualFood = opener.open(can);

        // Assert that the food returned is exactly the same as the expected food
        assertSame("Opening the can should return the correct food", expectedFood, actualFood);
    }

    /*
     * ------ "Write a test to check on how a Walrus can eat" ------
     */
    @Test
    public void testEatingProcess() {
        WalrusFood expectedFood = new WalrusFood();  // Create food

        gary.addToStomach(expectedFood);  // Add food to the walrus' stomach

        // Assert that the walrus has eaten the food
        assertTrue("Walrus should have eaten the food", gary.hasEaten(expectedFood));
    }

    /*
     * ------ "Write a test making a Walrus accept non-Walrus food" ------
     */

    // Option 1: Use null as food
    @Test
    public void acceptNonWalrusFood() {
        CannedWalrusFood can = new CannedWalrusFood(null);  // Create a can with null food

        feeder.feed(gary, can);  // Feed the walrus with the can

        // Assert that the walrus has eaten the non-food (null)
        assertTrue("Walrus should have eaten null as non-Walrus food", gary.hasEaten(null));
    }

    // Option 2: Use a subclass of WalrusFood, but in my opinion, this is not non-Walrus food, since it extends WalrusFood
    static class NonWalrusFood extends WalrusFood { }

    @Test
    public void testWalrusAcceptsSubclassedNonWalrusFood() {
        // Create a subclass of WalrusFood
        WalrusFood nonWalrusFood = new NonWalrusFood();  // Create an instance of the subclass

        gary.addToStomach(nonWalrusFood);  // Add the subclassed food to the walrus' stomach

        // Assert that the walrus has eaten the subclassed food
        assertTrue("Walrus should have eaten 'NonWalrusFood' as non-Walrus food", gary.hasEaten(nonWalrusFood));
    }
}
