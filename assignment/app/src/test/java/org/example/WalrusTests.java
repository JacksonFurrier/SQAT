package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WalrusTests {

    // 1. Test how much a walrus can eat
    @Test
    void testWalrusCapacity() {
        Walrus gary = new Walrus();
        for (int i = 0; i < 10; i++) {
            gary.addToStomach(new WalrusFood());
        }
        assertEquals(10, gary.getStomachSize());
    }

    // 2. Test walrus gets the right food
    @Test
    void testWalrusGetsCorrectFood() {
        CannedWalrusFood can = mock(CannedWalrusFood.class);
        WalrusFood expectedFood = new WalrusFood("fish");
        when(can.extractContents()).thenReturn(expectedFood);

        Walrus gary = new Walrus();
        gary.addToStomach(can.extractContents());

        assertEquals("fish", gary.getStomachContents().get(0).getType());
    }

    // 3. Test opening a can returns food
    @Test
    void testCanOpeningReturnsFood() {
        OpensCan opener = new OpensCan();
        CannedWalrusFood can = mock(CannedWalrusFood.class);
        WalrusFood food = new WalrusFood();
        when(can.extractContents()).thenReturn(food);

        WalrusFood result = opener.open(can);
        assertEquals(food, result);
    }

    // 4. Test non-Walrus food rejection
    @Test
    void testRejectsNonWalrusFood() {
        Walrus gary = new Walrus();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            gary.addToStomach(new Object()); // Non-walrus food
        });
        assertEquals("Invalid food for Walrus", e.getMessage());
    }
}
