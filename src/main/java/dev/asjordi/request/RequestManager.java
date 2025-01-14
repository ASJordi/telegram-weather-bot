package dev.asjordi.request;

import dev.asjordi.GlobalProperties;
import dev.asjordi.logger.LoggerConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestManager {

    private static final Logger LOGGER = LoggerConfig.getLogger();
    private final GlobalProperties props = GlobalProperties.getInstance();
    private String URL = "";

    public RequestManager() {
        this.props.loadPropertiesFromEnv();
        buildURL();
    }

    private void buildURL() {
        LOGGER.log(Level.INFO, () -> "Building URL for OpenWeather API request");
        this.URL = String.format("%s?zip=%s&units=%s&lang=%s&appid=%s",
                props.getProperty("OPENWEATHER_API_URL"),
                props.getProperty("OPENWEATHER_ZIP_CODE"),
                props.getProperty("OPENWEATHER_UNITS"),
                props.getProperty("OPENWEATHER_LANG"),
                props.getProperty("OPENWEATHER_TOKEN"));
        LOGGER.log(Level.INFO, () -> "URL built successfully");
    }

    public Optional<HttpResponse<String>> makeRequest() {
        LOGGER.log(Level.INFO, () -> "Starting HTTP request to OpenWeather API");
        HttpRequest request = null;

        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(this.URL))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .timeout(Duration.of(60, ChronoUnit.SECONDS))
                    .GET()
                    .build();

            LOGGER.log(Level.INFO, () -> "HTTP request build successfully");
        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, () -> "Failed to build HTTP request: " + e);
        }

        HttpResponse<String> response = null;

        try (HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.of(20, ChronoUnit.SECONDS))
                .build()) {

            LOGGER.log(Level.INFO, () -> "HTTP client built successfully");
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            LOGGER.log(Level.INFO, () -> "HTTP request sent successfully");
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, () -> "Failed to send HTTP request: " + e);
        }

        return Optional.ofNullable(response);
    }

}
