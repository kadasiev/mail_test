package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailVerificationTest extends BaseTest {

  private static final String SENDER = "David Kadasiev";
  private static final String RECEIVER = "selenium.test124@outlook.com";
  private static final String SUBJECT = "Test";
  private static final String LETTER = "Hi!\n\nHow are you?\n\nBest Regards\nDavid";

  @Test()
  public void validateEmailIsArrived() {
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(RECEIVER, SUBJECT + "1", LETTER);
    logoutSteps.mailLogout();
    loginSteps.outlookLogin();
    boolean isArrived =
        emailVerificationSteps.isEmailArrivedToOutlook(SENDER, SUBJECT + "1");
    logoutSteps.outlookLogOut();

    Assert.assertTrue(isArrived, "Validation that email is arrived");
  }

  @Test()
  public void validateEmailUnread() {
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(RECEIVER, SUBJECT + "2", LETTER);
    logoutSteps.mailLogout();
    loginSteps.outlookLogin();
    boolean isUnread =
        emailVerificationSteps.isEmailUnreadToOutlook(SENDER, SUBJECT + "2");
    logoutSteps.outlookLogOut();

    Assert.assertTrue(isUnread, "Validation that the new email is unread");
  }

  @Test()
  public void validateEmailContent() {
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(RECEIVER, SUBJECT + "3", LETTER);
    logoutSteps.mailLogout();
    loginSteps.outlookLogin();
    String emailContent =
        emailVerificationSteps.getEmailFromOutlook(SENDER, SUBJECT + "3");
    logoutSteps.outlookLogOut();

    Assert.assertEquals(emailContent, LETTER, "Validation of the email content");
  }
}
