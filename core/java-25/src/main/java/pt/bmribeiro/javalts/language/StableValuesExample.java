
package pt.bmribeiro.javalts.language;

import java.lang.StableValue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates Stable Values introduced by JEP 502.
 *
 * Context:
 * Supports lazy initialization without manually implementing
 * synchronization or double-checked locking.
 *
 * JEP: 502 - Stable Values (Preview)
 * Introduced: Java 25
 * Preview: Java 25
 * Finalized: Not finalized in Java 25
 * Compilation: Java 25 with --enable-preview
 * Category: Core Libraries
 *
 * Technical Explanation:
 * StableValue holds a value that can be initialized at most once.
 * The orElseSet() method computes the value on first access and
 * safely publishes it to concurrent callers.
 *
 * Comparison:
 * Unlike a conventional mutable field, a StableValue cannot have
 * its contents replaced after initialization. Unlike a final field,
 * its contents do not need to be initialized in the constructor.
 *
 * Practical Application:
 * Useful for lazily initializing configuration, expensive resources
 * and application components that may never be needed.
 */
public class StableValuesExample {

    private final StableValue<String> configuration =
        StableValue.of();

    private final AtomicInteger initializationCount =
        new AtomicInteger();

    /**
     * Returns the application configuration.
     *
     * The configuration is initialized only on first access.
     *
     * @return application configuration
     */
    public String getConfiguration() {

        return configuration.orElseSet(() -> {
            initializationCount.incrementAndGet();
            return "application-config";
        });
    }

    /**
     * Indicates whether the configuration has been initialized.
     *
     * @return true if the value is set
     */
    public boolean isConfigurationInitialized() {
        return configuration.isSet();
    }

    /**
     * Returns the number of successful initialization attempts.
     *
     * @return initialization count
     */
    public int getInitializationCount() {
        return initializationCount.get();
    }

    public static void main(String[] args) {

        StableValuesExample example =
            new StableValuesExample();

        System.out.println(
            "Initialized: "
                + example.isConfigurationInitialized()
        );

        System.out.println(
            "Configuration: "
                + example.getConfiguration()
        );

        System.out.println(
            "Initialized: "
                + example.isConfigurationInitialized()
        );

        System.out.println(
            "Configuration: "
                + example.getConfiguration()
        );

        System.out.println(
            "Initialization count: "
                + example.getInitializationCount()
        );
    }
}
