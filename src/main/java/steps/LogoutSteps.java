package steps;

public class LogoutSteps extends BaseSteps {

  public void outlookLogOut() {
    outlookMailboxPage.openMenu()
        .clickLogOut();
//        .acceptCookies();
  }

  public void mailLogOut() {
    mailMailboxPage.openMenu()
        .clickLogOut();
  }
}
