
package pt.bmribeiro.javalts.gc;

import java.util.List;

/**
 * Demonstrates the configuration of Generational ZGC in Java 21.
 *
 * <p>Generational ZGC divides the heap into young and old generations.
 * This allows the garbage collector to focus more frequently on
 * short-lived objects while managing long-lived objects separately.</p>
 *
 * <p>Unlike application-level APIs, garbage collector selection is
 * configured through JVM command-line options.</p>
 *
 * <p>Java 21 JVM configuration:
 * <pre>
 * -XX:+UseZGC -XX:+ZGenerational
 * </pre>
 * </p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>ZGC is a low-latency garbage collector.</li>
 *   <li>Generational ZGC separates young and old objects.</li>
 *   <li>Young objects are generally collected more frequently.</li>
 *   <li>GC execution is largely concurrent with application threads.</li>
 *   <li>Garbage collection timing is non-deterministic.</li>
 *   <li>GC performance must be evaluated using representative workloads.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 439</p>
 * <p>Introduced: Java 21</p>
 * <p>Preview: Not applicable</p>
 * <p>Finalized: Java 21</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Garbage Collection</p>
 *
 * @see <a href="https://openjdk.org/jeps/439">JEP 439: Generational ZGC</a>
 */
public final class GenerationalZGCExample {

    private GenerationalZGCExample() {
    }

    /**
     * Returns the JVM options required to enable Generational ZGC
     * in Java 21.
     *
     * @return immutable list of JVM options
     */
    public static List<String> generationalZgcJvmOptions() {
        return List.of(
            "-XX:+UseZGC",
            "-XX:+ZGenerational"
        );
    }

    /**
     * Returns the JVM option used to enable garbage collection logging.
     *
     * @return GC logging option
     */
    public static String garbageCollectionLoggingOption() {
        return "-Xlog:gc";
    }

    public static void main(String[] args) {
        System.out.println("Generational ZGC JVM options:");

        generationalZgcJvmOptions()
            .forEach(System.out::println);

        System.out.println(garbageCollectionLoggingOption());
    }
}
