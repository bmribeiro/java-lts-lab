package pt.bmribeiro.javalts.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApiExample {

    public LocalDate createDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public LocalTime createTime(int hour, int minute) {
        return LocalTime.of(hour, minute);
    }

    public LocalDateTime createDateTime(
        LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

    public ZonedDateTime createZonedDateTime(
        LocalDateTime dateTime, String zone) {
        return ZonedDateTime.of(dateTime, ZoneId.of(zone));
    }

    public LocalDate addDays(LocalDate date, long days) {
        return date.plusDays(days);
    }

    public Period calculatePeriod(LocalDate start, LocalDate end) {
        return Period.between(start, end);
    }

    public Duration calculateDuration(LocalTime start, LocalTime end) {
        return Duration.between(start, end);
    }

    public String formatDate(LocalDate date) {
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return date.format(formatter);
    }

    public LocalDate parseDate(String date) {
        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(date, formatter);
    }
}
