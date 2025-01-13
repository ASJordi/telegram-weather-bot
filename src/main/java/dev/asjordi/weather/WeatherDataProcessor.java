package dev.asjordi.weather;

import dev.asjordi.request.RequestManager;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherDataProcessor {

    private final RequestManager requestManager;
    private final DataMapper dataMapper;
    private String report;

    public WeatherDataProcessor() {
        this.requestManager = new RequestManager();
        this.dataMapper = new DataMapper();
    }

    public void processData() {
        var response = requestManager.makeRequest();
        WeatherApiResponse dataWeather;

        if (response.isPresent()) dataWeather = dataMapper.mapDataToObject(response);
        else throw new RuntimeException("Error getting data from API");

        generateReport(dataWeather);
    }

    private void generateReport(WeatherApiResponse response) {
        StringBuilder message = new StringBuilder();

        String cityName = response.getLocationName();
        String countryCode = response.getSystemDetails().getCountryCode();
        double currentTemperature = response.getTemperatureDetails().getCurrentTemperature();
        double perceivedTemperature = response.getTemperatureDetails().getPerceivedTemperature();
        String conditionDescription = response.getWeatherConditions().getFirst().getConditionDescription();
        int humidityPercentage = response.getTemperatureDetails().getHumidityPercentage();
        int levelPressure = response.getTemperatureDetails().getSeaLevelPressure();
        double windSpeed = response.getWindDetails().getWindSpeed();
        int windDirectionDegrees = response.getWindDetails().getWindDirectionDegrees();
        long timestamp = response.getTimestamp();
        String formattedDate = convertTime(timestamp);

        message.append("🌤 - Reporte climático para ")
                .append(cityName).append(", ").append(countryCode).append(" -\n")
                .append("🌡️ Temperatura actual: ").append(String.format("%.1f°C\n", currentTemperature))
                .append("🤗 Sensación térmica: ").append(String.format("%.1f°C\n", perceivedTemperature))
                .append("☁️ Clima: ").append(conditionDescription).append("\n")
                .append("💧 Humedad: ").append(humidityPercentage).append("%\n")
                .append("🌪️ Presión: ").append(levelPressure).append(" hPa\n")
                .append("🍃 Viento: ").append(String.format("%.2f m/s desde %d°\n", windSpeed, windDirectionDegrees))
                .append("⏰ Última actualización: ").append(formattedDate);

        this.report = message.toString();
    }

    private String convertTime(long epoch) {
        ZonedDateTime fecha = Instant.ofEpochSecond(epoch).atZone(ZoneId.of("America/Mexico_City"));
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return fecha.format(formato);
    }

    public String getReport() {
        return report;
    }

}
