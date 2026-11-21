
package pt.bmribeiro.javalts.security;

import javax.crypto.KDF;
import javax.crypto.SecretKey;
import javax.crypto.spec.HKDFParameterSpec;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;

/**
 * Demonstrates the Key Derivation Function API introduced by JEP 510.
 *
 * Context:
 * Applications often need to derive multiple cryptographic keys
 * from shared initial keying material.
 *
 * JEP: 510 - Key Derivation Function API
 * Preview: Java 24 (JEP 478)
 * Finalized: Java 25
 * Compilation: Java 25
 * Category: Security / Cryptography
 *
 * Technical Explanation:
 * HKDF-SHA256 implements the HMAC-based Extract-and-Expand
 * Key Derivation Function defined by RFC 5869.
 *
 * Extract converts the input keying material into a
 * pseudorandom key. Expand derives output key material
 * using additional context information.
 *
 * Comparison:
 * Unlike manually composing cryptographic primitives,
 * KDF provides a standard API for key derivation.
 *
 * Practical Application:
 * Useful for deriving separate encryption keys from
 * shared cryptographic material.
 *
 * Security Note:
 * HKDF is not a password hashing function. Do not use it
 * directly to store or derive keys from human passwords.
 */
public class KeyDerivationFunctionExample {

    private static final String KDF_ALGORITHM = "HKDF-SHA256";

    private static final String KEY_ALGORITHM = "AES";

    private static final int AES_KEY_LENGTH = 32;

    /**
     * Derives an AES key using HKDF-SHA256.
     *
     * @param initialKeyMaterial initial cryptographic key material
     * @param salt additional extraction input
     * @param info application-specific context information
     * @return derived AES secret key
     * @throws NoSuchAlgorithmException if the KDF is unavailable
     * @throws InvalidAlgorithmParameterException if parameters are invalid
     */
    public static SecretKey deriveAesKey(
        byte[] initialKeyMaterial,
        byte[] salt,
        byte[] info
    ) throws NoSuchAlgorithmException,
        InvalidAlgorithmParameterException {

        KDF kdf = KDF.getInstance(KDF_ALGORITHM);

        HKDFParameterSpec parameters =
            HKDFParameterSpec.ofExtract()
                .addIKM(initialKeyMaterial)
                .addSalt(salt)
                .thenExpand(info, AES_KEY_LENGTH);

        return kdf.deriveKey(KEY_ALGORITHM, parameters);
    }

    public static void main(String[] args)
        throws NoSuchAlgorithmException,
        InvalidAlgorithmParameterException {

        byte[] initialKeyMaterial =
            "example-initial-key-material-32".getBytes();

        byte[] salt =
            "application-salt".getBytes();

        byte[] info =
            "payment-encryption".getBytes();

        SecretKey derivedKey = deriveAesKey(
            initialKeyMaterial,
            salt,
            info
        );

        System.out.println(
            "Algorithm: " + derivedKey.getAlgorithm()
        );

        System.out.println(
            "Key length: " + derivedKey.getEncoded().length * 8
                + " bits"
        );
    }
}
