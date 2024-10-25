package listeners;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import utilities.FileManager;
import utilities.Logs;

import static utilities.DriverProvider.globalDriver;

public class AllureListeners implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {
        Logs.debug("Allure Screenshots...");

        final var status = result.getStatus();

        switch (status){
            case BROKEN, FAILED ->{
                if (globalDriver.get() != null){
                    FileManager.getScreenshot();
                    FileManager.getPageSource();
                }
            }
        }
    }
}
