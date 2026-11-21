
package pt.bmribeiro.javalts.concurrency;

import java.util.concurrent.StructuredTaskScope;

/**
 * Demonstrates Structured Concurrency introduced through JEP 505.
 *
 * JEP: 505 - Structured Concurrency (Fifth Preview)
 * Introduced: Java 19 (JEP 428 - Incubator)
 * Preview: Java 21 (JEP 453)
 * Additional previews: Java 22 (JEP 462), Java 23 (JEP 480),
 *                      Java 24 (JEP 499), Java 25 (JEP 505)
 * Finalized: Not finalized in Java 25
 * Compilation: Java 25 with --enable-preview
 * Category: Concurrency
 *
 * The example retrieves product information and available stock
 * concurrently, treating both operations as a single unit of work.
 */
public class StructuredConcurrencyExample {

    public record ProductSummary(String productName, int availableStock) {
    }

    /**
     * Retrieves product information and stock concurrently.
     *
     * Both subtasks belong to the same structured scope.
     * If either subtask fails, the default policy cancels the other.
     *
     * @param productId product identifier
     * @return combined product information
     * @throws InterruptedException if the owner thread is interrupted
     */
    public static ProductSummary loadProductSummary(String productId)
        throws InterruptedException {

        try (var scope = StructuredTaskScope.open()) {

            StructuredTaskScope.Subtask<String> productTask =
                scope.fork(() -> fetchProductName(productId));

            StructuredTaskScope.Subtask<Integer> stockTask =
                scope.fork(() -> fetchAvailableStock(productId));

            // Wait for all subtasks to succeed.
            // If one fails, the scope cancels the remaining subtasks.
            scope.join();

            return new ProductSummary(
                productTask.get(),
                stockTask.get()
            );
        }
    }

    private static String fetchProductName(String productId) {
        return "Product " + productId;
    }

    private static int fetchAvailableStock(String productId) {
        if ("FAIL".equals(productId)) {
            throw new IllegalStateException(
                "Inventory service is unavailable"
            );
        }

        return 150;
    }

    public static void main(String[] args) throws InterruptedException {

        ProductSummary summary = loadProductSummary("PRD-001");

        System.out.println("Product: " + summary.productName());
        System.out.println("Available stock: " + summary.availableStock());
    }
}
