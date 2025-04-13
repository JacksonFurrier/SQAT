package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.stream.Stream;
import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.example.FeedsWalrus;

public class WalrusTest {

    @Test
    public void testHowMuchAWalrusCanEat() {
        final var w = new Walrus();
        final var f = new FeedsWalrus();
        final var s = Stream.generate(WalrusFood::new).limit(999);
        
        s.forEach(food -> {
            f.feed(w, new CannedWalrusFood(food));
            assertTrue(w.hasEaten(food));
        });
    }

    @Test
    public void testWalrusGetsRightFood() {
        final var w = new Walrus();
        final var f = new FeedsWalrus();
        final var f1 = new WalrusFood();
        final var f2 = new WalrusFood();

        f.feed(w, new CannedWalrusFood(f1));
        assertTrue(w.hasEaten(f1) && !w.hasEaten(f2));
    }

    @Test
    public void testOpeningCanReturnsFood() {
        final var c = new CannedWalrusFood(new WalrusFood());
        final var f = c.extractContents();
        assertTrue(f instanceof WalrusFood);
    }

    @Test
    public void testHowAWalrusCanEat() {
        final var w = new Walrus();
        final var f = new FeedsWalrus();
        final var f1 = new WalrusFood();
        final var f2 = new WalrusFood();

        f.feed(w, new CannedWalrusFood(f1));
        w.addToStomach(f2);
        assertTrue(w.hasEaten(f1) && w.hasEaten(f2));
    }

    @Test
    public void testWalrusWrongFood() {
        final var w = new Walrus();
        w.addToStomach(null);
        assertTrue(w.hasEaten(null));
    }

    @Test
    public void testWalrusWrongFood2() {
        class MonkeyFood extends WalrusFood { }

        final var w = new Walrus();
        final var f = new MonkeyFood();

        w.addToStomach(f);
        assertTrue(w.hasEaten(f));
    }
}
