package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PatternMatchingSwitchExampleTest {

    @Test
    void shouldMatchStringPattern() {
        assertEquals(
            "String: Java",
            PatternMatchingSwitchExample.describe("Java")
        );
    }

    @Test
    void shouldMatchIntegerPattern() {
        assertEquals(
            "Integer: 21",
            PatternMatchingSwitchExample.describe(21)
        );
    }

    @Test
    void shouldMatchDoublePattern() {
        assertEquals(
            "Double: 21.5",
            PatternMatchingSwitchExample.describe(21.5)
        );
    }

    @Test
    void shouldMatchBooleanPattern() {
        assertEquals(
            "Boolean: true",
            PatternMatchingSwitchExample.describe(true)
        );
    }

    @Test
    void shouldHandleNullValue() {
        assertEquals(
            "Null value",
            PatternMatchingSwitchExample.describe(null)
        );
    }

    @Test
    void shouldHandleUnknownType() {
        assertEquals(
            "Unknown type",
            PatternMatchingSwitchExample.describe(new Object())
        );
    }

    @Test
    void shouldClassifyPositiveInteger() {
        assertEquals(
            "Positive",
            PatternMatchingSwitchExample.classify(10)
        );
    }

    @Test
    void shouldClassifyNegativeInteger() {
        assertEquals(
            "Negative",
            PatternMatchingSwitchExample.classify(-10)
        );
    }

    @Test
    void shouldClassifyZero() {
        assertEquals(
            "Zero",
            PatternMatchingSwitchExample.classify(0)
        );
    }

    @Test
    void shouldHandleNonIntegerValue() {
        assertEquals(
            "Not an integer",
            PatternMatchingSwitchExample.classify("Java")
        );
    }

    @Test
    void shouldCalculateCardPayment() {
        var payment =
            new PatternMatchingSwitchExample.CardPayment(150.0);

        assertEquals(
            150.0,
            PatternMatchingSwitchExample.calculatePayment(payment)
        );
    }

    @Test
    void shouldCalculateCashPayment() {
        var payment =
            new PatternMatchingSwitchExample.CashPayment(75.0);

        assertEquals(
            75.0,
            PatternMatchingSwitchExample.calculatePayment(payment)
        );
    }

    @Test
    void shouldRejectNullPayment() {
        assertThrows(
            NullPointerException.class,
            () -> PatternMatchingSwitchExample.calculatePayment(null)
        );
    }
}
