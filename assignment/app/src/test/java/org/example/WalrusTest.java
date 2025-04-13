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
    // 1. Write a test to see how much a Walrus can eat
    @Test
    public void testWalrusHowMuchFood() {
        Walrus walrus = new Walrus();
        int foodTestNum = 500;
        WalrusFood[] foodsArr = new WalrusFood[foodTestNum];

        for (int i = 0; i < foodTestNum; i++) {
            foodsArr[i] = new WalrusFood();
            walrus.addToStomach(foodsArr[i]);
        }
        assertTrue("Walrus ate every food", walrus.hasEaten(foodsArr[foodTestNum-1]));
    }

    // 2. Write a test to check if a Walrus gets the right food
    @Test
    public void testWalrusGetsRightFood() {
        Walrus walrus = new Walrus();
        WalrusFood rightFood = new WalrusFood();
        WalrusFood wrongFood = new WalrusFood();

        walrus.addToStomach(rightFood);

        assertTrue(walrus.hasEaten(rightFood));
        assertFalse(walrus.hasEaten(wrongFood));
    }

    // 3. Write a test to check opening a can will return food
    @Test
    public void testCannedWalrusFoodReturnsFood() {
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood walrusCannedFood = new CannedWalrusFood(walrusFood);
        OpensCan canOpener = new OpensCan();

        WalrusFood returnedFood = canOpener.open(walrusCannedFood);

        assertEquals(walrusFood, returnedFood);
    }

    // 4. Write a test to check on how a Walrus can eat
    @Test
    public void testWalrusHowItEats() {
        Walrus walrus = new Walrus();
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood walrusCannedFood = new CannedWalrusFood(walrusFood);
        FeedsWalrus walrusFeeder = new FeedsWalrus();

        walrusFeeder.feed(walrus, walrusCannedFood);

        assertTrue(walrus.hasEaten(walrusFood));
    }

    // 5. Write a test making a Walrus accept non-Walrus food
    @Test
    public void testWalrusAcceptsFakeFood() {
        class WalrusFoodFake extends WalrusFood {}
        Walrus walrus = new Walrus();
        WalrusFood walrusFoodFake = new WalrusFoodFake();

        walrus.addToStomach(walrusFoodFake);

        assertTrue(walrus.hasEaten(walrusFoodFake));
    }
}
