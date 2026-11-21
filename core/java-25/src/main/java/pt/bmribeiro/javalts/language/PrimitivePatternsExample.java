
package pt.bmribeiro.javalts.language;

/**
 * Demonstrates primitive type patterns, primitive instanceof,
 * primitive switch selectors, primitive record patterns,
 * and guarded primitive patterns.
 *
 * JEP: 507
 * Feature: Primitive Types in Patterns, instanceof, and switch
 * Introduced: Java 23 (JEP 455, First Preview)
 * Preview versions: Java 24 (JEP 488), Java 25 (JEP 507)
 * Status: Third Preview in Java 25
 * Category: Language
 *
 * Requires --enable-preview when compiling and running with Java 25.
 */
public class PrimitivePatternsExample {

    /**
     * Tests whether an int value can be safely represented as a byte.
     *
     * The pattern matches only when narrowing does not lose information.
     */
    public String safelyConvertToByte(int value) {
        if (value instanceof byte narrowed) {
            return "byte:" + narrowed;
        }

        return "outside-byte-range";
    }

    /**
     * Demonstrates a widening conversion from float to double
     * through a primitive type pattern.
     */
    public double convertFloatToDouble(float value) {
        if (value instanceof double widened) {
            return widened;
        }

        throw new IllegalStateException("Conversion did not match");
    }

    /**
     * Uses a double selector in a switch expression.
     * Guarded primitive patterns classify values by range.
     */
    public String classifyTemperature(double temperature) {
        return switch (temperature) {
            case double value when value < 0 ->
                "below-freezing";

            case double value when value <= 30 ->
                "normal";

            default ->
                "high";
        };
    }

    /**
     * Uses long as the selector type in a switch expression.
     */
    public String classifyLargeNumber(long value) {
        return switch (value) {
            case long number when number < 1_000_000L ->
                "less-than-million";

            case long number when number < 1_000_000_000L ->
                "less-than-billion";

            default ->
                "billion-or-more";
        };
    }

    /**
     * Record with primitive components.
     */
    public record SensorReading(int sensorId, double temperature) {
    }

    /**
     * Deconstructs a record using primitive type patterns.
     */
    public String classifySensorReading(SensorReading reading) {
        return switch (reading) {
            case SensorReading(int id, double temperature)
                when temperature < 0 ->
                "sensor-" + id + ":below-freezing";

            case SensorReading(int id, double temperature) ->
                "sensor-" + id + ":normal-or-high";
        };
    }
}
