package org.example;

import org.example.values.CannedWalrusFood;
import org.example.values.Walrus;
import org.example.values.WalrusFood;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class FeedsWalrusTest {

    @Test
    void testFeedAddsFoodToWalrus() {
        Walrus gary = mock(Walrus.class);
        CannedWalrusFood can = mock(CannedWalrusFood.class);
        WalrusFood food = mock(WalrusFood.class);

        when(can.extractContents()).thenReturn(food);

        FeedsWalrus feeder = new FeedsWalrus();
        feeder.feed(gary, can);

        verify(gary).addToStomach(food);
    }
}
