package pt.bmribeiro.javalts.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StringApiExampleTest {

    private final StringApiExample example = new StringApiExample();

    @Test
    void shouldIdentifyBlankStrings() {
        assertTrue(example.isBlank(""));
        assertTrue(example.isBlank("   "));
        assertTrue(example.isBlank("\t\n"));
        assertFalse(example.isBlank("Java"));
    }

    @Test
    void shouldReturnLinesAsStream() {
        assertEquals(
            Arrays.asList("Java 8", "Java 11", "Java 17"),
            example.getLines("Java 8\nJava 11\nJava 17")
                .collect(Collectors.toList())
        );
    }

    @Test
    void shouldReturnEmptyStreamForEmptyString() {
        assertEquals(
            Collections.emptyList(),
            example.getLines("").collect(Collectors.toList())
        );
    }

    @Test
    void shouldStripLeadingAndTrailingWhitespace() {
        assertEquals("Java 11", example.strip("   Java 11   "));
        assertEquals("", example.strip("   "));
    }

    @Test
    void shouldRepeatString() {
        assertEquals("JavaJavaJava", example.repeat("Java", 3));
        assertEquals("----------", example.repeat("-", 10));
    }

    @Test
    void shouldReturnEmptyStringWhenRepeatCountIsZero() {
        assertEquals("", example.repeat("Java", 0));
    }
}
