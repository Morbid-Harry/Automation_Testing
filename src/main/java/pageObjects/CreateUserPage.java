package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * POM representation of the create user page
 */
public class CreateUserPage extends SideBar{
    WebDriver driver;

    public CreateUserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
