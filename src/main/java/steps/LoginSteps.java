package steps;

public class LoginSteps extends BaseSteps{

  public void outlookLogIn() {
    outlookLogInPage.enterAccountName("selenium.test124@outlook.com")
        .submitAccountName()
        .enterPassword("q2r5h7k9#")
        .submitPassword()
        .clickDoNotStaySignInButton();
  }

  public void mailLogin(String mail, String password) {
    mailSignInPage.openSignInWindow()
        .enterUsername(mail)
        .chooseAnotherWayToLogIn()
        .enterPassword(password);
  }

  public void mailEnterMail(String mail) {
    mailSignInPage.openSignInWindow()
        .enterUsername(mail);
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
