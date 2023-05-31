package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class General_Steps{
    WebDriver driver;
    PageObjectManager pageObjectManager;

    /**
     *
     * @param base injected by cucumber to provide a single point of reference for the webdriver
     */
    public General_Steps(Base base)
    {
        this.driver = base.driver;
        this.pageObjectManager = base.pageObjectManager;
    }

    @When("I click logout")
    public void iClickLogout() {
        pageObjectManager.getSideBarPOM().clickSignout();
    }

    @Then("I should see the sidebar button {string}")
    public void iShouldSeeTheSidebarButton(String arg0) {
        pageObjectManager.getSideBarPOM().getVisibleButtons(arg0);
    }
}
