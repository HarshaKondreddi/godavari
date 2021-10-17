package com.zerodhatech.godavari;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

    /***
     * gets properties mentioned in properties files
     * @param property
     * @return
     * @throws IOException
     */
    public static String getPropertyName(String property) throws IOException {
        FileReader reader = new FileReader("application.properties");
        Properties properties = new Properties();
        properties.load(reader);
        return properties.getProperty(property);
    }
}
