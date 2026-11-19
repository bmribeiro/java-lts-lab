package pt.bmribeiro.javalts.api.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Collectors.teeing()
 *
 * Introduced: Java 12
 * Target Version: Java 17
 * Category: Stream API
 */
public class CollectorsTeeingExample {

    public record Statistics(long count, int sum, double average) {
    }

    public Statistics calculateStatistics(List<Integer> numbers) {

        return numbers.stream()
            .collect(Collectors.teeing(
                Collectors.summingInt(Integer::intValue),
                Collectors.counting(),
                (sum, count) -> new Statistics(
                    count,
                    sum,
                    count == 0 ? 0.0 : (double) sum / count
                )
            ));
    }
}
