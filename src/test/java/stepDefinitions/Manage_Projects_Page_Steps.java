package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;


public class Manage_Projects_Page_Steps {

    WebDriver driver;
    PageObjectManager pageObjectManager;
    public Manage_Projects_Page_Steps(Base base)
    {
        this.driver = base.driver;
        this.pageObjectManager = base.pageObjectManager;
    }

    @Given("I am on the Manage Project Page")
    public void iAmOnTheManageProjectPage() {
        pageObjectManager.getLoginPOM().navigateTo_LoginPage();
        pageObjectManager.getLoginPOM().login("rm_user1", "rmpass1");
        pageObjectManager.getSideBarPOM().clickManageProjects();
    }

    @When("I create a project with all fields filled")
    public void iCreateAProject() {
        pageObjectManager.getManangeProjectsPOM().createAProjectFull();
    }

    @Then("I should see a project created success message")
    public void iShouldSeeASuccessMessage() {
        assertTrue(pageObjectManager.getManangeProjectsPOM().isSuccessVisible());
    }

    @When("I create a project with that is remote")
    public void iCreateAProjectWithThatIsRemote() {
        pageObjectManager.getManangeProjectsPOM().createRemoteProject();
    }

    @When("I create a project with no tool tags selected")
    public void iCreateAProjectWithNoToolTagsSelected() {
        pageObjectManager.getManangeProjectsPOM().createProjectWithNoTools();
    }

    @When("I create a project with no dates")
    public void iCreateAProjectWithNoDates() {
        pageObjectManager.getManangeProjectsPOM().createProjectWithNoDates();
    }

    @When("I create a project with invalid dates")
    public void iCreateAProjectWithInvalidDates() {
        pageObjectManager.getManangeProjectsPOM().createProjectWithInvalidDates();
    }

    @Then("I shouldn't see a project created success message")
    public void iShouldntSeeASuccessMessage() {
        assertFalse(pageObjectManager.getManangeProjectsPOM().isSuccessVisible());
    }
}
