package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NestBasedAccessExampleTest {

    @Test
    void shouldAllowNestedClassToAccessPrivateMember() {
        NestBasedAccessExample example = new NestBasedAccessExample();

        assertEquals(
            "Java 11 Nest-Based Access",
            example.accessPrivateMember()
        );
    }
}
