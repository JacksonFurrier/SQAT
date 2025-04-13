package org.example;

import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.example.values.CannedWalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {

    /**
     * A test to see how much a Walrus can eat
     */
    @Test
    public void testHowMuchWalrusCanEat() {
        final Walrus harryTheWalrus = new Walrus();
        final int foodCount = 16384;

        for (int i = 0; i < foodCount; i++) {
            WalrusFood food = new WalrusFood();
            harryTheWalrus.addToStomach(food);
            assertTrue("Walrus wasn't able to eat food num" + i,  harryTheWalrus.hasEaten(food));
        }
    }

    /**
     * A test to check if a Walrus gets the right food
     */
    @Test
    public void testWalrusGetsTheRightFood() {
        final Walrus jerryTheWalrus = new Walrus();
        final FeedsWalrus bobTheFeeder = new FeedsWalrus();

        final WalrusFood food1 = new WalrusFood();
        final CannedWalrusFood canOfFood = new CannedWalrusFood(food1);
        bobTheFeeder.feed(jerryTheWalrus, canOfFood);
        assertTrue("Walrus didn't eat the right food that was canned.", jerryTheWalrus.hasEaten(food1));
        
        final WalrusFood food2 = new WalrusFood();
        jerryTheWalrus.addToStomach(food2);
        assertTrue("Walrus wasn't able to eat food that wasn't canned", jerryTheWalrus.hasEaten(food2));
    }

    /**
     * A test to check opening a can will return food
     */
    @Test
    public void testOpenCanReturnsFood() {
        final WalrusFood food = new WalrusFood();
        final CannedWalrusFood can = new CannedWalrusFood(food);
        final OpensCan opener = new OpensCan();
        assertEquals("Opener didn't have the right food", food, opener.open(can));
    }

    /**
     * A test to check on how a Walrus can eat
     */
    @Test
    public void testHowWalrusCanEat() {
        final Walrus larryTheWalrus = new Walrus();
        final WalrusFood food1 = new WalrusFood();
        larryTheWalrus.addToStomach(food1);
        assertTrue("Walrus wasn't able to eat food directly", larryTheWalrus.hasEaten(food1));

        final WalrusFood food2 = new WalrusFood();
        final CannedWalrusFood cannedFood1 = new CannedWalrusFood(food2);
        final FeedsWalrus peterTheFeeder = new FeedsWalrus();
        peterTheFeeder.feed(larryTheWalrus, cannedFood1);
        assertTrue("Walrus wasn't able to eat food from a can from a feeder", larryTheWalrus.hasEaten(food2));

        final WalrusFood food3 = new WalrusFood();
        final CannedWalrusFood cannedFood2 = new CannedWalrusFood(food3);
        final OpensCan opener = new OpensCan();
        final WalrusFood openedFood3 = opener.open(cannedFood2);
        larryTheWalrus.addToStomach(openedFood3);
        assertTrue("Walrus wasn't able to eat food from a can that was just opened", larryTheWalrus.hasEaten(food3));
    }

    /**
     * A test making a Walrus accept non-Walrus food
     * No animals were harmed during this exercise
     */
    @Test
    public void testWalrusCanEatNonWalrusFood() {
        final Walrus karryTheWalrus = new Walrus();
        final NonWalrusFood food = new NonWalrusFood();
        karryTheWalrus.addToStomach(food);
        assertTrue("Walrus wasn't able to eat food that was non-Walrus", karryTheWalrus.hasEaten(food));
    }

    /**
     * This class is not a WalrusFood, but it is a food that a Walrus can most definitely eat.
     */
    private class NonWalrusFood extends WalrusFood {
        public final String name = "Non-Walrus Food";
    }
}
