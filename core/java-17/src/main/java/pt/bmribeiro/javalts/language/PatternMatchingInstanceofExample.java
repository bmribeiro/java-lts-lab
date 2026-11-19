
package pt.bmribeiro.javalts.language;

/**
 * Pattern Matching for instanceof
 *
 * JEP: 394
 * Introduced: Java 14 (Preview)
 * Second Preview: Java 15
 * Finalized: Java 16
 * Target Version: Java 17
 * Category: Language Features
 */
public class PatternMatchingInstanceofExample {

    public String describe(Object value) {

        if (value instanceof String text) {
            return "String with length: " + text.length();
        }

        return "Unknown type";
    }

    public String describeLongString(Object value) {

        if (value instanceof String text && text.length() > 5) {
            return "Long string";
        }

        return "Short string or unknown type";
    }

    public String describeNegatedPattern(Object value) {

        if (!(value instanceof String text)) {
            return "Not a string";
        }

        return "String with length: " + text.length();
    }

    public int getNumericValue(Object value) {

        if (value instanceof Integer number) {
            return number * 2;
        }

        return 0;
    }

    public String identifyType(Object value) {

        if (value instanceof String text) {
            return "String: " + text;
        }

        if (value instanceof Integer number) {
            return "Integer: " + number;
        }

        if (value instanceof Double decimal) {
            return "Double: " + decimal;
        }

        return "Unknown type";
    }
}
