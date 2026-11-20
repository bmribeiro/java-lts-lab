
package pt.bmribeiro.javalts.collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedMap;
import java.util.SequencedSet;

import static org.junit.jupiter.api.Assertions.*;

class SequencedCollectionsExampleTest {

    private final SequencedCollectionsExample example =
        new SequencedCollectionsExample();

    @Test
    void shouldDescribeFirstAndLastElements() {
        List<String> elements = List.of("Java", "Kotlin", "Scala");

        String result = example.describeFirstAndLast(elements);

        assertEquals("First: Java, Last: Scala", result);
    }

    @Test
    void shouldDescribeEmptyCollection() {
        String result = example.describeFirstAndLast(List.of());

        assertEquals("Empty collection", result);
    }

    @Test
    void shouldReturnElementsInReverseOrder() {
        List<String> elements = List.of("Java", "Kotlin", "Scala");

        List<String> reversed = example.reversed(elements);

        assertEquals(List.of("Scala", "Kotlin", "Java"), reversed);
    }

    @Test
    void reversedCollectionShouldReflectChangesToOriginalList() {
        List<String> elements =
            new java.util.ArrayList<>(List.of("Java", "Kotlin"));

        List<String> reversed = example.reversed(elements);

        elements.add("Scala");

        assertEquals(List.of("Scala", "Kotlin", "Java"), reversed);
    }

    @Test
    void shouldCreateSequencedSetPreservingInsertionOrder() {
        List<String> elements =
            List.of("Java", "Kotlin", "Java", "Scala");

        SequencedSet<String> result =
            example.createSequencedSet(elements);

        assertEquals(List.of("Java", "Kotlin", "Scala"),
            List.copyOf(result));
    }

    @Test
    void sequencedSetShouldExposeFirstAndLastElements() {
        SequencedSet<String> result =
            example.createSequencedSet(
                List.of("Java", "Kotlin", "Scala"));

        assertEquals("Java", result.getFirst());
        assertEquals("Scala", result.getLast());
    }

    @Test
    void shouldCreateSequencedMapPreservingInsertionOrder() {
        SequencedMap<String, Integer> input = new LinkedHashMap<>();
        input.put("Java", 21);
        input.put("Kotlin", 2);
        input.put("Scala", 3);

        SequencedMap<String, Integer> result =
            example.createSequencedMap(input);

        assertEquals(List.of("Java", "Kotlin", "Scala"),
            List.copyOf(result.keySet()));
    }

    @Test
    void sequencedMapShouldExposeFirstAndLastEntries() {
        SequencedMap<String, Integer> input = new LinkedHashMap<>();
        input.put("Java", 21);
        input.put("Kotlin", 2);
        input.put("Scala", 3);

        SequencedMap<String, Integer> result =
            example.createSequencedMap(input);

        assertEquals("Java", result.firstEntry().getKey());
        assertEquals(21, result.firstEntry().getValue());
        assertEquals("Scala", result.lastEntry().getKey());
        assertEquals(3, result.lastEntry().getValue());
    }

    @Test
    void shouldRejectNullCollectionWhenDescribingElements() {
        assertThrows(NullPointerException.class,
            () -> example.describeFirstAndLast(null));
    }

    @Test
    void shouldRejectNullCollectionWhenReversing() {
        assertThrows(NullPointerException.class,
            () -> example.reversed(null));
    }

    @Test
    void shouldRejectNullCollectionWhenCreatingSequencedSet() {
        assertThrows(NullPointerException.class,
            () -> example.createSequencedSet(null));
    }

    @Test
    void shouldRejectNullMapWhenCreatingSequencedMap() {
        assertThrows(NullPointerException.class,
            () -> example.createSequencedMap(null));
    }
}
