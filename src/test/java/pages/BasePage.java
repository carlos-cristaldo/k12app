package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

import java.time.Duration;
import java.util.List;

import static utilities.DriverProvider.globalDriver;

public abstract class BasePage {

    private static final int defaultTimeOut = 30;
    protected int timeout;
    protected final SoftAssert softAssert;

    public BasePage(int timeout) {
        softAssert = new SoftAssert();
        this.timeout = timeout;

    }

    public BasePage() {
        this(defaultTimeOut);
    }

    public WebElement waitForDisplayed(By locator, int time) {
        final var wait = new WebDriverWait(globalDriver.get(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForDisplayed(By locator) {
        return  waitForDisplayed(locator, defaultTimeOut);
    }

    protected void waitPage(By locator, String pageName) {
        Logs.info("Waiting for page to load...");
        waitForDisplayed(locator, timeout);
        Logs.info("%s loaded correctly...", pageName);
    }

    public WebElement find(By locator) {
        return globalDriver.get().findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return globalDriver.get().findElements(locator);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();

}
