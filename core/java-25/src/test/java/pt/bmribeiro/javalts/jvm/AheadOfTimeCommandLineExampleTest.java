
package pt.bmribeiro.javalts.jvm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AheadOfTimeCommandLineExampleTest {

    private AheadOfTimeCommandLineExample example;

    @BeforeEach
    void setUp() {
        example = new AheadOfTimeCommandLineExample();
    }

    @Test
    void shouldProcessCustomersAndCalculateSum() {
        assertEquals(45, example.processCustomers(10));
    }

    @Test
    void shouldReturnZeroWhenNoCustomersExist() {
        assertEquals(0, example.processCustomers(0));
    }

    @Test
    void shouldProcessSingleCustomer() {
        assertEquals(0, example.processCustomers(1));
    }

    @Test
    void shouldRejectNegativeCustomerCount() {
        assertThrows(
            IllegalArgumentException.class,
            () -> example.processCustomers(-1)
        );
    }
}
