
package pt.bmribeiro.javalts.jvm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompactObjectHeadersExampleTest {

    private CompactObjectHeadersExample example;

    @BeforeEach
    void setUp() {
        example = new CompactObjectHeadersExample();
    }

    @Test
    void shouldRunWithCompactObjectHeadersEnabled() {
        assertTrue(example.areCompactObjectHeadersEnabled());
    }

    @Test
    void shouldCreateRequestedNumberOfCustomers() {
        List<CompactObjectHeadersExample.Customer> customers =
            example.createCustomers(100);

        assertEquals(100, customers.size());
    }

    @Test
    void shouldCreateCustomersWithExpectedValues() {
        List<CompactObjectHeadersExample.Customer> customers =
            example.createCustomers(2);

        assertEquals(
            new CompactObjectHeadersExample.Customer(
                0,
                "Customer-0"
            ),
            customers.getFirst()
        );

        assertEquals(
            new CompactObjectHeadersExample.Customer(
                1,
                "Customer-1"
            ),
            customers.getLast()
        );
    }

    @Test
    void shouldReturnEmptyListWhenCountIsZero() {
        assertTrue(example.createCustomers(0).isEmpty());
    }

    @Test
    void shouldRejectNegativeCount() {
        assertThrows(
            IllegalArgumentException.class,
            () -> example.createCustomers(-1)
        );
    }
}
