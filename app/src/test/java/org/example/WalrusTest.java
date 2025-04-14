package org.example.values;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.example.values.CannedWalrusFood;
import org.example.values.FeedsWalrus;

class WalrusTest {

    @Test
    void testHowMuchWalrusCanEat() {
        Walrus walrus = new Walrus();
        walrus.addToStomach(new WalrusFood("Fish"));
        walrus.addToStomach(new WalrusFood("Crab"));
        assertEquals(2, walrus.stomachSize());
    }

    @Test
    void testWalrusGetsRightFood() {
        Walrus walrus = new Walrus();
        WalrusFood fish = new WalrusFood("Fish");
        walrus.addToStomach(fish);
        assertTrue(walrus.hasEaten(fish));
    }

    @Test
    void testOpeningCanReturnsFood() {
        CannedWalrusFood can = new CannedWalrusFood(new WalrusFood("Sardines"));
        WalrusFood food = can.extractContents();
        assertNotNull(food);
        assertEquals("Sardines", food.getName());
    }

    @Test
    void testHowAWalrusCanEat() {
        Walrus walrus = new Walrus();
        FeedsWalrus feeder = new FeedsWalrus();
        WalrusFood clam = new WalrusFood("Clam");
        feeder.feed(walrus, new CannedWalrusFood(clam));
        assertTrue(walrus.hasEaten(clam));
    }

    @Test
    void testWalrusAcceptNonWalrusFood() {
        Walrus walrus = new Walrus();
        Object notFood = new Object();
        assertThrows(ClassCastException.class, () -> walrus.addToStomach((WalrusFood) notFood));
    }
}
