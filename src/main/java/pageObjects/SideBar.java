package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SideBar {

    private WebDriver driver;

    @FindBy(linkText = "Create User")
    private WebElement createUserButton;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardButton;

    @FindBy(linkText = "Manage Project Roles")
    private WebElement manageProjectRolesButton;

    public SideBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignout()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign-out")));
        signoutButton.click();
    }

    public void clickDashboard()
    {
        dashboardButton.click();
    }

    public void clickManageProjects()
    {
        manageProjectRolesButton.click();
    }

    public void clickCreateUser()
    {
        createUserButton.click();
    }
    public boolean getVisibleButtons(String buttontext)
    {
        WebElement buttonSearchedFor = driver.findElement(By.linkText(buttontext));

        //Check if element exists
        if(buttonSearchedFor != null)
        {
            //Check if element is displayed
            return buttonSearchedFor.isEnabled();
        }
        else {
            return false;
        }
    }

}
