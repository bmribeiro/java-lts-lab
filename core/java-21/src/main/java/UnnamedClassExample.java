
import java.util.List;

/**
 * Demonstrates Unnamed Classes and Instance Main Methods,
 * a Preview language feature introduced in Java 21.
 *
 * <p>An unnamed class allows a source file to contain fields,
 * methods and an instance main method without an explicit
 * class declaration.</p>
 *
 * <p>Instance main methods allow the Java launcher to execute
 * a non-static main method, creating an instance of the class
 * automatically.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>An unnamed class has no explicit class declaration.</li>
 *   <li>Unnamed classes belong to the unnamed package.</li>
 *   <li>An instance main method does not need to be static.</li>
 *   <li>The launcher creates an instance to invoke the main method.</li>
 *   <li>The feature supports simpler entry points for small programs.</li>
 *   <li>Preview features require --enable-preview.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 445</p>
 * <p>Introduced: Java 21</p>
 * <p>Preview: Java 21 (JEP 445)</p>
 * <p>Finalized: Not finalized in Java 21</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Language Features</p>
 *
 * @see <a href="https://openjdk.org/jeps/445">
 *     JEP 445: Unnamed Classes and Instance Main Methods (Preview)</a>
 */

String applicationName = "Java LTS Lab";

void main() {
    System.out.println(getApplicationDescription());
}

String getApplicationDescription() {
    return applicationName + " - Java 21";
}

List<String> getFeatures() {
    return List.of(
        "Unnamed Classes",
        "Instance Main Methods"
    );
}
