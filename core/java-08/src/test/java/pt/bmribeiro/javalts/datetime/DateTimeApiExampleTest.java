
package pt.bmribeiro.javalts.datetime;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeApiExampleTest {

    private final DateTimeApiExample example =
        new DateTimeApiExample();

    @Test
    void shouldCreateLocalDate() {
        LocalDate date = example.createDate(2026, 11, 16);

        assertEquals(LocalDate.of(2026, 11, 16), date);
    }

    @Test
    void shouldCreateLocalTime() {
        LocalTime time = example.createTime(14, 30);

        assertEquals(LocalTime.of(14, 30), time);
    }

    @Test
    void shouldCreateLocalDateTime() {
        LocalDate date = LocalDate.of(2026, 11, 16);
        LocalTime time = LocalTime.of(14, 30);

        LocalDateTime result =
            example.createDateTime(date, time);

        assertEquals(
            LocalDateTime.of(2026, 11, 16, 14, 30),
            result
        );
    }

    @Test
    void shouldCreateZonedDateTime() {
        LocalDateTime dateTime =
            LocalDateTime.of(2026, 7, 15, 10, 0);

        ZonedDateTime result =
            example.createZonedDateTime(
                dateTime, "Europe/Lisbon");

        assertEquals(ZoneId.of("Europe/Lisbon"), result.getZone());
        assertEquals(dateTime, result.toLocalDateTime());
    }

    @Test
    void shouldAddDaysWithoutChangingOriginalDate() {
        LocalDate original = LocalDate.of(2026, 11, 16);

        LocalDate result = example.addDays(original, 10);

        assertEquals(LocalDate.of(2026, 11, 26), result);
        assertEquals(LocalDate.of(2026, 11, 16), original);
    }

    @Test
    void shouldCalculatePeriodBetweenDates() {
        LocalDate start = LocalDate.of(1990, 1, 1);
        LocalDate end = LocalDate.of(2020, 3, 5);

        Period result = example.calculatePeriod(start, end);

        assertEquals(30, result.getYears());
        assertEquals(2, result.getMonths());
        assertEquals(4, result.getDays());
    }

    @Test
    void shouldCalculateDurationBetweenTimes() {
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(11, 30);

        Duration result = example.calculateDuration(start, end);

        assertEquals(9000, result.getSeconds());
    }

    @Test
    void shouldFormatDate() {
        LocalDate date = LocalDate.of(2026, 11, 16);

        assertEquals("16/11/2026", example.formatDate(date));
    }

    @Test
    void shouldParseDate() {
        LocalDate result = example.parseDate("16/11/2026");

        assertEquals(LocalDate.of(2026, 11, 16), result);
    }
}
