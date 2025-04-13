/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.example.*;
import org.example.values.*;
import org.example.OpensCan;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;;


public class WalrusTest {
    
    protected Walrus mainWalrus;
    
    @Before
    public void initMainWalrus() {
        this.mainWalrus = new Walrus();
    }


    // * Write a test to see how much a Walrus can eat
    @Test
    public void howMuchWalrusCanEatTest(){
        int[] foodNums = {0,5,10,100,100};
        for (int foodNum : foodNums) {
            Walrus localWalrus = new Walrus();
            List<WalrusFood> foods =  new ArrayList<WalrusFood>();

            for(int i = 1; i<=foodNum; i++){
                WalrusFood food = new WalrusFood();
                foods.add(food);
                localWalrus.addToStomach(food);
                assertTrue("localWalrus should have eaten food in iteration " + i + "/" + foodNum + " .", localWalrus.hasEaten(food));
            }

            for(int i = 0; i<foodNum; i++){
                WalrusFood food = foods.get(i);
                assertTrue("localWalrus should have food " + (i+1) + "/" + foodNum + " in stomach.", localWalrus.hasEaten(food));
            }
        }
    }

    // * Write a test to check if a Walrus gets the right food
    @Test
    public void walrusGetsRightFoodTest(){
        WalrusFood food1 = new WalrusFood();
        WalrusFood food2 = new WalrusFood();
        WalrusFood food3 = new WalrusFood();

        assertFalse("mainWalrus should have not eaten food1 before start.",mainWalrus.hasEaten(food1));
        assertFalse("mainWalrus should have not eaten food2 before start.",mainWalrus.hasEaten(food2));
        assertFalse("mainWalrus should have not eaten food3 before start.",mainWalrus.hasEaten(food3));
        assertFalse("mainWalrus should have not eaten null before start.",mainWalrus.hasEaten(null));

        mainWalrus.addToStomach(food1);
        assertTrue("mainWalrus should have eaten food1 after start.",mainWalrus.hasEaten(food1));
        assertFalse("mainWalrus should have not eaten food2 after food1.",mainWalrus.hasEaten(food2));
        assertFalse("mainWalrus should have not eaten null after food1.",mainWalrus.hasEaten(null));

        mainWalrus.addToStomach(food2);

        assertTrue("mainWalrus should have eaten food1 after food2.",mainWalrus.hasEaten(food1));
        assertTrue("mainWalrus should have eaten food2 after food2.",mainWalrus.hasEaten(food2));
        assertFalse("mainWalrus should have not eaten food3 after food2.",mainWalrus.hasEaten(food3));
        assertFalse("mainWalrus should have not eaten null after food2.",mainWalrus.hasEaten(null));

        mainWalrus.addToStomach(food3);
        assertTrue("mainWalrus should have eaten food3 after null.",mainWalrus.hasEaten(food3));
        assertTrue("mainWalrus should have eaten food2 after food3.",mainWalrus.hasEaten(food1));
        assertTrue("mainWalrus should have eaten food1 after food3.",mainWalrus.hasEaten(food2));
        assertFalse("mainWalrus should have not eaten null after food3.",mainWalrus.hasEaten(null));
    }

    // * Write a test to check opening a can will return food
    @Test
    public void openingACanWillReturnFoodTest(){
        WalrusFood food1 = new WalrusFood();
        CannedWalrusFood cFood1 = new CannedWalrusFood(food1);
        CannedWalrusFood cFood1Null = new CannedWalrusFood(null);
        
        WalrusFood food2 = new WalrusFood();
        CannedWalrusFood cFood2     = new CannedWalrusFood(food2);
        CannedWalrusFood cFood2Null = new CannedWalrusFood(null);
        
        OpensCan opener = new OpensCan();

        assertSame("cFood1 should open to food1."    , food1,opener.open(cFood1));
        assertSame("cFood1 should re-open to null."  , null,opener.open(cFood1));
        assertSame("cFood1Null should open to null." , null, opener.open(cFood1Null));

        assertSame("cFood2 should extract to food2."    , food2,cFood2.extractContents());
        assertSame("cFood2 should re-extract to null."  , null,cFood2.extractContents());
        assertSame("cFood2Null should extract to null." , null,cFood2Null.extractContents());
    }

    // * Write a test to check on how a Walrus can eat
    @Test
    public void checkHowAWalrusCanEatTest(){
        
        WalrusFood food1 = new WalrusFood();
        WalrusFood food1Null = null;
        this.mainWalrus.addToStomach(food1);
        this.mainWalrus.addToStomach(food1Null);

        assertTrue("mainWalrus should have eaten food1 (from .addToStomach).",this.mainWalrus.hasEaten(food1));
        assertTrue("mainWalrus should have eaten null  (from .addToStomach).",this.mainWalrus.hasEaten(null));

        WalrusFood food2 = new WalrusFood();
        CannedWalrusFood cFood2 = new CannedWalrusFood(food2);
        CannedWalrusFood cFood2Null = new CannedWalrusFood(null);
        this.mainWalrus.addToStomach(cFood2.extractContents());
        this.mainWalrus.addToStomach(cFood2Null.extractContents());

        assertTrue("mainWalrus should have eaten food2  (from .extractContents).",this.mainWalrus.hasEaten(food2));
        assertTrue("mainWalrus should have eaten null  (from .extractContents).",this.mainWalrus.hasEaten(null));

        WalrusFood food3 = new WalrusFood();
        CannedWalrusFood cFood3 = new CannedWalrusFood(food3);
        CannedWalrusFood cFood3Null = new CannedWalrusFood(null);
        OpensCan opener = new OpensCan();
        this.mainWalrus.addToStomach(opener.open(cFood3));
        this.mainWalrus.addToStomach(opener.open(cFood3Null));

        assertTrue("mainWalrus should have eaten food3  (from .open).",this.mainWalrus.hasEaten(food3));
        assertTrue("mainWalrus should have eaten null  (from .open).",this.mainWalrus.hasEaten(null));

        WalrusFood food4 = new WalrusFood();
        CannedWalrusFood cFood4 = new CannedWalrusFood(food4);
        CannedWalrusFood cFood4Null = new CannedWalrusFood(null);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(this.mainWalrus, cFood4);
        feeder.feed(this.mainWalrus, cFood4Null);
        
        assertTrue("mainWalrus should have eaten food4  (from .feed).",this.mainWalrus.hasEaten(food4));
        assertTrue("mainWalrus should have eaten null  (from .feed).",this.mainWalrus.hasEaten(null));

    }

    // * Write a test making a Walrus accept non-Walrus food
    @Test
    public void walrusAcceptNonWalrusFoodTest(){
        class SpyWalrusFood extends WalrusFood {};
        
        SpyWalrusFood fakeFood = new SpyWalrusFood();
        this.mainWalrus.addToStomach(fakeFood);

        assertTrue("mainWalrus should have eaten fakeFood.", this.mainWalrus.hasEaten(fakeFood));

        this.mainWalrus.addToStomach(null);
        assertTrue("mainWalrus should have eaten null.", this.mainWalrus.hasEaten(null));
    }

}
