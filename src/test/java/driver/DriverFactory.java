package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private final static WebDriver driver;

    static{
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
