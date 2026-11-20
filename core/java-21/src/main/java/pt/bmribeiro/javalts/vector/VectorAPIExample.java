
package pt.bmribeiro.javalts.vector;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.Objects;

/**
 * Demonstrates the Vector API, an Incubator API introduced
 * in Java 16 and evolved through subsequent Java releases.
 *
 * <p>The Vector API enables vector computations that can be
 * mapped to SIMD instructions supported by the processor.</p>
 *
 * <p>This example performs element-wise integer addition,
 * processing multiple elements in each vector operation.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>SIMD means Single Instruction, Multiple Data.</li>
 *   <li>Vector operations process multiple values in parallel.</li>
 *   <li>VectorSpecies describes the shape of a vector.</li>
 *   <li>SPECIES_PREFERRED selects the preferred vector shape
 *       supported by the current platform.</li>
 *   <li>Remaining elements that do not fill a complete vector
 *       are processed using a scalar loop.</li>
 *   <li>The API is incubating in Java 21 and requires
 *       the jdk.incubator.vector module.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 448</p>
 * <p>Introduced: Java 16 (JEP 338)</p>
 * <p>Incubator: Java 16 (JEP 338), Java 17 (JEP 414),
 * Java 18 (JEP 417), Java 19 (JEP 426),
 * Java 20 (JEP 438), Java 21 (JEP 448)</p>
 * <p>Finalized: Not finalized in Java 21</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Incubator API / Vector Computation</p>
 *
 * @see <a href="https://openjdk.org/jeps/448">
 *     JEP 448: Vector API (Sixth Incubator)</a>
 */
public final class VectorAPIExample {

    private static final VectorSpecies<Integer> SPECIES =
        IntVector.SPECIES_PREFERRED;

    private VectorAPIExample() {
    }

    /**
     * Adds corresponding elements from two integer arrays.
     *
     * <p>Complete vectors are processed using SIMD operations.
     * Remaining elements are processed individually.</p>
     *
     * @param first first input array
     * @param second second input array
     * @return a new array containing the element-wise sums
     * @throws NullPointerException if either array is null
     * @throws IllegalArgumentException if array lengths differ
     */
    public static int[] add(int[] first, int[] second) {
        Objects.requireNonNull(first, "First array cannot be null");
        Objects.requireNonNull(second, "Second array cannot be null");

        if (first.length != second.length) {
            throw new IllegalArgumentException(
                "Arrays must have the same length"
            );
        }

        int[] result = new int[first.length];

        int index = 0;
        int upperBound = SPECIES.loopBound(first.length);

        for (; index < upperBound; index += SPECIES.length()) {
            IntVector firstVector = IntVector.fromArray(
                SPECIES,
                first,
                index
            );

            IntVector secondVector = IntVector.fromArray(
                SPECIES,
                second,
                index
            );

            firstVector.add(secondVector).intoArray(result, index);
        }

        for (; index < first.length; index++) {
            result[index] = first[index] + second[index];
        }

        return result;
    }

    /**
     * Returns the number of integer elements processed
     * by a preferred vector instance.
     */
    public static int preferredVectorLength() {
        return SPECIES.length();
    }
}
