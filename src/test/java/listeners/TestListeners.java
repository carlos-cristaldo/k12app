package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.FileManager;
import utilities.Logs;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("Starting test = %s", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("Test finished successfully = %s", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("Failed test = %s", result.getName());
        FileManager.getScreenShot(result.getName());
        FileManager.getPageSource(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("Skipped test = %s", result.getName());
    }
}
