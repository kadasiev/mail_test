package steps;

public class LoginSteps extends BaseSteps{

  public void outlookLogin() {
    outlookSignInPage.openPage()
        .signIn("selenium.test124@outlook.com", "q2r5h7k9#");
  }

  public void mailLogin(String username, String password) {
    mailSignInPage.openPage()
        .openSignInWindow()
        .enterUsername(username)
        .enterPassword(password);
  }

  public void mailEnterUsername(String username) {
    mailSignInPage.openPage()
        .openSignInWindow()
        .enterUsername(username);
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
