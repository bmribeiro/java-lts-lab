package pt.bmribeiro.javalts.functional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfacesExampleTest {

    private final FunctionalInterfacesExample example =
        new FunctionalInterfacesExample();

    @Test
    void shouldIdentifyLongName() {
        assertTrue(example.isLongName("António"));
        assertFalse(example.isLongName("Ana"));
    }

    @Test
    void shouldReturnPrintedName() {
        assertEquals("Bruno", example.printName("Bruno"));
    }

    @Test
    void shouldProvideDefaultGreeting() {
        assertEquals(
            "Hello, Java 8!",
            example.getDefaultGreeting()
        );
    }

    @Test
    void shouldReturnNameLength() {
        assertEquals(5, example.getNameLength("Bruno"));
    }
}
