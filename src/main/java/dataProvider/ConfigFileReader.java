package dataProvider;

import enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Allows the reading of the config file
 */
public class ConfigFileReader {
    private Properties properties;

    /**
     * Performs the file reading and assigns it to the properties object
     */
    public ConfigFileReader()
    {
        String propertyFilePath = "configs//Configuration.properties";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Config not found at path" + propertyFilePath);
        }
    }

    /**
     *
     * @return the url in the properties objects (Which is found in the config file)
     */
    public String getUrl()
    {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("Url not Specified in Configuration.properties file.");
    }

    /**
     * Using the config file allows easy switching which browser is under test
     * @return the enum of which browser is listed in the config file.
     */
    public DriverType getBrowser()
    {
        String browserName = properties.getProperty("browser");
        return switch (browserName) {
            case "chrome" -> DriverType.CHROME;
            case "firefox" -> DriverType.FIREFOX;
            case "edge" -> DriverType.EDGE;
            default -> throw new RuntimeException("Browser type value " + browserName + " in Configuration properties file");
        };
    }


}
