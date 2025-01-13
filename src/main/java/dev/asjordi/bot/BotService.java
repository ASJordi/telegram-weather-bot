package dev.asjordi.bot;

import dev.asjordi.GlobalProperties;
import dev.asjordi.logger.LoggerConfig;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BotService {

    private static final Logger LOGGER = LoggerConfig.getLogger();
    private final GlobalProperties props = GlobalProperties.getInstance();
    private final WeatherBot bot;

    public BotService() {
        this.props.loadPropertiesFromEnv();
        this.bot = new WeatherBot(props.getProperty("TELEGRAM_BOT_TOKEN"));
        LOGGER.log(Level.INFO, () -> "BotService initialized");
    }

    public boolean sendWeatherReport(String report) {
        LOGGER.log(Level.INFO, () -> "Sending weather report");
        try (TelegramBotsLongPollingApplication botsApp = new TelegramBotsLongPollingApplication()) {
            botsApp.registerBot(props.getProperty("TELEGRAM_BOT_TOKEN"), bot);

            SendMessage message = SendMessage
                    .builder()
                    .chatId(Long.parseLong(props.getProperty("TELEGRAM_CHAT_ID")))
                    .text(report)
                    .build();

            bot.getTelegramClient().execute(message);
            LOGGER.log(Level.INFO, () -> "Weather report sent successfully");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error sending weather report", e);
            return false;
        }

        return true;
    }

}
