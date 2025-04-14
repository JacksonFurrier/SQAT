package org.example;
import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {
   
    private Walrus gary;
    private WalrusFood food;
    private FeedsWalrus feeder;
    private CannedWalrusFood cannedFood;
    private OpensCan opener;

    @Before
    public void setUp() {
        gary = new Walrus();
        feeder = new FeedsWalrus();
        opener = new OpensCan();
    }

    //would be cleaner to write every assert into a different test (the assignment's text sais 'a test')

    // Task 1
    // Write a test to see how much a Walrus can eat
    @Test
    public void testHowMuchWalrusCanEat() {
        int foodCounter = 1400; // Gary's stomack could be sooo big (since its a set), but he is on a diet today, only 1400
        
        for (int i = 1; i <= foodCounter; i++) {
            food = new WalrusFood();
            cannedFood = new CannedWalrusFood(food);
            feeder.feed(gary, cannedFood);

            assertTrue("Gary didn't eat " + i + " th food that was presented for him", gary.hasEaten(food));
        }
    }



    // Task 2
    // Write a test to check if a Walrus gets the right food 
    @Test
    public void testWalrusGetsRightFood() {
        food = new WalrusFood();
        WalrusFood foodNotEaten = new WalrusFood();

        assertFalse(gary.hasEaten(foodNotEaten));
        assertFalse(gary.hasEaten(food));

        cannedFood = new CannedWalrusFood(food);
        feeder.feed(gary, cannedFood);

        assertTrue(gary.hasEaten(food));
        assertFalse(gary.hasEaten(foodNotEaten));
    }



    // Task 3
    // Write a test to check opening a can will return food
    @Test
    public void testOpeningCanReturnFood() {
        food = new WalrusFood();
        cannedFood = new CannedWalrusFood(food);

        WalrusFood extractedFood = opener.open(cannedFood) ;

        assertTrue(extractedFood instanceof WalrusFood);
        assertEquals(extractedFood, food);
        assertSame(extractedFood, food);
    }



    // Task 4
    // Write a test to check on how a Walrus can eat
    @Test
    public void testHowWalrusCanEat() {
        //eat food
        food = new WalrusFood();
        gary.addToStomach(food);

        assertTrue(gary.hasEaten(food));


        //eat opened canned food
        food = new WalrusFood();
        cannedFood = new CannedWalrusFood(food);
        gary.addToStomach(opener.open(cannedFood));

        assertTrue(gary.hasEaten(food));


        //eat canned from feeder
        food = new WalrusFood();
        cannedFood = new CannedWalrusFood(food);

        feeder.feed(gary,cannedFood);

        assertTrue(gary.hasEaten(food));
    }



    // Task 5
    // Write a test making a Walrus accept non-Walrus food
    // No animals were harmed during this exercise
    @Test
    public void testWalrusAcceptNonWalrusFood() {
        food = null;
        gary.addToStomach(food);
        assertTrue(gary.hasEaten(food));

        class HumanOrWalrusFood extends WalrusFood{}
        HumanOrWalrusFood humanFood = new HumanOrWalrusFood();

        gary.addToStomach(humanFood);
        assertTrue(gary.hasEaten(humanFood));
    }
}
