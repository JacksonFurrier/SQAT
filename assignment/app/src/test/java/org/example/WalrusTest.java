/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

public class WalrusTest {

    Walrus walrus;
    WalrusFood exampleFood1;
    WalrusFood exampleFood2;
    CannedWalrusFood cannedFood1;

    @Before
    public void setup(){
        walrus = new Walrus();
        exampleFood1 = new WalrusFood();
        exampleFood2 = new WalrusFood();
        cannedFood1 = new CannedWalrusFood(exampleFood1);
    }

    @Test
    public void appHasAGreeting() {
    }

    /* walrus can eat much food */

    @Test
    public void eatMuchFood() {
        for(int i=0; i<100000; i++){
            WalrusFood food = new WalrusFood();
            walrus.addToStomach(food);
            assertTrue(walrus.hasEaten(food));
        }
    }

    /* walrus eats the right food */

    @Test
    public void eatNoFood() {
        walrus.addToStomach(null);
        assertFalse(walrus.hasEaten(exampleFood1));
    }

    @Test
    public void eatTheSameFood() {
        walrus.addToStomach(exampleFood1);
        assertTrue(walrus.hasEaten(exampleFood1));
    }

    @Test
    public void eatAnotherFood() {
        walrus.addToStomach(exampleFood1);
        assertFalse(walrus.hasEaten(exampleFood2));
    }

    /* opening a can */
    
    @Test
    public void canOpeningReturnFood() {
        OpensCan opensCan = new OpensCan();
        assertEquals(opensCan.open(cannedFood1), exampleFood1);
    }

    @Test
    public void canHasTheExpectedContent() {
        OpensCan opensCan = new OpensCan();
        assertEquals(opensCan.open(cannedFood1), exampleFood1);
    }

    /* how walrus can eat */

    @Test
    public void canExistsBeforeEating() {
        assertNotNull(cannedFood1.extractContents());
    }

    @Test
    public void feedWithCannedFood() {
        FeedsWalrus feedsWalrus = new FeedsWalrus();
        feedsWalrus.feed(walrus, cannedFood1);
        assertTrue(walrus.hasEaten(exampleFood1));
    }

    @Test
    public void feedWithRawFood() {
        walrus.addToStomach(exampleFood2);
        assertTrue(walrus.hasEaten(exampleFood2));
    }

    /* walrus eats non-walrus food */

    @Test
    public void eatRawNonWalrusFood() {
        class OtherFood extends WalrusFood {}

        OtherFood otherFood = new OtherFood();
        walrus.addToStomach(otherFood);
        assertTrue(walrus.hasEaten(otherFood));
    }

    @Test
    public void eatCannedNonWalrusFood() {
        class OtherFood extends WalrusFood {}

        OtherFood otherFood = new OtherFood();
        cannedFood1 = new CannedWalrusFood(otherFood);
        FeedsWalrus feedsWalrus = new FeedsWalrus();
        feedsWalrus.feed(walrus, cannedFood1);
        assertTrue(walrus.hasEaten(otherFood));
    }
}
