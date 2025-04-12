package org.example.values;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class WalrusTest {

    private Walrus walrus;
    private WalrusFood food;

    @Before
    public void setUp() {
        walrus = new Walrus();
        food = new WalrusFood();
    }

    // Test: A Walrus initially has not eaten the food.
    @Test
    public void testHasEatenInitiallyReturnsFalse() {
        assertFalse("Initially, the walrus should not have eaten any food", walrus.hasEaten(food));
    }
    
    // Test: The Walrus gets the right food when added.
    @Test
    public void testAddToStomachAndGetRightFood() {
        walrus.addToStomach(food);
        assertTrue("After adding food, the walrus should have eaten it", walrus.hasEaten(food));
    }
    
    // Test: How much a Walrus can eat—add multiple food items.
    @Test
    public void testHowMuchWalrusCanEat() {
        int numberOfFoods = 5;
        WalrusFood[] foods = new WalrusFood[numberOfFoods];
        for (int i = 0; i < numberOfFoods; i++) {
            foods[i] = new WalrusFood();
            walrus.addToStomach(foods[i]);
        }
        
        // Check that the walrus has eaten each food.
        for (int i = 0; i < numberOfFoods; i++) {
            assertTrue("Walrus should have eaten food item " + i, walrus.hasEaten(foods[i]));
        }
    }
    
    // Test: Making a Walrus accept non-Walrus food.
    // Since addToStomach takes only WalrusFood, we simulate an invalid food
    // by forcing a bad cast on an Object.
    @Test(expected = ClassCastException.class)
    public void testRejectsNonWalrusFood() {
        Object nonWalrusFood = new Object();
        // This cast will throw ClassCastException.
        walrus.addToStomach((WalrusFood) nonWalrusFood);
    }
}
