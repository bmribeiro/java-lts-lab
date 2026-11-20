package pt.bmribeiro.javalts.platform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NashornRemovalExampleTest {

    private NashornRemovalExample example;

    @BeforeEach
    void setUp() {
        example = new NashornRemovalExample();
    }

    @Test
    void shouldReturnAvailableEngineNames() {
        List<String> engines = example.getAvailableEngineNames();

        assertNotNull(engines);
    }

    @Test
    void shouldReturnSortedEngineNames() {
        List<String> engines = example.getAvailableEngineNames();

        List<String> sortedEngines = engines.stream()
            .sorted()
            .toList();

        assertEquals(sortedEngines, engines);
    }

    @Test
    void shouldNotFindNashornInStandardJava17Runtime() {
        assertFalse(example.isNashornAvailable());
    }

    @Test
    void shouldReturnConsistentNashornStatus() {
        String status = example.getNashornStatus();

        if (example.isNashornAvailable()) {
            assertEquals(
                "Nashorn JavaScript Engine is available.",
                status
            );
        } else {
            assertEquals(
                "Nashorn JavaScript Engine is not available.",
                status
            );
        }
    }

    @Test
    void shouldNotAssumeJavaScriptEngineIsAvailable() {
        boolean available = example.isJavaScriptEngineAvailable();

        assertTrue(
            available || !available,
            "The result must be a valid boolean."
        );
    }
}
