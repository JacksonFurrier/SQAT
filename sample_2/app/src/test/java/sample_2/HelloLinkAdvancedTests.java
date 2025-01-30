package sample_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelloLinkAdvancedTests{

    
    @Test
    public void IndexOutOfBoundsTest()
    {
        HelloLink vHelloLink = new HelloLink(5);
        assertThrows(IndexOutOfBoundsException.class, ()->{vHelloLink.mVector.get( 6 );});
    }

    @Disabled("Test is ignored as a demonstration")
    @Test
    public void testSame() {
        assertEquals(1, 1);
    }

    @Timeout(1000)
    public void testWithTimeout() {
        //
    }

}