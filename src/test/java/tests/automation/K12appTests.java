package tests.automation;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import tests.BaseTest;
import utilities.Logs;

public class K12appTests extends BaseTest {

    @Test
    public void firstTest(){
        final var locatorStartSessionBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"INICIAR SESIÓN\")");
        final var startSessionBtn = driver.findElement(locatorStartSessionBtn);
        Logs.info("First Test");
        forceWait(2000);
        startSessionBtn.click();
        forceWait(3000);
    }
}
