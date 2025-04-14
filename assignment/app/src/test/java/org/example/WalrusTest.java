package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;

public class WalrusTest {
   
    @Test
    public void walrusCanEatMultipleFoods() {
        
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
    public void walrusGetsRightFoodFromCan() {
        Walrus walrus = new Walrus();
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);

        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);

        assertTrue(walrus.hasEaten(expectedFood));
    }

    @Test
    public void openingCanReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);

        OpensCan opener = new OpensCan();
        WalrusFood opened = opener.open(can);

        assertSame(food, opened);
    }

    @Test
    public void walrusCanBeFed() {
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);

        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(walrus, can);

        assertTrue(walrus.hasEaten(food));  
    }

    @Test
    public void walrusAcceptsSubclassedFood() {
        class FakeFish extends WalrusFood {}

        Walrus walrus = new Walrus();
        WalrusFood weirdFood = new FakeFish();

        walrus.addToStomach(weirdFood);

        assertTrue(walrus.hasEaten(weirdFood));
    }

}
