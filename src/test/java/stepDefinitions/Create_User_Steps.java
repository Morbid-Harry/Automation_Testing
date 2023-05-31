package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class Create_User_Steps {

    WebDriver driver;
    PageObjectManager pageObjectManager;
    public Create_User_Steps(Base base)
    {
        this.driver = base.driver;
        this.pageObjectManager = base.pageObjectManager;
    }

    @Given("blah blah blah")
    public void blah()
    {
        
    }

    @Given("I am on the create user screen")
    public void iAmOnTheCreateUserScreen() {
        
    }

    @When("I create a user")
    public void iCreateAUser() {
        
    }

    @When("I create an admin")
    public void iCreateAnAdmin() {
        
    }

    @When("I create an resource manager")
    public void iCreateAnResourceManager() {
        
    }

    @When("I create a user with the username {string}")
    public void iCreateAUserWithTheUsername(String arg0) {
        
    }

    @When("I create a user with the email {string}")
    public void iCreateAUserWithTheEmail(String arg0) {
        
    }

    @Then("I should see a user created success message")
    public void iShouldSeeAUserCreatedSuccessMessage() {
    }
}
