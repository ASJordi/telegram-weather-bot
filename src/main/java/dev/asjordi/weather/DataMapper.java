package dev.asjordi.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.asjordi.logger.LoggerConfig;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMapper {

    private static final Logger LOGGER = LoggerConfig.getLogger();
    private final ObjectMapper mapper;
    private final Path PATH = Path.of("data.json");

    public DataMapper() {
        this.mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        LOGGER.log(Level.INFO, () -> "DataMapper initialized");
    }

    public WeatherApiResponse mapDataToObject(Optional<HttpResponse<String>> response) {
        WeatherApiResponse weatherApiResponse = null;
        LOGGER.log(Level.INFO, () -> "Mapping data to WeatherApiResponse object");

        if (response.isPresent() && response.get().statusCode() == 200) {
            try {
                weatherApiResponse = mapper.readValue(response.get().body(), WeatherApiResponse.class);
                LOGGER.log(Level.INFO, () -> "Data mapped to WeatherApiResponse object successfully");
            } catch (JsonProcessingException e) {
                LOGGER.log(Level.SEVERE, "Failed to map data to WeatherApiResponse object", e);
            }
        } else LOGGER.log(Level.SEVERE, () -> "No data found in response");

        return weatherApiResponse;
    }

    public boolean mapDataToFile(WeatherApiResponse weatherApiResponse) {
        try {
            this.mapper.writeValue(PATH.toFile(), weatherApiResponse);
        } catch (IOException e) {
            System.out.println("Failed to map WeatherApiResponse object to file: " + e);
            return false;
        }

        return true;
    }

}
