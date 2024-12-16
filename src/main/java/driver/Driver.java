package driver;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

  public static final int TIMEOUT = 20;


  public static void waitUntilTitleIs(String expectedTitle) {
    new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
    .until(ExpectedConditions.titleIs(expectedTitle));
  }

  public static String getTitle() {
    return DriverFactory.getDriver().getTitle();
  }
  
  public static void switchToDefaultContent() {
    DriverFactory.getDriver().switchTo().defaultContent();
  }

  public static void waitFor(long seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException ignored) {}
  }
}
