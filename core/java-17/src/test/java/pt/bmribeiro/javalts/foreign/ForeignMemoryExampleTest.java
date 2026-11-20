
package pt.bmribeiro.javalts.foreign;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForeignMemoryExampleTest {

    private ForeignMemoryExample example;

    @BeforeEach
    void setUp() {
        example = new ForeignMemoryExample();
    }

    @Test
    void shouldStoreAndReadPositiveInteger() {
        int result = example.storeAndReadInteger(42);

        assertEquals(42, result);
    }

    @Test
    void shouldStoreAndReadNegativeInteger() {
        int result = example.storeAndReadInteger(-123);

        assertEquals(-123, result);
    }

    @Test
    void shouldStoreAndReadZero() {
        int result = example.storeAndReadInteger(0);

        assertEquals(0, result);
    }

    @Test
    void shouldStoreAndReadMaximumInteger() {
        int result = example.storeAndReadInteger(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void shouldStoreAndReadMinimumInteger() {
        int result = example.storeAndReadInteger(Integer.MIN_VALUE);

        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void shouldReturnIntegerSizeInBytes() {
        long result = example.getIntegerSize();

        assertEquals(Integer.BYTES, result);
    }

    @Test
    void shouldReturnAllocatedMemorySize() {
        long result = example.getAllocatedMemorySize();

        assertEquals(Integer.BYTES, result);
    }
}
