
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SealedClassesExampleTest {

    private final SealedClassesExample example =
        new SealedClassesExample();

    @Test
    void shouldIdentifyCircle() {
        SealedClassesExample.Shape circle =
            new SealedClassesExample.Circle(5.0);

        assertEquals(
            "Circle with radius: 5.0",
            example.identifyShape(circle)
        );
    }

    @Test
    void shouldIdentifyRectangle() {
        SealedClassesExample.Shape rectangle =
            new SealedClassesExample.Rectangle(4.0, 6.0);

        assertEquals(
            "Rectangle with width: 4.0 and height: 6.0",
            example.identifyShape(rectangle)
        );
    }

    @Test
    void shouldIdentifyManager() {
        SealedClassesExample.Employee manager =
            new SealedClassesExample.Manager();

        assertEquals("Manager", example.identifyEmployee(manager));
    }

    @Test
    void shouldIdentifyDeveloper() {
        SealedClassesExample.Employee developer =
            new SealedClassesExample.Developer();

        assertEquals("Developer", example.identifyEmployee(developer));
    }

    @Test
    void shouldIdentifyJavaDeveloper() {
        SealedClassesExample.Employee developer =
            new SealedClassesExample.JavaDeveloper();

        assertEquals(
            "Java Developer",
            example.identifyEmployee(developer)
        );
    }
}
