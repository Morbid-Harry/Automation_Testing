package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.SideBar;


public class Dashboard_Page_Steps {

    WebDriver driver;
    PageObjectManager pageObjectManager;

    LoginPage loginPage;

    DashboardPage dashboardPage;

    SideBar sideBar;

    public Dashboard_Page_Steps(Test_Context testContext)
    {
        this.driver = testContext.driver;
        this.dashboardPage = testContext.pageObjectManager.getDashboardPOM();
        this.loginPage = testContext.pageObjectManager.getLoginPOM();
        this.sideBar = testContext.pageObjectManager.getSideBarPOM();
    }

    @Given("I am on the dashboard page")
    public void iAmOnTheDashboardPage()
    {
        loginPage.navigateTo_LoginPage();
        loginPage.login("haedward", "pass");
    }

    @When("I show interest in a project role")
    public void iShowInterestInAProjectRole() {
        dashboardPage.showInterestInProject();
    }

    @Then("I should see an email sent message")
    public void iShouldSeeAnEmailSentMessage() {
        assertTrue(dashboardPage.isSuccessVisible());
    }

    @When("I view the project role client: {string} and project {string}")
    public void iViewTheProjectRoleTitled(String clientName, String projectName) {
        dashboardPage.viewSpecificRecord(clientName, projectName);
    }

    @Then("The card title should be {string}")
    public void theCardTitleShouldBe(String cardTitle) {
        assertEquals(dashboardPage.getCardTitle(), cardTitle);

    }

    @Then("The project name should be {string}")
    public void theProjectNameShouldBe(String projectName) {
        assertEquals(dashboardPage.getProjectName(), projectName);
    }

    @Then("The grade required should be {string}")
    public void theGradeRequiredShouldBe(String gradeRequired) {
        assertEquals(gradeRequired, dashboardPage.getGradeRequired());
    }

    @Then("The start date should be {string}")
    public void theStartDateShouldBe(String startDate) {
        assertEquals(startDate, dashboardPage.getStartDate());
    }

    @Then("The end date should be {string}")
    public void theEndDateShouldBe(String endDate) {
        assertEquals(endDate, dashboardPage.getEndDate());
    }

    @Then("The way of working should be {string}")
    public void theWayOfWorkingShouldBe(String wayOfWorking) {
        assertEquals(wayOfWorking, dashboardPage.getWayOfWorking());
    }

    @Then("The address should be {string}")
    public void theAddressShouldBe(String address) {
        assertEquals(address, dashboardPage.getAddress());
    }

    @Then("The description should be {string}")
    public void theDescriptionShouldBe(String description) {
        assertEquals(description, dashboardPage.getDescription());
    }


    @When("I filter by grade {string}")
    public void iFilterByGrade(String gradeSelected) {
        dashboardPage.filterByGrade(gradeSelected);
    }

    @Then("All roles I see should have the grade {string}")
    public void allRolesISeeShouldBe(String filteredGrade) {
        assertTrue(dashboardPage.verifyFilterByGradeIsCorrect(filteredGrade));
    }

    @When("I filter by Way of Working {string}")
    public void iFilterByWayOfWorking(String wayOfWorkingSelected) {
        dashboardPage.filterByWayOfWorking(wayOfWorkingSelected);
    }

    @Then("All roles I see should have the Way of Working {string}")
    public void allRolesISeeShouldHaveTheWayOfWorking(String filteredWayOfWorking) {
        assertTrue(dashboardPage.verifyFilterByWayOfWorkingIsCorrect(filteredWayOfWorking));
    }

    @When("I filter by the Tool used {string}")
    public void iFilterByTheToolUsed(String toolSelected) {
        dashboardPage.filterByToolUsed(toolSelected);
    }

    @Then("All roles I see should have the Tool used {string}")
    public void allRolesISeeShouldHaveTheToolUsed(String filteredTool) {
        assertTrue(dashboardPage.verifyFilterByToolUsedIsCorrect(filteredTool));
    }

    @When("I click the Add to Favourites button")
    public void iClickTheAddToFavouritesButton() {
        dashboardPage.addProjectToFavourites();
    }

    @Then("I should see an added to favourites message")
    public void iShouldSeeAnAddedToFavouritesMessage() {
        assertTrue(dashboardPage.isSuccessVisible());
    }

    @Then("I should see an already in your favourites message")
    public void iShouldSeeAnAlreadyInYourFavouritesMessage() {
        assertTrue(dashboardPage.isFailureVisible());
    }

    @Given("I am on the favourites page")
    public void iAmOnTheFavouritesPage() {
        loginPage.navigateTo_LoginPage();
        loginPage.login("haedward", "pass");
        sideBar.clickFavourites();
    }

    @When("I click Remove from Favourites button")
    public void iClickRemoveFromFavouritesButton() {
        dashboardPage.removeProjectFromFavourites();
    }

    @Then("I should see project removed from favourites message")
    public void iShouldSeeProjectRemovedFromFavouritesMessage() {
        assertTrue(dashboardPage.isSuccessVisible());
    }
}
