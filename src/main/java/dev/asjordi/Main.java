package dev.asjordi;

import dev.asjordi.bot.BotService;
import dev.asjordi.logger.LoggerConfig;
import dev.asjordi.weather.WeatherDataProcessor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = LoggerConfig.getLogger();

    public static void main(String[] args) {

        LoggerConfig.setupLogger();
        LOGGER.log(Level.INFO, () -> "Starting application");

        WeatherDataProcessor processor = new WeatherDataProcessor();
        processor.processData();
        var report = processor.getReport();

        BotService botService = new BotService();
        botService.sendWeatherReport(report);
        System.exit(0);

    }

}