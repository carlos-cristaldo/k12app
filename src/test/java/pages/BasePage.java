package pages;

import io.appium.java_client.android.AndroidDriver;
import org.testng.asserts.SoftAssert;
import utilities.DriverProvider;

public abstract class BasePage {

    private static final int defaultTimeOut = 5;
    private final int timeout;
    protected final SoftAssert softAssert;

    public BasePage(int timeout) {
        softAssert = new SoftAssert();
        this.timeout = timeout;
    }

    public BasePage() {
        this(defaultTimeOut);
    }

    protected AndroidDriver getDriver(){
        return new DriverProvider().get();
    }
}
