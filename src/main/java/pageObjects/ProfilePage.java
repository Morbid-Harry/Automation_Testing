package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends SideBar{
    WebDriver driver;

    @FindBy(id = "first-name-input")
    WebElement firstNameInput;
    @FindBy(id = "Last-name-input")
    WebElement lastNameInput;
    @FindBy(id = "grade-input")
    WebElement gradeInput;
    @FindBy(id = "update-details")
    WebElement updateDetailsButton;
    @FindBy(id = "current-password-input")
    WebElement currentPassInput;
    @FindBy(id = "new-password-input")
    WebElement newPassInput;
    @FindBy(id = "confirm-password-input")
    WebElement confirmPassInput;
    @FindBy(id = "update-password")
    WebElement updatePasswordButton;
    @FindBy(className = "alert-success")
    WebElement successMessage;
    @FindBy(className = "alert-danger")
    WebElement failureMessage;

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String input)
    {
        //Clear the input first clear() seems to cause a form issue so have to send keys
        firstNameInput.sendKeys(Keys.CONTROL + "a");
        firstNameInput.sendKeys(Keys.DELETE);
        firstNameInput.sendKeys(input);
    }

    public void enterLastName(String input)
    {
        //Clear the input first clear() seems to cause a form issue so have to send keys
        lastNameInput.sendKeys(Keys.CONTROL + "a");
        lastNameInput.sendKeys(Keys.DELETE);
        lastNameInput.sendKeys(input);
    }

    public void selectGrade(String selectedValue)
    {
        Select gradeSelect = new Select(gradeInput);
        gradeSelect.selectByValue(selectedValue);
    }

    public void updateDetails()
    {
        updateDetailsButton.click();
    }

    public void enterCurrentPassword(String input)
    {
        currentPassInput.sendKeys(input);
    }

    public void enterNewPassword(String input)
    {
        newPassInput.sendKeys(input);
    }

    public void enterConfirmPassword(String input)
    {
        confirmPassInput.sendKeys(input);
    }

    public void updatePassword()
    {
        updatePasswordButton.click();
    }

    public boolean isSuccessVisible()
    {
        //Give time for the response to return message
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return successMessage.isDisplayed();
    }

    public boolean isFailureVisible()
    {
        //Give time for the response to return message
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return failureMessage.isDisplayed();
    }

}
