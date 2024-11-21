package CommonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverManager() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize the ChromeDriver
            driver = new ChromeDriver();

            // Set the browser to full-screen
            driver.manage().window().maximize(); // Or use fullscreen()
        }
        return driver;
    }

    // Optional: Method to quit the driver
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
}
