package sample_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class HelloLinkParameterizedTests{

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,1", "3,2", "4,3", "5,5", "6,8"})
    public void numeric_test(int left, int right) {
        assertEquals(left, HelloLink.compute(right));
    }

}