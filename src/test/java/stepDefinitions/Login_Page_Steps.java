package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class Login_Page_Steps {


    WebDriver driver;
    PageObjectManager pageObjectManager;
    public Login_Page_Steps(Base base)
    {
        this.driver = base.driver;
        this.pageObjectManager = base.pageObjectManager;
    }


    @Given("I am on the login page")
    public void onLoginPage()
    {
        pageObjectManager.getLoginPOM().navigateTo_LoginPage();
    }

    @When("I login with the username & password, {string} and {string}")
    public void enterUsernameAndPassword(String username, String password)
    {
        pageObjectManager.getLoginPOM().login(username, password);
    }

    @Then("I should see the text {string}")
    public void iShouldSeeTheText(String expectedMessage) {
        String actualMessage = pageObjectManager.getDashboardPOM().getWelcomeMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("I should see a failed to login message")
    public void iShouldSeeAFailedToLoginMessage() {
        WebElement errorMessage = driver.findElement(By.className("alert-danger"));
        errorMessage.isDisplayed();
    }

    @Then("I should see a logout success message")
    public void iShouldSeeALogoutSuccessMessage() {
        WebElement successMessage = driver.findElement(By.className("alert-success"));
        successMessage.isDisplayed();
    }



}
