
package pt.bmribeiro.javalts.jvm;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Demonstrates an application suitable for Ahead-of-Time
 * class loading and linking cache generation.
 *
 * JEP: 514
 * Feature: Ahead-of-Time Command-Line Ergonomics
 * Introduced: Java 25
 * Status: Final
 * Category: JVM / Performance
 *
 * Generate an AOT cache with:
 * -XX:AOTCacheOutput=target/application.aot
 *
 * Run with the generated cache:
 * -XX:AOTCache=target/application.aot
 *
 * AOT cache generation is a JVM launcher operation.
 */
public class AheadOfTimeCommandLineExample {

    /**
     * Creates and processes a representative workload.
     *
     * The workload exercises application classes and common
     * JDK classes during the training run.
     */
    public int processCustomers(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(
                "Count cannot be negative"
            );
        }

        List<Customer> customers = IntStream.range(0, count)
            .mapToObj(id -> new Customer(id, "Customer-" + id))
            .toList();

        return customers.stream()
            .mapToInt(Customer::id)
            .sum();
    }

    public record Customer(int id, String name) {
    }

    public static void main(String[] args) {
        AheadOfTimeCommandLineExample example =
            new AheadOfTimeCommandLineExample();

        int customerCount = 100_000;
        int result = example.processCustomers(customerCount);

        System.out.println("AOT demonstration application");
        System.out.println("Customers processed: " + customerCount);
        System.out.println("Processing result: " + result);
    }
}
