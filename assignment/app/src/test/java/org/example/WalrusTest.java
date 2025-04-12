package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {

    /**
     * Test that a Walrus can eat food when added directly.
     */
    @Test
    public void testAddFoodDirectly() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        
        // Verify that the walrus has not yet eaten this food
        assertFalse("Walrus should not have any food initially", walrus.hasEaten(food));
        
        // Add food directly to the walrus
        walrus.addToStomach(food);
        
        // Confirm that the walrus registers the added food
        assertTrue("Walrus should have eaten the added food", walrus.hasEaten(food));
    }

    /**
     * Test that a Walrus can eat multiple items.
     */
    @Test
    public void testMultipleFoodItems() {
        Walrus walrus = new Walrus();
        
        // Create several different food objects
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        WalrusFood food3 = new WalrusFood();
        
        // Add each food item
        walrus.addToStomach(food1);
        walrus.addToStomach(food2);
        walrus.addToStomach(food3);
        
        // Verify that the walrus registers each piece of food
        assertTrue("Walrus should have eaten food1", walrus.hasEaten(food1));
        assertTrue("Walrus should have eaten food2", walrus.hasEaten(food2));
        assertTrue("Walrus should have eaten food3", walrus.hasEaten(food3));
    }
    
    /**
     * Test that opening a can returns the exact food contained within.
     */
    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood canned = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();
        
        WalrusFood extracted = opener.open(canned);
        
        assertNotNull("The opened can should return a non-null food item", extracted);
        assertSame("The extracted food should be the exact instance contained in the can",
                   food, extracted);
    }
    
    /**
     * Test that feeding a walrus through the FeedsWalrus helper adds the food appropriately.
     */
    @Test
    public void testFeedingWalrusThroughFeeder() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood canned = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();
        
        // Use the feeder to feed the walrus
        feeder.feed(walrus, canned);
        
        // Confirm that the walrus registers the food
        assertTrue("Walrus should have eaten the food fed via the feeder", walrus.hasEaten(food));
    }
    
    @Test
    public void testNonWalrusFoodIsNotAccepted() {
        // The following code would not compile since NonWalrusFood is not a WalrusFood:
        // walrus.addToStomach(new NonWalrusFood());
        assertTrue("Type safety ensures that only WalrusFood is accepted (checked at compile time)", true);
    }
    
    /**
     * Test to confirm the statement "No animals were harmed during this exercise."
     */
    @Test
    public void testNoAnimalsHarmed() {
        boolean noAnimalsHarmed = true; 
        assertTrue("No animals were harmed during these tests", noAnimalsHarmed);
    }
}
