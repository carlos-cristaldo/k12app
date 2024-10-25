package pages.gh;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import pages.BasePage;

import static utilities.Utils.forceWait;

public class LoginPage extends BasePage {

    private final By chooseAccountTypeLbl = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Elija el Tipo de Cuenta\")");
    private final By mentorSelector = new By.ByXPath("//android.view.View[@resource-id=\"loginLCSelector\"]/android.widget.TextView");
    private final By usernameInput = new By.ByXPath("//android.view.View[@resource-id=\"loginEmailLC\"]/android.widget.EditText");
    private final By passwordInput = new By.ByXPath("//android.view.View[@resource-id=\"loginPasswordLC\"]/android.widget.EditText");
    private final By loginBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Iniciar sesión\")");

    public LoginPage() {
    }

    @Override
    @Step("Waiting for login page...")
    public void waitPageToLoad() {
        waitPage(chooseAccountTypeLbl, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying login page...")
    public void verifyPage() {
        waitForDisplayed(chooseAccountTypeLbl);
        softAssert.assertTrue(find(chooseAccountTypeLbl).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Logging in")
    public GHDashboardPage doLogin(User user){
        find(mentorSelector).click();
        find(usernameInput).sendKeys(user.getUserdata().getUsername());
        find(passwordInput).sendKeys(user.getUserdata().getPassword());
        find(loginBtn).click();
        find(loginBtn).click();
        forceWait(2000);
        return new GHDashboardPage();
    }


}
