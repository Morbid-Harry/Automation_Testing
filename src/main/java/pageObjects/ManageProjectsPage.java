package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * POM representation of Manage Project Role page
 */
public class ManageProjectsPage extends SideBar{
    WebDriver driver;

    @FindBy(id = "client-name-input")
    private WebElement clientNameInput;
    @FindBy(id = "project-name-input")
    private WebElement projectNameInput;
    @FindBy(id = "grade-input")
    private WebElement gradeSelect;
    @FindBy(id = "start-date-input")
    private WebElement startDateInput;
    @FindBy(id = "end-date-input")
    private WebElement endDateInput;
    @FindBy(id = "work-input")
    private WebElement locationSelect;
    @FindBy(id = "address-input")
    private WebElement addressInput;
    @FindBy(id = "general-description-input")
    private WebElement descriptionInput;
    @FindBy(name = "tools-used")
    private List<WebElement> toolsUsedTags;
    @FindBy(id = "create-project")
    private WebElement createProjectButton;
    @FindBy(className = "alert-success")
    private WebElement successMessage;

    public ManageProjectsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Creates a project with all fields filled out with random values
     */
    public void createAProjectFull()
    {
        //Generate random values
        Random random = new Random();

        //Random Company Name
        String randomString = "Company:" + random.nextInt(1000);
        clientNameInput.sendKeys(randomString);

        //Random Project Name
        randomString = "Project:" + random.nextInt(1000);
        projectNameInput.sendKeys(randomString);

        //Random Grade Selection
        Select gradeDropdown = new Select(gradeSelect);
        List<WebElement> gradeOptions = gradeDropdown.getOptions();
        gradeDropdown.selectByIndex(random.nextInt(gradeOptions.size()));

        //Add a start and end date
        startDateInput.sendKeys("30052023");
        endDateInput.sendKeys("31122023");

        //Select Hybrid
        Select workLocationDropDown = new Select(locationSelect);
        workLocationDropDown.selectByValue("Client_Site");

        //Type a random Address
        randomString = "Test Address: " + random.nextInt(1000);
        addressInput.sendKeys(randomString);

        //Type a general description
        randomString = "This is a general description for the Client: "
                + clientNameInput.getAttribute("value") + " and " + projectNameInput.getAttribute("value");
        descriptionInput.sendKeys(randomString);

        //Select some random tags
        selectRandomTags();

        //Click create project need to use JS to simulate the click as overlaps with other elements
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createProjectButton);

    }

    /**
     * Creates a project with the location set to remote as an address is not required
     */
    public void createRemoteProject()
    {
        //Generate random values
        Random random = new Random();

        //Random Company Name
        String randomString = "Company:" + random.nextInt(1000);
        clientNameInput.sendKeys(randomString);

        //Random Project Name
        randomString = "Project:" + random.nextInt(1000);
        projectNameInput.sendKeys(randomString);

        //Random Grade Selection
        Select gradeDropdown = new Select(gradeSelect);
        List<WebElement> gradeOptions = gradeDropdown.getOptions();
        gradeDropdown.selectByIndex(random.nextInt(gradeOptions.size()));

        //Add a start and end date
        startDateInput.sendKeys("30052023");
        endDateInput.sendKeys("31122023");

        //Select Remote
        Select workLocationDropDown = new Select(locationSelect);
        workLocationDropDown.selectByValue("Remote");

        //Type a general description
        randomString = "This is a general description for the Client: "
                + clientNameInput.getAttribute("value") + " and " + projectNameInput.getAttribute("value");
        descriptionInput.sendKeys(randomString);

        //Select some random tags
        selectRandomTags();

        //Click create project need to use JS to simulate the click as overlaps with other elements
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createProjectButton);
    }

    /**
     * Creates a remote project where no tool tags are selected and submits it
     */
    public void createProjectWithNoTools()
    {
        //Generate random values
        Random random = new Random();

        //Random Company Name
        String randomString = "Company:" + random.nextInt(1000);
        clientNameInput.sendKeys(randomString);

        //Random Project Name
        randomString = "Project:" + random.nextInt(1000);
        projectNameInput.sendKeys(randomString);

        //Random Grade Selection
        Select gradeDropdown = new Select(gradeSelect);
        List<WebElement> gradeOptions = gradeDropdown.getOptions();
        gradeDropdown.selectByIndex(random.nextInt(gradeOptions.size()));

        //Add a start and end date
        startDateInput.sendKeys("30052023");
        endDateInput.sendKeys("31122023");

        //Select Remote
        Select workLocationDropDown = new Select(locationSelect);
        workLocationDropDown.selectByValue("Remote");

        //Type a general description
        randomString = "This is a general description for the Client: "
                + clientNameInput.getAttribute("value") + " and " + projectNameInput.getAttribute("value");
        descriptionInput.sendKeys(randomString);

        //Click create project need to use JS to simulate the click as overlaps with other elements
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createProjectButton);
    }

    /**
     * Dates for projects are not required so this generates a project where no start or end date is added
     */
    public void createProjectWithNoDates()
    {
        //Generate random values
        Random random = new Random();

        //Random Company Name
        String randomString = "Company:" + random.nextInt(1000);
        clientNameInput.sendKeys(randomString);

        //Random Project Name
        randomString = "Project:" + random.nextInt(1000);
        projectNameInput.sendKeys(randomString);

        //Random Grade Selection
        Select gradeDropdown = new Select(gradeSelect);
        List<WebElement> gradeOptions = gradeDropdown.getOptions();
        gradeDropdown.selectByIndex(random.nextInt(gradeOptions.size()));

        //Select Remote
        Select workLocationDropDown = new Select(locationSelect);
        workLocationDropDown.selectByValue("Remote");

        //Type a general description
        randomString = "This is a general description for the Client: "
                + clientNameInput.getAttribute("value") + " and " + projectNameInput.getAttribute("value");
        descriptionInput.sendKeys(randomString);

        //Click create project need to use JS to simulate the click as overlaps with other elements
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createProjectButton);
    }

    /**
     * Attempts to create a project with an end date that is before the start date
     */
    public void createProjectWithInvalidDates()
    {
        //Generate random values
        Random random = new Random();

        //Random Company Name
        String randomString = "Company:" + random.nextInt(1000);
        clientNameInput.sendKeys(randomString);

        //Random Project Name
        randomString = "Project:" + random.nextInt(1000);
        projectNameInput.sendKeys(randomString);

        //Random Grade Selection
        Select gradeDropdown = new Select(gradeSelect);
        List<WebElement> gradeOptions = gradeDropdown.getOptions();
        gradeDropdown.selectByIndex(random.nextInt(gradeOptions.size()));

        //Add a start and end date
        startDateInput.sendKeys("31122023");
        endDateInput.sendKeys("30052023");

        //Select Remote
        Select workLocationDropDown = new Select(locationSelect);
        workLocationDropDown.selectByValue("Remote");

        //Type a general description
        randomString = "This is a general description for the Client: "
                + clientNameInput.getAttribute("value") + " and " + projectNameInput.getAttribute("value");
        descriptionInput.sendKeys(randomString);

        //Click create project need to use JS to simulate the click as overlaps with other elements
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createProjectButton);
    }

    /**
     * Method to select 3 random tags in the manage project page
     */
    public void selectRandomTags()
    {
        Random random = new Random();
        int numberOfCheckboxesToSelect = 3; // Number of checkboxes you want to select
        List<Integer> selectedCheckboxIndices = new ArrayList<>();

        while (selectedCheckboxIndices.size() < numberOfCheckboxesToSelect) {
            int randomIndex = random.nextInt(toolsUsedTags.size());
            if (!selectedCheckboxIndices.contains(randomIndex)) {
                selectedCheckboxIndices.add(randomIndex);
            }
        }

        for (int checkboxIndex : selectedCheckboxIndices) {
            WebElement checkbox = toolsUsedTags.get(checkboxIndex);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", checkbox);
        }

    }

    /**
     *
     * @return true or false if the success message is visible when creating a project role
     */
    public boolean isSuccessVisible()
    {
        if(driver.findElements(By.className("alert-success")).isEmpty())
        {
            return false;
        }
        else {
            return successMessage.isDisplayed();
        }

    }


}
