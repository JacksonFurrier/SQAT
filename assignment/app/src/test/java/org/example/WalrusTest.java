package org.example;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.example.values.*;


public class WalrusTest {

    private Walrus gary;
    private FeedsWalrus feeder = new FeedsWalrus();

    @Before
    public void init() {
        gary = new Walrus();
    }

    /*
    ------ "Write a test to see how much a Walrus can eat" ------
    Integer.MAX_VALUE is the maximum size of a set, but let's test with a smaller number
    */
	@Test
	public void testFeedMultiple() {
		List<WalrusFood> eatenFoods = new ArrayList<>();
		for (int i = 0; i < 999; i++) {
			WalrusFood food = new WalrusFood();
			CannedWalrusFood can = new CannedWalrusFood(food);
			feeder.feed(gary, can);
            eatenFoods.add(food);
		}

		for (WalrusFood food : eatenFoods) {
			assertTrue(gary.hasEaten(food));
		}
	}

    /*
    ------ "Write a test to check if a Walrus gets the right food" ------
    */
    @Test
    public void testGetsRightFood() {
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);

        feeder.feed(gary, can);

        assertTrue("Walrus should have the right food in its stomach", gary.hasEaten(expectedFood));
    }

    /*
    ------ "Write a test to check opening a can will return food" ------
    */
    @Test
    public void testOpeningCan() {
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);
        OpensCan opener = new OpensCan();

        WalrusFood actualFood = opener.open(can);

        assertSame("Opening the can should return the correct food", expectedFood, actualFood);
    }

    /*
    ------ "Write a test to check on how a Walrus can eat" ------
    */
   @Test
    public void testEatingProcess() {
        WalrusFood expectedFood = new WalrusFood();

        gary.addToStomach(expectedFood);

        assertTrue("Walrus should have eaten the food", gary.hasEaten(expectedFood));
    }

    /*
    ------ "Write a test making a Walrus accept non-Walrus food" ------
    */

    // Option 1: Use null as food
    @Test
    public void acceptNonWalrusFood() {
        // A null is most certainly a non-Walrus food
        CannedWalrusFood can = new CannedWalrusFood(null);

        feeder.feed(gary, can);

        assertTrue("Walrus should have eaten null non-Walrus food", gary.hasEaten(null));
    }

    // Option 2: Use a subclass of WalrusFood, but in my opinion this is not non-Walrus food, since it extends WalrusFood
    static class NonWalrusFood extends WalrusFood { }
    
    @Test
    public void testWalrusAcceptsSubclassedNonWalrusFood() {
        WalrusFood nonWalrusFood = new NonWalrusFood();

        gary.addToStomach(nonWalrusFood);

        assertTrue("Walrus should have eaten 'NonWalrusFood' non-Walrus food", gary.hasEaten(nonWalrusFood));
    }
}
