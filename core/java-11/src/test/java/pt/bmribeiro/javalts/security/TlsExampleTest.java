
package pt.bmribeiro.javalts.security;

import org.junit.jupiter.api.Test;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TlsExampleTest {

    private final TlsExample example = new TlsExample();

    @Test
    void shouldCreateTls13Context() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext context = example.createTls13Context();

        assertNotNull(context);
        assertEquals("TLSv1.3", context.getProtocol());
    }

    @Test
    void shouldIncludeTls13AmongEnabledProtocols()
        throws NoSuchAlgorithmException, KeyManagementException {

        List<String> protocols = example.getEnabledProtocols();

        assertTrue(protocols.contains("TLSv1.3"));
    }

    @Test
    void shouldConfirmTls13IsEnabled()
        throws NoSuchAlgorithmException, KeyManagementException {

        assertTrue(example.isTls13Enabled());
    }
}
