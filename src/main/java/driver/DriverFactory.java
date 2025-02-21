package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized void openBrowser() {
        if (getDriver() == null) {
            switch(System.getProperty("browser", "chrome")) {
                case "firefox" -> driver.set(new FirefoxDriver());
                case "chrome" ->  driver.set(new ChromeDriver());
                default -> throw new IllegalArgumentException("Unsupported browser: "
                    + System.getProperty("browser"));
            }
            WebDriver currentDriver = getDriver();
            if (currentDriver != null) {
                currentDriver.manage().window().maximize();
            }
        }
    }

    public static synchronized void closeBrowser() {
        WebDriver currentDriver = getDriver();
        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
