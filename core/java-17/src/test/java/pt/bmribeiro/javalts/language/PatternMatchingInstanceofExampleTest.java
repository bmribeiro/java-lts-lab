
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternMatchingInstanceofExampleTest {

    private PatternMatchingInstanceofExample example;

    @BeforeEach
    void setUp() {
        example = new PatternMatchingInstanceofExample();
    }

    @Test
    void shouldDescribeStringUsingPatternMatching() {
        assertEquals(
            "String with length: 5",
            example.describe("Hello")
        );
    }

    @Test
    void shouldReturnUnknownTypeForInteger() {
        assertEquals(
            "Unknown type",
            example.describe(42)
        );
    }

    @Test
    void shouldIdentifyLongString() {
        assertEquals(
            "Long string",
            example.describeLongString("Java Developer")
        );
    }

    @Test
    void shouldIdentifyShortString() {
        assertEquals(
            "Short string or unknown type",
            example.describeLongString("Java")
        );
    }

    @Test
    void shouldIdentifyUnknownTypeInLongStringMethod() {
        assertEquals(
            "Short string or unknown type",
            example.describeLongString(42)
        );
    }

    @Test
    void shouldDescribeNegatedPatternForNonString() {
        assertEquals(
            "Not a string",
            example.describeNegatedPattern(42)
        );
    }

    @Test
    void shouldDescribeNegatedPatternForString() {
        assertEquals(
            "String with length: 5",
            example.describeNegatedPattern("Hello")
        );
    }

    @Test
    void shouldReturnDoubledIntegerValue() {
        assertEquals(84, example.getNumericValue(42));
    }

    @Test
    void shouldReturnZeroForNonInteger() {
        assertEquals(0, example.getNumericValue("42"));
    }

    @Test
    void shouldIdentifyStringType() {
        assertEquals(
            "String: Java",
            example.identifyType("Java")
        );
    }

    @Test
    void shouldIdentifyIntegerType() {
        assertEquals(
            "Integer: 42",
            example.identifyType(42)
        );
    }

    @Test
    void shouldIdentifyDoubleType() {
        assertEquals(
            "Double: 3.14",
            example.identifyType(3.14)
        );
    }

    @Test
    void shouldReturnUnknownTypeForUnsupportedObject() {
        assertEquals(
            "Unknown type",
            example.identifyType(true)
        );
    }
}
