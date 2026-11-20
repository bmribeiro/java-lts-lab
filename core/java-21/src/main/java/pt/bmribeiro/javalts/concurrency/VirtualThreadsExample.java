
package pt.bmribeiro.javalts.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Demonstrates Virtual Threads introduced by JEP 444.
 *
 * <h2>Introduction</h2>
 * Virtual Threads are lightweight threads managed by the Java runtime.
 * They were introduced to simplify the development of highly concurrent
 * applications, particularly those involving blocking I/O operations.
 *
 * Unlike platform threads, virtual threads are not permanently associated
 * with operating system threads. The JVM schedules them onto carrier threads,
 * allowing a large number of virtual threads to share a smaller number of
 * platform threads.
 *
 * <h2>Key Concepts</h2>
 * <ul>
 *     <li>Virtual Threads are lightweight and designed for high concurrency.</li>
 *     <li>They are particularly useful for I/O-bound workloads.</li>
 *     <li>They do not make CPU-intensive tasks execute faster.</li>
 *     <li>They support the thread-per-request programming model.</li>
 *     <li>They should generally not be pooled; create one per task.</li>
 * </ul>
 *
 * <h2>Interview Notes</h2>
 * <ul>
 *     <li>
 *         Platform Threads vs Virtual Threads:
 *         Platform Threads are backed by operating system threads.
 *         Virtual Threads are scheduled by the JVM onto carrier threads.
 *     </li>
 *     <li>
 *         Carrier Thread: the platform thread on which a virtual thread
 *         is temporarily executed.
 *     </li>
 *     <li>
 *         I/O-bound vs CPU-bound: Virtual Threads improve scalability for
 *         blocking workloads, but do not increase available CPU capacity.
 *     </li>
 *     <li>
 *         Thread-per-request: each request can execute in its own virtual
 *         thread instead of sharing a limited pool of platform threads.
 *     </li>
 * </ul>
 *
 * JEP: 444
 * Introduced: Java 21
 * Preview: Java 19 (JEP 425), Java 20 (JEP 436)
 * Finalized: Java 21
 * Target Version: Java 21
 * Category: Concurrency
 *
 * @see <a href="https://openjdk.org/jeps/444">JEP 444: Virtual Threads</a>
 */
public final class VirtualThreadsExample {

    private VirtualThreadsExample() {
    }

    /**
     * Starts a task using a Virtual Thread.
     *
     * @param task the task to execute
     * @return the started Virtual Thread
     * @throws NullPointerException if the task is null
     */
    public static Thread startVirtualThread(Runnable task) {
        Objects.requireNonNull(task, "Task cannot be null");

        return Thread.ofVirtual().start(task);
    }

    /**
     * Executes one task per Virtual Thread using a dedicated executor.
     *
     * The executor automatically creates a new virtual thread for each
     * submitted task and is closed after all tasks complete.
     *
     * @param taskNames the names of the tasks to execute
     * @return the task results in submission order
     * @throws NullPointerException if the list or a task name is null
     * @throws InterruptedException if the current thread is interrupted
     * @throws ExecutionException if a task fails during execution
     */
    public static List<TaskResult> executeTasks(List<String> taskNames)
        throws InterruptedException, ExecutionException {

        Objects.requireNonNull(taskNames, "Task names cannot be null");

        List<Future<TaskResult>> futures = new ArrayList<>();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (String taskName : taskNames) {
                Objects.requireNonNull(taskName, "Task name cannot be null");

                futures.add(executor.submit(() -> new TaskResult(
                    taskName,
                    Thread.currentThread().getName(),
                    Thread.currentThread().isVirtual()
                )));
            }

            List<TaskResult> results = new ArrayList<>();

            for (Future<TaskResult> future : futures) {
                results.add(future.get());
            }

            return List.copyOf(results);
        }
    }

    /**
     * Represents the result of a task executed by a Virtual Thread.
     *
     * @param taskName the task name
     * @param threadName the executing thread name
     * @param virtualThread whether the executing thread is virtual
     */
    public record TaskResult(
        String taskName,
        String threadName,
        boolean virtualThread
    ) {
    }
}
