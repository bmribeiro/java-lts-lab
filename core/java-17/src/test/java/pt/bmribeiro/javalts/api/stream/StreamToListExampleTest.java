package pt.bmribeiro.javalts.api.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StreamToListExampleTest {

    private final StreamToListExample example =
        new StreamToListExample();

    @Test
    void shouldFilterLongNames() {
        List<String> result = example.filterLongNames(
            List.of("Java", "Go", "Spring", "SQL")
        );

        assertEquals(List.of("Java", "Spring"), result);
    }

    @Test
    void shouldReturnEvenNumbers() {
        List<Integer> result = example.getEvenNumbers(
            List.of(1, 2, 3, 4, 5, 6)
        );

        assertEquals(List.of(2, 4, 6), result);
    }

    @Test
    void shouldConvertNamesToUpperCase() {
        List<String> result = example.convertToUpperCase(
            List.of("java", "spring", "angular")
        );

        assertEquals(
            List.of("JAVA", "SPRING", "ANGULAR"),
            result
        );
    }

    @Test
    void shouldReturnDistinctNames() {
        List<String> result = example.getDistinctNames(
            List.of("Java", "Spring", "Java", "Angular", "Spring")
        );

        assertEquals(
            List.of("Java", "Spring", "Angular"),
            result
        );
    }

    @Test
    void shouldReturnUnmodifiableList() {
        List<String> result = example.filterLongNames(
            List.of("Java", "Spring")
        );

        assertThrows(
            UnsupportedOperationException.class,
            () -> result.add("Angular")
        );
    }

    @Test
    void shouldReturnEmptyListWhenNoElementsMatch() {
        List<String> result = example.filterLongNames(
            List.of("Go", "C")
        );

        assertEquals(List.of(), result);
    }
}
