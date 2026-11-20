
package pt.bmribeiro.javalts.language;

/**
 * Demonstrates Flexible Constructor Bodies introduced by JEP 513.
 *
 * JEP: 513
 * Introduced: Java 22 (Preview - JEP 447)
 * Second Preview: Java 23 (JEP 482)
 * Third Preview: Java 24 (JEP 492)
 * Finalized: Java 25
 * Preview: No
 * Compilation: Java 25
 * Category: Language Features
 *
 * Flexible Constructor Bodies allow selected statements
 * before an explicit constructor invocation such as
 * super(...) or this(...).
 *
 * These statements can initialize fields declared in
 * the current class, but cannot read the instance being
 * constructed or invoke its instance methods.
 *
 * This example demonstrates why initializing subclass
 * fields before invoking the superclass constructor
 * can prevent the superclass from observing default values.
 */
public class FlexibleConstructorBodiesExample extends ConstructorBase {

    private final String name;

    /**
     * Initializes the subclass field before invoking
     * the superclass constructor.
     *
     * @param name name to validate and initialize
     */
    public FlexibleConstructorBodiesExample(String name) {

        this.name = validateName(name);

        super();
    }

    /**
     * Validates and normalizes the constructor argument.
     *
     * This is a static method and therefore does not
     * access the instance being constructed.
     *
     * @param name name to validate
     * @return normalized name
     * @throws IllegalArgumentException if the name is null or blank
     */
    private static String validateName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Name cannot be null or blank"
            );
        }

        return name.trim();
    }

    /**
     * Overrides the superclass method.
     *
     * The superclass constructor invokes this method
     * during object construction.
     *
     * @return initialized subclass name
     */
    @Override
    protected String currentName() {
        return name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        FlexibleConstructorBodiesExample example =
            new FlexibleConstructorBodiesExample(" Bruno Ribeiro ");

        System.out.println("Initialized name: " + example.getName());

        System.out.println(
            "Name observed by superclass: "
                + example.getObservedName()
        );
    }
}

/**
 * Superclass used to demonstrate constructor execution order.
 *
 * Its constructor invokes an overridable method.
 */
class ConstructorBase {

    private final String observedName;

    ConstructorBase() {
        this.observedName = currentName();
    }

    protected String currentName() {
        return "Base";
    }

    final String getObservedName() {
        return observedName;
    }
}
