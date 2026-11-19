package pt.bmribeiro.javalts.gc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZGcExampleTest {

    private ZGcExample example;

    @BeforeEach
    void setUp() {
        example = new ZGcExample();
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
    void shouldIdentifyZGcWhenActive() {
        boolean active = example.isZGcActive();

        boolean collectorExists = example
            .getAvailableGarbageCollectors()
            .stream()
            .anyMatch(name ->
                name.toLowerCase().contains("zgc"));

        assertEquals(collectorExists, active);
    }

    @Test
    void shouldReturnConsistentZGcStatus() {
        String status = example.getZGcStatus();

        if (example.isZGcActive()) {
            assertEquals("ZGC is active.", status);
        } else {
            assertEquals("ZGC is not active.", status);
        }
    }
}
