package steps;

import driver.DriverFactory;

public class NavigationSteps {

  public void openPage(String url) {
    DriverFactory.getDriver()
        .navigate()
        .to(url);
  }
}
