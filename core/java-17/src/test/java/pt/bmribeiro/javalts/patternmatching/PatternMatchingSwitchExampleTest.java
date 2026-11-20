
package pt.bmribeiro.javalts.patternmatching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternMatchingSwitchExampleTest {

    private PatternMatchingSwitchExample example;

    @BeforeEach
    void setUp() {
        example = new PatternMatchingSwitchExample();
    }

    @Test
    void shouldDescribeNullValue() {
        assertEquals("Null value", example.describe(null));
    }

    @Test
    void shouldDescribeString() {
        assertEquals("String: Java", example.describe("Java"));
    }

    @Test
    void shouldDescribeInteger() {
        assertEquals("Integer: 17", example.describe(17));
    }

    @Test
    void shouldDescribeDouble() {
        assertEquals("Double: 17.5", example.describe(17.5));
    }

    @Test
    void shouldDescribeBoolean() {
        assertEquals("Boolean: true", example.describe(true));
    }

    @Test
    void shouldDescribeUnknownType() {
        assertEquals("Unknown type", example.describe(17L));
    }

    @Test
    void shouldClassifyNull() {
        assertEquals("Null", example.classify(null));
    }

    @Test
    void shouldClassifyBlankString() {
        assertEquals("Empty string", example.classify("   "));
    }

    @Test
    void shouldClassifyNonEmptyString() {
        assertEquals("Non-empty string", example.classify("Java"));
    }

    @Test
    void shouldClassifyPositiveInteger() {
        assertEquals("Positive integer", example.classify(10));
    }

    @Test
    void shouldClassifyNegativeInteger() {
        assertEquals("Negative integer", example.classify(-10));
    }

    @Test
    void shouldClassifyZero() {
        assertEquals("Zero", example.classify(0));
    }

    @Test
    void shouldClassifyOtherTypes() {
        assertEquals("Other", example.classify(10L));
    }
}
