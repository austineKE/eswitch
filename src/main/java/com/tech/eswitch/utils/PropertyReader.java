package com.tech.eswitch.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final String PROPERTY_FILE = "application.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
