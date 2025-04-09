package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WalrusTest {

    @Test
    public void testWalrusCanEatMultipleFoods() {
        Walrus walrus = new Walrus();
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        walrus.addToStomach(food1);
        walrus.addToStomach(food2);
        assertTrue("Walrus should have eaten food1", walrus.hasEaten(food1));
        assertTrue("Walrus should have eaten food2", walrus.hasEaten(food2));
    }

    @Test
    public void testWalrusGetsRightFood() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();
        WalrusFood extracted = opener.open(cannedFood);
        walrus.addToStomach(extracted);
        assertTrue("Walrus should have eaten the provided food", walrus.hasEaten(food));
    }

    @Test
    public void testOpenCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();
        WalrusFood extracted = opener.open(cannedFood);
        assertEquals("Extracted food should be the same as original", food, extracted);
        assertNull("Can should be empty after extraction", cannedFood.extractContents());
    }

    @Test
    public void testWalrusCanEatWithFeedsWalrus() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, cannedFood);
        assertTrue("Walrus should have eaten the food after feeding", walrus.hasEaten(food));
    }

    @Test
    public void testWalrusAcceptsNonStandardFood() {
        Walrus walrus = new Walrus();
        class NonStandardWalrusFood extends WalrusFood { }
        WalrusFood nonStandardFood = new NonStandardWalrusFood();
        walrus.addToStomach(nonStandardFood);
        assertTrue("Walrus should accept non-standard WalrusFood", walrus.hasEaten(nonStandardFood));
    }
}
