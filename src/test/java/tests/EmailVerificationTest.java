package tests;

import static driver.Driver.openPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailVerificationTest extends BaseTest {

  private static final String SENDER = "David Kadasiev";
  private static final String RECEIVER = "selenium.test124@outlook.com";
  private static final String SUBJECT = "Test";
  private static final String LETTER = "Hi!\n\nHow are you?\n\nBest Regards\nDavid";
  private static final String USERNAME = "selenium.test124@mail.ru";
  private static final String PASSWORD = "q2r5h7k9#";
  private static final String OUTLOOK_BASE_PAGE = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=16&ct=1696870280&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26RpsCsrfState%3de427b455-e16e-e65b-55eb-6b5f905de2eb&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c";
  private static final String MAIL_BASE_PAGE = "https://mail.ru/";

  @Test()
  public void validateEmailIsArrived() {
    openPage(MAIL_BASE_PAGE);
    loginSteps.mailLogin(USERNAME, PASSWORD);
    emailVerificationSteps.sendLetterFromMail(RECEIVER, SUBJECT + "1", LETTER);
    logoutSteps.mailLogOut();
    openPage(OUTLOOK_BASE_PAGE);
    loginSteps.outlookLogIn();
    boolean isArrived = emailVerificationSteps
        .isEmailArrivedToOutlook(SENDER, SUBJECT + "1");
    logoutSteps.outlookLogOut();

    Assert.assertTrue(isArrived, "Validation that email is arrived");
  }

  @Test()
  public void validateEmailUnread() {
    openPage(MAIL_BASE_PAGE);
    loginSteps.mailLogin(USERNAME, PASSWORD);
    emailVerificationSteps.sendLetterFromMail(RECEIVER, SUBJECT + "2", LETTER);
    logoutSteps.mailLogOut();
    openPage(OUTLOOK_BASE_PAGE);
    loginSteps.outlookLogIn();
    boolean isUnread = emailVerificationSteps
        .isEmailUnreadInOutlook(SENDER, SUBJECT + "2");
    logoutSteps.outlookLogOut();

    Assert.assertTrue(isUnread, "Validation that the new email is unread");
  }

  @Test()
  public void validateEmailContent() {
    openPage(MAIL_BASE_PAGE);
    loginSteps.mailLogin(USERNAME, PASSWORD);
    emailVerificationSteps.sendLetterFromMail(RECEIVER, SUBJECT + "3", LETTER);
    logoutSteps.mailLogOut();
    openPage(OUTLOOK_BASE_PAGE);
    loginSteps.outlookLogIn();
    String emailContent = emailVerificationSteps
        .getEmailFromOutlook(SENDER, SUBJECT + "3");
    logoutSteps.outlookLogOut();

    Assert.assertEquals(emailContent, LETTER, "Validation of the email content");
  }
}
