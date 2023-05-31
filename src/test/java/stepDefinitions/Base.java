package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Base {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public managers.WebDriverManager webDriverManager;

    @Before
    public void before()
    {
        this.webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        this.pageObjectManager = new PageObjectManager(driver);
    }

    @After
    public void after()
    {
        webDriverManager.closeDriver();
    }
}
