package pageObjects;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * POM representation of login page
 */
public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "sign-in")
    private WebElement loginButton;

    ConfigFileReader configFileReader;

    public LoginPage(WebDriver driver)
    {
        configFileReader = new ConfigFileReader();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo_LoginPage()
    {
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    public void login(String username, String password)
    {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
