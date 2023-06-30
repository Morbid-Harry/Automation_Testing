package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import managers.Wait;
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

    @Given("I am on the create user screen")
    public void iAmOnTheCreateUserScreen() {
        pageObjectManager.getLoginPOM().navigateTo_LoginPage();
        pageObjectManager.getLoginPOM().login("admin", "adminpass");
        pageObjectManager.getSideBarPOM().clickCreateUser();
    }

    @When("I create a user")
    public void iCreateAUser() {
        pageObjectManager.getCreateUserPOM().enterFirstName("UserTestFirstName");
        pageObjectManager.getCreateUserPOM().enterLastName("UserTestLastName");
        pageObjectManager.getCreateUserPOM().generateRandomEmail();
        pageObjectManager.getCreateUserPOM().selectGrade("A1");
        pageObjectManager.getCreateUserPOM().generateRandomUsername();
        pageObjectManager.getCreateUserPOM().enterPassword("pass");
        pageObjectManager.getCreateUserPOM().createUser();
    }

    @When("I create an admin")
    public void iCreateAnAdmin() {
        pageObjectManager.getCreateUserPOM().enterFirstName("AdminTestFirstName");
        pageObjectManager.getCreateUserPOM().enterLastName("AdminTestLastName");
        pageObjectManager.getCreateUserPOM().generateRandomEmail();
        pageObjectManager.getCreateUserPOM().selectGrade("A10");
        pageObjectManager.getCreateUserPOM().generateRandomUsername();
        pageObjectManager.getCreateUserPOM().enterPassword("pass");
        pageObjectManager.getCreateUserPOM().isAdmin();
        pageObjectManager.getCreateUserPOM().createUser();
    }

    @When("I create an resource manager")
    public void iCreateAnResourceManager() {
        pageObjectManager.getCreateUserPOM().enterFirstName("RMTestFirstName");
        pageObjectManager.getCreateUserPOM().enterLastName("RMTestLastName");
        pageObjectManager.getCreateUserPOM().generateRandomEmail();
        pageObjectManager.getCreateUserPOM().selectGrade("A6");
        pageObjectManager.getCreateUserPOM().generateRandomUsername();
        pageObjectManager.getCreateUserPOM().enterPassword("pass");
        pageObjectManager.getCreateUserPOM().isResourceManger();
        pageObjectManager.getCreateUserPOM().createUser();
    }

    @When("I create a user with the username {string}")
    public void iCreateAUserWithTheUsername(String userName) {
        pageObjectManager.getCreateUserPOM().enterFirstName("TestFirstName");
        pageObjectManager.getCreateUserPOM().enterLastName("TestLastName");
        pageObjectManager.getCreateUserPOM().generateRandomEmail();
        pageObjectManager.getCreateUserPOM().selectGrade("A4");
        pageObjectManager.getCreateUserPOM().enterUsername(userName);
        pageObjectManager.getCreateUserPOM().enterPassword("pass");
        pageObjectManager.getCreateUserPOM().createUser();
    }

    @When("I create a user with the email {string}")
    public void iCreateAUserWithTheEmail(String email) {
        pageObjectManager.getCreateUserPOM().enterFirstName("TestFirstName");
        pageObjectManager.getCreateUserPOM().enterLastName("TestLastName");
        pageObjectManager.getCreateUserPOM().enterEmail(email);
        pageObjectManager.getCreateUserPOM().selectGrade("A2");
        pageObjectManager.getCreateUserPOM().generateRandomUsername();
        pageObjectManager.getCreateUserPOM().enterPassword("pass");
        pageObjectManager.getCreateUserPOM().createUser();
    }

    @Then("I should see a user created success message")
    public void iShouldSeeAUserCreatedSuccessMessage() {
        assertTrue(pageObjectManager.getCreateUserPOM().isSuccessVisible());
    }

    @Then("I should see a failed to create user message")
    public void iShouldSeeAFailedToCreateUserMessage() {
        assertTrue(pageObjectManager.getCreateUserPOM().isFailureVisible());
    }
}
