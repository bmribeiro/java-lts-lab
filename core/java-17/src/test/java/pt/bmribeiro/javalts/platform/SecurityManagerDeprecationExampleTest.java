
package pt.bmribeiro.javalts.platform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityManagerDeprecationExampleTest {

    private SecurityManagerDeprecationExample example;

    @BeforeEach
    void setUp() {
        example = new SecurityManagerDeprecationExample();
    }

    @Test
    void shouldIdentifySecurityManagerAsInactiveByDefault() {
        assertFalse(example.isSecurityManagerActive());
    }

    @Test
    void shouldReturnInactiveStatusWhenNoSecurityManagerIsInstalled() {
        assertEquals(
            "Security Manager is not active.",
            example.getSecurityManagerStatus()
        );
    }

    @Test
    void shouldReturnConsistentSecurityManagerStatus() {
        String expectedStatus = example.isSecurityManagerActive()
            ? "Security Manager is active."
            : "Security Manager is not active.";

        assertEquals(expectedStatus, example.getSecurityManagerStatus());
    }
}
