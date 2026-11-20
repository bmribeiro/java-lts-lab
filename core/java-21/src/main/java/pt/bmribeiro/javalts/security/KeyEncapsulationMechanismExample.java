package pt.bmribeiro.javalts.security;

import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;

/**
 * Demonstrates the Key Encapsulation Mechanism (KEM) API introduced
 * in Java 21.
 *
 * <p>A KEM allows two parties to establish a shared secret using
 * asymmetric cryptography.</p>
 *
 * <p>The receiver generates an asymmetric key pair and shares
 * the public key. The sender uses that public key to encapsulate
 * a shared secret. The receiver uses the corresponding private
 * key to decapsulate the message and recover the same secret.</p>
 *
 * <p>This example uses DHKEM with X25519.</p>
 *
 * <p>Interview notes:
 * <ul>
 *   <li>KEM provides standardized key encapsulation and decapsulation.</li>
 *   <li>The sender uses the receiver's public key.</li>
 *   <li>The receiver uses their private key to recover the secret.</li>
 *   <li>The encapsulation message is sent to the receiver.</li>
 *   <li>The shared secret can be used as input for symmetric key derivation.</li>
 *   <li>KEM does not directly encrypt application messages.</li>
 *   <li>Algorithm availability depends on the installed security providers.</li>
 * </ul>
 * </p>
 *
 * <p>JEP: 452</p>
 * <p>Introduced: Java 21</p>
 * <p>Preview: Not applicable</p>
 * <p>Finalized: Java 21</p>
 * <p>Target Version: Java 21</p>
 * <p>Category: Security / Cryptography</p>
 *
 * @see <a href="https://openjdk.org/jeps/452">
 *     JEP 452: Key Encapsulation Mechanism API</a>
 */
public final class KeyEncapsulationMechanismExample {

    private KeyEncapsulationMechanismExample() {
    }

    /**
     * Establishes a shared secret between a sender and a receiver.
     *
     * @return true if both parties derive the same secret
     * @throws GeneralSecurityException if a cryptographic operation fails
     */
    public static boolean establishSharedSecret()
        throws GeneralSecurityException {

        // Receiver generates an asymmetric key pair.
        KeyPairGenerator keyPairGenerator =
            KeyPairGenerator.getInstance("X25519");

        KeyPair receiverKeyPair =
            keyPairGenerator.generateKeyPair();

        // Sender encapsulates a secret using the receiver's public key.
        KEM kem = KEM.getInstance("DHKEM");

        KEM.Encapsulated encapsulated =
            kem.newEncapsulator(receiverKeyPair.getPublic())
                .encapsulate();

        SecretKey senderSecret = encapsulated.key();

        // Receiver decapsulates the message using their private key.
        SecretKey receiverSecret =
            kem.newDecapsulator(receiverKeyPair.getPrivate())
                .decapsulate(encapsulated.encapsulation());

        // Verify that both parties derived the same secret.
        return MessageDigest.isEqual(
            senderSecret.getEncoded(),
            receiverSecret.getEncoded()
        );
    }

    public static void main(String[] args)
        throws GeneralSecurityException {

        boolean successful = establishSharedSecret();

        System.out.println(
            "Shared secret successfully established: " + successful
        );
    }
}
