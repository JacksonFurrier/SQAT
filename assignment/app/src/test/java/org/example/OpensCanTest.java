package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.WalrusFood;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class OpensCanTest {

    private OpensCan opener;
    private WalrusFood food;
    private CannedWalrusFood can;

    @Before
    public void setUp() {
        opener = new OpensCan();
        food = new WalrusFood();
        can = new CannedWalrusFood(food);
    }

    @Test
    public void testOpenReturnsFood() {
        WalrusFood extracted = opener.open(can);
        assertNotNull("OpensCan should extract food from the can", extracted);
        assertEquals("Extracted food should match the original food", food, extracted);
    }

    @Test
    public void testOpenClearsTheCan() {
        // First extraction empties the can.
        opener.open(can);
        WalrusFood secondExtraction = opener.open(can);
        assertNull("After extraction, subsequent open() should return null", secondExtraction);
    }
    
    @Test
    public void testOpenOnEmptyCan() {
        CannedWalrusFood emptyCan = new CannedWalrusFood();
        WalrusFood extracted = opener.open(emptyCan);
        assertNull("Opening an empty can should return null", extracted);
    }
}
