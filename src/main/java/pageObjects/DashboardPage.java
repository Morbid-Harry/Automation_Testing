package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * POM representation of Dashboard page
 */
public class DashboardPage extends SideBar{
    WebDriver driver;
    @FindBy(tagName = "h1")
    WebElement welcomeMessage;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage()
    {
        return welcomeMessage.getText();
    }


}
