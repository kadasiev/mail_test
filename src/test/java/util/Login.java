package util;

import pages.OutlookSignInPage;

public class Login {

  public static void outLookLogin() {
    new OutlookSignInPage()
        .openPage()
        .signIn("selenium.test124@outlook.com", "q2r5h7k9#");
  }

  public static void outLookLogout() {

  }

}
