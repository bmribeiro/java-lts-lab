
package pt.bmribeiro.javalts.language;

import java.util.List;

/**
 * Demonstrates Unnamed Patterns and Variables, a Preview language
 * feature introduced in Java 21.
 *
 * <p>The underscore character (_) represents an unnamed pattern
 * or variable when its value is not required.</p>
 *
 * <p>This feature reduces unnecessary declarations and makes
 * pattern matching code more concise.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>Unnamed patterns can ignore record components.</li>
 *   <li>Unnamed type patterns can match a type without binding its value.</li>
 *   <li>Unnamed variables can be used when a declared value is not needed.</li>
 *   <li>Multiple unnamed variables can be used in the same scope.</li>
 *   <li>An unnamed variable cannot be read or assigned.</li>
 *   <li>The underscore is not a conventional variable identifier.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 443</p>
 * <p>Introduced: Java 21</p>
 * <p>Preview: Java 21 (JEP 443)</p>
 * <p>Finalized: Not finalized in Java 21</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Language Features</p>
 *
 * @see <a href="https://openjdk.org/jeps/443">
 *     JEP 443: Unnamed Patterns and Variables (Preview)</a>
 */
public final class UnnamedPatternsVariablesExample {

    private UnnamedPatternsVariablesExample() {
    }

    /**
     * Describes a point using only its X coordinate.
     *
     * <p>The Y coordinate is intentionally ignored.</p>
     *
     * @param value object to inspect
     * @return description of the point or an indication of no match
     */
    public static String describePoint(Object value) {
        if (value instanceof Point(int x, _)) {
            return "X coordinate: " + x;
        }

        return "Not a point";
    }

    /**
     * Identifies supported value types without binding their values.
     *
     * @param value object to inspect
     * @return the detected type description
     */
    public static String describeType(Object value) {
        return switch (value) {
            case String _ -> "String";
            case Integer _ -> "Integer";
            case Double _ -> "Double";
            case null -> "Null";
            default -> "Other";
        };
    }

    /**
     * Counts the elements without using the loop variable.
     *
     * @param values list of values
     * @return number of elements
     */
    public static int countElements(List<String> values) {
        int count = 0;

        for (String _ : values) {
            count++;
        }

        return count;
    }

    /**
     * Represents a two-dimensional point.
     *
     * @param x horizontal coordinate
     * @param y vertical coordinate
     */
    public record Point(int x, int y) {
    }
}
