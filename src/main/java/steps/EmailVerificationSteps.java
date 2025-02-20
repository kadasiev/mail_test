package steps;

import model.Letter;

public class EmailVerificationSteps extends BaseSteps {

  public void sendLetterFromMail(Letter letter) {
    mailMailboxPage.createLetter()
        .fillReceiver(letter.getReceiver())
        .fillSubject(letter.getSubject())
        .clearMailBody()
        .fillMailBody(letter.getBody())
        .sendLetter()
        .closeEmailIsSentNotification();
  }

  public boolean isEmailArrivedToOutlook(Letter letter) {
    return outlookMailboxPage.isEmailArrived(letter);
  }

  public boolean isEmailUnreadInOutlook(Letter letter) {
    return outlookMailboxPage.isEmailUnread(letter);
  }

  public String getEmailFromOutlook(Letter letter) {
    return outlookMailboxPage.getEmailContent(letter);
  }
}
