
package pt.bmribeiro.javalts.api.random;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomGeneratorExampleTest {

    private final RandomGeneratorExample example =
        new RandomGeneratorExample();

    @Test
    void shouldGenerateIntegerWithinRange() {
        int result = example.generateInteger(10, 20);

        assertTrue(result >= 10 && result < 20);
    }

    @Test
    void shouldGenerateDoubleBetweenZeroAndOne() {
        double result = example.generateDouble();

        assertTrue(result >= 0.0 && result < 1.0);
    }

    @Test
    void shouldGenerateArrayWithRequestedSize() {
        int[] result = example.generateIntegers(10, 1, 100);

        assertEquals(10, result.length);
    }

    @Test
    void shouldGenerateIntegersWithinRange() {
        int[] result = example.generateIntegers(100, 5, 15);

        for (int number : result) {
            assertTrue(number >= 5 && number < 15);
        }
    }

    @Test
    void shouldReturnAvailableAlgorithms() {
        List<String> algorithms = example.getAvailableAlgorithms();

        assertFalse(algorithms.isEmpty());
        assertEquals(
            algorithms.stream().sorted().toList(),
            algorithms
        );
    }

    @Test
    void shouldGenerateIntegerUsingExplicitAlgorithm() {
        int result = example.generateWithAlgorithm(
            "L64X128MixRandom",
            1,
            100
        );

        assertTrue(result >= 1 && result < 100);
    }
}
