package dev.asjordi;

import dev.asjordi.bot.BotService;
import dev.asjordi.weather.WeatherDataProcessor;

public class Main {

    public static void main(String[] args) {

        WeatherDataProcessor processor = new WeatherDataProcessor();
        processor.processData();
        var report = processor.getReport();

        BotService botService = new BotService();
        boolean status = botService.sendWeatherReport(report);

        if (status) System.out.println("Weather report sent successfully");
        else System.out.println("Error sending weather report");

        System.exit(0);

    }

}