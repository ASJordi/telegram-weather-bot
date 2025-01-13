package dev.asjordi.bot;

import dev.asjordi.logger.LoggerConfig;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherBot implements LongPollingSingleThreadUpdateConsumer {

    private static final Logger LOGGER = LoggerConfig.getLogger();
    private final TelegramClient telegramClient;

    public WeatherBot(String token) {
        this.telegramClient = new OkHttpTelegramClient(token);
        LOGGER.log(Level.INFO, () -> "WeatherBot initialized");
    }

    @Override
    public void consume(Update update) {
        // Do nothing
    }

    public TelegramClient getTelegramClient() {
        return telegramClient;
    }
}
