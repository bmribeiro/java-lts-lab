
package pt.bmribeiro.javalts.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PEMDecoder;
import java.security.PEMEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Demonstrates the PEM Encodings API introduced by JEP 470.
 *
 * JEP: 470
 * Introduced: Java 25
 * Status: Preview
 * Package: java.security
 * Module: java.base
 *
 * PEM is a textual format used to represent cryptographic
 * objects through Base64-encoded DER data.
 *
 * PEMEncoder converts supported Java cryptographic objects
 * into PEM representations.
 *
 * PEMDecoder converts PEM representations back into
 * Java cryptographic objects.
 *
 * Preview features require --enable-preview at compilation
 * and execution time.
 */
public class PEMEncodingsExample {

    private final PEMEncoder encoder = PEMEncoder.of();
    private final PEMDecoder decoder = PEMDecoder.of();

    /**
     * Generates an RSA key pair for demonstration purposes.
     */
    public KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator =
            KeyPairGenerator.getInstance("RSA");

        generator.initialize(2048);

        return generator.generateKeyPair();
    }

    /**
     * Encodes a public key into PEM format.
     */
    public String encodePublicKey(PublicKey publicKey) {
        return encoder.encodeToString(publicKey);
    }

    /**
     * Decodes a PEM representation into a public key.
     */
    public PublicKey decodePublicKey(String pem) {
        return decoder.decode(pem, PublicKey.class);
    }

    /**
     * Encodes a private key into PEM format.
     */
    public String encodePrivateKey(PrivateKey privateKey) {
        return encoder.encodeToString(privateKey);
    }

    /**
     * Decodes a PEM representation into a private key.
     */
    public PrivateKey decodePrivateKey(String pem) {
        return decoder.decode(pem, PrivateKey.class);
    }

    public static void main(String[] args) throws Exception {
        PEMEncodingsExample example = new PEMEncodingsExample();

        KeyPair keyPair = example.generateKeyPair();

        String publicKeyPem =
            example.encodePublicKey(keyPair.getPublic());

        String privateKeyPem =
            example.encodePrivateKey(keyPair.getPrivate());

        PublicKey decodedPublicKey =
            example.decodePublicKey(publicKeyPem);

        PrivateKey decodedPrivateKey =
            example.decodePrivateKey(privateKeyPem);

        System.out.println("Public key PEM:");
        System.out.println(publicKeyPem);

        System.out.println(
            "Public key decoded: "
                + decodedPublicKey.getAlgorithm()
        );

        System.out.println(
            "Private key decoded: "
                + decodedPrivateKey.getAlgorithm()
        );
    }
}
