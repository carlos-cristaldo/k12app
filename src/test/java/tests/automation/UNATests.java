package tests.automation;

import model.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.gh.GHDashboardPage;
import pages.gh.LoginPage;
import pages.gh.MarketingPage;
import pages.una.UNADashboardPage;
import tests.BaseTest;
import utilities.DriverManager;

import static utilities.DriverProvider.globalDriver;
import static utilities.Utils.forceWait;
import static utilities.Utils.getUser;

public class UNATests extends BaseTest {

    private final DriverManager driverManager = new DriverManager();
    private final MarketingPage marketingPage = new MarketingPage();
    private LoginPage loginPage;
    private GHDashboardPage ghDashboardPage;
    private UNADashboardPage unaDashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driverManager.buildLocalDriver();
        marketingPage.waitPageToLoad();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.killDriver();
    }

    @Test(groups = {regression, smoke})
    public void successLogin() {
        User user = getUser("user1");
        unaDashboardPage = marketingPage.goToUna(user);
        unaDashboardPage.waitPageToLoad();
        forceWait(3000);
    }

    @AfterClass
    public void cleanThreadLocal() {
        globalDriver.remove();
    }
}