package org.example.values;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class WalrusFoodTest {

    @Test
    public void testInstanceCreation() {
        WalrusFood food = new WalrusFood();
        assertNotNull("A new WalrusFood instance should not be null", food);
    }
}
