package driver;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

  private final static WebDriver DRIVER = DriverFactory.getDriver();
  private final static WebDriverWait WAIT = new WebDriverWait(DRIVER, Duration.ofSeconds(20));

  public static void waitUntilTitleIs(String expectedTitle) {
    WAIT.until(ExpectedConditions.titleIs(expectedTitle));
  }

  public static String getTitle() {
    return DRIVER.getTitle();
  }

  public static void navigateTo(String url) {
    DRIVER.navigate().to(url);
  }
  
  public static void switchToDefaultContent() {
    DRIVER.switchTo().defaultContent();
  }

  public static void waitForPageToLoad() {
    WAIT.until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
  }

  public static void waitFor(long seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException ignored) {}
  }
}
