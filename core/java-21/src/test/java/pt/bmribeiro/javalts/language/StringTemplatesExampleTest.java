
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringTemplatesExampleTest {

    @Test
    void shouldInterpolateGreeting() {
        String result =
            StringTemplatesExample.createGreeting("Bruno", 42);

        assertEquals("Hello, Bruno! You are 42 years old.", result);
    }

    @Test
    void shouldEvaluateExpressionsInsideTemplate() {
        String result =
            StringTemplatesExample.createFullName("Bruno", "Ribeiro");

        assertEquals("Full name: Bruno Ribeiro", result);
    }

    @Test
    void shouldProcessTemplateUsingCustomProcessor() {
        String result =
            StringTemplatesExample.createUppercaseGreeting("Bruno");

        assertEquals("HELLO, BRUNO!", result);
    }

    @Test
    void shouldReturnTemplateFragments() {
        List<String> fragments =
            StringTemplatesExample.getTemplateFragments("Bruno");

        assertEquals(List.of("Hello, ", "!"), fragments);
    }

    @Test
    void shouldInterpolateNullName() {
        String result =
            StringTemplatesExample.createGreeting(null, 42);

        assertEquals("Hello, null! You are 42 years old.", result);
    }

    @Test
    void shouldProcessNullNameUsingCustomProcessor() {
        String result =
            StringTemplatesExample.createUppercaseGreeting(null);

        assertEquals("HELLO, NULL!", result);
    }
}
