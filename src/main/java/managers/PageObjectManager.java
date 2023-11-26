package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

/**
 * When we have multiple feature files we will end up creating lots of pages objects. With POM and Dependency Injection we ensure there is only ever 1 instance of a created page object.
 * Reducing overall resource demand.
 */
public class PageObjectManager {
    private WebDriver driver;

    private LoginPage loginPage;

    private DashboardPage dashboardPage;

    private ManageProjectsPage manageProjectsPage;

    private CreateUserPage createUserPage;

    private ProfilePage profilePage;

    private SideBar sideBar;

    /**
     *
     * @param driver since page objects require a driver to findElements or perform clicks this needs to be passed to in
     */
    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * Creates a login page object if it does not exist
     * @return loginPage object representation of the login webpage
     */
    public LoginPage getLoginPOM()
    {
        if(loginPage == null)
        {
            return loginPage = new LoginPage(driver);
        }
        else{
            return loginPage;
        }
    }

    /**
     * Creates a dashboard page object if it does not exist
     * @return dashboardPage object representation of the dashboard webpage
     */
    public DashboardPage getDashboardPOM()
    {
        if(dashboardPage == null)
        {
            return dashboardPage = new DashboardPage(driver);
        }
        else{
            return dashboardPage;
        }
    }

    /**
     * Creates a sidebar page object if it does not exist
     * @return sideBar object representation of the sidebar & its buttons
     */
    public SideBar getSideBarPOM()
    {
        if(sideBar == null)
        {
            return sideBar = new SideBar(driver);
        }
        else{
            return sideBar;
        }
    }

    /**
     * Creates a managerProjectPage page object if it does not exist
     * @return managerProjectPage object representation of the Manage Project Roles Webpage
     */
    public ManageProjectsPage getManangeProjectsPOM()
    {
        if(manageProjectsPage == null)
        {
            return  manageProjectsPage = new ManageProjectsPage(driver);
        }
        else {
            return manageProjectsPage;
        }
    }

    /**
     * Creates a createUserPage page object if it does not exist
     * @return createUserPage object representation of the Create User Webpage
     */
    public CreateUserPage getCreateUserPOM()
    {
        if(createUserPage == null)
        {
            return  createUserPage = new CreateUserPage(driver);
        }
        else {
            return createUserPage;
        }
    }

    public ProfilePage getProfilePOM() {
        if (profilePage == null)
        {
            return profilePage = new ProfilePage(driver);
        }
        else {
            return profilePage;
        }
    }


}
