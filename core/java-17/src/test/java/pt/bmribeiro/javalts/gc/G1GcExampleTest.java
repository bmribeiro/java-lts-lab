
package pt.bmribeiro.javalts.gc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class G1GcExampleTest {

    private G1GcExample example;

    @BeforeEach
    void setUp() {
        example = new G1GcExample();
    }

    @Test
    void shouldReturnAvailableGarbageCollectors() {
        List<String> collectors =
            example.getAvailableGarbageCollectors();

        assertNotNull(collectors);
        assertFalse(collectors.isEmpty());
    }

    @Test
    void shouldReturnSortedGarbageCollectors() {
        List<String> collectors =
            example.getAvailableGarbageCollectors();

        List<String> sortedCollectors = collectors.stream()
            .sorted()
            .toList();

        assertEquals(sortedCollectors, collectors);
    }

    @Test
    void shouldIdentifyG1WhenActive() {
        boolean active = example.isG1Active();

        boolean collectorExists = example
            .getAvailableGarbageCollectors()
            .stream()
            .anyMatch(name ->
                name.toLowerCase().contains("g1"));

        assertEquals(collectorExists, active);
    }

    @Test
    void shouldReturnConsistentG1Status() {
        String status = example.getG1Status();

        if (example.isG1Active()) {
            assertEquals(
                "G1 Garbage Collector is active.",
                status
            );
        } else {
            assertEquals(
                "G1 Garbage Collector is not active.",
                status
            );
        }
    }

    @Test
    void shouldReturnNonNegativeUsedHeapMemory() {
        assertTrue(example.getUsedHeapMemory() >= 0);
    }

    @Test
    void shouldReturnNonNegativeCommittedHeapMemory() {
        assertTrue(example.getCommittedHeapMemory() >= 0);
    }

    @Test
    void shouldReturnNonNegativeUnusedCommittedHeapMemory() {
        long unusedMemory = example.getUnusedCommittedHeapMemory();

        assertTrue(unusedMemory >= 0);
    }
}
