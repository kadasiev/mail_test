package steps;

import driver.DriverFactory;

public class NavigationSteps {

  public void openPage(String url) {
    DriverFactory.openBrowser();
    DriverFactory.getDriver()
        .navigate()
        .to(url);
  }
}
