
package pt.bmribeiro.javalts.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StableValuesExampleTest {

    @Test
    void shouldNotInitializeConfigurationAtConstruction() {

        StableValuesExample example =
            new StableValuesExample();

        assertFalse(example.isConfigurationInitialized());
        assertEquals(0, example.getInitializationCount());
    }

    @Test
    void shouldInitializeConfigurationOnFirstAccess() {

        StableValuesExample example =
            new StableValuesExample();

        String result = example.getConfiguration();

        assertEquals("application-config", result);
        assertTrue(example.isConfigurationInitialized());
        assertEquals(1, example.getInitializationCount());
    }

    @Test
    void shouldReuseConfigurationAfterFirstInitialization() {

        StableValuesExample example =
            new StableValuesExample();

        String firstResult = example.getConfiguration();
        String secondResult = example.getConfiguration();

        assertEquals(firstResult, secondResult);
        assertEquals(1, example.getInitializationCount());
    }
}
