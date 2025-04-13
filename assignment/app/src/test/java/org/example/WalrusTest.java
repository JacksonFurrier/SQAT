package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

// Ensure that any additional required classes like OpensCan and FeedsWalrus are imported or defined.

public class WalrusTest {

    static class AlternateFood extends WalrusFood {}

    @Test 
    public void appHasAGreeting() {
        // Possibly add an assertion or remove if unused.
    }

    // Test how much a Walrus can eat
    @Test
    public void testWalrusCanEatMultipleItems() {
        Walrus wal = new Walrus();
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        WalrusFood food3 = new WalrusFood();

        wal.addToStomach(food1);
        wal.addToStomach(food2);
        wal.addToStomach(food3);

        assertTrue("Walrus should have eaten food1", wal.hasEaten(food1));
        assertTrue("Walrus should have eaten food2", wal.hasEaten(food2));
        assertTrue("Walrus should have eaten food3", wal.hasEaten(food3));
    }

    // Test if a Walrus gets the right food
    @Test
    public void testWalrusGetsRightFood() {
        Walrus wal = new Walrus();
        WalrusFood rightFood = new WalrusFood();
        WalrusFood wrongFood = new WalrusFood();

        wal.addToStomach(rightFood);

        assertTrue(wal.hasEaten(rightFood));
        assertFalse("Walrus has eaten wrong food", wal.hasEaten(wrongFood));
    }

    // Test opening a can returns food
    @Test
    public void openingCanReturnsFood() {
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(walrusFood);

        OpensCan canOpener = new OpensCan();
        WalrusFood foodInCan = canOpener.open(can);

        assertNotNull("Opening a can should return food", foodInCan);
    }

    @Test
    public void walrusCanEat() {
        Walrus walrus = new Walrus();
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood cannedWalrusFood = new CannedWalrusFood(walrusFood);

        FeedsWalrus feedsWalrus = new FeedsWalrus();
        feedsWalrus.feed(walrus, cannedWalrusFood);

        assertTrue("A Walrus should be able to eat walrus food", walrus.hasEaten(walrusFood));
    }

    // Test Walrus accepting non-Walrus food
    @Test
    public void testWalrusAcceptsAlternateFoodTypes() {
        Walrus walrus = new Walrus();
        WalrusFood altFood = new AlternateFood();

        walrus.addToStomach(altFood);
        assertTrue("Walrus should accept alternative food types", walrus.hasEaten(altFood));
    }
}
