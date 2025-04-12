package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

/**
 * Tests the eating behavior of a Walrus in different scenarios,
 * including feeding canned food, eating directly, and handling unexpected food types.
 */
public class WalrusTest {

    private Walrus walrus;
    private FeedsWalrus feeder;

    @Before
    public void setUp() {
        walrus = new Walrus();
        feeder = new FeedsWalrus();
    }

    @Test
    public void testToSeeHowMuchAWalrusCanEat() {
        int maxFood = 500;
        for (int i = 0; i < maxFood; i++) {
            WalrusFood food = new WalrusFood();
            walrus.addToStomach(food);
            assertTrue("Walrus could not eat the " + (i + 1) + "th food.", walrus.hasEaten(food));
        }

        System.out.println("Walrus successfully ate " + maxFood + " different food items!");
    }

    @Test
    public void testWalrusGetsTheRightFood() {
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);

        feeder.feed(walrus, can);

        assertTrue("Walrus should have eaten the food from the can", walrus.hasEaten(expectedFood));
    }

    @Test
    public void testOpeningCanReturnsTheFoodInside() {
        WalrusFood foodInside = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(foodInside);
        OpensCan opener = new OpensCan();

        WalrusFood extracted = opener.open(can);

        assertEquals("Opening the can should return the food that was inside", foodInside, extracted);
    }

    @Test
    public void testHowAWalrusCanEat() {
        WalrusFood sardine = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(sardine);

        feeder.feed(walrus, cannedFood);

        assertTrue("Walrus should have eaten the sardine from the can", walrus.hasEaten(sardine));
    }

    @Test
    public void testWalrusAcceptsNonWalrusFood() {
        Object pizza = new Object(); // Not a WalrusFood

        walrus.addToStomach(pizza);

        assertTrue("Walrus should accept non-Walrus food like pizza", walrus.hasEaten(pizza));
    }
}
