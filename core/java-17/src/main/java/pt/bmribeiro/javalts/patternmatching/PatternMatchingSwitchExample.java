
package pt.bmribeiro.javalts.patternmatching;

/**
 * JEP: 406
 * Introduced: Java 17
 * Preview: Java 17
 * Second Preview: Java 18 (JEP 420)
 * Third Preview: Java 19 (JEP 427)
 * Finalized: Java 21 (JEP 441)
 * Target Version: Java 17
 * Category: Language Features
 *
 * Demonstrates pattern matching for switch,
 * using type patterns and guarded patterns.
 */
public class PatternMatchingSwitchExample {

    public String describe(Object value) {
        return switch (value) {
            case null -> "Null value";
            case String text -> "String: " + text;
            case Integer number -> "Integer: " + number;
            case Double number -> "Double: " + number;
            case Boolean flag -> "Boolean: " + flag;
            default -> "Unknown type";
        };
    }

    public String classify(Object value) {
        return switch (value) {
            case null -> "Null";

            case String text && text.isBlank() ->
                "Empty string";

                case String text ->
                    "Non-empty string";

            case Integer number && number > 0 ->
                "Positive integer";

            case Integer number && number < 0 ->
                "Negative integer";

                case Integer number ->
                    "Zero";

                default -> "Other";
        };
    }
}
