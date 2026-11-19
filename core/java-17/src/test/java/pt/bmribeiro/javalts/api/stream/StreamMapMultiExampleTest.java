
package pt.bmribeiro.javalts.api.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamMapMultiExampleTest {

    private final StreamMapMultiExample example =
        new StreamMapMultiExample();

    @Test
    void shouldExpandWordsIntoCharacters() {
        List<String> result = example.expandCharacters(
            List.of("Java", "17")
        );

        assertEquals(
            List.of("J", "a", "v", "a", "1", "7"),
            result
        );
    }

    @Test
    void shouldExpandPositiveNumbers() {
        List<Integer> result = example.expandNumbers(
            List.of(1, 2, -3, 4)
        );

        assertEquals(
            List.of(1, 2, 2, 4, 4, 8),
            result
        );
    }

    @Test
    void shouldReturnOriginalAndUpperCaseWordsWhenLengthIsGreaterThanThree() {
        List<String> result = example.filterAndExpand(
            List.of("Java", "Go", "Spring")
        );

        assertEquals(
            List.of("Java", "JAVA", "Spring", "SPRING"),
            result
        );
    }

    @Test
    void shouldRemoveNullAndBlankWordsAndTrimRemainingWords() {
        List<String> result = example.extractNonEmptyWords(
            java.util.Arrays.asList(
                " Java ",
                null,
                "",
                "   ",
                " Spring "
            )
        );

        assertEquals(
            List.of("Java", "Spring"),
            result
        );
    }

    @Test
    void shouldReturnEmptyListWhenInputIsEmpty() {
        List<String> result = example.expandCharacters(List.of());

        assertEquals(List.of(), result);
    }

    @Test
    void shouldReturnEmptyListWhenNoNumbersArePositive() {
        List<Integer> result = example.expandNumbers(
            List.of(0, -1, -2)
        );

        assertEquals(List.of(), result);
    }
}
