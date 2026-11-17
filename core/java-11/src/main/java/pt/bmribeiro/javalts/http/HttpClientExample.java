package pt.bmribeiro.javalts.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample {

    private final HttpClient client;

    public HttpClientExample() {
        this.client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();
    }

    /**
     * Builds an HTTP GET request.
     */
    public HttpRequest createGetRequest(URI uri) {
        return HttpRequest.newBuilder()
            .uri(uri)
            .timeout(Duration.ofSeconds(30))
            .GET()
            .build();
    }

    /**
     * Sends a synchronous HTTP GET request.
     */
    public HttpResponse<String> sendGet(URI uri)
        throws IOException, InterruptedException {

        HttpRequest request = createGetRequest(uri);

        return client.send(
            request,
            HttpResponse.BodyHandlers.ofString()
        );
    }

    /**
     * Sends an asynchronous HTTP GET request.
     */
    public CompletableFuture<HttpResponse<String>> sendGetAsync(URI uri) {
        HttpRequest request = createGetRequest(uri);

        return client.sendAsync(
            request,
            HttpResponse.BodyHandlers.ofString()
        );
    }
}
