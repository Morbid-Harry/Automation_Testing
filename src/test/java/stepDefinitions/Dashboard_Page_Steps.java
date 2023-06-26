package stepDefinitions;

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
        assertEquals(cardTitle, pageObjectManager.getDashboardPOM().getCardTitle());
    }

    @Then("The project name should be {string}")
    public void theProjectNameShouldBe(String projectName) {
        assertEquals(projectName, pageObjectManager.getDashboardPOM().getProjectName());
    }

    @Then("The grade required should be {string}")
    public void theGradeRequiredShouldBe(String gradeRequired) {
        assertEquals(gradeRequired, pageObjectManager.getDashboardPOM().getGradeRequired());
    }

    @Then("The start date should be {string}")
    public void theStartDateShouldBe(String startDate) {
        assertEquals(startDate, pageObjectManager.getDashboardPOM().getStartDate());
    }

    @Then("The end date should be {string}")
    public void theEndDateShouldBe(String endDate) {
        assertEquals(endDate, pageObjectManager.getDashboardPOM().getEndDate());
    }

    @Then("The way of working should be {string}")
    public void theWayOfWorkingShouldBe(String wayOfWorking) {
        assertEquals(wayOfWorking, pageObjectManager.getDashboardPOM().getWayOfWorking());
    }

    @Then("The address should be {string}")
    public void theAddressShouldBe(String address) {
        assertEquals(address, pageObjectManager.getDashboardPOM().getAddress());
    }

    @Then("The description should be {string}")
    public void theDescriptionShouldBe(String description) {
        assertEquals(description, pageObjectManager.getDashboardPOM().getDescription());
    }


    @When("I filter by grade {string}")
    public void iFilterByGrade(String gradeSelected) {
        pageObjectManager.getDashboardPOM().filterByGrade(gradeSelected);
    }

    @Then("All roles I see should have the grade {string}")
    public void allRolesISeeShouldBe(String filteredGrade) {
        assertTrue(pageObjectManager.getDashboardPOM().verifyFilterByGradeIsCorrect(filteredGrade));
    }

    @When("I filter by Way of Working {string}")
    public void iFilterByWayOfWorking(String wayOfWorkingSelected) {
        pageObjectManager.getDashboardPOM().filterByWayOfWorking(wayOfWorkingSelected);
    }

    @Then("All roles I see should have the Way of Working {string}")
    public void allRolesISeeShouldHaveTheWayOfWorking(String filteredWayOfWorking) {
        assertTrue(pageObjectManager.getDashboardPOM().verifyFilterByWayOfWorkingIsCorrect(filteredWayOfWorking));
    }

    @When("I filter by the Tool used {string}")
    public void iFilterByTheToolUsed(String toolSelected) {
        pageObjectManager.getDashboardPOM().filterByToolUsed(toolSelected);
    }

    @Then("All roles I see should have the Tool used {string}")
    public void allRolesISeeShouldHaveTheToolUsed(String filteredTool) {
        assertTrue(pageObjectManager.getDashboardPOM().verifyFilterByToolUsedIsCorrect(filteredTool));
    }
}
