package steps;

import static driver.Driver.waitFor;

import driver.Driver;
import model.Letter;

public class EmailVerificationSteps extends BaseSteps {

  public void sendLetterFromMail(Letter letter) {
    mailMailboxPage.createLetter()
        .fillReceiver(letter.receiver())
        .fillSubject(letter.subject())
        .clearMailBody()
        .fillMailBody(letter.body())
        .sendLetter()
        .closeEmailIsSentNotification();
  }

  public boolean isEmailArrivedToOutlook(Letter letter) {
    return outlookMailboxPage.waitUntilEmailArrives(letter)
        .isEmailArrived(letter);
  }

  public boolean isEmailUnreadInOutlook(Letter letter) {
    return outlookMailboxPage.waitUntilEmailArrives(letter)
        .isEmailUnread(letter);
  }

  public String getEmailFromOutlook(Letter letter) {
    return outlookMailboxPage.waitUntilEmailArrives(letter)
        .openEmail(letter)
        .getEmailContent();
  }

  public String getTitle() {
    waitFor(15);
    return Driver.getTitle();
  }
}
