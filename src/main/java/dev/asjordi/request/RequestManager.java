package dev.asjordi.request;

import dev.asjordi.GlobalProperties;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class RequestManager {

    private GlobalProperties props = GlobalProperties.getInstance();
    private String URL = "";

    public RequestManager() {
        this.props.loadPropertiesFromEnv();
        buildURL();
    }

    private void buildURL() {
        this.URL = String.format("%s?zip=%s&units=%s&lang=%s&appid=%s",
                props.getProperty("OPENWEATHER_API_URL"),
                props.getProperty("OPENWEATHER_ZIP_CODE"),
                props.getProperty("OPENWEATHER_UNITS"),
                props.getProperty("OPENWEATHER_LANG"),
                props.getProperty("OPENWEATHER_TOKEN"));
    }

    public Optional<HttpResponse<String>> makeRequest() {
        HttpRequest request = null;

        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(this.URL))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .timeout(Duration.of(60, ChronoUnit.SECONDS))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            System.out.println("Failed to build HTTP request: " + e);
        }

        HttpResponse<String> response = null;

        try (HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.of(20, ChronoUnit.SECONDS))
                .build()) {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to send HTTP request: " + e);
        }

        return Optional.ofNullable(response);
    }

}
