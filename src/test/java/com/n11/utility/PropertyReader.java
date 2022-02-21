package com.n11.utility;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertyReader {

    private static Properties properties;

    static {

        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}