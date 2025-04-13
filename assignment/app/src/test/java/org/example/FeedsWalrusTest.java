package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeedsWalrusTest {

    @Test
    void testFeedsWalrusWithValidFood() {
        Walrus gary = new Walrus();
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(gary, can);
        assertTrue(gary.hasEaten(food));
    }

    @Test
    void testFeedWithEmptyCanDoesNothing() {
        Walrus gary = new Walrus();
        CannedWalrusFood can = new CannedWalrusFood(); // 没有食物
        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(gary, can);
        assertFalse(gary.hasEaten(new WalrusFood())); // 不应记录任何食物
    }
}
