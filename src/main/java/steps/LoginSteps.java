package steps;

import static driver.Driver.refreshPage;
import static driver.Driver.waitFor;
import static util.TestDataReader.getValue;

public class LoginSteps extends BaseSteps{

  public void outlookLogIn() {
    outlookLogInPage.enterAccountName(getValue("outLookAccountName"));

    for (int i = 0; i < 2; i++) {
      outlookLogInPage.enterPassword(getValue("outLookPassword"));
      //Wait until password filed disappears
      waitFor(2);
      if (!outlookLogInPage.isPasswordFieldDisplayed()) {
        break;
      }
    }
    for (int i = 0; i < 10; i++) {
      if (outlookLogInPage.isDoNotStaySignInButtonDisplayed()) {
        outlookLogInPage.clickDoNotStaySignInButton();
        break;
      }
      refreshPage();
      waitFor(3);
    }
  }

  public void mailLogin() {
    mailSignInPage.openSignInWindow()
        .enterAccountName(getValue("mailAccountName"))
        .chooseAnotherWayToLogIn()
        .enterPassword(getValue("mailPassword"));
  }

  public void mailEnterAccountName(String mail) {
    mailSignInPage.openSignInWindow()
        .enterAccountName(mail);
  }

  public String getErrorMessageFromWrongUsername() {
    return mailSignInPage.getErrorMessageFromWrongUsername();
  }

  public String getErrorMessageFromWrongPassword() {
    return mailSignInPage.getErrorMessageFromWrongPassword();
  }
}
