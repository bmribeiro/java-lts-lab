
package pt.bmribeiro.javalts.gc;

import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Demonstrates JVM thread monitoring in the context
 * of ZGC concurrent thread-stack processing.
 *
 * JEP: 376
 * Introduced: Java 16
 * Finalized: Java 16
 * Target Version: Java 17
 * Category: JVM / Garbage Collection
 */
public class ZGcConcurrentStackProcessingExample {

    public boolean isZGcActive() {
        return ManagementFactory.getGarbageCollectorMXBeans()
            .stream()
            .anyMatch(gc ->
                gc.getName()
                    .toLowerCase()
                    .contains("zgc"));
    }

    public int getActiveThreadCount() {
        return ManagementFactory.getThreadMXBean()
            .getThreadCount();
    }

    public int getPeakThreadCount() {
        return ManagementFactory.getThreadMXBean()
            .getPeakThreadCount();
    }

    public List<String> getActiveThreadNames() {
        return ManagementFactory.getThreadMXBean()
            .dumpAllThreads(false, false)
            .length == 0
            ? List.of()
            : ManagementFactory.getThreadMXBean()
            .dumpAllThreads(false, false)
            .length > 0
            ? java.util.Arrays.stream(
                ManagementFactory.getThreadMXBean()
                    .dumpAllThreads(false, false))
            .map(thread -> thread.getThreadName())
            .sorted()
            .toList()
            : List.of();
    }

    public String getZGcStatus() {
        return isZGcActive()
            ? "ZGC is active with concurrent thread-stack processing."
            : "ZGC is not active.";
    }
}
