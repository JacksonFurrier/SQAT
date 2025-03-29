package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Before;

public class WalrusTest {

    private Walrus walrus;

    /*
     * Set up a Walrus
     */
    @Before
    public void setUp() {
        walrus = new Walrus();
    }

    @Test 
    public void appHasAGreeting() {
    }

    /*
     * Test to see how much a Walrus can eat
     */
    @Test
    public void testToSeeWalrusAteFood() {
        for (int i = 0; i < 1000; i++) {
            WalrusFood walrusFood = new WalrusFood();
            walrus.addToStomach(walrusFood);
            assertTrue(walrus.hasEaten(walrusFood));
        }
    }

    /*
     * Test to check if a Walrus gets the right food
     */
    @Test
    public void testToSeeWalrusGotRightFood() {
        WalrusFood walrusFood = new WalrusFood();
        walrus.addToStomach(walrusFood);
        assertTrue(walrus.hasEaten(walrusFood));
    }

    /*
     * Test to check opening a can will return food
     */
    @Test
    public void testToSeeWalrusGotCannedFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        assertEquals(food, can.extractContents());
    }

    /*
     * Test to check on how a Walrus can eat
     */
    @Test
    public void testToSeeWalrusCanEat() {
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(walrusFood);
        OpensCan opensCan = new OpensCan();
        walrus.addToStomach(opensCan.open(can));
        assertTrue(walrus.hasEaten(walrusFood));
    }

    /*
     * Test making a Walrus accept non-Walrus food
     */
    @Test
    public void testToSeeWalrusCanEatNonWalrusFood() {
        class NonWalrusFood extends WalrusFood {
        }

        NonWalrusFood nonWalrusFood = new NonWalrusFood();
        walrus.addToStomach(nonWalrusFood);
        assertTrue(walrus.hasEaten(nonWalrusFood));
    }
}
