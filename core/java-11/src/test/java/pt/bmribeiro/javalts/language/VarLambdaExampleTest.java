package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VarLambdaExampleTest {

    private final VarLambdaExample example = new VarLambdaExample();

    @Test
    void shouldConcatenateStrings() {
        assertEquals(
            "Java 11",
            example.concatenate("Java ", "11")
        );
    }

    @Test
    void shouldConvertStringToUpperCase() {
        assertEquals(
            "JAVA 11",
            example.toUpperCase("Java 11")
        );
    }
}
