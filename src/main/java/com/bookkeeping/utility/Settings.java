package com.bookkeeping.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    public static Properties properties = new Properties();

    public static void readConfig() {
        try {
            properties.load(
                    new FileInputStream("src/main/resources/config.properties")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
