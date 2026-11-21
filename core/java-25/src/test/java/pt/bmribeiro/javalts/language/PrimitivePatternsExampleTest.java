package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimitivePatternsExampleTest {

    private PrimitivePatternsExample example;

    @BeforeEach
    void setUp() {
        example = new PrimitivePatternsExample();
    }

    @Test
    void shouldSafelyConvertIntToByte() {
        assertEquals("byte:100", example.safelyConvertToByte(100));
    }

    @Test
    void shouldRejectIntOutsideByteRange() {
        assertEquals(
            "outside-byte-range",
            example.safelyConvertToByte(128)
        );
    }

    @Test
    void shouldWidenFloatToDouble() {
        float value = 12.5f;

        assertEquals(
            (double) value,
            example.convertFloatToDouble(value)
        );
    }

    @Test
    void shouldClassifyTemperature() {
        assertEquals(
            "below-freezing",
            example.classifyTemperature(-5.0)
        );

        assertEquals(
            "normal",
            example.classifyTemperature(20.0)
        );

        assertEquals(
            "high",
            example.classifyTemperature(35.0)
        );
    }

    @Test
    void shouldClassifyLongValues() {
        assertEquals(
            "less-than-million",
            example.classifyLargeNumber(500_000L)
        );

        assertEquals(
            "less-than-billion",
            example.classifyLargeNumber(500_000_000L)
        );

        assertEquals(
            "billion-or-more",
            example.classifyLargeNumber(2_000_000_000L)
        );
    }

    @Test
    void shouldDeconstructRecordWithPrimitivePatterns() {
        var reading =
            new PrimitivePatternsExample.SensorReading(10, -2.5);

        assertEquals(
            "sensor-10:below-freezing",
            example.classifySensorReading(reading)
        );
    }

    @Test
    void shouldClassifyNonFreezingSensorReading() {
        var reading =
            new PrimitivePatternsExample.SensorReading(20, 22.5);

        assertEquals(
            "sensor-20:normal-or-high",
            example.classifySensorReading(reading)
        );
    }
}
