package pt.bmribeiro.javalts.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PredicateExampleTest {

    private final PredicateExample example = new PredicateExample();

    @Test
    void shouldFilterNullAndEmptyNames() {
        List<String> names = Arrays.asList(
            "Bruno",
            "",
            "Ana",
            null,
            "Carlos"
        );

        assertEquals(
            Arrays.asList("Bruno", "Ana", "Carlos"),
            example.filterNonEmptyNames(names)
        );
    }

    @Test
    void shouldFilterBlankStrings() {
        List<String> values = Arrays.asList(
            "Java",
            "",
            "   ",
            "Java 11",
            null
        );

        assertEquals(
            Arrays.asList("Java", "Java 11"),
            example.filterBlankStrings(values)
        );
    }

    @Test
    void shouldReturnEmptyListWhenNoValidNamesExist() {
        List<String> names = Arrays.asList("", null, "");

        assertEquals(
            Collections.emptyList(),
            example.filterNonEmptyNames(names)
        );
    }
}
