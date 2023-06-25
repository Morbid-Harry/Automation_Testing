package pageObjects;

import managers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * POM representation of Dashboard page
 */
public class DashboardPage extends SideBar{
    WebDriver driver;
    @FindBy(tagName = "h1")
    WebElement welcomeMessage;
    @FindBy(linkText= "View Details")
    private List<WebElement> viewDetailsButtons;

    @FindBy(id = "show-interest")
    private WebElement showInterestButton;

    @FindBy(className = "alert-success")
    private WebElement emailSentMessage;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage()
    {
        return welcomeMessage.getText();
    }

    public void viewSpecificRecord(String companyName, String projectName)
    {

        //Construct the XPath expression for specific record
        String xpathExpression = String.format("//h5[contains(text(), '%s') and contains(text(), '%s')]/ancestor::div[@class='card my-2']", companyName, projectName);

        //Find the specific card
        WebElement card = driver.findElement(By.xpath(xpathExpression));

        //Get the button of that card and click it
        WebElement viewDetails = card.findElement(By.linkText("View Details"));
        viewDetails.click();
    }

    public void showInterestInProject()
    {
        viewDetailsButtons.get(0).click();

        //Wait for the show interest button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(showInterestButton));

        showInterestButton.click();
    }

    public boolean isSuccessVisible()
    {
        //Give time for the response as have to wait for email to send
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return emailSentMessage.isDisplayed();
    }


}
