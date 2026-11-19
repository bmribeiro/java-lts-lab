
package pt.bmribeiro.javalts.language;

/**
 * Sealed Classes
 *
 * JEP: 409
 * Introduced: Java 15 (Preview)
 * Second Preview: Java 16
 * Finalized: Java 17
 * Target Version: Java 17
 * Category: Language Features
 */
public class SealedClassesExample {

    public sealed interface Shape
        permits Circle, Rectangle {
    }

    public record Circle(double radius) implements Shape {
    }

    public record Rectangle(double width, double height)
        implements Shape {
    }

    public sealed abstract static class Employee
        permits Manager, Developer {
    }

    public static final class Manager extends Employee {
    }

    public static non-sealed class Developer extends Employee {
    }

    public static class JavaDeveloper extends Developer {
    }

    public String identifyShape(Shape shape) {

        if (shape instanceof Circle circle) {
            return "Circle with radius: " + circle.radius();
        }

        if (shape instanceof Rectangle rectangle) {
            return "Rectangle with width: " + rectangle.width()
                + " and height: " + rectangle.height();
        }

        return "Unknown shape";
    }

    public String identifyEmployee(Employee employee) {

        if (employee instanceof Manager) {
            return "Manager";
        }

        if (employee instanceof JavaDeveloper) {
            return "Java Developer";
        }

        if (employee instanceof Developer) {
            return "Developer";
        }

        return "Unknown employee";
    }
}
