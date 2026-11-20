
package pt.bmribeiro.javalts.concurrency;

import java.lang.ScopedValue;

/**
 * Demonstrates Scoped Values, a Preview API introduced in Java 20
 * and evolved in Java 21.
 *
 * <p>Scoped Values allow immutable data to be shared across methods
 * executed within a bounded execution scope.</p>
 *
 * <p>A value is bound to a ScopedValue for the duration of a scope.
 * Methods invoked within that scope can access the bound value.
 * Once the scope ends, the binding is no longer available.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>Scoped Values provide context propagation without mutable thread-local state.</li>
 *   <li>Bindings are immutable within their scope.</li>
 *   <li>Bindings are available to methods executed within the scope.</li>
 *   <li>The binding is automatically removed when the scope ends.</li>
 *   <li>Scoped Values are designed to work well with structured concurrency.</li>
 *   <li>Scoped Values are not a general replacement for every ThreadLocal use case.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 446</p>
 * <p>Introduced: Java 20 (JEP 429)</p>
 * <p>Preview: Java 20 (JEP 429), Java 21 (JEP 446)</p>
 * <p>Finalized: Not finalized in Java 21</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Concurrency</p>
 *
 * @see <a href="https://openjdk.org/jeps/446">
 *     JEP 446: Scoped Values (Preview)</a>
 */
public final class ScopedValuesExample {

    private static final ScopedValue<String> USER =
        ScopedValue.newInstance();

    private ScopedValuesExample() {
    }

    /**
     * Executes an operation within a scope containing a user value.
     *
     * @param username user name to bind to the scope
     * @return the user name obtained inside the scope
     */
    public static String executeWithUser(String username) throws Exception {
        return ScopedValue.where(USER, username)
            .call(ScopedValuesExample::getCurrentUser);
    }

    /**
     * Returns the user bound to the current scope.
     *
     * @return current user name
     * @throws java.util.NoSuchElementException if no binding exists
     */
    public static String getCurrentUser() {
        return USER.get();
    }

    /**
     * Indicates whether the user value is bound in the current scope.
     *
     * @return true if a binding exists
     */
    public static boolean isUserBound() {
        return USER.isBound();
    }
}
