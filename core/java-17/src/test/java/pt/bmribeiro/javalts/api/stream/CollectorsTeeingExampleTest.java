
package pt.bmribeiro.javalts.api.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectorsTeeingExampleTest {

    private final CollectorsTeeingExample example =
        new CollectorsTeeingExample();

    @Test
    void shouldCalculateStatisticsForMultipleNumbers() {
        var statistics = example.calculateStatistics(
            List.of(10, 20, 30, 40, 50)
        );

        assertEquals(5, statistics.count());
        assertEquals(150, statistics.sum());
        assertEquals(30.0, statistics.average());
    }

    @Test
    void shouldCalculateStatisticsForSingleNumber() {
        var statistics = example.calculateStatistics(
            List.of(25)
        );

        assertEquals(1, statistics.count());
        assertEquals(25, statistics.sum());
        assertEquals(25.0, statistics.average());
    }

    @Test
    void shouldReturnZeroStatisticsForEmptyList() {
        var statistics = example.calculateStatistics(List.of());

        assertEquals(0, statistics.count());
        assertEquals(0, statistics.sum());
        assertEquals(0.0, statistics.average());
    }

    @Test
    void shouldCalculateStatisticsForNegativeNumbers() {
        var statistics = example.calculateStatistics(
            List.of(-10, -20, 30)
        );

        assertEquals(3, statistics.count());
        assertEquals(0, statistics.sum());
        assertEquals(0.0, statistics.average());
    }
}
