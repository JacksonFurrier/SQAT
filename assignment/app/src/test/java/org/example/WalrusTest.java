/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.example.values.*;
import org.example.OpensCan;
import org.example.FeedsWalrus;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class WalrusTest {

    Walrus walrus;
    OpensCan opensCan;
    FeedsWalrus feedsWalrus;
    WalrusFood walrusFood;
    CannedWalrusFood cannedWalrusFood;

    //Setup function before all tests
    @Before
    public void setup() {
        walrus = new Walrus();
        opensCan = new OpensCan();
        feedsWalrus = new FeedsWalrus();

        walrusFood = new WalrusFood();
        cannedWalrusFood = new CannedWalrusFood(walrusFood);
    }

    // 1. Write a test to see how much a Walrus can eat 
    
    @Test
    public void HowMuchWalrusCanEat(){
        int testLimit = 1000;

        List<WalrusFood> foods = new ArrayList();
        for (int i = 0; i < testLimit ; i++) {
            foods.add(new WalrusFood()); 
        }

        for (WalrusFood food : foods) {
            walrus.addToStomach(food);
        }
        
        for(WalrusFood food : foods){
            assertTrue(walrus.hasEaten(food));
        }
    }

    // 2. Write a test to check if a Walrus gets the right food 
    
    @Test
    public void DoesWalrusGetRightFood() {
        /* walrusFood = new WalrusFood();
        cannedWalrusFood = new CannedWalrusFood(walrusFood); */

        feedsWalrus.feed(walrus, cannedWalrusFood);
        assertTrue(walrus.hasEaten(walrusFood));
    }

    // 3. Write a test to check opening a can will return food 
    
    @Test
    public void DoesCanReturnFood() {
        WalrusFood a = opensCan.open(cannedWalrusFood);
        // Check that is food
        assertEquals(WalrusFood.class, a.getClass());
        // Check if its empty, it shouldnt be
        assertTrue(a != null);
        // Check if its the right food
        assertTrue(a == walrusFood);
    }
    
    // 4. Write a test to check on how a Walrus can eat
    
    @Test
    public void DoesWalrusEatFoodDirectly() {
        // Check if walrus can eat normal food
        WalrusFood food = walrusFood;
        walrus.addToStomach(food);
        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void DoesWalrusEatCannedDirectly() {
        // Check if walrus can eat canned food
        WalrusFood food = opensCan.open(cannedWalrusFood);
        walrus.addToStomach(food);
        assertTrue(walrus.hasEaten(food));
    }

/*     @Test
    public void DoesWalrusEatCanned() {
        // Check if walrus can be feed canned food
        CannedWalrusFood food = cannedWalrusFood;
        WalrusFood food2 = opensCan.open(cannedWalrusFood);
        feedsWalrus.feed(walrus,food);
        assertTrue(walrus.hasEaten(food2));
    }
 */
    // 5. Write a test making a Walrus accept non-Walrus food 
    
    @Test
    public void DoesWalrusEatNonWalrusFood() {
        WalrusFood food = null;
        walrus.addToStomach(food);
        assertTrue(walrus.hasEaten(food));
    }
    
    @Test
    public void DoesWalrusEatNonWalrusFoodExtend() {
        class NonWalrusFood extends WalrusFood{}
        NonWalrusFood nonwalrusfood = new NonWalrusFood();
        walrus.addToStomach(nonwalrusfood);
        assertTrue(walrus.hasEaten(nonwalrusfood));
    }

}
