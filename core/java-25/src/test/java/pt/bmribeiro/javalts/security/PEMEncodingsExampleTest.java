
package pt.bmribeiro.javalts.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;

class PEMEncodingsExampleTest {

    private PEMEncodingsExample example;
    private KeyPair keyPair;

    @BeforeEach
    void setUp() throws Exception {
        example = new PEMEncodingsExample();
        keyPair = example.generateKeyPair();
    }

    @Test
    void shouldEncodePublicKeyIntoPem() {
        String pem =
            example.encodePublicKey(keyPair.getPublic());

        assertNotNull(pem);
        assertTrue(pem.startsWith("-----BEGIN PUBLIC KEY-----"));
        assertTrue(pem.contains("-----END PUBLIC KEY-----"));
    }

    @Test
    void shouldDecodePublicKeyFromPem() {
        String pem =
            example.encodePublicKey(keyPair.getPublic());

        PublicKey decoded =
            example.decodePublicKey(pem);

        assertNotNull(decoded);
        assertEquals("RSA", decoded.getAlgorithm());

        assertArrayEquals(
            keyPair.getPublic().getEncoded(),
            decoded.getEncoded()
        );
    }

    @Test
    void shouldEncodePrivateKeyIntoPem() {
        String pem =
            example.encodePrivateKey(keyPair.getPrivate());

        assertNotNull(pem);
        assertTrue(pem.startsWith("-----BEGIN PRIVATE KEY-----"));
        assertTrue(pem.contains("-----END PRIVATE KEY-----"));
    }

    @Test
    void shouldDecodePrivateKeyFromPem() {
        String pem =
            example.encodePrivateKey(keyPair.getPrivate());

        PrivateKey decoded =
            example.decodePrivateKey(pem);

        assertNotNull(decoded);
        assertEquals("RSA", decoded.getAlgorithm());

        assertArrayEquals(
            keyPair.getPrivate().getEncoded(),
            decoded.getEncoded()
        );
    }

    @Test
    void shouldRejectInvalidPemContent() {
        String invalidPem = "This is not a valid PEM document";

        assertThrows(
            IllegalArgumentException.class,
            () -> example.decodePublicKey(invalidPem)
        );
    }
}
