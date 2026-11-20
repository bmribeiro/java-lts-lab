package pt.bmribeiro.javalts.collections;
import java.util.Objects;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedMap;
import java.util.SequencedSet;

/**
 * Demonstrates Sequenced Collections introduced by JEP 431.
 *
 * <h2>Introduction</h2>
 * Sequenced Collections provide a unified API for collections with a
 * defined encounter order.
 *
 * Before Java 21, different collection interfaces exposed different
 * mechanisms for accessing their first and last elements.
 * This feature introduces common interfaces and consistent operations
 * for working with ordered collections.
 *
 * <h2>Key Concepts</h2>
 * <ul>
 *     <li>SequencedCollection: ordered collection with first and last access.</li>
 *     <li>SequencedSet: ordered set without duplicate elements.</li>
 *     <li>SequencedMap: map with a defined encounter order.</li>
 *     <li>getFirst() and getLast(): access the first and last elements.</li>
 *     <li>addFirst() and addLast(): insert elements at either end.</li>
 *     <li>reversed(): returns a reverse-ordered view of the collection.</li>
 * </ul>
 *
 * <h2>Interview Notes</h2>
 * <ul>
 *     <li>
 *         SequencedCollection vs List:
 *         SequencedCollection is a common abstraction for ordered
 *         collections, while List additionally provides indexed access.
 *     </li>
 *     <li>
 *         SequencedSet:
 *         Preserves encounter order while maintaining uniqueness.
 *     </li>
 *     <li>
 *         SequencedMap:
 *         Provides ordered map operations, including access to the
 *         first and last entries.
 *     </li>
 *     <li>
 *         reversed():
 *         Returns a view in reverse encounter order, not an independent
 *         copy. Changes may be reflected in both views.
 *     </li>
 * </ul>
 *
 * JEP: 431
 * Introduced: Java 21
 * Preview: None
 * Finalized: Java 21
 * Target Version: Java 21
 * Category: Collections API
 *
 * @see <a href="https://openjdk.org/jeps/431">JEP 431: Sequenced Collections</a>
 */
public final class SequencedCollectionsExample {

    public SequencedCollectionsExample() {
    }

    /**
     * Returns the first and last elements of a sequenced collection.
     *
     * @param elements the input elements
     * @return a string describing the first and last elements
     */
    public static String describeFirstAndLast(List<String> elements) {

        Objects.requireNonNull(elements, "Elements cannot be null");

        if (elements.isEmpty()) {
            return "Empty collection";
        }

        return "First: " + elements.getFirst()
            + ", Last: " + elements.getLast();
    }

    /**
     * Returns a reversed view of the supplied list.
     *
     * @param elements the input elements
     * @return the elements in reverse encounter order
     */
    public static List<String> reversed(List<String> elements) {

        Objects.requireNonNull(elements, "Elements cannot be null");

        return elements.reversed();
    }

    /**
     * Creates a sequenced set from the supplied elements.
     *
     * Duplicate elements are removed while preserving insertion order.
     *
     * @param elements the input elements
     * @return a sequenced set
     */
    public static SequencedSet<String> createSequencedSet(
        List<String> elements) {

        Objects.requireNonNull(elements, "Elements cannot be null");

        return new LinkedHashSet<>(elements);
    }

    /**
     * Creates a sequenced map from the supplied key-value pairs.
     *
     * @param entries the key-value pairs
     * @return a sequenced map
     */
    public static SequencedMap<String, Integer> createSequencedMap(
        SequencedMap<String, Integer> entries) {

        Objects.requireNonNull(entries, "Entries cannot be null");

        return new LinkedHashMap<>(entries);
    }
}
