
package pt.bmribeiro.javalts.concurrency;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class VirtualThreadsExampleTest {

    @Test
    void shouldStartAndExecuteVirtualThread() throws InterruptedException {
        AtomicBoolean executed = new AtomicBoolean(false);

        Thread thread = VirtualThreadsExample.startVirtualThread(
            () -> executed.set(true)
        );

        thread.join();

        assertTrue(thread.isVirtual());
        assertTrue(executed.get());
        assertEquals(Thread.State.TERMINATED, thread.getState());
    }

    @Test
    void shouldExecuteTaskOnVirtualThread() throws InterruptedException {
        AtomicBoolean virtualThread = new AtomicBoolean(false);
        CountDownLatch latch = new CountDownLatch(1);

        Thread thread = VirtualThreadsExample.startVirtualThread(() -> {
            virtualThread.set(Thread.currentThread().isVirtual());
            latch.countDown();
        });

        assertTrue(latch.await(5, TimeUnit.SECONDS));
        thread.join();

        assertTrue(virtualThread.get());
    }

    @Test
    void shouldExecuteMultipleTasksUsingVirtualThreads() throws Exception {
        List<String> taskNames = List.of(
            "task-1",
            "task-2",
            "task-3"
        );

        List<VirtualThreadsExample.TaskResult> results =
            VirtualThreadsExample.executeTasks(taskNames);

        assertEquals(3, results.size());

        assertTrue(results.stream()
            .allMatch(VirtualThreadsExample.TaskResult::virtualThread));

        assertEquals(taskNames, results.stream()
            .map(VirtualThreadsExample.TaskResult::taskName)
            .toList());
    }

    @Test
    void shouldPreserveSubmissionOrder() throws Exception {
        List<String> taskNames = List.of(
            "first",
            "second",
            "third"
        );

        List<VirtualThreadsExample.TaskResult> results =
            VirtualThreadsExample.executeTasks(taskNames);

        assertEquals(
            taskNames,
            results.stream()
                .map(VirtualThreadsExample.TaskResult::taskName)
                .toList()
        );
    }

    @Test
    void shouldReturnEmptyListWhenNoTasksAreProvided() throws Exception {
        List<VirtualThreadsExample.TaskResult> results =
            VirtualThreadsExample.executeTasks(List.of());

        assertTrue(results.isEmpty());
    }

    @Test
    void shouldRejectNullTask() {
        assertThrows(
            NullPointerException.class,
            () -> VirtualThreadsExample.startVirtualThread(null)
        );
    }

    @Test
    void shouldRejectNullTaskNamesList() {
        assertThrows(
            NullPointerException.class,
            () -> VirtualThreadsExample.executeTasks(null)
        );
    }

    @Test
    void shouldRejectNullTaskName() {
        List<String> taskNames = java.util.Arrays.asList(
            "task-1",
            null
        );

        assertThrows(
            NullPointerException.class,
            () -> VirtualThreadsExample.executeTasks(taskNames)
        );
    }
}
