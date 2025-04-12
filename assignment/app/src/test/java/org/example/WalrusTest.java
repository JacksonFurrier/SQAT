package org.example;

import org.example.values.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {

    @Test
    public void testWalrusCanEatMultipleFoods() {
        Walrus walrus = new Walrus();
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        
        walrus.addToStomach(food1);
        walrus.addToStomach(food2);

        assertTrue(walrus.hasEaten(food1));
        assertTrue(walrus.hasEaten(food2));
    }

    @Test
    public void testWalrusGetsRightFood() {
        Walrus walrus = new Walrus();
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);
        FeedsWalrus feeder = new FeedsWalrus();

        feeder.feed(walrus, can);

        assertTrue(walrus.hasEaten(expectedFood));
    }

    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();

        WalrusFood result = opener.open(can);
        assertEquals(food, result);
    }

    @Test
    public void testWalrusCanEat() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();

        walrus.addToStomach(food);

        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void testWalrusAcceptsNonWalrusFood() {
        Walrus walrus = new Walrus();
        WalrusFood weirdFood = new WalrusFood(); 

        walrus.addToStomach(weirdFood);

        assertTrue("Walrus should accept this non-Walrus food", walrus.hasEaten(weirdFood));
    }
}