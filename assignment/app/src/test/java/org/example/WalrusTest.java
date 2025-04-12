package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class WalrusTest {

    private Walrus walrus;
    private OpensCan canOpener;
    private FeedsWalrus feeder;

    @Before
    public void setUp() {
        walrus = new Walrus();
        canOpener = new OpensCan();
        feeder = new FeedsWalrus();
    }

    // 1. Test Walrus food limit
    @Test
    public void testFoodLimit() {
        for (int i = 1; i < 5000; i++) {
            WalrusFood food = new WalrusFood();
            walrus.addToStomach(food);
            assertTrue("The food limit is" + (i-1) , walrus.hasEaten(food));
        }
    }

    // 2. Test Walrus gets the correct food
    @Test
    public void testCorrectFood() {
        WalrusFood food = new WalrusFood();
        walrus.addToStomach(food);
        assertTrue("Correct food", walrus.hasEaten(food));
    }

    // 3. Test opening a can returns food
    @Test
    public void testOpenCan() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood canned = new CannedWalrusFood(food);
        assertEquals(food, canOpener.open(canned));
    }

    @Test
    public void testOpenEmptyCan() {
        CannedWalrusFood emptyCan = new CannedWalrusFood(null);
        assertNull(canOpener.open(emptyCan));
    }

    // 4. Test Walrus can eat in various ways
    @Test
    public void testEatDirectly() {
        WalrusFood food = new WalrusFood();
        walrus.addToStomach(food);
        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void testEatFromCan() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood canned = new CannedWalrusFood(food);
        walrus.addToStomach(canOpener.open(canned));
        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void testEatViaFeeder() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood canned = new CannedWalrusFood(food);
        feeder.feed(walrus, canned);
        assertTrue(walrus.hasEaten(food));
    }

    // 5. Test accepting non-Walrus food
    @Test
    public void testNonWalrusFood() {
        class Banana extends WalrusFood {}
        Banana banana = new Banana();
        walrus.addToStomach(banana);
        assertTrue(walrus.hasEaten(banana));
    }

    @Test
    public void testNullFood() {
        walrus.addToStomach(null);
        assertTrue(walrus.hasEaten(null));
    }
}
