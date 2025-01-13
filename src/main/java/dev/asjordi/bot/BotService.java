package dev.asjordi.bot;

import dev.asjordi.GlobalProperties;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BotService {

    private final GlobalProperties props = GlobalProperties.getInstance();
    private final WeatherBot bot;

    public BotService() {
        this.props.loadPropertiesFromEnv();
        this.bot = new WeatherBot(props.getProperty("TELEGRAM_BOT_TOKEN"));
    }

    public boolean sendWeatherReport(String report) {

        try (TelegramBotsLongPollingApplication botsApp = new TelegramBotsLongPollingApplication()) {
            botsApp.registerBot(props.getProperty("TELEGRAM_BOT_TOKEN"), bot);

            SendMessage message = SendMessage
                    .builder()
                    .chatId(Long.parseLong(props.getProperty("TELEGRAM_CHAT_ID")))
                    .text(report)
                    .build();

            bot.getTelegramClient().execute(message);
        } catch (Exception e) {
            System.out.println("Error sending message: " + e.getMessage());
            return false;
        }

        return true;
    }

}
