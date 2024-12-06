import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ScorePage {

    private AppiumDriver driver;
    private AppTest appTest;
    // Locators
    private By first_rule_next = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(13)\n");
    private By second_rule_next = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)");
    private By third_rule_next = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Next\"]/android.view.ViewGroup");
    private By fourth_rule_next = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)");
    private By fifth_rule_next = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)");
    private By sixth_rule_next = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)");
    private By changeround_btn = AppiumBy.androidUIAutomator("new UiSelector().className(\"com.horcrux.svg.PathView\").instance(1)");
    private By BackfromRound_btn =AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(22)");
    private By round_name = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0) ");

    // After Rule Screen validation locators
    private By Round1txt = AppiumBy.androidUIAutomator("new UiSelector().text(\"Scoring\")");

    // Constructor
    public ScorePage(AppiumDriver driver, AppTest appTest) {
        this.driver = driver;
        this.appTest = appTest;
    }

    // Method to perform login
    public void rulescreen() throws InterruptedException {
        appTest.click(first_rule_next);
        appTest.click(second_rule_next);
        appTest.click(third_rule_next);
        appTest.click(fourth_rule_next);
        appTest.click(fifth_rule_next);
        appTest.click(sixth_rule_next);
        Thread.sleep(2000);
        //AppTest.scroll(500,1000,500,300);
        Thread.sleep(2000);
        validate();
    }

    public void back_from_current_screen() throws InterruptedException{
        appTest.click(BackfromRound_btn);
    }

    public void AddScore(String[] arr) throws InterruptedException {

      // for(int j=0;j<4;j++) { //for Scroll it depends how much time I have to do
            for (int i = 1; i < 13; i++) { //For putting value
                // Construct the UiSelector string with the value of i
                String selector = String.format("new UiSelector().className(\"android.widget.EditText\").instance(%d)", i);
                // Pass the selector and corresponding array value to the write method
                appTest.write(AppiumBy.androidUIAutomator(selector), arr[i]);
            }
       // }
    }

    public void changeround() throws InterruptedException{
        appTest.click(changeround_btn);
    }

    public void AddRoundName(String name) throws InterruptedException{
        appTest.write(round_name,name);
    }

    // Method to validate login and check for the "Bowls Rules" text
    private void validate() {
        try {
            // Wait for the "Bowls Rules" text to be visible
            WebElement bowlsRulesElement = appTest.waitUntilElementIsVisible(Round1txt);

            // If the element is found, login is successful
            if (bowlsRulesElement.isDisplayed()) {
                System.out.println("Now You are on Roun1 Screen");
            }
        } catch (Exception e) {
            System.out.println("Round 1 Screen not found");
        }
    }

    public void waitForElementToBeVisible(By by) throws InterruptedException {
        WebElement element = appTest.waitUntilElementIsVisible(by);
    }
}
