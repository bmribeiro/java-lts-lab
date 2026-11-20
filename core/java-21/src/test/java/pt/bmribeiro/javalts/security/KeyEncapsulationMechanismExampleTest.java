package pt.bmribeiro.javalts.security;

import org.junit.jupiter.api.Test;

import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class KeyEncapsulationMechanismExampleTest {

    @Test
    void shouldEstablishSharedSecretBetweenSenderAndReceiver()
        throws GeneralSecurityException {

        boolean result =
            KeyEncapsulationMechanismExample.establishSharedSecret();

        assertTrue(result);
    }

    @Test
    void shouldEstablishSharedSecretConsistentlyAcrossMultipleExchanges()
        throws GeneralSecurityException {

        for (int i = 0; i < 10; i++) {
            assertTrue(
                KeyEncapsulationMechanismExample.establishSharedSecret()
            );
        }
    }
}
