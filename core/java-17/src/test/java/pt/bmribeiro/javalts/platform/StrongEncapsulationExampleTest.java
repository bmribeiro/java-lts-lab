package pt.bmribeiro.javalts.platform;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrongEncapsulationExampleTest {

    private final StrongEncapsulationExample example =
        new StrongEncapsulationExample();

    private static class TestClass {
        private String value;
    }

    @Test
    void shouldAllowReflectiveAccessToApplicationClass() {
        assertTrue(
            example.isFieldAccessible(TestClass.class, "value")
        );
    }

    @Test
    void shouldIdentifyAccessibleApplicationField() {
        assertEquals(
            "Accessible",
            example.getEncapsulationStatus(TestClass.class, "value")
        );
    }

    @Test
    void shouldPreventReflectiveAccessToJdkInternalField() {
        assertFalse(
            example.isFieldAccessible(String.class, "value")
        );
    }

    @Test
    void shouldIdentifyStronglyEncapsulatedJdkField() {
        assertEquals(
            "Strongly encapsulated",
            example.getEncapsulationStatus(String.class, "value")
        );
    }

    @Test
    void shouldIdentifyMissingField() {
        assertEquals(
            "Field not found",
            example.getEncapsulationStatus(TestClass.class, "unknown")
        );
    }
}
