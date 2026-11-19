package pt.bmribeiro.javalts.diagnostics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HelpfulNullPointerExceptionsExampleTest {

    private final HelpfulNullPointerExceptionsExample example =
        new HelpfulNullPointerExceptionsExample();

    @Test
    void shouldReturnCustomerNameInUpperCase() {
        var customer =
            new HelpfulNullPointerExceptionsExample.Customer("Bruno");

        assertEquals("BRUNO", example.getCustomerName(customer));
    }

    @Test
    void shouldReturnCustomerNameLength() {
        var customer =
            new HelpfulNullPointerExceptionsExample.Customer("Bruno");

        assertEquals(5, example.getCustomerNameLength(customer));
    }

    @Test
    void shouldThrowNullPointerExceptionWhenCustomerIsNull() {
        assertThrows(
            NullPointerException.class,
            () -> example.getCustomerName(null)
        );
    }

    @Test
    void shouldThrowNullPointerExceptionWhenCustomerNameIsNull() {
        var customer =
            new HelpfulNullPointerExceptionsExample.Customer(null);

        assertThrows(
            NullPointerException.class,
            () -> example.getCustomerName(customer)
        );
    }

    @Test
    void shouldThrowNullPointerExceptionWhenGettingLengthOfNullName() {
        var customer =
            new HelpfulNullPointerExceptionsExample.Customer(null);

        assertThrows(
            NullPointerException.class,
            () -> example.getCustomerNameLength(customer)
        );
    }
}
