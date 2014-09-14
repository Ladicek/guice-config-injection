package cz.ladicek.guiceConfigInjection;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static Injector injector() throws IOException {
        return Guice.createInjector(new PropertiesModule(loadConfig()));
    }

    private static Properties loadConfig() throws IOException {
        Properties config = new Properties();
        InputStream stream = null;
        try {
            stream = Main.class.getResourceAsStream("/config.properties");
            config.load(stream);
            return config;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}
