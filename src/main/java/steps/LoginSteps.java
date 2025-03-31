package steps;

import static driver.Driver.refreshPage;
import static driver.Driver.waitFor;

import model.User;

public class LoginSteps extends BaseSteps {

  public void outlookLogIn(User user) {
    outlookLogInPage.enterAccountName(user.accountName());

    for (int i = 0; i < 2; i++) {
      outlookLogInPage.enterPassword(user.password());
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

  public void mailLogin(User user) {
    mailSignInPage.openSignInWindow()
        .enterAccountName(user.accountName())
        .chooseAnotherWayToLogIn()
        .enterPassword(user.password());
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
