package pt.bmribeiro.javalts.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalExampleTest {

    private final OptionalExample example = new OptionalExample();

    @Test
    void shouldIdentifyEmptyOptional() {
        assertTrue(example.isEmpty(Optional.empty()));
    }

    @Test
    void shouldIdentifyPresentOptional() {
        assertFalse(example.isEmpty(Optional.of("Java 11")));
    }

    @Test
    void shouldReturnEmptyStatus() {
        assertEquals(
            "No value present",
            example.getStatus(Optional.empty())
        );
    }

    @Test
    void shouldReturnPresentValueStatus() {
        assertEquals(
            "Value present: Java 11",
            example.getStatus(Optional.of("Java 11"))
        );
    }
}
