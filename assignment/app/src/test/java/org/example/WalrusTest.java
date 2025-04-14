package org.example;

import org.example.values.Walrus; 
import org.example.values.CannedWalrusFood;
import org.example.values.WalrusFood;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalrusTest {

    @Test
    public void testWalrusCanEat() {

        Walrus walrus = new Walrus();
        FeedsWalrus feeder = new FeedsWalrus();
        
        // number how many times to feed the Walrus.
        final int feedCount = 10_000;

        for (int i = 0; i < feedCount; i++) {
            WalrusFood food = new WalrusFood();
            CannedWalrusFood cannedFood = new CannedWalrusFood(food);
            feeder.feed(walrus, cannedFood);
            
            assertTrue("Walrus did not eat food at iteration " + i, 
                       walrus.hasEaten(food));
        }
        
        System.out.println("The Walrus successfully ate " + feedCount + " items.");
    }

    @Test
    public void testWalrusGetsRightFood() {

        Walrus walrus = new Walrus();
        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);
        FeedsWalrus feeder = new FeedsWalrus();

        // Feed the walrus.
        feeder.feed(walrus, can);

        assertTrue("The walrus did not receive the correct food.", 
                   walrus.hasEaten(expectedFood));
    }

    @Test
    public void testOpenCanReturnsFood() {

        WalrusFood expectedFood = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(expectedFood);
        OpensCan canOpener = new OpensCan();

        WalrusFood actualFood = canOpener.open(can);

        assertSame("Expected to get the same WalrusFood from the can", expectedFood, actualFood);
    }

    @Test
    public void testWalrusEatsFood() {
 
        Walrus walrus = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood cannedFood = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();

        feeder.feed(walrus, cannedFood);

        assertTrue("Walrus should have eaten the food", walrus.hasEaten(food));
    }

    @Test(expected = ClassCastException.class)
    public void testWalrusRejectsNonWalrusFood() {
        Walrus walrus = new Walrus();
        FeedsWalrus feeder = new FeedsWalrus();

        CannedWalrusFood badCan = new CannedWalrusFood(new WalrusFood()) {
            @Override
            public WalrusFood extractContents() {
                
                return (WalrusFood)(Object) "Not a WalrusFood";
            }
        };

        feeder.feed(walrus, badCan);
    }

}
