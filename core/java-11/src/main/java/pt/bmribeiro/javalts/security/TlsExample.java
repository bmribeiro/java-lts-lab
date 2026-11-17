
package pt.bmribeiro.javalts.security;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class TlsExample {

    private static final String TLS_13 = "TLSv1.3";

    public SSLContext createTls13Context()
        throws NoSuchAlgorithmException, KeyManagementException {

        SSLContext context = SSLContext.getInstance(TLS_13);

        context.init(null, null, null);

        return context;
    }

    public List<String> getEnabledProtocols()
        throws NoSuchAlgorithmException, KeyManagementException {

        SSLEngine engine = createTls13Context().createSSLEngine();

        return Arrays.asList(
            engine.getEnabledProtocols()
        );
    }

    public boolean isTls13Enabled()
        throws NoSuchAlgorithmException, KeyManagementException {

        return getEnabledProtocols().contains(TLS_13);
    }
}
