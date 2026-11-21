
package pt.bmribeiro.javalts.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScopedValuesExampleTest {

    @Test
    void shouldPropagateRequestIdAcrossLayers() throws Exception {

        String result =
            ScopedValuesExample.handleRequest("REQ-001");

        assertEquals(
            "Processing request: REQ-001",
            result
        );
    }

    @Test
    void shouldRestorePreviousValueAfterNestedScope() throws Exception {

        String result =
            ScopedValuesExample.demonstrateRebinding(
                "REQ-001",
                "REQ-002"
            );

        assertEquals(
            "REQ-001 -> REQ-002 -> REQ-001",
            result
        );
    }

    @Test
    void shouldNotKeepBindingAfterScopeCompletes() throws Exception {

        ScopedValuesExample.handleRequest("REQ-001");

        assertFalse(
            ScopedValuesExample.isRequestBound()
        );
    }

    @Test
    void shouldNotKeepBindingAfterException() {

        assertThrows(
            IllegalStateException.class,
            () -> ScopedValuesExample.executeWithFailure("REQ-ERROR")
        );

        assertFalse(
            ScopedValuesExample.isRequestBound()
        );
    }

    @Test
    void shouldNotHaveBindingBeforeRequestExecution() {

        assertFalse(
            ScopedValuesExample.isRequestBound()
        );
    }
}
