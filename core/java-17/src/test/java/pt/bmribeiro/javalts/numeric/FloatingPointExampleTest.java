
package pt.bmribeiro.javalts.numeric;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FloatingPointExampleTest {

    private final FloatingPointExample example =
        new FloatingPointExample();

    @Test
    void shouldCalculateArithmeticExpression() {
        double result = example.calculateExpression(2.0, 3.0, 4.0);

        assertEquals(20.0, result, 0.000001);
    }

    @Test
    void shouldCalculateDivision() {
        double result = example.calculateDivision(10.0, 4.0);

        assertEquals(2.5, result, 0.000001);
    }

    @Test
    void shouldDemonstrateFloatingPointPrecision() {
        double result = example.calculatePrecisionDifference();

        assertEquals(0.30000000000000004, result);
        assertFalse(result == 0.3);
    }

    @Test
    void shouldIdentifyNaN() {
        assertTrue(example.isNaN(Double.NaN));
        assertFalse(example.isNaN(10.0));
    }

    @Test
    void shouldIdentifyInfiniteValues() {
        assertTrue(example.isInfinite(Double.POSITIVE_INFINITY));
        assertTrue(example.isInfinite(Double.NEGATIVE_INFINITY));
        assertFalse(example.isInfinite(100.0));
    }

    @Test
    void shouldTreatDivisionByZeroAccordingToFloatingPointSemantics() {
        double result = example.calculateDivision(10.0, 0.0);

        assertTrue(example.isInfinite(result));
    }
}
