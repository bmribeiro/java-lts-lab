
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnnamedPatternsVariablesExampleTest {

    @Test
    void shouldDescribePointUsingOnlyNamedCoordinate() {
        var point = new UnnamedPatternsVariablesExample.Point(10, 20);

        assertEquals(
            "X coordinate: 10",
            UnnamedPatternsVariablesExample.describePoint(point)
        );
    }

    @Test
    void shouldReturnNotAPointForDifferentType() {
        assertEquals(
            "Not a point",
            UnnamedPatternsVariablesExample.describePoint("not a point")
        );
    }

    @Test
    void shouldReturnNotAPointForNull() {
        assertEquals(
            "Not a point",
            UnnamedPatternsVariablesExample.describePoint(null)
        );
    }

    @Test
    void shouldIdentifyStringType() {
        assertEquals(
            "String",
            UnnamedPatternsVariablesExample.describeType("Java")
        );
    }

    @Test
    void shouldIdentifyIntegerType() {
        assertEquals(
            "Integer",
            UnnamedPatternsVariablesExample.describeType(21)
        );
    }

    @Test
    void shouldIdentifyDoubleType() {
        assertEquals(
            "Double",
            UnnamedPatternsVariablesExample.describeType(21.0)
        );
    }

    @Test
    void shouldIdentifyNullType() {
        assertEquals(
            "Null",
            UnnamedPatternsVariablesExample.describeType(null)
        );
    }

    @Test
    void shouldIdentifyOtherTypes() {
        assertEquals(
            "Other",
            UnnamedPatternsVariablesExample.describeType(true)
        );
    }

    @Test
    void shouldCountElements() {
        assertEquals(
            3,
            UnnamedPatternsVariablesExample.countElements(
                List.of("Java", "21", "Preview")
            )
        );
    }

    @Test
    void shouldReturnZeroForEmptyList() {
        assertEquals(
            0,
            UnnamedPatternsVariablesExample.countElements(List.of())
        );
    }

    @Test
    void shouldThrowExceptionForNullList() {
        assertThrows(
            NullPointerException.class,
            () -> UnnamedPatternsVariablesExample.countElements(null)
        );
    }
}
