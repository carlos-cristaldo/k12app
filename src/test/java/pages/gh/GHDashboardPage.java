package pages.gh;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.una.UNADashboardPage;

public class GHDashboardPage extends BasePage {

    private final By illDoItLaterBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Lo haré mas tarde\")");
    private final By dismissPasswordManagerBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"No\")");
    private final By communityBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\" Comunidad\")");
    private final By closeCheckOutTheNewCommunityModal = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"×\")");
    private final By myStudentsBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\" Mis Estudiantes\")");
    private final By unaCommunityBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Community\")");
    private final By greetingLbl = new By.ByXPath("//android.widget.TextView[contains(@text,\"Hola\")]");

    public GHDashboardPage() {
    }

    @Override
    @Step("Waiting for login page...")
    public void waitPageToLoad() {
        waitForDisplayed(illDoItLaterBtn);
        find(illDoItLaterBtn).click();
        waitForDisplayed(dismissPasswordManagerBtn);
        find(dismissPasswordManagerBtn).click();
        waitPage(greetingLbl, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying login page...")
    public void verifyPage() {

    }

    @Step("Going to UNA ...")
    public UNADashboardPage goToUna() {
        waitForDisplayed(communityBtn);
        find(communityBtn).click();
        waitForDisplayed(closeCheckOutTheNewCommunityModal);
        find(closeCheckOutTheNewCommunityModal).click();
        waitForDisplayed(unaCommunityBtn);
        find(unaCommunityBtn).click();
        return new UNADashboardPage();
    }


}
