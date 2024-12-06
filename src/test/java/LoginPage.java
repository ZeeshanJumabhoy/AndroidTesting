import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private AppiumDriver driver;
    private AppTest appTest;

    // Locators
    private By usernameTXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter Email Address\")");
    private By passwordTXT = AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter Password\")");
    private By loginBTN = AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In\")");
    private By signInHeader = AppiumBy.xpath("//android.widget.TextView[@text=\"Sign In using account\"]");

    // After login validation locators
    private By bowlsRulesText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Bowls Rules\")");

    // Constructor
    public LoginPage(AppiumDriver driver, AppTest appTest) {
        this.driver = driver;
        this.appTest = appTest;
    }

    // Method to perform login
    public void login(String email, String password) throws InterruptedException {
        // Wait for the sign-in header to be visible before interacting
        appTest.click(signInHeader);

        // Use the generic methods from AppTest class
        appTest.write(usernameTXT, email);
        appTest.write(passwordTXT, password);
        appTest.click(loginBTN);
        Thread.sleep(2000);
        // Validate login
        validateLogin();
    }

    // Method to validate login and check for the "Bowls Rules" text
    private void validateLogin() {
        try {
            // Wait for the "Bowls Rules" text to be visible
            WebElement bowlsRulesElement = appTest.waitUntilElementIsVisible(bowlsRulesText);

            // If the element is found, login is successful
            if (bowlsRulesElement.isDisplayed()) {
                System.out.println("Login successful and 'Bowls Rules' text is displayed.");
            }
        } catch (Exception e) {
            System.out.println("Login failed or 'Bowls Rules' text not found.");
        }
    }

    public void waitForElementToBeVisible(By by) throws InterruptedException {
        WebElement element = appTest.waitUntilElementIsVisible(by);
    }
}
