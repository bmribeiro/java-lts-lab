
package pt.bmribeiro.javalts.vector;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * JEP: 414
 * Introduced: Java 16 (JEP 338 - First Incubator)
 * Incubator: Java 17 (Second Incubator)
 * Finalized: Not finalized in Java 17
 * Target Version: Java 17
 * Category: Vector API / Performance
 *
 * Demonstrates vectorized integer addition using SIMD operations.
 */
public class VectorApiExample {

    private static final VectorSpecies<Integer> SPECIES =
        IntVector.SPECIES_PREFERRED;

    /**
     * Adds two integer arrays using the Vector API.
     *
     * Processes multiple elements per iteration and handles
     * remaining elements with a scalar operation.
     *
     * @param first first input array
     * @param second second input array
     * @return array containing the sums
     */
    public int[] add(int[] first, int[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException(
                "Input arrays cannot be null.");
        }

        if (first.length != second.length) {
            throw new IllegalArgumentException(
                "Input arrays must have the same length.");
        }

        int[] result = new int[first.length];

        int upperBound = SPECIES.loopBound(first.length);

        int index = 0;

        for (; index < upperBound; index += SPECIES.length()) {
            IntVector firstVector =
                IntVector.fromArray(SPECIES, first, index);

            IntVector secondVector =
                IntVector.fromArray(SPECIES, second, index);

            IntVector resultVector = firstVector.add(secondVector);

            resultVector.intoArray(result, index);
        }

        // Process remaining elements.
        for (; index < first.length; index++) {
            result[index] = first[index] + second[index];
        }

        return result;
    }

    public int getVectorLength() {
        return SPECIES.length();
    }

    public String getVectorShape() {
        return SPECIES.vectorShape().toString();
    }
}
