package pages.una;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.BasePage;

public class UNADashboardPage extends BasePage {

    private final By k12Icon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"bx-mark\")");
    private final By dismissPasswordManagerBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"No\")");
    private final By communityBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\" Comunidad\")");
    private final By closeCheckOutTheNewCommunityModal = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"×\")");
    private final By myStudentsBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\" Mis Estudiantes\")");
    private final By unaCommunityBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Community\")");
    private final By greetingLbl = new By.ByXPath("//android.widget.TextView[contains(@text,\"Hola\")]");

    public UNADashboardPage() {
    }

    @Override
    @Step("Waiting for login page...")
    public void waitPageToLoad() {
        waitForDisplayed(k12Icon);

    }

    @Override
    @Step("Verifying login page...")
    public void verifyPage() {

    }




}
