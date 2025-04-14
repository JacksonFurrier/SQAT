/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.example.values.CannedWalrusFood;

public class WalrusTest {
    private Walrus walrus;
    private FeedsWalrus feeder;
    private OpensCan opener;

    @Before
    public void setUp() {
        walrus = new Walrus();
        feeder = new FeedsWalrus();
        opener = new OpensCan();
    }

    // 1. Test how much a Walrus can eat
    @Test
    public void testWalrusCapacity() {
        int foodCount = 10000;

        for (int i = 0; i < foodCount; i++) {
            WalrusFood food = new WalrusFood("food-" + i);
            CannedWalrusFood can = new CannedWalrusFood(food);
            feeder.feed(walrus, can);

            if (i % 1000 == 0 && i > 0) {
                assertTrue(walrus.hasEaten(food));
            }
        }

        for (int i = 0; i < 10; i++) {
            int randomIndex = (int)(Math.random() * foodCount);
            WalrusFood testFood = new WalrusFood("food-" + randomIndex);
            assertFalse(walrus.hasEaten(testFood));
        }
    }

    // 2. Test if a Walrus gets the right food
    @Test
    public void testWalrusCanEatFood() {
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();

        CannedWalrusFood can1 = new CannedWalrusFood(food1);
        CannedWalrusFood can2 = new CannedWalrusFood(food2);

        feeder.feed(walrus, can1);
        feeder.feed(walrus, can2);

        assertTrue(walrus.hasEaten(food1));
        assertTrue(walrus.hasEaten(food2));
    }

    @Test
    public void testWalrusGetsRightFood() {
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();

        CannedWalrusFood can1 = new CannedWalrusFood(food1);
        CannedWalrusFood can2 = new CannedWalrusFood(food2);

        feeder.feed(walrus, can1);

        assertTrue(walrus.hasEaten(food1));
        assertFalse(walrus.hasEaten(food2));
    }

    // 3. Test opening a can will return food
    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);

        WalrusFood result = opener.open(can);

        assertNotNull(result);
        assertSame(food, result);
    }

    @Test
    public void testOpeningEmptyCan() {
        CannedWalrusFood emptyCan = new CannedWalrusFood();
        WalrusFood result = opener.open(emptyCan);
        assertNull(result);
    }

    // 4. Test how a Walrus can eat
    @Test
    public void testHowWalrusCanEat() {
        WalrusFood food = new WalrusFood();

        assertFalse(walrus.hasEaten(food));

        walrus.addToStomach(food);

        assertTrue(walrus.hasEaten(food));
    }

    // 5. Test making a Walrus accept non-Walrus food
    @Test
    public void testWalrusAcceptsNonWalrusFood() {
        class SharkFood extends WalrusFood {
            public SharkFood() {
                super("shark-food");
            }
        }

        WalrusFood regularFood = new WalrusFood();
        SharkFood sharkFood = new SharkFood();

        walrus.addToStomach(regularFood);
        walrus.addToStomach(sharkFood);

        assertTrue(walrus.hasEaten(regularFood));
        assertTrue(walrus.hasEaten(sharkFood));

        WalrusFood fishFood = new WalrusFood("fish");
        CannedWalrusFood fishCan = new CannedWalrusFood(fishFood);
        feeder.feed(walrus, fishCan);
        assertTrue(walrus.hasEaten(fishFood));
    }
}