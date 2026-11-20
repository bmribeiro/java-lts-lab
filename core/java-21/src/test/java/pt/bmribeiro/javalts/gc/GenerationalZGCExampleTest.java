
package pt.bmribeiro.javalts.gc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerationalZGCExampleTest {

    @Test
    void shouldReturnGenerationalZgcJvmOptions() {
        List<String> options =
            GenerationalZGCExample.generationalZgcJvmOptions();

        assertEquals(
            List.of("-XX:+UseZGC", "-XX:+ZGenerational"),
            options
        );
    }

    @Test
    void shouldReturnImmutableJvmOptions() {
        List<String> options =
            GenerationalZGCExample.generationalZgcJvmOptions();

        assertThrows(
            UnsupportedOperationException.class,
            () -> options.add("-Xmx512m")
        );
    }

    @Test
    void shouldReturnGarbageCollectionLoggingOption() {
        String option =
            GenerationalZGCExample.garbageCollectionLoggingOption();

        assertEquals("-Xlog:gc", option);
    }
}
