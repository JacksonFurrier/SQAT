
package sample_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.MockedStatic;

public class StaticUtilsTest{

@Test
void givenStaticMethodWithNoArgs_whenMocked_thenReturnsMockSuccessfully() {
    assertEquals(StaticUtils.name(), "Baeldung");

    try (MockedStatic<StaticUtils> utilities = mockStatic(StaticUtils.class)) {
        utilities.when(StaticUtils::name).thenReturn("Eugen");
        assertEquals(StaticUtils.name(), "Eugen");
    }

    assertEquals(StaticUtils.name(), "Baeldung");
}
}