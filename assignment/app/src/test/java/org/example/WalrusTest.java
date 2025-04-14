/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test;

import static org.junit.Assert.*;

public class WalrusTest {
    @Test
    public void testHowMuchAWalrusCanEat() {
        Walrus gary = new Walrus();

        for (int i = 0; i < 5; ++i) {
            WalrusFood walrusFood = new WalrusFood();
            gary.addToStomach(walrusFood);
            assertTrue(gary.hasEaten(walrusFood));
        }
    }

    @Test
    public void testIfAWalrusGetsTheRightFood() {
        Walrus gary = new Walrus();
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood cannedWalrusFood = new CannedWalrusFood(walrusFood);
        OpensCan opensCan = new OpensCan();

        assertEquals(walrusFood, opensCan.open(cannedWalrusFood));
    }

    @Test
    public void testIfOpeningACanWillReturnFood() {
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood cannedWalrusFood = new CannedWalrusFood(walrusFood);
        OpensCan opensCan = new OpensCan();

        assertNotNull(opensCan.open(cannedWalrusFood));
    }

    @Test
    public void testHowAWalrusCanEat() {
        Walrus gary = new Walrus();
        WalrusFood walrusFood = new WalrusFood();
        CannedWalrusFood cannedWalrusFood = new CannedWalrusFood(walrusFood);

        FeedsWalrus feedsWalrus = new FeedsWalrus();
        feedsWalrus.feed(gary, cannedWalrusFood);

        assertNull(cannedWalrusFood.extractContents());
        assertTrue(gary.hasEaten(walrusFood));
    }

    @Test
    public void testWalrusEatingNonWalrusFood() {
        Walrus gary = new Walrus();
        WalrusFood walrusFood = new WalrusFood();

        FeedsWalrus feedsWalrus = new FeedsWalrus();
        assertThrows(ClassCastException.class, () -> feedsWalrus.feed(gary, (CannedWalrusFood) new Object())) ;
    }
}