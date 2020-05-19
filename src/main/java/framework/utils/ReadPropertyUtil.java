package framework.utils;

import aquality.selenium.browser.AqualityServices;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyUtil {

        private static final String RESOURCES_PATH = "src/main/resources/";
        private static Properties properties;

        private static void readProperties() {
            if (properties == null) {
                properties = new Properties();
            }
            try {
                properties.load(new FileReader(new File(RESOURCES_PATH, "frame.properties")));
            } catch (IOException ex) {
                AqualityServices.getLogger().error(ex.getMessage());
            }
        }

        public static String getData(String data) {
            initializeProperties();
            return properties.getProperty(data);
        }

        private static void initializeProperties() {
            if (properties == null) {
                readProperties();
            }
        }
    }
