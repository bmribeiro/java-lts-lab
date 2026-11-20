
package pt.bmribeiro.javalts.instrumentation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DynamicAgentLoadingExampleTest {

    @Test
    void shouldReturnEnableDynamicAgentLoadingOption() {
        assertEquals(
            "-XX:+EnableDynamicAgentLoading",
            DynamicAgentLoadingExample.enableDynamicAgentLoadingOption()
        );
    }

    @Test
    void shouldReturnDisableDynamicAgentLoadingOption() {
        assertEquals(
            "-XX:-EnableDynamicAgentLoading",
            DynamicAgentLoadingExample.disableDynamicAgentLoadingOption()
        );
    }

    @Test
    void shouldReturnInstrumentationTraceOption() {
        assertEquals(
            "-Djdk.instrument.traceUsage",
            DynamicAgentLoadingExample.instrumentationTraceOption()
        );
    }

    @Test
    void shouldReturnStartupAgentOption() {
        assertEquals(
            "-javaagent:/opt/agents/example-agent.jar",
            DynamicAgentLoadingExample.startupAgentOption(
                "/opt/agents/example-agent.jar"
            )
        );
    }

    @Test
    void shouldAcceptRelativeAgentPath() {
        assertEquals(
            "-javaagent:agents/example-agent.jar",
            DynamicAgentLoadingExample.startupAgentOption(
                "agents/example-agent.jar"
            )
        );
    }

    @Test
    void shouldThrowExceptionWhenAgentPathIsNull() {
        assertThrows(
            IllegalArgumentException.class,
            () -> DynamicAgentLoadingExample.startupAgentOption(null)
        );
    }

    @Test
    void shouldThrowExceptionWhenAgentPathIsBlank() {
        assertThrows(
            IllegalArgumentException.class,
            () -> DynamicAgentLoadingExample.startupAgentOption(" ")
        );
    }

    @Test
    void shouldReturnDiagnosticOptions() {
        List<String> expected = List.of(
            "-XX:+EnableDynamicAgentLoading",
            "-Djdk.instrument.traceUsage"
        );

        assertEquals(
            expected,
            DynamicAgentLoadingExample.diagnosticOptions()
        );
    }

    @Test
    void shouldReturnImmutableDiagnosticOptions() {
        List<String> options =
            DynamicAgentLoadingExample.diagnosticOptions();

        assertThrows(
            UnsupportedOperationException.class,
            () -> options.add("-XX:-EnableDynamicAgentLoading")
        );
    }

    @Test
    void shouldReturnIndependentDiagnosticOptions() {
        List<String> first =
            DynamicAgentLoadingExample.diagnosticOptions();

        List<String> second =
            DynamicAgentLoadingExample.diagnosticOptions();

        assertNotSame(first, second);
        assertEquals(first, second);
    }
}
