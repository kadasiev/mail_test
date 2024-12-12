package steps;

public class LogoutSteps extends BaseSteps {

  public void outlookLogOut() {
    outlookMailboxPage.signOut();
  }

  public void mailLogout() {
    mailMailboxPage.signOut();
  }
}
