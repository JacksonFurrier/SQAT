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

        assertTrue(walrus.hasEaten(food1));
        assertTrue(walrus.hasEaten(food2));
        assertTrue(walrus.hasEaten(food3));
    }

    @Test
    public void testWalrusGetsRightFood() {
        Walrus walrus = new Walrus();
        WalrusFood correctFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(correctFood);
        FeedsWalrus feeder = new FeedsWalrus();

        feeder.feed(walrus, can);

        assertTrue(walrus.hasEaten(correctFood));
    }

    @Test
    public void testOpeningCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();

        WalrusFood result = opener.open(can);

        assertEquals(food, result);
    }

    @Test
    public void testCheckHowAWalrusCanEat() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();

        assertFalse(walrus.hasEaten(food)); 
        walrus.addToStomach(food);
        assertTrue(walrus.hasEaten(food)); 
    }

    @Test
    public void testWalrusAcceptsNonWalrusFood() {
        Walrus walrus = new Walrus();
        WalrusFood known = new WalrusFood();
        WalrusFood unknown = new WalrusFood(); 

        walrus.addToStomach(known);
        assertTrue(walrus.hasEaten(known));
        assertFalse(walrus.hasEaten(unknown));
    }
}
