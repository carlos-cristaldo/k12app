package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.FileManager;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Logs.info("Suite started = %s", suite.getName());
        FileManager.deleteScreenshots();
    }

    @Override
    public void onFinish(ISuite suite) {
        Logs.info("Suite finished = %s", suite.getName());
    }
}
