package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

import org.example.values.CannedWalrusFood;
import org.example.values.WalrusFood;

public class CanTest {
    @Test public void emptyCanReturnsNull() {
        CannedWalrusFood can = new CannedWalrusFood();
        WalrusFood food = can.extractContents();
        assertEquals(food, null);
    }

    @Test public void canReturnsFood() {
        CannedWalrusFood can = new CannedWalrusFood(new WalrusFood());
        WalrusFood food = can.extractContents();
        assertNotEquals(food, null);
    }
}
