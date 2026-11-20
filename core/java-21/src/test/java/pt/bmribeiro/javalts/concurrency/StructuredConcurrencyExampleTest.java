package pt.bmribeiro.javalts.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class StructuredConcurrencyExampleTest {

    @Test
    void shouldLoadDashboardUsingConcurrentTasks()
        throws InterruptedException, ExecutionException {

        StructuredConcurrencyExample.Dashboard dashboard =
            StructuredConcurrencyExample.loadDashboard("1001");

        assertAll(
            () -> assertEquals("User-1001", dashboard.username()),
            () -> assertEquals(5, dashboard.orderCount())
        );
    }

    @Test
    void shouldLoadDashboardForDifferentUsers()
        throws InterruptedException, ExecutionException {

        StructuredConcurrencyExample.Dashboard firstDashboard =
            StructuredConcurrencyExample.loadDashboard("1001");

        StructuredConcurrencyExample.Dashboard secondDashboard =
            StructuredConcurrencyExample.loadDashboard("2002");

        assertAll(
            () -> assertEquals("User-1001", firstDashboard.username()),
            () -> assertEquals("User-2002", secondDashboard.username()),
            () -> assertEquals(5, firstDashboard.orderCount()),
            () -> assertEquals(5, secondDashboard.orderCount())
        );
    }

    @Test
    void shouldRejectNullUserId() {

        assertThrows(
            NullPointerException.class,
            () -> StructuredConcurrencyExample.loadDashboard(null)
        );
    }

    @Test
    void shouldCreateDashboardRecord() {

        StructuredConcurrencyExample.Dashboard dashboard =
            new StructuredConcurrencyExample.Dashboard("User-1001", 5);

        assertAll(
            () -> assertEquals("User-1001", dashboard.username()),
            () -> assertEquals(5, dashboard.orderCount())
        );
    }
}
