
package pt.bmribeiro.javalts.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates JVM Garbage Collector discovery,
 * including the Shenandoah Garbage Collector.
 *
 * JEP: 379
 * Introduced: Java 12 (Experimental)
 * Finalized: Java 15
 * Target Version: Java 17
 * Category: JVM / Garbage Collection
 */
public class ShenandoahGcExample {

    public List<String> getAvailableGarbageCollectors() {
        return ManagementFactory.getGarbageCollectorMXBeans()
            .stream()
            .map(GarbageCollectorMXBean::getName)
            .sorted()
            .collect(Collectors.toList());
    }

    public boolean isShenandoahActive() {
        return getAvailableGarbageCollectors()
            .stream()
            .anyMatch(name ->
                name.toLowerCase().contains("shenandoah"));
    }

    public String getGarbageCollectorStatus() {
        return isShenandoahActive()
            ? "Shenandoah Garbage Collector is active."
            : "Shenandoah Garbage Collector is not active.";
    }
}
