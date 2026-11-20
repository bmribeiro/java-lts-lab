
package pt.bmribeiro.javalts.language;

/**
 * Demonstrates Pattern Matching for switch finalized by JEP 441.
 *
 * <h2>Introduction</h2>
 * Pattern Matching for switch allows switch expressions and statements
 * to match values against type patterns, eliminating repetitive
 * instanceof checks and explicit casts.
 *
 * It supports type patterns, null labels, guarded patterns using
 * the when keyword, and exhaustive pattern matching.
 *
 * <h2>Key Concepts</h2>
 * <ul>
 *     <li>Type patterns directly in switch labels.</li>
 *     <li>Guarded patterns using the when keyword.</li>
 *     <li>Explicit null handling with case null.</li>
 *     <li>Exhaustiveness checking for switch expressions.</li>
 *     <li>Pattern dominance and ordering.</li>
 * </ul>
 *
 * <h2>Interview Notes</h2>
 * <ul>
 *     <li>
 *         Pattern Matching vs instanceof:
 *         Pattern Matching for switch centralizes type checks and
 *         branching logic in a single construct.
 *     </li>
 *     <li>
 *         Guarded Patterns:
 *         The when clause adds a boolean condition to a pattern.
 *     </li>
 *     <li>
 *         Dominance:
 *         A broader pattern cannot precede a narrower pattern
 *         when it would make the narrower case unreachable.
 *     </li>
 *     <li>
 *         Exhaustiveness:
 *         Switch expressions must cover all possible input values.
 *     </li>
 * </ul>
 *
 * JEP: 441
 * Introduced: Java 17 (JEP 406)
 * Preview: Java 17, 18, 19, 20, 21
 * Finalized: Java 21
 * Target Version: Java 21
 * Category: Language Features
 *
 * @see <a href="https://openjdk.org/jeps/441">JEP 441: Pattern Matching for switch</a>
 */
public final class PatternMatchingSwitchExample {

    private PatternMatchingSwitchExample() {
    }

    /**
     * Describes a value based on its type.
     *
     * @param value the value to inspect
     * @return a description of the value
     */
    public static String describe(Object value) {

        return switch (value) {
            case null -> "Null value";
            case String text -> "String: " + text;
            case Integer number -> "Integer: " + number;
            case Double number -> "Double: " + number;
            case Boolean flag -> "Boolean: " + flag;
            default -> "Unknown type";
        };
    }

    /**
     * Classifies an integer using a guarded pattern.
     *
     * @param value the value to classify
     * @return the corresponding classification
     */
    public static String classify(Object value) {

        return switch (value) {
            case Integer number when number > 0 -> "Positive";
            case Integer number when number < 0 -> "Negative";
            case Integer number -> "Zero";
            default -> "Not an integer";
        };
    }

    /**
     * Calculates a payment amount based on its payment type.
     *
     * @param payment the payment to process
     * @return the payment amount
     */
    public static double calculatePayment(Payment payment) {

        return switch (payment) {
            case CardPayment card -> card.amount();
            case CashPayment cash -> cash.amount();
        };
    }

    /**
     * Represents a sealed payment hierarchy.
     */
    public sealed interface Payment
        permits CardPayment, CashPayment {
    }

    /**
     * Represents a card payment.
     *
     * @param amount payment amount
     */
    public record CardPayment(double amount) implements Payment {
    }

    /**
     * Represents a cash payment.
     *
     * @param amount payment amount
     */
    public record CashPayment(double amount) implements Payment {
    }
}
