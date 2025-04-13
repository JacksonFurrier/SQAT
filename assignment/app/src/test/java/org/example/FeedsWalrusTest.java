package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.Test; // ✅ 改成JUnit4的导入
import static org.junit.Assert.*; // ✅ 改成JUnit4的断言

public class FeedsWalrusTest {

    @Test
    public void testWalrusCanEatMultipleFoods() {
        Walrus gary = new Walrus();
        FeedsWalrus feeder = new FeedsWalrus();

        WalrusFood fish = new WalrusFood();
        WalrusFood shrimp = new WalrusFood();

        feeder.feed(gary, new CannedWalrusFood(fish));
        feeder.feed(gary, new CannedWalrusFood(shrimp));

        assertTrue(gary.hasEaten(fish));
        assertTrue(gary.hasEaten(shrimp));
    }

    @Test
    public void testWalrusGetsCorrectFood() {
        Walrus gary = new Walrus();
        FeedsWalrus feeder = new FeedsWalrus();

        WalrusFood crab = new WalrusFood();
        feeder.feed(gary, new CannedWalrusFood(crab));

        assertTrue(gary.hasEaten(crab));
    }

    @Test
    public void testOpeningCanReturnsFood() {
        OpensCan opener = new OpensCan();
        WalrusFood sardines = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(sardines);

        WalrusFood food = opener.open(can);

        assertNotNull(food);  // 打开罐头以后拿到的食物不应该是null
        assertEquals(sardines, food); // 打开的应该是罐头原本的内容
    }

    @Test
    public void testWalrusEatingBehavior() {
        Walrus gary = new Walrus();
        FeedsWalrus feeder = new FeedsWalrus();

        WalrusFood clam = new WalrusFood();
        assertFalse(gary.hasEaten(clam)); // 一开始还没吃

        feeder.feed(gary, new CannedWalrusFood(clam));

        assertTrue(gary.hasEaten(clam)); // 吃完之后就应该吃过
    }

    @Test
    public void testWalrusAcceptsNonStandardFood() {
        Walrus gary = new Walrus();

        gary.addToStomach(null);

        assertTrue(gary.hasEaten(null));
    }
}
