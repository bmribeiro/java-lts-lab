package pt.bmribeiro.javalts.http;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientExampleTest {

    private final HttpClientExample example = new HttpClientExample();

    @Test
    void shouldCreateGetRequest() {
        URI uri = URI.create("https://example.com/api/books");

        HttpRequest request = example.createGetRequest(uri);

        assertEquals(uri, request.uri());
        assertEquals("GET", request.method());
        assertTrue(request.timeout().isPresent());
    }

    @Test
    void shouldConfigureRequestTimeout() {
        HttpRequest request = example.createGetRequest(
            URI.create("https://example.com")
        );

        assertEquals(
            30,
            request.timeout().get().toSeconds()
        );
    }
}
