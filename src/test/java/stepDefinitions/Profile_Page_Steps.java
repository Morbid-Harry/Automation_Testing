package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class Profile_Page_Steps {


    WebDriver driver;
    PageObjectManager pageObjectManager;
    public Profile_Page_Steps(Base base)
    {
        this.driver = base.driver;
        this.pageObjectManager = base.pageObjectManager;
    }

    @Given("I am on the profile page")
    public void iAmOnTheProfilePage()
    {
        pageObjectManager.getLoginPOM().navigateTo_LoginPage();
        pageObjectManager.getLoginPOM().login("haedward", "pass");
        pageObjectManager.getSideBarPOM().clickProfile();
    }

    @When("I update my first name to {string}")
    public void iUpdateMyFirstNameTo(String firstName) {
        pageObjectManager.getProfilePOM().enterFirstName(firstName);
    }

    @When("I update my last name to {string}")
    public void iUpdateMyLastNameTo(String lastName) {
        pageObjectManager.getProfilePOM().enterLastName(lastName);
    }

    @When("I update my grade to {string}")
    public void iUpdateMyGradeTo(String gradeSelected) {
        pageObjectManager.getProfilePOM().selectGrade(gradeSelected);
    }

    @When("I click the update details button")
    public void iClickTheUpdateDetailsButton() {
        pageObjectManager.getProfilePOM().updateDetails();
    }

    @Then("I should see a update success message")
    public void iShouldSeeAUpdateSuccessMessage() {
        assertTrue(pageObjectManager.getProfilePOM().isSuccessVisible());
    }


    @When("I enter my current password {string}")
    public void iEnterMyCurrentPassword(String currentPassword) {
        pageObjectManager.getProfilePOM().enterCurrentPassword(currentPassword);
    }

    @When("I enter my new password {string}")
    public void iEnterMyNewPassword(String newPassword) {
        pageObjectManager.getProfilePOM().enterNewPassword(newPassword);
    }

    @When("I enter the confirm password {string}")
    public void iEnterTheConfirmPassword(String confirmPassword) {
        pageObjectManager.getProfilePOM().enterConfirmPassword(confirmPassword);
    }

    @When("I click the update password button")
    public void iClickTheUpdatePasswordButton() {
        pageObjectManager.getProfilePOM().updatePassword();
    }

    @Then("I should see an update failure message")
    public void iShouldSeeAnUpdateFailureMessage() {
        assertTrue(pageObjectManager.getProfilePOM().isFailureVisible());
    }

    @When("I navigate to the profile page")
    public void iNavigateToTheProfilePage() {
        pageObjectManager.getSideBarPOM().clickProfile();
    }
}
