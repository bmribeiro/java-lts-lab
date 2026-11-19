
package pt.bmribeiro.javalts.numeric;

/**
 * Always-Strict Floating-Point Semantics
 *
 * JEP: 306
 * Introduced: Java 17
 * Finalized: Java 17
 * Target Version: Java 17
 * Category: Numeric / JVM Semantics
 */
public class FloatingPointExample {

    public double calculateExpression(
        double a,
        double b,
        double c
    ) {
        return (a + b) * c;
    }

    public double calculateDivision(double dividend, double divisor) {
        return dividend / divisor;
    }

    public double calculatePrecisionDifference() {
        return 0.1 + 0.2;
    }

    public boolean isNaN(double value) {
        return Double.isNaN(value);
    }

    public boolean isInfinite(double value) {
        return Double.isInfinite(value);
    }
}
