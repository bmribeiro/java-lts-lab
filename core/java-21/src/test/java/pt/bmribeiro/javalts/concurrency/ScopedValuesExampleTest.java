
package pt.bmribeiro.javalts.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScopedValuesExampleTest {

    @Test
    void shouldExecuteWithUserBoundToScope() throws Exception {
        String result =
            ScopedValuesExample.executeWithUser("Bruno");

        assertEquals("Bruno", result);
    }

    @Test
    void shouldMakeUserAvailableInsideScope() throws Exception {
        String result =
            ScopedValuesExample.executeWithUser("JavaDeveloper");

        assertEquals("JavaDeveloper", result);
    }

    @Test
    void shouldRemoveUserBindingAfterScopeEnds() throws Exception {
        ScopedValuesExample.executeWithUser("Bruno");

        assertFalse(ScopedValuesExample.isUserBound());
    }

    @Test
    void shouldNotHaveUserBoundOutsideScope() {
        assertFalse(ScopedValuesExample.isUserBound());
    }

    @Test
    void shouldSupportIndependentScopes() throws Exception {
        String firstResult =
            ScopedValuesExample.executeWithUser("UserA");

        String secondResult =
            ScopedValuesExample.executeWithUser("UserB");

        assertAll(
            () -> assertEquals("UserA", firstResult),
            () -> assertEquals("UserB", secondResult),
            () -> assertFalse(ScopedValuesExample.isUserBound())
        );
    }
}
