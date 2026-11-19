
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchExpressionExampleTest {

    private SwitchExpressionExample example;

    @BeforeEach
    void setUp() {
        example = new SwitchExpressionExample();
    }

    @Test
    void shouldReturnWeekendForSaturday() {
        assertEquals("Weekend", example.getDayType("SATURDAY"));
    }

    @Test
    void shouldReturnWeekendForSunday() {
        assertEquals("Weekend", example.getDayType("SUNDAY"));
    }

    @Test
    void shouldReturnWeekdayForMonday() {
        assertEquals("Weekday", example.getDayType("MONDAY"));
    }

    @Test
    void shouldReturnWeekdayForFriday() {
        assertEquals("Weekday", example.getDayType("FRIDAY"));
    }

    @Test
    void shouldReturnInvalidDayForUnknownValue() {
        assertEquals("Invalid day", example.getDayType("HOLIDAY"));
    }

    @Test
    void shouldReturnDayDescriptionForWeekend() {
        assertEquals(
            "Day type: Weekend",
            example.getDayDescription("SATURDAY")
        );
    }

    @Test
    void shouldReturnDayDescriptionForWeekday() {
        assertEquals(
            "Day type: Weekday",
            example.getDayDescription("WEDNESDAY")
        );
    }

    @Test
    void shouldReturnInvalidDayDescriptionForUnknownValue() {
        assertEquals(
            "Invalid day",
            example.getDayDescription("HOLIDAY")
        );
    }
}
