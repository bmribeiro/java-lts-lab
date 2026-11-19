
package pt.bmribeiro.javalts.api.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringMethodsExampleTest {

    private final StringMethodsExample example =
        new StringMethodsExample();

    @Test
    void shouldIndentText() {
        String result = example.indentText("Java\nSpring\nAngular", 4);

        assertEquals(
            "    Java\n    Spring\n    Angular\n",
            result
        );
    }

    @Test
    void shouldRemoveIndentation() {
        String result = example.indentText(
            "    Java\n    Spring\n    Angular",
            -2
        );

        assertEquals(
            "  Java\n  Spring\n  Angular\n",
            result
        );
    }

    @Test
    void shouldNormalizeText() {
        assertEquals(
            "JAVA",
            example.normalizeText("  java  ")
        );
    }

    @Test
    void shouldCalculateTextLength() {
        assertEquals(4, example.getTextLength("Java"));
    }

    @Test
    void shouldAddPrefix() {
        assertEquals(
            "Java 17",
            example.addPrefix("17", "Java ")
        );
    }

    @Test
    void shouldReverseText() {
        assertEquals("avaJ", example.reverseText("Java"));
    }
}
