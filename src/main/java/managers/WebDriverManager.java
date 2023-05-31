package managers;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This is so we don't need to create a driver in each of our tests
 * which would then mean we need to change each driver separately if
 * e.g. if the browser we are testing in changes
 *
 * Also ensures step definitions doesn't need to handle driver logic
 */
public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;

    /**
     * Reads in the browser type being used from the properties file
     * and assigns to driverType
     */
    public WebDriverManager()
    {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    }


    /**
     *
     * @return the driver or create and return if one doesn't exist
     */
    public WebDriver getDriver()
    {
        if(driver == null)
        {
            driver = createLocalDriver();
        }
        return driver;
    }

    /**
     *
     * @return a driver with stated browser type in config file
     */
    private WebDriver createLocalDriver()
    {
        switch (driverType) {
            case EDGE -> driver = new EdgeDriver();
            case CHROME -> driver = new ChromeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
        }
        return driver;
    }

    /**
     * Close & quit the driver to ensure it's not left open when tests are finished
     */
    public void closeDriver()
    {
        driver.close();
        driver.quit();
    }


}
