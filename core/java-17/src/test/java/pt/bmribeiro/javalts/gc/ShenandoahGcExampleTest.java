
package pt.bmribeiro.javalts.gc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShenandoahGcExampleTest {

    private ShenandoahGcExample example;

    @BeforeEach
    void setUp() {
        example = new ShenandoahGcExample();
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
    void shouldIdentifyShenandoahWhenActive() {
        boolean active = example.isShenandoahActive();

        boolean collectorExists = example
            .getAvailableGarbageCollectors()
            .stream()
            .anyMatch(name ->
                name.toLowerCase().contains("shenandoah"));

        assertEquals(collectorExists, active);
    }

    @Test
    void shouldReturnConsistentGarbageCollectorStatus() {
        String status = example.getGarbageCollectorStatus();

        if (example.isShenandoahActive()) {
            assertEquals(
                "Shenandoah Garbage Collector is active.",
                status
            );
        } else {
            assertEquals(
                "Shenandoah Garbage Collector is not active.",
                status
            );
        }
    }
}
