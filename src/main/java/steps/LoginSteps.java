package steps;

import static util.TestDataReader.getTestData;

public class LoginSteps extends BaseSteps{

  public void outlookLogIn() {
    outlookLogInPage.enterAccountName(getTestData("outLookAccountName"))
        .submitAccountName()
        .enterPassword(getTestData("outLookPassword"))
        .submitPassword()
        .clickDoNotStaySignInButton();
  }

  public void mailLogin() {
    mailSignInPage.openSignInWindow()
        .enterAccountName(getTestData("mailAccountName"))
        .chooseAnotherWayToLogIn()
        .enterPassword(getTestData("mailPassword"));
  }

  public void mailEnterAccountName(String mail) {
    mailSignInPage.openSignInWindow()
        .enterAccountName(mail);
  }

  public String getTitle() {
    return mailMailboxPage.getTitle();
  }

  public String getErrorMessageFromWrongUsername() {
    return mailSignInPage.getErrorMessageFromWrongUsername();
  }

  public String getErrorMessageFromWrongPassword() {
    return mailSignInPage.getErrorMessageFromWrongPassword();
  }
}
