package dev.asjordi;

import java.util.Properties;

public class GlobalProperties {

    private static GlobalProperties instance;
    private final Properties properties;

    private GlobalProperties() {
        this.properties = new Properties();
    }

    public static GlobalProperties getInstance() {
        if (instance == null) instance = new GlobalProperties();
        return instance;
    }

    public void loadPropertiesFromEnv() {
        this.properties.setProperty("OPENWEATHER_API_URL", "https://api.openweathermap.org/data/2.5/weather");
        this.properties.setProperty("OPENWEATHER_TOKEN", System.getenv("OPENWEATHER_TOKEN"));
        this.properties.setProperty("OPENWEATHER_ZIP_CODE", System.getenv("OPENWEATHER_ZIP_CODE"));
        this.properties.setProperty("OPENWEATHER_LANG", System.getenv("OPENWEATHER_LANG"));
        this.properties.setProperty("OPENWEATHER_UNITS", System.getenv("OPENWEATHER_UNITS"));
        this.properties.setProperty("TELEGRAM_BOT_TOKEN", System.getenv("TELEGRAM_BOT_TOKEN"));
        this.properties.setProperty("TELEGRAM_CHAT_ID", System.getenv("TELEGRAM_CHAT_ID"));
    }

    public String getProperty(String key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        String value = this.properties.getProperty(key);
        if (value == null) throw new IllegalArgumentException("Property not found for key: " + key);
        return value;
    }

}
