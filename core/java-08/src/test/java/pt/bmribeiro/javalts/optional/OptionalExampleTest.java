package pt.bmribeiro.javalts.optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionalExampleTest {

    private final OptionalExample example = new OptionalExample();

    @Test
    void shouldFindExistingName() {
        assertEquals("Ana", example.findNameById(1L).orElse(null));
    }

    @Test
    void shouldReturnEmptyWhenNameDoesNotExist() {
        assertFalse(example.findNameById(99L).isPresent());
    }

    @Test
    void shouldReturnDefaultNameWhenUserDoesNotExist() {
        assertEquals("Unknown", example.findNameOrDefault(99L, "Unknown"));
    }

    @Test
    void shouldMapNameToItsLength() {
        assertEquals(5, example.findNameLength(2L).orElse(-1));
    }

    @Test
    void shouldFilterNamesByLength() {
        assertEquals("Alexandre",
            example.findLongNameById(3L).orElse(null));

        assertFalse(example.findLongNameById(1L).isPresent());
    }

    @Test
    void shouldGenerateDefaultValueLazily() {
        assertEquals("Unknown user",
            example.findNameOrGenerateDefault(99L));
    }

    @Test
    void shouldThrowExceptionWhenNameDoesNotExist() {
        assertThrows(IllegalArgumentException.class,
            () -> example.findNameOrThrow(99L));
    }
}
