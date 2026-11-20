
package pt.bmribeiro.javalts.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Demonstrates G1 Garbage Collector monitoring.
 *
 * JEP: 344, 346
 * Introduced: Java 12
 * Finalized: Java 12
 * Target Version: Java 17
 * Category: JVM / Garbage Collection
 */
public class G1GcExample {

    public List<String> getAvailableGarbageCollectors() {
        return ManagementFactory.getGarbageCollectorMXBeans()
            .stream()
            .map(GarbageCollectorMXBean::getName)
            .sorted()
            .toList();
    }

    public boolean isG1Active() {
        return getAvailableGarbageCollectors()
            .stream()
            .anyMatch(name ->
                name.toLowerCase().contains("g1"));
    }

    public String getG1Status() {
        return isG1Active()
            ? "G1 Garbage Collector is active."
            : "G1 Garbage Collector is not active.";
    }

    public long getUsedHeapMemory() {
        return ManagementFactory.getMemoryMXBean()
            .getHeapMemoryUsage()
            .getUsed();
    }

    public long getCommittedHeapMemory() {
        return ManagementFactory.getMemoryMXBean()
            .getHeapMemoryUsage()
            .getCommitted();
    }

    public long getUnusedCommittedHeapMemory() {
        return getCommittedHeapMemory() - getUsedHeapMemory();
    }
}
