
package pt.bmribeiro.javalts.concurrency;

import java.lang.ScopedValue;

/**
 * Demonstrates Scoped Values introduced by JEP 506.
 *
 * JEP: 506
 * Introduced: Java 20 (Incubator - JEP 429)
 * First Preview: Java 21 (JEP 446)
 * Second Preview: Java 23 (JEP 481)
 * Third Preview: Java 24 (JEP 487)
 * Finalized: Java 25
 * Preview: No
 * Compilation: Java 25
 * Category: Core Libraries / Concurrency
 *
 * ScopedValue provides a mechanism to share immutable
 * contextual data across methods without explicitly
 * passing it through method parameters.
 *
 * A binding is available within a bounded dynamic scope
 * and is automatically restored when that scope completes.
 *
 * This example simulates request context propagation
 * across Controller, Service and Repository layers.
 */
public class ScopedValuesExample {

    /**
     * Scoped value representing the current request identifier.
     *
     * The key is private to this class to restrict access
     * to the contextual information.
     */
    private static final ScopedValue<String> REQUEST_ID =
        ScopedValue.newInstance();

    /**
     * Executes a request within a scoped request context.
     *
     * @param requestId request identifier
     * @return result obtained from the repository layer
     */
    public static String handleRequest(String requestId) {

        return ScopedValue.where(REQUEST_ID, requestId)
            .call(ScopedValuesExample::controllerLayer);
    }

    /**
     * Simulates the controller layer.
     *
     * @return service result
     */
    private static String controllerLayer() {
        return serviceLayer();
    }

    /**
     * Simulates the service layer.
     *
     * @return repository result
     */
    private static String serviceLayer() {
        return repositoryLayer();
    }

    /**
     * Simulates the repository layer.
     *
     * The request identifier is accessed directly
     * without being passed as a method parameter.
     *
     * @return current request identifier
     */
    private static String repositoryLayer() {
        return "Processing request: " + REQUEST_ID.get();
    }

    /**
     * Demonstrates nested scoped value bindings.
     *
     * The inner binding temporarily replaces the outer
     * value and the previous value is restored afterwards.
     *
     * @param outerRequestId outer request identifier
     * @param innerRequestId inner request identifier
     * @return values observed in the different scopes
     */
    public static String demonstrateRebinding(
        String outerRequestId,
        String innerRequestId) {

        return ScopedValue.where(REQUEST_ID, outerRequestId)
            .call(() -> {

                String before = REQUEST_ID.get();

                String inner = ScopedValue
                    .where(REQUEST_ID, innerRequestId)
                    .call(REQUEST_ID::get);

                String after = REQUEST_ID.get();

                return before + " -> "
                    + inner + " -> "
                    + after;
            });
    }

    /**
     * Checks whether the request identifier is bound
     * in the current execution context.
     *
     * @return true if a binding exists
     */
    public static boolean isRequestBound() {
        return REQUEST_ID.isBound();
    }

    public static void main(String[] args) {

        System.out.println(handleRequest("REQ-001"));

        System.out.println(
            demonstrateRebinding("REQ-001", "REQ-002")
        );

        System.out.println(
            "Request context bound: " + isRequestBound()
        );
    }
}
