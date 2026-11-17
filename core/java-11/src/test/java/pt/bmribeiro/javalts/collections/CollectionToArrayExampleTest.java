package pt.bmribeiro.javalts.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CollectionToArrayExampleTest {

    private final CollectionToArrayExample example =
        new CollectionToArrayExample();

    @Test
    void shouldConvertStringsToArray() {
        String[] result = example.toStringArray(
            Arrays.asList("Bruno", "Ana", "Carlos")
        );

        assertArrayEquals(
            new String[]{"Bruno", "Ana", "Carlos"},
            result
        );
    }

    @Test
    void shouldConvertIntegersToArray() {
        Integer[] result = example.toIntegerArray(
            Arrays.asList(10, 20, 30)
        );

        assertArrayEquals(
            new Integer[]{10, 20, 30},
            result
        );
    }

    @Test
    void shouldReturnEmptyArrayForEmptyCollection() {
        String[] result = example.toStringArray(
            Collections.emptyList()
        );

        assertArrayEquals(new String[0], result);
    }
}
