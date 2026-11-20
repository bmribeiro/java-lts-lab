package pt.bmribeiro.javalts.instrumentation;

import java.util.List;

/**
 * Demonstrates the JVM behaviour introduced by JEP 451.
 *
 * JEP: 451
 * Introduced: Java 21
 * Preview: Not applicable
 * Finalized: Not applicable (JVM behaviour)
 * Target Version: Java 21
 * Category: JVM / Java Instrumentation
 *
 * JEP 451 prepares the JDK for a future release in which
 * dynamic loading of agents will be disabled by default.
 *
 * In Java 21, dynamic agent loading remains enabled by default,
 * but the JVM emits a warning when an agent is loaded dynamically.
 *
 * Interview notes:
 * - Java agents can modify application behaviour at runtime.
 * - Startup agents are loaded using the -javaagent option.
 * - Dynamic agents are attached to an already running JVM.
 * - JEP 451 introduces warnings for dynamic agent loading.
 * - EnableDynamicAgentLoading explicitly allows dynamic loading.
 * - jdk.instrument.traceUsage helps diagnose Instrumentation API use.
 * - Startup agent loading is not affected by this JEP.
 */
public final class DynamicAgentLoadingExample {

    private DynamicAgentLoadingExample() {
    }

    /**
     * Returns the JVM option that explicitly allows dynamic
     * agent loading.
     *
     * @return the JVM option
     */
    public static String enableDynamicAgentLoadingOption() {
        return "-XX:+EnableDynamicAgentLoading";
    }

    /**
     * Returns the JVM option that disables dynamic agent loading.
     *
     * @return the JVM option
     */
    public static String disableDynamicAgentLoadingOption() {
        return "-XX:-EnableDynamicAgentLoading";
    }

    /**
     * Returns the system property used to trace Instrumentation API usage.
     *
     * @return the JVM system property
     */
    public static String instrumentationTraceOption() {
        return "-Djdk.instrument.traceUsage";
    }

    /**
     * Returns the JVM option used to load an agent at startup.
     *
     * @param agentPath path to the Java agent JAR
     * @return the JVM startup option
     * @throws IllegalArgumentException if the path is null or blank
     */
    public static String startupAgentOption(String agentPath) {
        if (agentPath == null || agentPath.isBlank()) {
            throw new IllegalArgumentException(
                "Agent path cannot be null or blank"
            );
        }

        return "-javaagent:" + agentPath;
    }

    /**
     * Returns useful JVM options for diagnosing dynamic agent loading.
     *
     * @return immutable list of JVM options
     */
    public static List<String> diagnosticOptions() {
        return List.of(
            enableDynamicAgentLoadingOption(),
            instrumentationTraceOption()
        );
    }
}
