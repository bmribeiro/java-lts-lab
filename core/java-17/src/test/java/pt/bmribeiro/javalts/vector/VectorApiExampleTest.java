
package pt.bmribeiro.javalts.vector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VectorApiExampleTest {

    private final VectorApiExample example = new VectorApiExample();

    @Test
    void shouldAddArraysUsingVectorApi() {
        int[] first = {1, 2, 3, 4};
        int[] second = {5, 6, 7, 8};

        int[] result = example.add(first, second);

        assertArrayEquals(
            new int[]{6, 8, 10, 12},
            result
        );
    }

    @Test
    void shouldProcessArraysLargerThanVectorLength() {
        int[] first = {1, 2, 3, 4, 5, 6, 7};
        int[] second = {10, 20, 30, 40, 50, 60, 70};

        int[] result = example.add(first, second);

        assertArrayEquals(
            new int[]{11, 22, 33, 44, 55, 66, 77},
            result
        );
    }

    @Test
    void shouldProcessEmptyArrays() {
        int[] result = example.add(new int[0], new int[0]);

        assertArrayEquals(new int[0], result);
    }

    @Test
    void shouldRejectNullFirstArray() {
        assertThrows(
            IllegalArgumentException.class,
            () -> example.add(null, new int[]{1, 2})
        );
    }

    @Test
    void shouldRejectNullSecondArray() {
        assertThrows(
            IllegalArgumentException.class,
            () -> example.add(new int[]{1, 2}, null)
        );
    }

    @Test
    void shouldRejectArraysWithDifferentLengths() {
        assertThrows(
            IllegalArgumentException.class,
            () -> example.add(
                new int[]{1, 2},
                new int[]{3}
            )
        );
    }

    @Test
    void shouldExposePositiveVectorLength() {
        assertTrue(example.getVectorLength() > 0);
    }

    @Test
    void shouldExposeVectorShape() {
        String shape = example.getVectorShape();

        assertTrue(shape.startsWith("S_"));
        assertTrue(shape.endsWith("_BIT"));
    }
}
