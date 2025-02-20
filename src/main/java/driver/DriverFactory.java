package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static void openBrowser() {
        if (driver == null) {
            switch(System.getProperty("browser")) {
                case "firefox" -> driver = new FirefoxDriver();
                case "chrome" ->  driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
