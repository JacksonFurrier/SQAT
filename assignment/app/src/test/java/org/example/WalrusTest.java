package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {
    @Test public void appHasAGreeting() {
    }

    // Test how much a Walrus can eat
    @Test
    public void testWalrusCanEatMultipleItems() {
        Walrus gary = new Walrus();
        WalrusFood fish1 = new WalrusFood();
        WalrusFood fish2 = new WalrusFood();
        WalrusFood fish3 = new WalrusFood();

        gary.addToStomach(fish1);
        gary.addToStomach(fish2);
        gary.addToStomach(fish3);

        assertTrue("Walrus should have eated fish1", gary.hasEaten(fish1));
        assertTrue("Walrus should have eated fish2", gary.hasEaten(fish2));
        assertTrue(gary.hasEaten(fish3));
    }

    // Test if a Walrus gets the right food
    @Test
    public void testWalrusGetsRightFood() {
        Walrus gary = new Walrus();
        WalrusFood rightFood = new WalrusFood();
        WalrusFood wrongFood = new WalrusFood();

        gary.addToStomach(rightFood);

        assertTrue(gary.hasEaten(rightFood));
        assertFalse("Walrus shouldnt have eaten wrong food", gary.hasEaten(wrongFood));
    }

    // Test opening a can return food
    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood originalFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(originalFood);
        OpensCan canOpener = new OpensCan();

        WalrusFood extractedFood = canOpener.open(can);

        assertSame("Opening a can should return original food", originalFood, extractedFood);

        WalrusFood secondTry = can.extractContents();
        assertNull(secondTry);
    }

    // Test how a Walrus can eat
    @Test
    public void testHowWalrusEats() {
        Walrus gary = new Walrus();

        // Direct feeding
        WalrusFood directFood = new WalrusFood();
        gary.addToStomach(directFood);
        assertTrue(gary.hasEaten(directFood));

        // Can feeding
        WalrusFood cannedFoodContent = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(cannedFoodContent);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(gary, cannedFood);

        assertTrue(gary.hasEaten(cannedFoodContent));

        // Test both foods present
        assertTrue(gary.hasEaten(directFood) && gary.hasEaten(cannedFoodContent));

        // Test empty can doesnt add food
        CannedWalrusFood emptyCan = new CannedWalrusFood();
        feeder.feed(gary, emptyCan);

        WalrusFood notEaten = new WalrusFood();
        assertFalse(gary.hasEaten(notEaten));
    }

    // Test Walrus accepting non-Walrus food
    @Test
    public void testWalrusCanEatNonWalrusFood() {
        Walrus gary = new Walrus();

        class CustomFood extends WalrusFood {
            private String name;

            public CustomFood(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        CustomFood salmon = new CustomFood("Salmon");
        gary.addToStomach(salmon);

        assertTrue("Walrus should accept custom food", gary.hasEaten(salmon));
        assertTrue(salmon instanceof WalrusFood);
    }
}