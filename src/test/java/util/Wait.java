package util;

import driver.DriverFactory;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

  static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
      Duration.ofSeconds(20));

  static WebDriverWait getWait() {
    return wait;
  }
}
