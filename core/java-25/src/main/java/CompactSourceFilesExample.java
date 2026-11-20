
/**
 * Demonstrates Compact Source Files and Instance Main Methods
 * introduced by JEP 512.
 *
 * JEP: 512
 * Introduced: Java 21 (Preview - JEP 445)
 * Second Preview: Java 22 (JEP 463)
 * Third Preview: Java 23 (JEP 477)
 * Fourth Preview: Java 24 (JEP 495)
 * Finalized: Java 25
 * Preview: No
 * Compilation: Java 25
 * Category: Language Features
 *
 * Compact source files allow methods and fields to be declared
 * without an explicit class declaration.
 *
 * The compiler implicitly declares a final top-level class
 * in the unnamed package to contain these members.
 *
 * Instance main methods allow application entry points
 * without requiring the static modifier.
 */

// Instance field
String greeting = "Hello, Java 25!";

// Instance method
String getGreeting() {
    return greeting;
}

// Instance main method
void main() {
    System.out.println(getGreeting());
}
