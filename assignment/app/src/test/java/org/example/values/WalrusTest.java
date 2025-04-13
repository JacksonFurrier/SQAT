package org.example.values;

import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {

    @Test
    public void testWalrusAcceptsFood() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();

        walrus.addToStomach(food);

        System.out.println("Walrus accepted food: " + food);
        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void testOpenCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();

        WalrusFood result = opener.open(can);

        System.out.println("Opened can, received food: " + result);
        assertNotNull(result);
    }

    @Test
    public void testFeedWalrusFromCan() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();

        feeder.feed(walrus, can);

        System.out.println("Fed walrus from can. Walrus has food: " + walrus.hasEaten(food));
        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void testWalrusGetsCorrectFoodObject() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        walrus.addToStomach(food);

        System.out.println("Testing that walrus received the correct food object...");
        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void testWalrusAcceptsAnyFood() {
        Walrus walrus = new Walrus();
        WalrusFood weirdFood = new WalrusFood();  // symbolic for non-walrus food

        walrus.addToStomach(weirdFood);

        System.out.println("Testing acceptance of non-walrus food...");
        assertTrue(walrus.hasEaten(weirdFood));
    }
}

