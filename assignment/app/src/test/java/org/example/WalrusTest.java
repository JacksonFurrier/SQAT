/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

public class WalrusTest {
    
    @Test public void appHasAGreeting() {
    }
    @Test
    public void testWalrusCanEatCapacity() {
        Walrus walrus1 = new Walrus();
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        CannedWalrusFood can1 = new CannedWalrusFood(food1);
        CannedWalrusFood can2 = new CannedWalrusFood(food2);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus1, can1);
        feeder.feed(walrus1, can2);
        assertTrue("walrus1 has eaten food1", walrus1.hasEaten(food1));
        assertTrue("walrus1 has eaten food2", walrus1.hasEaten(food2));
    }
    @Test
    public void testRightFoodAssignment() {
        Walrus walrus1 = new Walrus();
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus1, can);
        assertTrue("walrus1's stomach contain the fed food", 
            walrus1.hasEaten(expectedFood));
    }
    @Test
    public void testOpenCanReturnsFood() {
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);
        OpensCan opensCan = new OpensCan();
        WalrusFood result = opensCan.open(can);
        assertEquals("Opened can return the food", expectedFood, result);
        assertNull("Can be empty after opening", can.extractContents());
    }
    @Test
    public void testFeedingProcess() {
        Walrus walrus1 = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus1, can);
        assertTrue("Feeding add food to stomach", 
            walrus1.hasEaten(food));
    }
    @Test
    public void testAcceptsNonCannedFood() {
        Walrus walrus1 = new Walrus();
        WalrusFood nonCannedFood = new WalrusFood();
        walrus1.addToStomach(nonCannedFood);
        assertTrue("Walrus accept directly added food", 
            walrus1.hasEaten(nonCannedFood));
    }
}
