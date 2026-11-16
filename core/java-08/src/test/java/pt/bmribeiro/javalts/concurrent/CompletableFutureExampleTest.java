
package pt.bmribeiro.javalts.concurrent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CompletableFutureExampleTest {

    private ExecutorService executor;
    private CompletableFutureExample example;

    @BeforeEach
    void setUp() {
        executor = Executors.newFixedThreadPool(2);
        example = new CompletableFutureExample(executor);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        executor.shutdown();

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    @Test
    void shouldFetchUserNameAsynchronously() throws Exception {
        String result = example.fetchUserName(1L)
            .get(2, TimeUnit.SECONDS);

        assertEquals("User-1", result);
    }

    @Test
    void shouldTransformUserName() throws Exception {
        String result = example.fetchUserNameUpperCase(1L)
            .get(2, TimeUnit.SECONDS);

        assertEquals("USER-1", result);
    }

    @Test
    void shouldProcessUserNameWithoutReturningResult() throws Exception {
        assertNull(example.processUserName(1L)
            .get(2, TimeUnit.SECONDS));
    }

    @Test
    void shouldComposeDependentAsyncOperations() throws Exception {
        String result = example.fetchUserProfile(1L)
            .get(2, TimeUnit.SECONDS);

        assertEquals("User-1 - Premium", result);
    }

    @Test
    void shouldCombineIndependentResults() throws Exception {
        Integer result = example.calculateCombinedScore()
            .get(2, TimeUnit.SECONDS);

        assertEquals(150, result);
    }

    @Test
    void shouldRecoverFromException() throws Exception {
        String result = example.fetchUserWithFallback(1L)
            .get(2, TimeUnit.SECONDS);

        assertEquals("Unknown user", result);
    }

    @Test
    void shouldExecuteTaskWithoutReturningResult() throws Exception {
        assertNull(example.executeTask()
            .get(2, TimeUnit.SECONDS));
    }
}
