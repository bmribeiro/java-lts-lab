
package pt.bmribeiro.javalts.concurrency;

import java.util.concurrent.StructuredTaskScope;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StructuredConcurrencyExampleTest {

    @Test
    void shouldRetrieveProductAndStockConcurrently()
        throws InterruptedException {

        StructuredConcurrencyExample.ProductSummary result =
            StructuredConcurrencyExample.loadProductSummary("PRD-001");

        assertEquals("Product PRD-001", result.productName());
        assertEquals(150, result.availableStock());
    }

    @Test
    void shouldRetrieveDifferentProductIdentifiers()
        throws InterruptedException {

        StructuredConcurrencyExample.ProductSummary result =
            StructuredConcurrencyExample.loadProductSummary("PRD-002");

        assertEquals("Product PRD-002", result.productName());
        assertEquals(150, result.availableStock());
    }

    @Test
    void shouldPropagateFailureWhenSubtaskFails() {

        StructuredTaskScope.FailedException exception =
            assertThrows(
                StructuredTaskScope.FailedException.class,
                () -> StructuredConcurrencyExample
                    .loadProductSummary("FAIL")
            );

        assertInstanceOf(
            IllegalStateException.class,
            exception.getCause()
        );

        assertEquals(
            "Inventory service is unavailable",
            exception.getCause().getMessage()
        );
    }
}
