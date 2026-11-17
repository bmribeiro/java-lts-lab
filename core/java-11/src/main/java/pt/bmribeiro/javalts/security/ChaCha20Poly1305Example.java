
package pt.bmribeiro.javalts.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

public class ChaCha20Poly1305Example {

    private static final String TRANSFORMATION =
        "ChaCha20-Poly1305";

    private static final int KEY_SIZE = 256;
    private static final int NONCE_SIZE = 12;

    public SecretKey generateKey() throws GeneralSecurityException {

        KeyGenerator keyGenerator =
            KeyGenerator.getInstance("ChaCha20");

        keyGenerator.init(KEY_SIZE);

        return keyGenerator.generateKey();
    }

    public byte[] encrypt(
        byte[] plaintext,
        SecretKey key,
        byte[] nonce
    ) throws GeneralSecurityException {

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);

        cipher.init(
            Cipher.ENCRYPT_MODE,
            key,
            new IvParameterSpec(nonce)
        );

        return cipher.doFinal(plaintext);
    }

    public byte[] decrypt(
        byte[] ciphertext,
        SecretKey key,
        byte[] nonce
    ) throws GeneralSecurityException {

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);

        cipher.init(
            Cipher.DECRYPT_MODE,
            key,
            new IvParameterSpec(nonce)
        );

        return cipher.doFinal(ciphertext);
    }

    public byte[] generateNonce() {

        byte[] nonce = new byte[NONCE_SIZE];

        new SecureRandom().nextBytes(nonce);

        return nonce;
    }
}
