package steps;

import static driver.Driver.waitFor;

import org.openqa.selenium.ElementClickInterceptedException;

public class LogoutSteps extends BaseSteps {

  public void outlookLogOut() {
    for (int i = 0; i < 3; i++) {
      outlookMailboxPage.openAccountMenu();
      waitFor(1);
      if (outlookMailboxPage.isAccountManuDisplayed()) {
        break;
      }
    }
    try {
      outlookMailboxPage.clickLogOut();
    } catch (ElementClickInterceptedException e) {
      //Wait until the 'email arrived' notification disappears
      waitFor(3);
      outlookMailboxPage.clickLogOut();
    }
  }

  public void mailLogOut() {
    mailMailboxPage.openMenu()
        .clickLogOut();
  }
}
