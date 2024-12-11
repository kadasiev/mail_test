package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OutlookMailboxPage;
import pages.OutlookSignInPage;
import util.EmailManager;

public class EmailVerificationTest extends BaseTest {

  @Test()
  public void validateEmailIsArrived() throws InterruptedException {
    EmailManager.sendLetter("selenium.test124@outlook.com", "test7",
        "Hi!\n\nHow are you?\n\nBest Regards\nDavid");

    boolean isArrived = new OutlookSignInPage().openPage()
        .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
        .isEmailArrived("David Kadasiev", "test7");
    new OutlookMailboxPage().signOut();

    Assert.assertTrue(isArrived, "Validation that email is arrived");
  }

  @Test()
  public void validateEmailUnread() throws InterruptedException {
    EmailManager.sendLetter("selenium.test124@outlook.com", "test8",
        "Hi\n\nHow are you?\n\nBest Regards\nDavid");

    boolean isUnread = new OutlookSignInPage()
        .openPage()
        .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
        .isEmailUnread("David Kadasiev", "test8");

    new OutlookMailboxPage().signOut();

    Assert.assertTrue(isUnread, "Validation that the new email is unread");
  }

  @Test()
  public void validateEmailContent() throws InterruptedException {
    EmailManager.sendLetter("selenium.test124@outlook.com", "test9",
        "Hi\n\nHow are you?\n\nBest Regards\nDavid");

    String emailContent = new OutlookSignInPage().openPage()
        .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
        .getEmailContent("David Kadasiev", "test9");
    new OutlookMailboxPage().signOut();

    Assert.assertEquals(emailContent,
        "Hi\n\nHow are you?\n\nBest Regards\nDavid", "Validation of the email content");

  }
}
