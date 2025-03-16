package tests;

import static driver.Driver.openPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static util.LetterCreator.newLetter;
import static util.TestDataReader.getValue;

import model.Letter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailVerificationTest extends BaseTest {

  private static final String SENDER = "David Kadasiev";

  @Test(groups = {"regression"})
  public void validateEmailIsArrived() {
    Letter letter = newLetter(SENDER, getValue("outLookAccountName"));
    openPage(getValue("mailBasePage"));
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(letter);
    navigationSteps.openFolderInMail("Sent");
    lettersManagementSteps.deleteLetterFromMail(letter);
    logoutSteps.mailLogOut();
    openPage(getValue("outlookBasePage"));
    loginSteps.outlookLogIn();
    boolean isArrived = emailVerificationSteps
        .isEmailArrivedToOutlook(letter);
    lettersManagementSteps.deleteLetterFromOutlook(letter);
    logoutSteps.outlookLogOut();

    assertTrue(isArrived, "The email hasn't arrive!");
  }

  @Test(groups = {"regression"})
  public void validateEmailUnread() {
    Letter letter = newLetter(SENDER, getValue("outLookAccountName"));
    openPage(getValue("mailBasePage"));
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(letter);
    navigationSteps.openFolderInMail("Sent");
    lettersManagementSteps.deleteLetterFromMail(letter);
    logoutSteps.mailLogOut();
    openPage(getValue("outlookBasePage"));
    loginSteps.outlookLogIn();
    boolean isUnread = emailVerificationSteps
        .isEmailUnreadInOutlook(letter);
    lettersManagementSteps.deleteLetterFromOutlook(letter);
    logoutSteps.outlookLogOut();

    assertTrue(isUnread, "The new email is marked as read!");
  }

  @Test(groups = {"regression"})
  public void validateEmailContent() {
    Letter letter = newLetter(SENDER, getValue("outLookAccountName"));
    openPage(getValue("mailBasePage"));
    loginSteps.mailLogin();
    emailVerificationSteps.sendLetterFromMail(letter);
    navigationSteps.openFolderInMail("Sent");
    lettersManagementSteps.deleteLetterFromMail(letter);
    logoutSteps.mailLogOut();
    openPage(getValue("outlookBasePage"));
    loginSteps.outlookLogIn();
    String emailContent = emailVerificationSteps
        .getEmailFromOutlook(letter);
    lettersManagementSteps.deleteLetterFromOutlook(letter);
    logoutSteps.outlookLogOut();

    assertEquals(emailContent, letter.body(),
        "The email content is not valid!");
  }
}
