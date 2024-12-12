package steps;

import pages.MailSignInPage;

public class LoginSteps extends BaseSteps{

  public void outlookLogin() {
    outlookSignInPage.openPage()
        .signIn("selenium.test124@outlook.com", "q2r5h7k9#");
  }

  public void mailLogin() {
    mailSignInPage.openPage()
        .openSignInWindow()
        .enterUsername("selenium.test124@mail.ru")
        .enterPassword("q2r5h7k9#");
  }

}
