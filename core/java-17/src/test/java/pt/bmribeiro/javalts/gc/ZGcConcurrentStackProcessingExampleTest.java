
package pt.bmribeiro.javalts.gc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZGcConcurrentStackProcessingExampleTest {

    private ZGcConcurrentStackProcessingExample example;

    @BeforeEach
    void setUp() {
        example = new ZGcConcurrentStackProcessingExample();
    }

    @Test
    void shouldIdentifyZGcConsistently() {
        boolean active = example.isZGcActive();

        boolean collectorExists =
            java.lang.management.ManagementFactory
                .getGarbageCollectorMXBeans()
                .stream()
                .anyMatch(gc -> gc.getName()
                    .toLowerCase()
                    .contains("zgc"));

        assertEquals(collectorExists, active);
    }

    @Test
    void shouldReturnPositiveActiveThreadCount() {
        assertTrue(example.getActiveThreadCount() > 0);
    }

    @Test
    void shouldReturnPositivePeakThreadCount() {
        assertTrue(example.getPeakThreadCount() > 0);
    }

    @Test
    void shouldReturnActiveThreadNames() {
        List<String> threadNames = example.getActiveThreadNames();

        assertNotNull(threadNames);
        assertFalse(threadNames.isEmpty());
        assertTrue(threadNames.stream()
            .allMatch(name -> name != null && !name.isBlank()));
    }

    @Test
    void shouldReturnSortedThreadNames() {
        List<String> threadNames = example.getActiveThreadNames();

        List<String> sortedNames = threadNames.stream()
            .sorted()
            .toList();

        assertEquals(sortedNames, threadNames);
    }

    @Test
    void shouldReturnConsistentZGcStatus() {
        String status = example.getZGcStatus();

        if (example.isZGcActive()) {
            assertEquals(
                "ZGC is active with concurrent thread-stack processing.",
                status
            );
        } else {
            assertEquals(
                "ZGC is not active.",
                status
            );
        }
    }
}
