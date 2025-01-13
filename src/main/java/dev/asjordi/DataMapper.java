package dev.asjordi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Optional;

public class DataMapper {

    private final ObjectMapper mapper;
    private final Path PATH = Path.of("data.json");

    public DataMapper() {
        this.mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public WeatherApiResponse mapDataToObject(Optional<HttpResponse<String>> response) {
        WeatherApiResponse weatherApiResponse = null;

        if (response.isPresent() && response.get().statusCode() == 200) {
            try {
                weatherApiResponse = mapper.readValue(response.get().body(), WeatherApiResponse.class);
            } catch (JsonProcessingException e) {
                System.out.println("Failed to map data to WeatherApiResponse object: " + e);
            }
        } else {
            System.out.println("Error getting data from API\n" + "Status code: " + response.get().statusCode());
        }

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
