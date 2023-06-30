package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * POM representation of Dashboard page
 */
public class DashboardPage extends SideBar{
    WebDriver driver;
    @FindBy(tagName = "h1")
    WebElement welcomeMessage;
    @FindBy(linkText= "View Details")
    private List<WebElement> viewDetailsButtons;

    @FindBy(id = "show-interest")
    private WebElement showInterestButton;

    @FindBy(id = "add-favourites")
    private WebElement addToFavouritesButton;

    @FindBy(id = "remove-favourites")
    private WebElement removeFromFavouritesButton;

    @FindBy(className = "alert-success")
    private WebElement alertSuccessMessage;

    @FindBy(className = "alert-danger")
    private WebElement alertFailureMessage;

    @FindBy(id = "grade-filter")
    private WebElement gradeFilter;

    @FindBy(id = "way-of-working-filter")
    private WebElement wayOfWorkingFilter;

    @FindBy(id = "tool-filter")
    private WebElement toolUsedFilter;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage()
    {
        return welcomeMessage.getText();
    }

    public void viewSpecificRecord(String companyName, String projectName)
    {
        //Construct the XPath expression for specific record
        String xpathExpression = String.format("//h5[contains(text(), '%s') and contains(text(), '%s')]/ancestor::div[@class='card my-2']", companyName, projectName);

        //Find the specific card
        WebElement card = driver.findElement(By.xpath(xpathExpression));

        //Get the button of that card and click it
        WebElement viewDetails = card.findElement(By.linkText("View Details"));

        // Scroll to the button element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", viewDetails);

        //Js emulated click as otherwise will get element intercept error
        jsExecutor.executeScript("arguments[0].click();", viewDetails);
    }

    public void showInterestInProject()
    {
        viewDetailsButtons.get(0).click();

        //Wait for the show interest button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(showInterestButton));

        showInterestButton.click();
    }

    public void addProjectToFavourites()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToFavouritesButton));

        addToFavouritesButton.click();
    }

    public void removeProjectFromFavourites()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(removeFromFavouritesButton));

        removeFromFavouritesButton.click();
    }

    public boolean isSuccessVisible()
    {
        //Give time for the response to return message
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return alertSuccessMessage.isDisplayed();
    }

    public boolean isFailureVisible()
    {
        //Give time for the response to return message
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return alertFailureMessage.isDisplayed();
    }

    public WebElement waitForModalToBeVisible()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement modalContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));

        return modalContainer.findElement(By.className("modal-content"));
    }


    public String getCardTitle()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement projectTitle = content.findElement(By.id("exampleModalLabel"));

        return projectTitle.getText();
    }

    public String getProjectName()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement projectName = content.findElement(By.xpath("//div[@class='modal-body']//div[@class='col-6'][1]//p[1]"));

        //Remove the label part before returning
        return projectName.getText().replace("Project Name: ", "");
    }

    public String getGradeRequired()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement gradeRequired = content.findElement(By.xpath("//div[@class='modal-body']//div[@class='col-6'][2]//p[1]"));

        return gradeRequired.getText().replace("Grade Required: ", "");
    }

    public String getStartDate()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement startDate = content.findElement(By.xpath("//div[@class='modal-body']/div[3]/div[1]/p"));

        return startDate.getText().replace("Start Date: ", "");
    }

    public String getEndDate()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement endDate = content.findElement(By.xpath("//div[@class='modal-body']/div[3]/div[2]/p"));

        return endDate.getText().replace("End Date: ", "");
    }

    public String getWayOfWorking()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement wayOfWorking = content.findElement(By.xpath("//div[@class='modal-body']/div[5]/div[1]/p"));

        return wayOfWorking.getText().replace("Way of Working: ", "");
    }

    public String getAddress()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement address = content.findElement(By.xpath("//div[@class='modal-body']/div[5]/div[2]/p"));

        String fullString = address.getText();

        //This is to get the test project addresses without removing the "Test Address:" part of the string
        return fullString.substring("Address: ".length());
    }

    public String getDescription()
    {
        WebElement content = waitForModalToBeVisible();

        WebElement description = content.findElement(By.id("description"));

        return description.getText();

    }

    public void filterByGrade(String gradeSelected)
    {
        Select gradeFilterSelect = new Select(gradeFilter);
        gradeFilterSelect.selectByValue(gradeSelected);
    }

    public boolean verifyFilterByGradeIsCorrect(String filteredGrade)
    {
        //Get all the cards
        List<WebElement> allCards = driver.findElements(By.cssSelector(".project-card.col-lg-4.col-sm-6"));

        for (WebElement card : allCards) {
            //Only check the cards that are displayed
            if (card.isDisplayed()) {

                // Get the grade value on the card
                WebElement gradeElement = card.findElement(By.cssSelector("[data-label='Grade Required']"));
                // Get the string without the label
                String gradeText = gradeElement.getText().replace("Grade Required: ", "");

                //If the value expected does not equal the value on the card return false
                if (!gradeText.equals(filteredGrade)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void filterByWayOfWorking(String wayOfWorkingSelected)
    {
        Select wayOfWorkingFilterSelect = new Select(wayOfWorkingFilter);
        wayOfWorkingFilterSelect.selectByValue(wayOfWorkingSelected);
    }

    public boolean verifyFilterByWayOfWorkingIsCorrect(String filteredWayOfWorking)
    {
        //Get all the cards
        List<WebElement> allCards = driver.findElements(By.cssSelector(".project-card.col-lg-4.col-sm-6"));

        for (WebElement card : allCards) {
            //Only check the cards that are displayed
            if (card.isDisplayed()) {

                // Get the way of working value on the card
                WebElement wayOfWorkingElement = card.findElement(By.cssSelector("[data-label='Way of Working']"));
                // Get the string without the label
                String wayOfWorkingText = wayOfWorkingElement.getText().replace("Way of Working: ", "");

                //If the value expected does not equal the value on the card return false
                if (!wayOfWorkingText.equals(filteredWayOfWorking)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void filterByToolUsed(String toolSelected)
    {
        Select toolUsedFilterSelect = new Select(toolUsedFilter);
        toolUsedFilterSelect.selectByValue(toolSelected);
    }

    public boolean verifyFilterByToolUsedIsCorrect(String filteredToolUsed)
    {
        //Get all the cards
        List<WebElement> allCards = driver.findElements(By.cssSelector(".project-card.col-lg-4.col-sm-6"));

        for (WebElement card : allCards) {
            // Check if the card is displayed
            if (card.isDisplayed()) {
                // Get the tool elements on the card
                List<WebElement> toolElements = card.findElements(By.cssSelector("span label"));

                boolean foundTool = false;

                //Iterate through the tool elements to check if the given tool is present
                for (WebElement toolElement : toolElements) {
                    String toolText = toolElement.getText();

                    //If toolText matches that of the tool chosen to filter by then set flag to true
                    if (toolText.equals(filteredToolUsed)) {
                        foundTool = true;
                        break;
                    }
                }

                //if the tool flag is still false after looping through tools return false as means cards that are displaying aren't filtered correctly
                if (!foundTool) {
                    return false;
                }
            }
        }

        //Cards must be filtered correctly if reaching this so return true
        return true;
    }
}
