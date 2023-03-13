
package course_3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StaticUtilsTest{

@Test
void givenStaticMethodWithNoArgs_whenMocked_thenReturnsMockSuccessfully() {
    assertThat(StaticUtils.name()).isEqualTo("Baeldung");

    try (MockedStatic<StaticUtils> utilities = Mockito.mockStatic(StaticUtils.class)) {
        utilities.when(StaticUtils::name).thenReturn("Eugen");
        assertThat(StaticUtils.name()).isEqualTo("Eugen");
    }

    assertThat(StaticUtils.name()).isEqualTo("Baeldung");
}
}