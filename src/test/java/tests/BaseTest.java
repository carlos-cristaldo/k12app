package tests;

import io.appium.java_client.android.AndroidDriver;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utilities.DriverProvider;
import utilities.Logs;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {

    protected SoftAssert softAssert;
    protected final String regression = "regression";
    protected final String smoke = "smoke";
    protected AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        Logs.info("setup method");
        softAssert = new SoftAssert();
        driver = initDriver();
        Logs.info("Assigning driver...");
        new DriverProvider().set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        Logs.info("teardown method");
        driver.quit();
    }

    private static DesiredCapabilities getDesiredCapabilites(){
        final var desiredCapabilities = new DesiredCapabilities();
        final var fileAPK = new File("src/test/resources/apk/1.21.79-uat.apk");
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:appPackage", "com.k12.onboarding");
        desiredCapabilities.setCapability("appium:appActivity", "com.k12.onboarding.MainActivity");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:app", fileAPK.getAbsolutePath());

        return desiredCapabilities;
    }

    private static AndroidDriver initDriver(){
        try {
            final var appiumUrl = "http://127.0.0.1:4723/";
            final var desiredCapabilities = getDesiredCapabilites();
            Logs.debug("Starting driver...");
            return new AndroidDriver(new URI(appiumUrl).toURL(), desiredCapabilities);
        } catch (MalformedURLException | URISyntaxException e) {
            Logs.error("Error starting the driver %s", e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    protected void forceWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
