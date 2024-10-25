package tests;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {

    protected SoftAssert softAssert;
    protected final String regression = "regression";
    protected final String smoke = "smoke";



    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("setup method");
        softAssert = new SoftAssert();
        Logs.info("Assigning driver...");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Logs.info("teardown method");
    }






}
