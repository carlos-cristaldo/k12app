package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import static utilities.DriverProvider.globalDriver;


public class DriverManager {

    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver() {
        if (runServer) {
            buildRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }

    public void buildLocalDriver() {
        try {
            final var appiumUrl = "http://127.0.0.1:4723/";
            final var desiredCapabilities = getDesiredBSCapabilities();
            Logs.debug("Starting driver...");
            final var driver = new AndroidDriver(new URI(appiumUrl).toURL(), desiredCapabilities);
            new DriverProvider().setGlobalDriver(driver);
        } catch (MalformedURLException | URISyntaxException e) {
            Logs.error("Error starting the driver %s", e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    public void killDriver() {
        globalDriver.get().quit();
    }

    public void buildRemoteDriver() {

    }

    private static DesiredCapabilities getDesiredLocalCapabilites() {
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

    private static DesiredCapabilities getDesiredBSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        bstackOptions.put("userName", "carloscristaldo_OwV0a3");
        bstackOptions.put("accessKey", "ccYqspGmFEUNbDN1cypP");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("bstack:options", bstackOptions);
        return capabilities;
    }

}
