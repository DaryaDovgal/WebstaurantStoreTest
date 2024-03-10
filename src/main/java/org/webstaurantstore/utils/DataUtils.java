package org.webstaurantstore.utils;

import java.io.*;
import java.util.Properties;

public class DataUtils {

    private static final String propertiesFile = "src/main/resources/config.properties";
    private static Properties properties = new Properties();
    private static boolean propIsLoaded = false;

    /*
    Loads properties file
     */
    public static void loadProperties(){
        try{
            FileInputStream file = new FileInputStream(propertiesFile);
            properties.load(file);
            propIsLoaded = true;
        } catch (IOException e) {
            System.out.println("Could not load property file. " + e.getMessage());
        }
    }

    /*
    Returns Value from properties file with provided Key
     */
    public static String getProperty(String key){
        if (!propIsLoaded){
            loadProperties();
        }
        return properties.getProperty(key);
    }
}
