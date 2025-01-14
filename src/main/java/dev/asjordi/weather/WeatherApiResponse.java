package dev.asjordi.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class WeatherApiResponse {

    @JsonProperty("coord")
    private Coordinates coordinates;

    @JsonProperty("weather")
    private List<WeatherCondition> weatherConditions;

    @JsonProperty("base")
    private String dataSource;

    @JsonProperty("main")
    private TemperatureDetails temperatureDetails;

    @JsonProperty("visibility")
    private int visibilityMeters;

    @JsonProperty("wind")
    private WindDetails windDetails;

    @JsonProperty("rain")
    private RainDetails rainDetails;

    @JsonProperty("clouds")
    private CloudCoverage cloudCoverage;

    @JsonProperty("dt")
    private long timestamp;

    @JsonProperty("sys")
    private SystemDetails systemDetails;

    @JsonProperty("timezone")
    private int timezoneOffset;

    @JsonProperty("id")
    private int locationId;

    @JsonProperty("name")
    private String locationName;

    @JsonProperty("cod")
    private int responseCode;

    @Data
    @NoArgsConstructor
    public static class Coordinates {

        @JsonProperty("lon")
        private double longitude;

        @JsonProperty("lat")
        private double latitude;

    }

    @Data
    @NoArgsConstructor
    public static class WeatherCondition {

        @JsonProperty("id")
        private int conditionId;

        @JsonProperty("main")
        private String conditionGroup;

        @JsonProperty("description")
        private String conditionDescription;

        @JsonProperty("icon")
        private String conditionIcon;

    }

    @Data
    @NoArgsConstructor
    public static class TemperatureDetails {

        @JsonProperty("temp")
        private double currentTemperature;

        @JsonProperty("feels_like")
        private double perceivedTemperature;

        @JsonProperty("temp_min")
        private double minimumTemperature;

        @JsonProperty("temp_max")
        private double maximumTemperature;

        @JsonProperty("pressure")
        private int atmosphericPressure;

        @JsonProperty("humidity")
        private int humidityPercentage;

        @JsonProperty("sea_level")
        private int seaLevelPressure;

        @JsonProperty("grnd_level")
        private int groundLevelPressure;

    }

    @Data
    @NoArgsConstructor
    public static class WindDetails {

        @JsonProperty("speed")
        private double windSpeed;

        @JsonProperty("deg")
        private int windDirectionDegrees;

        @JsonProperty("gust")
        private double windGustSpeed;

    }

    @Data
    @NoArgsConstructor
    public static class RainDetails {

        @JsonProperty("1h")
        private double rainfallLastHour;

    }

    @Data
    @NoArgsConstructor
    public static class CloudCoverage {

        @JsonProperty("all")
        private int cloudinessPercentage;

    }

    @Data
    @NoArgsConstructor
    public static class SystemDetails {

        @JsonProperty("type")
        private int systemType;

        @JsonProperty("id")
        private int systemId;

        @JsonProperty("country")
        private String countryCode;

        @JsonProperty("sunrise")
        private long sunriseTime;

        @JsonProperty("sunset")
        private long sunsetTime;

    }
}
