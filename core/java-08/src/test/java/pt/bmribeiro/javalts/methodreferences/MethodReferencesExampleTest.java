package pt.bmribeiro.javalts.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodReferencesExampleTest {

    private final MethodReferencesExample example =
        new MethodReferencesExample();

    @Test
    void shouldParseNumberUsingStaticMethodReference() {
        assertEquals(123, example.parseNumber("123"));
    }

    @Test
    void shouldAppendNameUsingInstanceMethodReference() {
        assertEquals("Bruno", example.appendName("Bruno"));
    }

    @Test
    void shouldConvertNamesToUpperCase() {
        List<String> names = Arrays.asList("Ana", "Bruno");

        List<String> result = example.convertToUpperCase(names);

        assertEquals(Arrays.asList("ANA", "BRUNO"), result);
    }

    @Test
    void shouldCopyNamesUsingConstructorReference() {
        List<String> names = Arrays.asList("Ana", "Bruno");

        List<String> result = example.copyNames(names);

        assertEquals(names, result);
        assertNotSame(names, result);
        assertInstanceOf(ArrayList.class, result);
    }
}
