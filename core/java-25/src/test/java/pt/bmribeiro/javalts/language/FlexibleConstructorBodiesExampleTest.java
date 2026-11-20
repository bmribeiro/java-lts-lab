
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlexibleConstructorBodiesExampleTest {

    @Test
    void shouldInitializeFieldBeforeSuperclassConstructor() {

        FlexibleConstructorBodiesExample example =
            new FlexibleConstructorBodiesExample("Bruno Ribeiro");

        assertEquals("Bruno Ribeiro", example.getName());

        assertEquals(
            "Bruno Ribeiro",
            example.getObservedName()
        );
    }

    @Test
    void shouldNormalizeNameBeforeInitialization() {

        FlexibleConstructorBodiesExample example =
            new FlexibleConstructorBodiesExample("  Bruno Ribeiro  ");

        assertEquals("Bruno Ribeiro", example.getName());

        assertEquals(
            "Bruno Ribeiro",
            example.getObservedName()
        );
    }

    @Test
    void shouldRejectNullName() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new FlexibleConstructorBodiesExample(null)
        );
    }

    @Test
    void shouldRejectBlankName() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new FlexibleConstructorBodiesExample("   ")
        );
    }
}
