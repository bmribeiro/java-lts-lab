package pt.bmribeiro.javalts.foreign;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForeignFunctionMemoryExampleTest {

    @Test
    void shouldStoreAndReadPositiveInteger() {
        assertEquals(
            42,
            ForeignFunctionMemoryExample.storeAndReadInt(42)
        );
    }

    @Test
    void shouldStoreAndReadNegativeInteger() {
        assertEquals(
            -42,
            ForeignFunctionMemoryExample.storeAndReadInt(-42)
        );
    }

    @Test
    void shouldStoreAndReadZero() {
        assertEquals(
            0,
            ForeignFunctionMemoryExample.storeAndReadInt(0)
        );
    }

    @Test
    void shouldSumTwoPositiveIntegersUsingNativeMemory() {
        assertEquals(
            30,
            ForeignFunctionMemoryExample.sumUsingNativeMemory(10, 20)
        );
    }

    @Test
    void shouldSumPositiveAndNegativeIntegersUsingNativeMemory() {
        assertEquals(
            5,
            ForeignFunctionMemoryExample.sumUsingNativeMemory(10, -5)
        );
    }

    @Test
    void shouldSumTwoNegativeIntegersUsingNativeMemory() {
        assertEquals(
            -30,
            ForeignFunctionMemoryExample.sumUsingNativeMemory(-10, -20)
        );
    }

    @Test
    void shouldHandleIntegerBoundaries() {
        assertEquals(
            Integer.MAX_VALUE,
            ForeignFunctionMemoryExample.sumUsingNativeMemory(
                Integer.MAX_VALUE,
                0
            )
        );
    }
}
