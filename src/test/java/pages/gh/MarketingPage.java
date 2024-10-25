package pages.gh;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.una.UNADashboardPage;

public class MarketingPage extends BasePage {

    private final By startSessionBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"INICIAR SESIÓN\")");
    private LoginPage loginPage;
    private GHDashboardPage ghDashboardPage;
    private UNADashboardPage unaDashboardPage;

    @Override
    @Step("Waiting for marketing page...")
    public void waitPageToLoad() {
        waitPage(startSessionBtn, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying marketing page...")
    public void verifyPage() {
        softAssert.assertTrue(find(startSessionBtn).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Click on Start Session button")
    public LoginPage clickStartSessionBth() {
        find(startSessionBtn).click();
        return new LoginPage();
    }

    @Step("Going to UNA...")
    public UNADashboardPage goToUna(User user){
        loginPage = clickStartSessionBth();
        ghDashboardPage = loginPage.doLogin(user);
        ghDashboardPage.waitPageToLoad();
        unaDashboardPage = ghDashboardPage.goToUna();
        return unaDashboardPage;
    }
}
