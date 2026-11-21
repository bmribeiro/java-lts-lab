
package pt.bmribeiro.javalts.security;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class KeyDerivationFunctionExampleTest {

    private static final byte[] IKM =
        "example-initial-key-material-32".getBytes();

    private static final byte[] SALT =
        "application-salt".getBytes();

    private static final byte[] INFO =
        "payment-encryption".getBytes();

    @Test
    void shouldDeriveAes256Key() throws Exception {

        SecretKey key =
            KeyDerivationFunctionExample.deriveAesKey(
                IKM,
                SALT,
                INFO
            );

        assertNotNull(key);
        assertEquals("AES", key.getAlgorithm());
        assertEquals(32, key.getEncoded().length);
    }

    @Test
    void shouldProduceSameKeyForSameInputs() throws Exception {

        SecretKey firstKey =
            KeyDerivationFunctionExample.deriveAesKey(
                IKM,
                SALT,
                INFO
            );

        SecretKey secondKey =
            KeyDerivationFunctionExample.deriveAesKey(
                IKM,
                SALT,
                INFO
            );

        assertArrayEquals(
            firstKey.getEncoded(),
            secondKey.getEncoded()
        );
    }

    @Test
    void shouldProduceDifferentKeysForDifferentContext()
        throws Exception {

        SecretKey firstKey =
            KeyDerivationFunctionExample.deriveAesKey(
                IKM,
                SALT,
                INFO
            );

        SecretKey secondKey =
            KeyDerivationFunctionExample.deriveAesKey(
                IKM,
                SALT,
                "authentication".getBytes()
            );

        org.junit.jupiter.api.Assertions.assertFalse(
            java.util.Arrays.equals(
                firstKey.getEncoded(),
                secondKey.getEncoded()
            )
        );
    }
}
