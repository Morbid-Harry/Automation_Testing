package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;


public class Dashboard_Page_Steps {

    WebDriver driver;
    PageObjectManager pageObjectManager;
    public Dashboard_Page_Steps(Base base)
    {
        this.driver = base.driver;
        this.pageObjectManager = base.pageObjectManager;
    }

    @Given("I am on the dashboard page")
    public void iAmOnTheDashboardPage()
    {
        pageObjectManager.getLoginPOM().navigateTo_LoginPage();
        pageObjectManager.getLoginPOM().login("haedward", "pass");
    }

    @When("I show interest in a project role")
    public void iShowInterestInAProjectRole() {
        pageObjectManager.getDashboardPOM().showInterestInProject();
    }

    @Then("I should see an email sent message")
    public void iShouldSeeAnEmailSentMessage() {
        assertTrue(pageObjectManager.getDashboardPOM().isSuccessVisible());
    }

    @When("I view the project role client: {string} and project {string}")
    public void iViewTheProjectRoleTitled(String clientName, String projectName) {
        pageObjectManager.getDashboardPOM().viewSpecificRecord(clientName, projectName);
    }

    @Then("The card title should be {string}")
    public void theCardTitleShouldBe(String cardTitle) {
    }

    @Then("The project name should be {string}")
    public void theProjectNameShouldBe(String projectName) {
        
    }

    @Then("The start date should be {string}")
    public void theStartDateShouldBe(String startDate) {
        
    }

    @Then("The end date should be {string}")
    public void theEndDateShouldBe(String endDate) {
        
    }

    @Then("The way of working should be {string}")
    public void theWayOfWorkingShouldBe(String wayOfWorking) {
        
    }

    @Then("The address should be {string}")
    public void theAddressShouldBe(String address) {
        
    }

    @Then("The description should be {string}")
    public void theDescriptionShouldBe(String description) {
    }
}
