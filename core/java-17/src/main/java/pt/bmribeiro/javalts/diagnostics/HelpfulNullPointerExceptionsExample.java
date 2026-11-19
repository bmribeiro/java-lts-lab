package pt.bmribeiro.javalts.diagnostics;

/**
 * Helpful NullPointerExceptions
 *
 * JEP: 358
 * Introduced: Java 14
 * Target Version: Java 17
 * Category: JVM Diagnostics
 */
public class HelpfulNullPointerExceptionsExample {

    public record Customer(String name) {
    }

    public String getCustomerName(Customer customer) {
        return customer.name().toUpperCase();
    }

    public int getCustomerNameLength(Customer customer) {
        return customer.name().length();
    }
}
