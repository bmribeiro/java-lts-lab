package pt.bmribeiro.javalts.platform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RmiActivationRemovalExampleTest {

    private RmiActivationRemovalExample example;

    @BeforeEach
    void setUp() {
        example = new RmiActivationRemovalExample();
    }

    @Test
    void shouldConfirmRmiIsAvailable() {
        assertTrue(example.isRmiAvailable());
    }

    @Test
    void shouldConfirmRmiActivationIsRemoved() {
        assertFalse(example.isRmiActivationAvailable());
    }

    @Test
    void shouldReturnRmiActivationUnavailableStatus() {
        assertEquals(
            "RMI Activation is not available.",
            example.getRmiActivationStatus()
        );
    }

    @Test
    void shouldReturnRmiAvailableStatus() {
        assertEquals(
            "Java RMI is available.",
            example.getRmiStatus()
        );
    }
}
