package org.example;

import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.example.values.CannedWalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {
	
	// 1. Write a test to see how much a Walrus can eat
    @Test
    public void testHowMuchWalrusCanEat() {
		Walrus walrus = new Walrus();
		WalrusFood food = new WalrusFood();
		
        int foodAmount = 100; // Example amount
		
		for (int i = 0; i < foodAmount; i++) {
            walrus.addToStomach(food);
            assertTrue(walrus.hasEaten(food));
        }
    }

	// 2. Write a test to check if a Walrus gets the right food
    @Test
    public void testWalrusGetsRightFood() {
		Walrus walrus = new Walrus();
        WalrusFood fish = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(fish);

        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);

        assertTrue(walrus.hasEaten(fish));
    }

	// 3. Write a test to check opening a can will return food
    @Test
    public void testOpeningCanReturnsFood() {
		WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        OpensCan opener = new OpensCan();
        WalrusFood openedFood = opener.open(can);
		
		assertSame(food, openedFood);
    }

	// 4. Write a test to check on how a Walrus can eat
    @Test
    public void testHowWalrusCanEat() {
		Walrus walrus = new Walrus();
        WalrusFood fish = new WalrusFood();
		
		walrus.addToStomach(fish);
		
		WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();

        feeder.feed(walrus, can);
        
        assertTrue(walrus.hasEaten(food));
        assertTrue(walrus.hasEaten(fish));
    }


	// 5. Write a test making a Walrus accept non-Walrus food
    @Test
    public void testWalrusAcceptsNonWalrusFood() {
		class NonWalrusFood extends WalrusFood{}
        NonWalrusFood nonWalrusFood = new NonWalrusFood();
		
		Walrus walrus = new Walrus();

        walrus.addToStomach(nonWalrusFood);
        assertTrue(walrus.hasEaten(nonWalrusFood));
    }
}
