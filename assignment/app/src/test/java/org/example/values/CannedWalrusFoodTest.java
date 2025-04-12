package org.example.values;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class CannedWalrusFoodTest {

    @Test
    public void testExtractContentsReturnsFoodAndClearsContents() {
        WalrusFood food = new WalrusFood();
        CannedWalrusFood can = new CannedWalrusFood(food);
        
        // First extraction should return the food.
        WalrusFood extracted = can.extractContents();
        assertNotNull("Extracted food should not be null", extracted);
        assertEquals("Extracted food should match the provided food", food, extracted);
        
        // Subsequent extraction should return null.
        WalrusFood secondExtraction = can.extractContents();
        assertNull("Subsequent extraction should return null", secondExtraction);
    }
    
    @Test
    public void testDefaultConstructorReturnsNull() {
        // A can created with the default constructor has no food.
        CannedWalrusFood emptyCan = new CannedWalrusFood();
        WalrusFood extracted = emptyCan.extractContents();
        assertNull("Extraction from an empty can should return null", extracted);
    }
}
