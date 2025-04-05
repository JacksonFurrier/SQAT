/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.*;;

public class WalrusTest {
    private Walrus walrus;

    @Before
    public void setUp() {
        walrus = new Walrus();
    }

    @Test
    public void testHowMuchWalrusCanEat() {
        int i;
        for (i = 0; i < 10000; i++) {
            try {
                walrus.addToStomach(new WalrusFood());
            } catch (Exception e) {
                break;
            }
        }

        if(i < 10000)
            System.out.println(String.format("Walrus can eat %04d foods.", i));
        else
            System.out.println("Walrus can ate all our foods.");

        assertTrue(true);
    }

    @Test
    public void testIfWalrusGetsTheRightFood() {
        WalrusFood food = new WalrusFood();

        assertFalse(walrus.hasEaten(food));
        walrus.addToStomach(food);
        assertTrue(walrus.hasEaten(food));
    }

    @Test
    public void testOpeningACan() {
        OpensCan canOpener = new OpensCan();

        CannedWalrusFood emptyCan = new CannedWalrusFood();
        CannedWalrusFood emptyCan2 = new CannedWalrusFood(null);
        CannedWalrusFood cannedWalrusFood = new CannedWalrusFood(new WalrusFood());

        assertNull(canOpener.open(emptyCan));
        assertNull(canOpener.open(emptyCan2));
        assertTrue(WalrusFood.class.isInstance(canOpener.open(cannedWalrusFood)));
        assertNull(canOpener.open(cannedWalrusFood));
    }
}
