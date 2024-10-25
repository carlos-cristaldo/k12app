package utilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverProvider {

    private final static ThreadLocal<AndroidDriver> threadLocal =  new ThreadLocal<>();
    public static ThreadLocal<AndroidDriver> globalDriver =  new ThreadLocal<>();

    public void set(AndroidDriver driver){
        threadLocal.set(driver);
    }

    public void setGlobalDriver(AndroidDriver driver){
        globalDriver.set(driver);
    }

    public AndroidDriver get(){
        return threadLocal.get();
    }
}
