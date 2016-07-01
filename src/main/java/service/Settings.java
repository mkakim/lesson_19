package service;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Created by Merei on 29.06.2016.
 */
public class Settings {
    private static final Settings INSTANCE = new Settings();
    public static Settings getInstance() {
        return INSTANCE;
    }

    private final Properties properties = new Properties();

    private Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("mkakim.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String value(String key) {
        return this.properties.getProperty(key);
    }
}
