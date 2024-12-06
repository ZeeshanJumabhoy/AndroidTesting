import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddUserPage {

    private AppiumDriver driver;
    private AppTest appTest;
    // Locators
    private By WE_button = AppiumBy.androidUIAutomator("new UiSelector().className(\"com.horcrux.svg.PathView\").instance(2)");
    private By THEY_button = AppiumBy.androidUIAutomator("new UiSelector().className(\"com.horcrux.svg.PathView\").instance(3)");

    private By plus_button = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(11)");
    private By username_text  = AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter UserName\")");
    private By add_button = AppiumBy.androidUIAutomator("new UiSelector().text(\"Add\")");
    private By back_button = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(10)");

    // After Rule Screen validation locators
    private By Round1txt = AppiumBy.androidUIAutomator("new UiSelector().text(\"Scoring\")");

    // Constructor
    public AddUserPage(AppiumDriver driver, AppTest appTest) {
        this.driver = driver;
        this.appTest = appTest;
    }


    // Method to perform login
    public void Add_WE_Members(String[] WE_membersname, int num) throws InterruptedException {
        appTest.click(WE_button);
        Thread.sleep(2000);
        for(int i=0 ;i< num; i++)
        {
            appTest.click(plus_button);
            appTest.write(username_text,WE_membersname[i]);
            appTest.click(add_button);
            //Validation left to check whether player is been added or not
        }
        appTest.click(back_button);
        Thread.sleep(2000);
        validate();
    }

    public void Add_They_Members(String[] THEY_membersname, int num) throws InterruptedException {
        appTest.click(THEY_button);
        Thread.sleep(2000);
        for(int i=0 ;i< num; i++)
        {
            appTest.click(plus_button);
            appTest.write(username_text,THEY_membersname[i]);
            appTest.click(add_button);
            //Validation left to check whether player is been added or not
        }
        appTest.click(back_button);
        Thread.sleep(2000);
        validate();
    }


    // Method to validate login and check for the "Bowls Rules" text
    private void validate() {
        try {
            // Wait for the "Bowls Rules" text to be visible
            WebElement bowlsRulesElement = appTest.waitUntilElementIsVisible(Round1txt);

            // If the element is found, login is successful
            if (bowlsRulesElement.isDisplayed()) {
                System.out.println("Now You are on Round1 Screen");
            }
        } catch (Exception e) {
            System.out.println("Round 1 Screen not found");
        }
    }

    public void waitForElementToBeVisible(By by) throws InterruptedException {
        WebElement element = appTest.waitUntilElementIsVisible(by);
    }
}
