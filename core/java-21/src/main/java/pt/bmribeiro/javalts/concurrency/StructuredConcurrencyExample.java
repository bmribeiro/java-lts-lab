
package pt.bmribeiro.javalts.concurrency;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

/**
 * Demonstrates Structured Concurrency using the Java 21 Preview API.
 *
 * <p>Structured Concurrency treats related concurrent tasks as a single
 * unit of work. The parent task controls the lifecycle of its subtasks,
 * making task cancellation and error handling easier to manage.</p>
 *
 * <p>This example uses ShutdownOnFailure to execute two independent
 * operations concurrently. If one subtask fails, the scope is shut down
 * and unfinished subtasks are interrupted.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>StructuredTaskScope organizes concurrent tasks hierarchically.</li>
 *   <li>fork() starts a subtask within the current scope.</li>
 *   <li>join() waits for subtasks to complete.</li>
 *   <li>ShutdownOnFailure cancels unfinished subtasks after a failure.</li>
 *   <li>throwIfFailed() propagates a subtask failure.</li>
 *   <li>try-with-resources ensures that the task scope is closed.</li>
 *   <li>The default StructuredTaskScope constructor uses virtual threads.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 453</p>
 * <p>Introduced: Java 19 (JEP 428)</p>
 * <p>Preview: Java 19 (JEP 428), Java 20 (JEP 437),
 * Java 21 (JEP 453)</p>
 * <p>Finalized: Not finalized in Java 21</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Concurrency</p>
 *
 * @see <a href="https://openjdk.org/jeps/453">
 *     JEP 453: Structured Concurrency (Preview)</a>
 */
public final class StructuredConcurrencyExample {

    private StructuredConcurrencyExample() {
    }

    /**
     * Loads dashboard information using concurrent subtasks.
     *
     * @param userId identifier of the user
     * @return dashboard information
     * @throws InterruptedException if the current thread is interrupted
     * @throws ExecutionException if a subtask fails
     */
    public static Dashboard loadDashboard(String userId)
        throws InterruptedException, ExecutionException {

        Objects.requireNonNull(userId, "userId must not be null");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            StructuredTaskScope.Subtask<String> userTask =
                scope.fork(() -> fetchUserName(userId));

            StructuredTaskScope.Subtask<Integer> ordersTask =
                scope.fork(() -> fetchOrderCount(userId));

            scope.join();

            scope.throwIfFailed();

            return new Dashboard(
                userTask.get(),
                ordersTask.get()
            );
        }
    }

    private static String fetchUserName(String userId) {
        return "User-" + userId;
    }

    private static Integer fetchOrderCount(String userId) {
        return 5;
    }

    /**
     * Represents the combined dashboard information.
     *
     * @param username user name
     * @param orderCount number of orders
     */
    public record Dashboard(String username, int orderCount) {
    }

    public static void main(String[] args)
        throws InterruptedException, ExecutionException {

        Dashboard dashboard = loadDashboard("1001");

        System.out.println("Username: " + dashboard.username());
        System.out.println("Orders: " + dashboard.orderCount());
    }
}
