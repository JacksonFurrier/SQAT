package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Before;
import org.junit.Test;

public class WalrusTest {
    Walrus gary;
    FeedsWalrus feedsWalrus;
    OpensCan canOpener;
    
    @Before
    public void init() {
        gary = new Walrus();
        feedsWalrus = new FeedsWalrus();
        canOpener = new OpensCan();
    }
    
    @Test
    public void walrusEatingCapacity() {
        final int MAX_FOODS = 10000;
        
        for (int i = 0; i < MAX_FOODS; i++) {
            var meal = new WalrusFood("meal" + i);
            var cannedMeal = new CannedWalrusFood(meal);
            feedsWalrus.feed(gary, cannedMeal);
            
            if (i > 0 && i % 2500 == 0) {
                assertTrue(gary.hasEaten(meal));
            }
        }
        
        for (int i = 0; i < 5; i++) {
            int idx = (int)(Math.random() * MAX_FOODS);
            var differentMeal = new WalrusFood("meal" + idx);
            assertFalse(gary.hasEaten(differentMeal));
        }
    }
    
    @Test
    public void walrusEatsMultipleFoods() {
        var krill = new WalrusFood();
        var fish = new WalrusFood();
        
        var krillCan = new CannedWalrusFood(krill);
        var fishCan = new CannedWalrusFood(fish);
        
        feedsWalrus.feed(gary, krillCan);
        feedsWalrus.feed(gary, fishCan);
        
        assertTrue(gary.hasEaten(krill));
        assertTrue(gary.hasEaten(fish));
    }
    
    @Test
    public void walrusGetsTheRightFood() {
        var squid = new WalrusFood();
        var clam = new WalrusFood();
        
        var squidCan = new CannedWalrusFood(squid);
        var clamCan = new CannedWalrusFood(clam);
        
        feedsWalrus.feed(gary, squidCan);
        
        assertTrue(gary.hasEaten(squid));
        assertFalse(gary.hasEaten(clam));
    }
    
    @Test
    public void openingFullCan() {
        var sardine = new WalrusFood();
        var sardineCan = new CannedWalrusFood(sardine);
        
        var foodFromCan = canOpener.open(sardineCan);
        
        assertNotNull(foodFromCan);
        assertSame(sardine, foodFromCan);
    }
    
    @Test
    public void openingEmptyCan() {
        var emptyCan = new CannedWalrusFood();
        var result = canOpener.open(emptyCan);
        assertNull(result);
    }
    
    @Test
    public void walrusDirectFeeding() {
        var herring = new WalrusFood();
        
        assertFalse(gary.hasEaten(herring));
        
        gary.addToStomach(herring);
        
        assertTrue(gary.hasEaten(herring));
    }
    
    @Test
    public void walrusEatsNonWalrusFood() {
        class PenguinFood extends WalrusFood {
            public PenguinFood() {
                super("penguin-chow");
            }
        }
        
        var normalFood = new WalrusFood();
        var penguinFood = new PenguinFood();
        
        gary.addToStomach(normalFood);
        gary.addToStomach(penguinFood);
        
        assertTrue(gary.hasEaten(normalFood));
        assertTrue(gary.hasEaten(penguinFood));
        
        var sealFood = new WalrusFood("seal-kibble");
        var sealFoodCan = new CannedWalrusFood(sealFood);
        feedsWalrus.feed(gary, sealFoodCan);
        assertTrue(gary.hasEaten(sealFood));
    }
}
