
package pt.bmribeiro.javalts.language;

import java.lang.StringTemplate;
import java.util.Locale;

import static java.lang.StringTemplate.RAW;

/**
 * Demonstrates String Templates, a Preview language feature
 * introduced in Java 21.
 *
 * <p>String Templates combine literal text with embedded Java
 * expressions. A template processor evaluates the template and
 * produces the resulting value.</p>
 *
 * <p>The STR processor performs standard string interpolation.
 * Custom processors can implement additional processing,
 * validation or transformation.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>Embedded expressions use the syntax \{expression}.</li>
 *   <li>STR is the built-in processor for string interpolation.</li>
 *   <li>Template expressions are evaluated by a processor.</li>
 *   <li>StringTemplate exposes fragments() and values().</li>
 *   <li>Custom processors implement StringTemplate.Processor.</li>
 *   <li>Template processors can return types other than String.</li>
 *   <li>String Templates are not equivalent to simple concatenation:
 *       processors can validate or transform template contents.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 430</p>
 * <p>Introduced: Java 21</p>
 * <p>Preview: Java 21 (JEP 430)</p>
 * <p>Finalized: Not finalized; withdrawn after the Java 22 preview</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Language Features</p>
 *
 * @see <a href="https://openjdk.org/jeps/430">
 *     JEP 430: String Templates (Preview)</a>
 */
public final class StringTemplatesExample {

    /**
     * Custom processor that converts the interpolated template
     * result to uppercase.
     */
    private static final StringTemplate.Processor<String, RuntimeException>
        UPPERCASE = template ->
        StringTemplate.interpolate(
            template.fragments(),
            template.values()
        ).toUpperCase(Locale.ROOT);

    private StringTemplatesExample() {
    }

    /**
     * Interpolates a name and age into a string template.
     *
     * @param name person's name
     * @param age person's age
     * @return interpolated string
     */
    public static String createGreeting(String name, int age) {
        return STR."Hello, \{name}! You are \{age} years old.";
    }

    /**
     * Evaluates Java expressions inside a string template.
     *
     * @param firstName first name
     * @param lastName last name
     * @return interpolated full name
     */
    public static String createFullName(
        String firstName,
        String lastName) {

        return STR."Full name: \{firstName + " " + lastName}";
    }

    /**
     * Processes a string template using a custom uppercase processor.
     *
     * @param name person's name
     * @return uppercase interpolated string
     */
    public static String createUppercaseGreeting(String name) {
        return UPPERCASE."Hello, \{name}!";
    }

    /**
     * Returns the fragments of a raw string template.
     *
     * @param name person's name
     * @return immutable list of template fragments
     */
    public static java.util.List<String> getTemplateFragments(
        String name) {

        StringTemplate template = RAW."Hello, \{name}!";

        return template.fragments();
    }

    public static void main(String[] args) {
        System.out.println(createGreeting("Bruno", 42));

        System.out.println(createFullName("Bruno", "Ribeiro"));

        System.out.println(createUppercaseGreeting("Bruno"));

        System.out.println(getTemplateFragments("Bruno"));
    }
}
