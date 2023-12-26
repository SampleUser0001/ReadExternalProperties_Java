package sample.props.enums;

import java.util.Properties;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.IOException;

public enum SamplePropertiesEnum {
    SAMPLE_KEY("sample.key");

    private static Properties properties;
    
    private final String key;

    private SamplePropertiesEnum(String key) {
        this.key = key;
    }

    public static void load(String propertiesPath) {
        properties = new Properties();
        try (InputStream in = SamplePropertiesEnum.class.getClassLoader().getResourceAsStream(propertiesPath)){
            properties.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue() {
        return properties.getProperty(this.key);
    }
}

