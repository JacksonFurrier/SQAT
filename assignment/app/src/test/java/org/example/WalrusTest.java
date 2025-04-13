package org.example;

import org.example.values.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {

    @Test
    public void testHowMuchAWalrusCanEat() {
        Walrus walrus = new Walrus();
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        WalrusFood food3 = new WalrusFood();

        walrus.addToStomach(food1);
        walrus.addToStomach(food2);
        walrus.addToStomach(food3);

        System.out.println("Testing how much the walrus can eat...");
        assertTrue(walrus.hasEaten(food1));
        assertTrue(walrus.hasEaten(food2));
        assertTrue(walrus.hasEaten(food3));
        System.out.println("Walrus successfully ate all three food items.");
    }

    @Test
    public void testWalrusReceivesCorrectFood() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood canned = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();

        feeder.feed(walrus, canned);

        System.out.println("Testing if walrus receives the correct food from the can...");
        assertTrue(walrus.hasEaten(food));
        System.out.println("Walrus has the correct food.");
    }

    @Test
    public void testOpeningCanReturnsValidFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood canned = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();

        System.out.println("Testing if opening the can returns the correct food...");
        WalrusFood openedFood = opener.open(canned);

        assertEquals(food, openedFood);
        System.out.println("Can opened and food is valid.");
    }

    @Test
    public void testWalrusEatsFood() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();

        walrus.addToStomach(food);

        System.out.println("Testing if walrus eats food...");
        assertTrue(walrus.hasEaten(food));
        System.out.println("Walrus has eaten the food.");
    }

    @Test
    public void testWalrusAcceptsNonWalrusFood() {
        class OtherFood extends WalrusFood {}

        Walrus walrus = new Walrus();
        WalrusFood otherFood = new OtherFood();

        walrus.addToStomach(otherFood);

        System.out.println("Testing if walrus accepts 'non-walrus' food...");
        assertTrue(walrus.hasEaten(otherFood));
        System.out.println("Walrus accepted non-standard food.");
    }
}
