package dev.asjordi.bot;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class WeatherBot implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;

    public WeatherBot(String token) {
        this.telegramClient = new OkHttpTelegramClient(token);
    }

    @Override
    public void consume(Update update) {
        // Do nothing
    }

    public TelegramClient getTelegramClient() {
        return telegramClient;
    }
}
