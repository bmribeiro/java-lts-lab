
package pt.bmribeiro.javalts.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    private final Executor executor;

    public CompletableFutureExample(Executor executor) {
        this.executor = executor;
    }

    public CompletableFuture<String> fetchUserName(Long userId) {
        return CompletableFuture.supplyAsync(
            () -> "User-" + userId,
            executor
        );
    }

    public CompletableFuture<String> fetchUserNameUpperCase(Long userId) {
        return fetchUserName(userId)
            .thenApply(String::toUpperCase);
    }

    public CompletableFuture<Void> processUserName(Long userId) {
        return fetchUserName(userId)
            .thenAccept(System.out::println);
    }

    public CompletableFuture<String> fetchUserProfile(Long userId) {
        return fetchUserName(userId)
            .thenCompose(name ->
                CompletableFuture.supplyAsync(
                    () -> name + " - Premium",
                    executor
                )
            );
    }

    public CompletableFuture<Integer> calculateCombinedScore() {
        CompletableFuture<Integer> first =
            CompletableFuture.supplyAsync(() -> 100, executor);

        CompletableFuture<Integer> second =
            CompletableFuture.supplyAsync(() -> 50, executor);

        return first.thenCombine(second, Integer::sum);
    }

    public CompletableFuture<String> fetchUserWithFallback(Long userId) {
        return CompletableFuture
            .<String>supplyAsync(
                () -> {
                    throw new IllegalStateException("Service unavailable");
                },
                executor
            )
            .exceptionally(exception -> "Unknown user");
    }

    public CompletableFuture<Void> executeTask() {
        return CompletableFuture.runAsync(
            () -> System.out.println("Task executed"),
            executor
        );
    }
}
