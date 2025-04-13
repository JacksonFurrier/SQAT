package org.example.values;

import org.example.FeedsWalrus;
import org.example.OpensCan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalrusTest {

    private Walrus walrus;
    private WalrusFood food;

    @BeforeEach
    public void setUp() {
        walrus = new Walrus();
        food = new WalrusFood();
    }

   
    @Test
    public void testHasEatenInitiallyReturnsFalse() {
        assertFalse(walrus.hasEaten(food), "Initially, the walrus should not have eaten any food");
    }

    
    @Test
    public void testAddToStomachAndGetRightFood() {
        walrus.addToStomach(food);
        assertTrue(walrus.hasEaten(food), "After adding food, the walrus should have eaten it");
    }

   
    @Test
    public void testHowMuchWalrusCanEat() {
        int numberOfFoods = 5;
        WalrusFood[] foods = new WalrusFood[numberOfFoods];
        for (int i = 0; i < numberOfFoods; i++) {
            foods[i] = new WalrusFood();
            walrus.addToStomach(foods[i]);
        }

        for (int i = 0; i < numberOfFoods; i++) {
            assertTrue(walrus.hasEaten(foods[i]), "Walrus should have eaten food item " + i);
        }
    }

    
    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood innerFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(innerFood);
        OpensCan opener = new OpensCan();
        WalrusFood result = opener.open(can);
        assertSame(innerFood, result, "Opening the can should return the original WalrusFood");
    }

    
    @Test
    public void testFeedingWalrusWithCan() {
        WalrusFood innerFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(innerFood);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);
        assertTrue(walrus.hasEaten(innerFood), "Walrus should have eaten the food from the can");
    }

   
    @Test
    public void testRejectsNonWalrusFood() {
        assertThrows(ClassCastException.class, () -> {
            Object notFood = new Object();
            walrus.addToStomach((WalrusFood) notFood);
        }, "Walrus should reject non-WalrusFood items");
    }
}

