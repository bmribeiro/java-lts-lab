
package pt.bmribeiro.javalts.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Demonstrates Z Garbage Collector discovery and monitoring.
 *
 * JEP: 377
 * Introduced: Java 11 (Experimental)
 * Finalized: Java 15
 * Target Version: Java 17
 * Category: JVM / Garbage Collection
 */
public class ZGcExample {

    public List<String> getAvailableGarbageCollectors() {
        return ManagementFactory.getGarbageCollectorMXBeans()
            .stream()
            .map(GarbageCollectorMXBean::getName)
            .sorted()
            .toList();
    }

    public boolean isZGcActive() {
        return getAvailableGarbageCollectors()
            .stream()
            .anyMatch(name ->
                name.toLowerCase().contains("zgc"));
    }

    public String getZGcStatus() {
        return isZGcActive()
            ? "ZGC is active."
            : "ZGC is not active.";
    }
}
