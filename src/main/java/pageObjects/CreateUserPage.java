package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * POM representation of the create user page
 */
public class CreateUserPage extends SideBar{
    WebDriver driver;

    @FindBy(id = "first-name-input")
    WebElement firstNameInput;
    @FindBy(id = "Last-name-input")
    WebElement lastNameInput;
    @FindBy(id = "email-input")
    WebElement emailInput;
    @FindBy(id = "grade-input")
    WebElement gradeSelectInput;
    @FindBy(id = "user-name-input")
    WebElement userNameInput;
    @FindBy(id = "password-input")
    WebElement passwordInput;
    @FindBy(id = "option1")
    WebElement isAdminCheckBox;
    @FindBy(id = "option2")
    WebElement isResourceManagerCheckBox;
    @FindBy(id = "sign-up")
    WebElement createAccountButton;

    @FindBy(className = "alert-success")
    WebElement successMessage;
    @FindBy(className = "alert-danger")
    WebElement failureMessage;

    public CreateUserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String input)
    {
        firstNameInput.sendKeys(input);
    }

    public void enterLastName(String input)
    {
        lastNameInput.sendKeys(input);
    }

    public void enterEmail(String input)
    {
        emailInput.sendKeys(input);
    }

    public void selectGrade(String selectedValue)
    {
        Select gradeSelect = new Select(gradeSelectInput);
        gradeSelect.selectByValue(selectedValue);
    }

    public void enterUsername(String input)
    {
        userNameInput.sendKeys(input);
    }

    public void enterPassword(String input)
    {
        passwordInput.sendKeys(input);
    }

    public void isAdmin()
    {
        isAdminCheckBox.click();
    }

    public void isResourceManger()
    {
        isResourceManagerCheckBox.click();
    }

    public void createUser()
    {
        createAccountButton.click();
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

    public void generateRandomUsername(){
        enterUsername(getSaltString());
    }

    public void generateRandomEmail()
    {
        enterEmail(getSaltString()+"@email.com");
    }

    private String getSaltString()
    {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
}
