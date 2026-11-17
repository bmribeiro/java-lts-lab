
package pt.bmribeiro.javalts.security;

import org.junit.jupiter.api.Test;

import javax.crypto.AEADBadTagException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ChaCha20Poly1305ExampleTest {

    private final ChaCha20Poly1305Example example =
        new ChaCha20Poly1305Example();

    @Test
    void shouldEncryptAndDecryptData()
        throws GeneralSecurityException {

        SecretKey key = example.generateKey();
        byte[] nonce = example.generateNonce();

        byte[] original = "Java 11 ChaCha20-Poly1305"
            .getBytes(StandardCharsets.UTF_8);

        byte[] encrypted = example.encrypt(original, key, nonce);
        byte[] decrypted = example.decrypt(encrypted, key, nonce);

        assertArrayEquals(original, decrypted);
        assertFalse(Arrays.equals(original, encrypted));
    }

    @Test
    void shouldRejectTamperedCiphertext()
        throws GeneralSecurityException {

        SecretKey key = example.generateKey();
        byte[] nonce = example.generateNonce();

        byte[] original = "Sensitive information"
            .getBytes(StandardCharsets.UTF_8);

        byte[] encrypted = example.encrypt(original, key, nonce);

        encrypted[0] ^= 1;

        assertThrows(
            AEADBadTagException.class,
            () -> example.decrypt(encrypted, key, nonce)
        );
    }

    @Test
    void shouldGenerateNonceWith12Bytes() {

        byte[] nonce = example.generateNonce();

        assertNotNull(nonce);
        assertEquals(12, nonce.length);
    }
}
