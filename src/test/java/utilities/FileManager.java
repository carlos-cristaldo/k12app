package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static final String screenshotsPath = "src/test/resources/screenshots";
    private static final String pageSourcePath = "src/test/resources/pageSource";

    public static void getScreenShot(String screenshotsName) {
        Logs.debug("Taking screenshot...");

        final var screenshotFile = ((TakesScreenshot) new DriverProvider().get())
                .getScreenshotAs(OutputType.FILE);
        final var path = String.format("%s/%s.png", screenshotsPath, screenshotsName);

        try {
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException e) {
            Logs.error("Error while taking screenshot...");
        }
    }

    public static void deleteScreenshots() {
        Logs.info("Cleaning screenshots folder...");

        try {
            FileUtils.deleteDirectory(new File(screenshotsPath));
            FileUtils.deleteDirectory(new File(pageSourcePath));
        } catch (IOException e) {
            Logs.error("Error truing screenshots folder...");
            Logs.error(e.getMessage());
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] getScreenshot() {
        return ((TakesScreenshot) new DriverProvider().get())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "pagesource", type = "text/html", fileExtension = "txt")
    public static String getPageSource() {
        final var pageSource = new DriverProvider().get().getPageSource();
        return pageSource != null ?
                Jsoup.parse(pageSource).toString() : "Error saving pagesource....";
    }

    public static void getPageSource(String fileName) {
        final var path = String.format("%s/%s.xml", pageSourcePath, fileName);

        final var file = new File(path);
        Logs.debug("Creating parent folders if don't exist...");
        if (file.getParentFile().mkdirs()) {
            try {
                final var fileWriter = new FileWriter(file);
                final var pageSource = new DriverProvider().get().getPageSource();
                if (pageSource != null) {
                    fileWriter.write(Jsoup.parse(pageSource).toString());
                }
                fileWriter.close();
            } catch (IOException e) {
                Logs.error("Error saving pagesource....");
                Logs.error(e.getMessage());
            }
        }
    }
}
