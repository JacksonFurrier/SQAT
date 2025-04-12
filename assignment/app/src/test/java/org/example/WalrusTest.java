/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

public class WalrusTest {

    private Walrus walrus;
    private FeedsWalrus feedsWalrus;

    //Setup Walrus
    @Before
    public void setUp() {
        walrus = new Walrus();
        feedsWalrus = new FeedsWalrus();
    }

    //Write a test to see how much a Walrus can eat
    @Test
    public void checkHowMuchCanWalrusEat() {
        final int foodCount = 100;
        for(int i = 0; i < foodCount; i++) {
            WalrusFood food = new WalrusFood();
            CannedWalrusFood cannedFood = new CannedWalrusFood(food);
            feedsWalrus.feed(walrus, cannedFood);
            assertTrue("The specific food must be in the stomach", walrus.hasEaten(food));
        }
    }


    //Write a test to check if a Walrus gets the right food
    @Test
    public void checkIfWalrusGetsTheRightFood() {
        WalrusFood goodFood = new WalrusFood();
        CannedWalrusFood goodCannedFood = new CannedWalrusFood(goodFood);

        WalrusFood badFood = new WalrusFood();
        CannedWalrusFood badCannedFood = new CannedWalrusFood(badFood);

        feedsWalrus.feed(walrus, goodCannedFood);

        assertTrue("Walrus has eatean the good food", walrus.hasEaten(goodFood));
        assertNull("Walrus has eaten the good food from the can", goodCannedFood.extractContents());

        assertFalse("Walrus didn't eat the bad food", walrus.hasEaten(badFood));
        assertFalse("Walrus didn't eat the bad food from the can", walrus.hasEaten(badCannedFood.extractContents()));
    }


    //Write a test to check opening a can will return food
    @Test
    public void checkIfOpeningACanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(food);
        OpensCan canOpener = new OpensCan();

        assertEquals("The food will stay the same even when it is canned", food, canOpener.open(cannedFood));

        assertNull("Opening the same can for the second time, it should be empty", canOpener.open(cannedFood));
    }


    //Write a test to check on how a Walrus can eat
    @Test
    public void checkHowWalrusCanEat() {
        WalrusFood firstFood = new WalrusFood();
        walrus.addToStomach(firstFood);
        assertTrue("Walrus can eat the food by adding it to it's stomach", walrus.hasEaten(firstFood));

        WalrusFood secondFood = new WalrusFood();
        CannedWalrusFood firstCannedFood = new CannedWalrusFood(secondFood);
        feedsWalrus.feed(walrus, firstCannedFood);
        assertTrue("Walrus can be fed canned food", walrus.hasEaten(secondFood));
        

        OpensCan canOpener = new OpensCan();
        WalrusFood thirdFood = new WalrusFood();
        CannedWalrusFood secondCannedFood = new CannedWalrusFood(thirdFood);
        walrus.addToStomach(canOpener.open(secondCannedFood));
        assertTrue("Walrus can eat the food that was opened by a can opener by adding it to it's stomach", walrus.hasEaten(thirdFood));

    }


    //Write a test making a Walrus accept non-Walrus food
    static class NonWalrusFood extends WalrusFood {}

    @Test
    public void checkIfWalrusCanAcceptNonWalrusFood() {
        WalrusFood nonWalrusFood = new NonWalrusFood();
        walrus.addToStomach(nonWalrusFood);
        assertTrue("Walrus can eat the non-Walrus food", walrus.hasEaten(nonWalrusFood));

        WalrusFood secondNonWalrusFood = new NonWalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(secondNonWalrusFood);
        feedsWalrus.feed(walrus, cannedFood);
        assertTrue("Walrus can eat the non-Walrus food even when it is canned", walrus.hasEaten(secondNonWalrusFood));
    }


}
