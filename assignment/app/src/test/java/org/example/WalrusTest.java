package org.example;

import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.example.values.CannedWalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {
    
    // Tests for Question 1: How much a Walrus can eat
    @Test
    public void testWalrusCanEat() {
        // Create a Walrus object
        Walrus walrus = new Walrus();
        
        // Create a WalrusFood object
        WalrusFood fish = new WalrusFood();
        
        // Add the food to the walrus's stomach
        walrus.addToStomach(fish);
        
        // Assert that the Walrus has eaten the food
        assertTrue("Walrus should have eaten the food", walrus.hasEaten(fish));
    }
    
    @Test
    public void testWalrusCanEatMultipleItems() {
        // Create a Walrus object
        Walrus walrus = new Walrus();
        
        // Create multiple WalrusFood objects
        WalrusFood fish1 = new WalrusFood();
        WalrusFood fish2 = new WalrusFood();
        WalrusFood fish3 = new WalrusFood();
        
        // Add the foods to the walrus's stomach
        walrus.addToStomach(fish1);
        walrus.addToStomach(fish2);
        walrus.addToStomach(fish3);
        
        // Assert that the Walrus has eaten all three food items
        assertTrue("Walrus should have eaten fish1", walrus.hasEaten(fish1));
        assertTrue("Walrus should have eaten fish2", walrus.hasEaten(fish2));
        assertTrue("Walrus should have eaten fish3", walrus.hasEaten(fish3));
    }
    
    @Test
    public void testWalrusCanBeFedWithCannedFood() {
        // Create a Walrus object
        Walrus walrus = new Walrus();
        
        // Create a CannedWalrusFood object with a WalrusFood inside
        WalrusFood fish = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(fish);
        
        // Create a FeedsWalrus object to feed the walrus
        FeedsWalrus feeder = new FeedsWalrus();
        
        // Feed the walrus using the FeedsWalrus object
        feeder.feed(walrus, cannedFood);
        
        // Assert that the Walrus has eaten the food from the can
        assertTrue("Walrus should have eaten the food from the can", walrus.hasEaten(fish));
    }
    
    // Tests for Question 2: Check if a Walrus gets the right food
    @Test
    public void testWalrusGetsRightFood() {
        // Create a Walrus object
        Walrus walrus = new Walrus();
        
        // Create different WalrusFood objects
        WalrusFood rightFood = new WalrusFood();
        WalrusFood wrongFood = new WalrusFood();
        
        // Add only the "right" food to the walrus's stomach
        walrus.addToStomach(rightFood);
        
        // Assert that the Walrus has eaten the right food
        assertTrue("Walrus should have eaten the right food", walrus.hasEaten(rightFood));
        
        // Assert that the Walrus has not eaten the wrong food
        assertFalse("Walrus should not have eaten the wrong food", walrus.hasEaten(wrongFood));
    }
    
    @Test
    public void testWalrusGetsRightFoodWhenFed() {
        // Create a Walrus object
        Walrus walrus = new Walrus();
        
        // Create a specific WalrusFood object
        WalrusFood specificFood = new WalrusFood();
        
        // Create a CannedWalrusFood with our specific food
        CannedWalrusFood cannedFood = new CannedWalrusFood(specificFood);
        
        // Feed the walrus using the FeedsWalrus object
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, cannedFood);
        
        // Create a different food object that the walrus hasn't eaten
        WalrusFood differentFood = new WalrusFood();
        
        // Assert that the Walrus has eaten our specific food
        assertTrue("Walrus should have eaten the specific food", walrus.hasEaten(specificFood));
        
        // Assert that the Walrus has not eaten the different food
        assertFalse("Walrus should not have eaten the different food", walrus.hasEaten(differentFood));
    }
    
    // Tests for Question 3: Check that opening a can returns food
    @Test
    public void testOpeningCanReturnsFood() {
        // Create a WalrusFood object
        WalrusFood originalFood = new WalrusFood();
        
        // Put the food in a can
        CannedWalrusFood can = new CannedWalrusFood(originalFood);
        
        // Create an OpensCan object
        OpensCan canOpener = new OpensCan();
        
        // Open the can
        WalrusFood extractedFood = canOpener.open(can);
        
        // Assert that the extracted food is the same as the original food
        assertSame("Opening a can should return the original food", originalFood, extractedFood);
        
        // Try to extract from the same can again (should be null since the can is now empty)
        WalrusFood secondExtraction = can.extractContents();
        assertNull("Extracting from an empty can should return null", secondExtraction);
    }
    
    // Tests for Question 4: Check how a Walrus can eat
    @Test
    public void testHowWalrusCanEat() {
        // Create a Walrus object
        Walrus walrus = new Walrus();
        
        // Test Method 1: Direct feeding via addToStomach()
        WalrusFood directFood = new WalrusFood();
        walrus.addToStomach(directFood);
        assertTrue("Walrus should be able to eat food added directly to stomach", 
                  walrus.hasEaten(directFood));
        
        // Test Method 2: Feeding via FeedsWalrus with canned food
        WalrusFood cannedFoodContent = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(cannedFoodContent);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, cannedFood);
        assertTrue("Walrus should be able to eat food fed via FeedsWalrus", 
                  walrus.hasEaten(cannedFoodContent));
        
        // Test that both foods are in the stomach
        assertTrue("Walrus should have both directly added food and fed food in stomach", 
                  walrus.hasEaten(directFood) && walrus.hasEaten(cannedFoodContent));
        
        // Test that an empty can doesn't add any food
        CannedWalrusFood emptyCan = new CannedWalrusFood();
        feeder.feed(walrus, emptyCan);
        
        // Create a food that hasn't been eaten
        WalrusFood uneatenFood = new WalrusFood();
        assertFalse("Walrus should not have eaten food that wasn't added or fed", 
                   walrus.hasEaten(uneatenFood));
    }
    
    // Tests for Question 5: Make a Walrus accept non-Walrus food
    @Test
    public void testWalrusCanEatNonWalrusFood() {
        // Create a Walrus object
        Walrus walrus = new Walrus();
        
        // Create a custom food class that extends WalrusFood
        // This is technically a "non-Walrus food" in the sense that it's a subclass
        class CustomFood extends WalrusFood {
            private String name;
            
            public CustomFood(String name) {
                this.name = name;
            }
            
            public String getName() {
                return name;
            }
        }
        
        // Create a CustomFood object
        CustomFood customFood = new CustomFood("Salmon");
        
        // Feed the custom food to the Walrus
        walrus.addToStomach(customFood);
        
        // Verify that the Walrus has eaten the custom food
        assertTrue("Walrus should accept and eat custom food", walrus.hasEaten(customFood));
        
        // Also verify that the custom food can be distinguished from regular WalrusFood
        WalrusFood regularFood = new WalrusFood();
        assertNotEquals("Custom food should be different from regular food", regularFood, customFood);
        
        // Check that we're really dealing with our custom type
        assertTrue("Should be an instance of CustomFood", customFood instanceof CustomFood);
        assertTrue("Should also be an instance of WalrusFood", customFood instanceof WalrusFood);
    }
}