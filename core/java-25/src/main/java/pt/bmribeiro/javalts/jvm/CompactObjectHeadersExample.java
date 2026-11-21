
package pt.bmribeiro.javalts.jvm;

import com.sun.management.HotSpotDiagnosticMXBean;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Demonstrates the Compact Object Headers JVM feature.
 *
 * JEP: 519
 * Feature: Compact Object Headers
 * Introduced: Java 24 (JEP 450, Experimental)
 * Finalized: Java 25 (JEP 519)
 * Status: Final
 * Category: JVM / Performance
 *
 * Enable with:
 * -XX:+UseCompactObjectHeaders
 *
 * This is a JVM-level optimization. It does not require
 * changes to application object definitions.
 */
public class CompactObjectHeadersExample {

    /**
     * Checks the effective value of the Compact Object Headers
     * JVM option through the HotSpot diagnostic management interface.
     */
    public boolean areCompactObjectHeadersEnabled() {
        HotSpotDiagnosticMXBean bean =
            ManagementFactory.getPlatformMXBean(
                HotSpotDiagnosticMXBean.class
            );

        return bean != null
            && Boolean.parseBoolean(
            bean.getVMOption("UseCompactObjectHeaders").getValue()
        );
    }

    /**
     * Creates a collection containing a large number of small objects.
     */
    public List<Customer> createCustomers(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(
                "Count cannot be negative"
            );
        }

        return IntStream.range(0, count)
            .mapToObj(id -> new Customer(id, "Customer-" + id))
            .toList();
    }

    /**
     * Small immutable domain object.
     */
    public record Customer(long id, String name) {
    }

    public static void main(String[] args) {
        CompactObjectHeadersExample example =
            new CompactObjectHeadersExample();

        List<Customer> customers = example.createCustomers(1_000_000);

        System.out.println(
            "Compact Object Headers enabled: "
                + example.areCompactObjectHeadersEnabled()
        );

        System.out.println("Customers created: " + customers.size());
        System.out.println("First customer: " + customers.getFirst());
    }
}
