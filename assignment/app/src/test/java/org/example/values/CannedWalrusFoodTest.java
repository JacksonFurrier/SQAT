package org.example.values;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CannedWalrusFoodTest {

    @Test
    void testExtractContentsReturnsFood() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        WalrusFood result = can.extractContents();
        assertNotNull(result);
        assertSame(food, result);
    }

    @Test
    void testExtractContentsEmptiesCan() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        can.extractContents();
        assertNull(can.extractContents());
    }

    @Test
    void testCanBeConstructedWithNullFood() {
        CannedWalrusFood can = new CannedWalrusFood(null);
        assertNull(can.extractContents());
    }
}
