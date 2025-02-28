package tests;

import static driver.Driver.openPage;
import static util.LetterCreator.newLetter;
import static util.TestDataReader.getTestData;

import model.Letter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailVerificationTest extends BaseTest {

  private static final String SENDER = "David Kadasiev";

  @Test(groups = {"regression"})
  public void validateEmailIsArrived() {
    Letter letter = newLetter(SENDER, getTestData("outLookAccountName"));
    openPage(getTestData("mailBasePage"));
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(letter);
    navigationSteps.openFolderInMail("Sent");
    lettersManagementSteps.deleteLetterFromMail(letter);
    logoutSteps.mailLogOut();
    openPage(getTestData("outlookBasePage"));
    loginSteps.outlookLogIn();
    boolean isArrived = emailVerificationSteps
        .isEmailArrivedToOutlook(letter);
    lettersManagementSteps.deleteLetterFromOutlook(letter);
    logoutSteps.outlookLogOut();

    Assert.assertTrue(isArrived, "The email didn't arrive!");
  }

  @Test(groups = {"regression"})
  public void validateEmailUnread() {
    Letter letter = newLetter(SENDER, getTestData("outLookAccountName"));
    openPage(getTestData("mailBasePage"));
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(letter);
    logoutSteps.mailLogOut();
    openPage(getTestData("outlookBasePage"));
    loginSteps.outlookLogIn();
    boolean isUnread = emailVerificationSteps
        .isEmailUnreadInOutlook(letter);
    logoutSteps.outlookLogOut();

    Assert.assertTrue(isUnread, "Validation that the new email is unread");
  }

  @Test(groups = {"regression"})
  public void validateEmailContent() {
    Letter letter = newLetter(SENDER, getTestData("outLookAccountName"));
    openPage(getTestData("mailBasePage"));
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(letter);
    logoutSteps.mailLogOut();
    openPage(getTestData("outlookBasePage"));
    loginSteps.outlookLogIn();
    String emailContent = emailVerificationSteps
        .getEmailFromOutlook(letter);
    logoutSteps.outlookLogOut();

    Assert.assertEquals(emailContent, letter.body(),
        "Validation of the email content");
  }
}
