package dev.asjordi.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

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

    // Getters and Setters

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<WeatherCondition> getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(List<WeatherCondition> weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public TemperatureDetails getTemperatureDetails() {
        return temperatureDetails;
    }

    public void setTemperatureDetails(TemperatureDetails temperatureDetails) {
        this.temperatureDetails = temperatureDetails;
    }

    public int getVisibilityMeters() {
        return visibilityMeters;
    }

    public void setVisibilityMeters(int visibilityMeters) {
        this.visibilityMeters = visibilityMeters;
    }

    public WindDetails getWindDetails() {
        return windDetails;
    }

    public void setWindDetails(WindDetails windDetails) {
        this.windDetails = windDetails;
    }

    public RainDetails getRainDetails() {
        return rainDetails;
    }

    public void setRainDetails(RainDetails rainDetails) {
        this.rainDetails = rainDetails;
    }

    public CloudCoverage getCloudCoverage() {
        return cloudCoverage;
    }

    public void setCloudCoverage(CloudCoverage cloudCoverage) {
        this.cloudCoverage = cloudCoverage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public SystemDetails getSystemDetails() {
        return systemDetails;
    }

    public void setSystemDetails(SystemDetails systemDetails) {
        this.systemDetails = systemDetails;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public static class Coordinates {

        @JsonProperty("lon")
        private double longitude;

        @JsonProperty("lat")
        private double latitude;

        // Getters and Setters

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
    }

    public static class WeatherCondition {

        @JsonProperty("id")
        private int conditionId;

        @JsonProperty("main")
        private String conditionGroup;

        @JsonProperty("description")
        private String conditionDescription;

        @JsonProperty("icon")
        private String conditionIcon;

        // Getters and Setters

        public int getConditionId() {
            return conditionId;
        }

        public void setConditionId(int conditionId) {
            this.conditionId = conditionId;
        }

        public String getConditionGroup() {
            return conditionGroup;
        }

        public void setConditionGroup(String conditionGroup) {
            this.conditionGroup = conditionGroup;
        }

        public String getConditionDescription() {
            return conditionDescription;
        }

        public void setConditionDescription(String conditionDescription) {
            this.conditionDescription = conditionDescription;
        }

        public String getConditionIcon() {
            return conditionIcon;
        }

        public void setConditionIcon(String conditionIcon) {
            this.conditionIcon = conditionIcon;
        }
    }

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

        // Getters and Setters

        public double getCurrentTemperature() {
            return currentTemperature;
        }

        public void setCurrentTemperature(double currentTemperature) {
            this.currentTemperature = currentTemperature;
        }

        public double getPerceivedTemperature() {
            return perceivedTemperature;
        }

        public void setPerceivedTemperature(double perceivedTemperature) {
            this.perceivedTemperature = perceivedTemperature;
        }

        public double getMinimumTemperature() {
            return minimumTemperature;
        }

        public void setMinimumTemperature(double minimumTemperature) {
            this.minimumTemperature = minimumTemperature;
        }

        public double getMaximumTemperature() {
            return maximumTemperature;
        }

        public void setMaximumTemperature(double maximumTemperature) {
            this.maximumTemperature = maximumTemperature;
        }

        public int getAtmosphericPressure() {
            return atmosphericPressure;
        }

        public void setAtmosphericPressure(int atmosphericPressure) {
            this.atmosphericPressure = atmosphericPressure;
        }

        public int getHumidityPercentage() {
            return humidityPercentage;
        }

        public void setHumidityPercentage(int humidityPercentage) {
            this.humidityPercentage = humidityPercentage;
        }

        public int getSeaLevelPressure() {
            return seaLevelPressure;
        }

        public void setSeaLevelPressure(int seaLevelPressure) {
            this.seaLevelPressure = seaLevelPressure;
        }

        public int getGroundLevelPressure() {
            return groundLevelPressure;
        }

        public void setGroundLevelPressure(int groundLevelPressure) {
            this.groundLevelPressure = groundLevelPressure;
        }
    }

    public static class WindDetails {

        @JsonProperty("speed")
        private double windSpeed;

        @JsonProperty("deg")
        private int windDirectionDegrees;

        @JsonProperty("gust")
        private double windGustSpeed;

        // Getters and Setters

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public int getWindDirectionDegrees() {
            return windDirectionDegrees;
        }

        public void setWindDirectionDegrees(int windDirectionDegrees) {
            this.windDirectionDegrees = windDirectionDegrees;
        }

        public double getWindGustSpeed() {
            return windGustSpeed;
        }

        public void setWindGustSpeed(double windGustSpeed) {
            this.windGustSpeed = windGustSpeed;
        }
    }

    public static class RainDetails {

        @JsonProperty("1h")
        private double rainfallLastHour;

        // Getters and Setters

        public double getRainfallLastHour() {
            return rainfallLastHour;
        }

        public void setRainfallLastHour(double rainfallLastHour) {
            this.rainfallLastHour = rainfallLastHour;
        }
    }

    public static class CloudCoverage {

        @JsonProperty("all")
        private int cloudinessPercentage;

        // Getters and Setters

        public int getCloudinessPercentage() {
            return cloudinessPercentage;
        }

        public void setCloudinessPercentage(int cloudinessPercentage) {
            this.cloudinessPercentage = cloudinessPercentage;
        }
    }

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

        // Getters and Setters

        public int getSystemType() {
            return systemType;
        }

        public void setSystemType(int systemType) {
            this.systemType = systemType;
        }

        public int getSystemId() {
            return systemId;
        }

        public void setSystemId(int systemId) {
            this.systemId = systemId;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public long getSunriseTime() {
            return sunriseTime;
        }

        public void setSunriseTime(long sunriseTime) {
            this.sunriseTime = sunriseTime;
        }

        public long getSunsetTime() {
            return sunsetTime;
        }

        public void setSunsetTime(long sunsetTime) {
            this.sunsetTime = sunsetTime;
        }
    }
}
