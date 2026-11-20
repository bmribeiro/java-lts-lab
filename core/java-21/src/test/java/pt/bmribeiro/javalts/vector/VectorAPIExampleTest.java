
package pt.bmribeiro.javalts.vector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorAPIExampleTest {

    @Test
    void shouldAddCorrespondingElements() {
        int[] first = {1, 2, 3, 4};
        int[] second = {5, 6, 7, 8};

        int[] result = VectorAPIExample.add(first, second);

        assertArrayEquals(
            new int[]{6, 8, 10, 12},
            result
        );
    }

    @Test
    void shouldAddArraysWithNegativeValues() {
        int[] first = {-1, -2, 3, 0};
        int[] second = {1, 2, -3, 0};

        int[] result = VectorAPIExample.add(first, second);

        assertArrayEquals(
            new int[]{0, 0, 0, 0},
            result
        );
    }

    @Test
    void shouldProcessEmptyArrays() {
        int[] result = VectorAPIExample.add(
            new int[0],
            new int[0]
        );

        assertArrayEquals(new int[0], result);
    }

    @Test
    void shouldProcessSingleElementArrays() {
        int[] result = VectorAPIExample.add(
            new int[]{10},
            new int[]{20}
        );

        assertArrayEquals(new int[]{30}, result);
    }

    @Test
    void shouldProcessArraysSmallerThanPreferredVectorLength() {
        int length = Math.max(
            1,
            VectorAPIExample.preferredVectorLength() - 1
        );

        int[] first = new int[length];
        int[] second = new int[length];

        for (int i = 0; i < length; i++) {
            first[i] = i;
            second[i] = i * 2;
        }

        int[] result = VectorAPIExample.add(first, second);

        for (int i = 0; i < length; i++) {
            assertEquals(i * 3, result[i]);
        }
    }

    @Test
    void shouldProcessArraysWithExactlyOneVector() {
        int length = VectorAPIExample.preferredVectorLength();

        int[] first = new int[length];
        int[] second = new int[length];

        for (int i = 0; i < length; i++) {
            first[i] = i + 1;
            second[i] = i + 10;
        }

        int[] result = VectorAPIExample.add(first, second);

        for (int i = 0; i < length; i++) {
            assertEquals(
                first[i] + second[i],
                result[i]
            );
        }
    }

    @Test
    void shouldProcessRemainingElementsAfterCompleteVectors() {
        int length = VectorAPIExample.preferredVectorLength() + 1;

        int[] first = new int[length];
        int[] second = new int[length];

        for (int i = 0; i < length; i++) {
            first[i] = i;
            second[i] = i * 10;
        }

        int[] result = VectorAPIExample.add(first, second);

        for (int i = 0; i < length; i++) {
            assertEquals(
                first[i] + second[i],
                result[i]
            );
        }
    }

    @Test
    void shouldProcessMultipleVectorsAndRemainingElements() {
        int vectorLength = VectorAPIExample.preferredVectorLength();
        int length = (vectorLength * 2) + 3;

        int[] first = new int[length];
        int[] second = new int[length];

        for (int i = 0; i < length; i++) {
            first[i] = i * 2;
            second[i] = i * 3;
        }

        int[] result = VectorAPIExample.add(first, second);

        for (int i = 0; i < length; i++) {
            assertEquals(
                i * 5,
                result[i]
            );
        }
    }

    @Test
    void shouldNotModifyInputArrays() {
        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6};

        int[] originalFirst = first.clone();
        int[] originalSecond = second.clone();

        VectorAPIExample.add(first, second);

        assertArrayEquals(originalFirst, first);
        assertArrayEquals(originalSecond, second);
    }

    @Test
    void shouldReturnANewArray() {
        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6};

        int[] result = VectorAPIExample.add(first, second);

        assertNotSame(first, result);
        assertNotSame(second, result);
    }

    @Test
    void shouldThrowExceptionWhenFirstArrayIsNull() {
        int[] second = {1, 2, 3};

        assertThrows(
            NullPointerException.class,
            () -> VectorAPIExample.add(null, second)
        );
    }

    @Test
    void shouldThrowExceptionWhenSecondArrayIsNull() {
        int[] first = {1, 2, 3};

        assertThrows(
            NullPointerException.class,
            () -> VectorAPIExample.add(first, null)
        );
    }

    @Test
    void shouldThrowExceptionWhenArrayLengthsDiffer() {
        int[] first = {1, 2, 3};
        int[] second = {4, 5};

        assertThrows(
            IllegalArgumentException.class,
            () -> VectorAPIExample.add(first, second)
        );
    }

    @Test
    void shouldExposePositivePreferredVectorLength() {
        assertTrue(
            VectorAPIExample.preferredVectorLength() > 0
        );
    }
}
