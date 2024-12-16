package steps;

public class EmailVerificationSteps extends BaseSteps {

  public void sendLetterFromMail(String receiver, String subject, String letter) {
    mailMailboxPage.createLetter()
        .fillReceiver(receiver)
        .fillSubject(subject)
        .clearMailBody()
        .fillMailBody(letter)
        .sendLetter();
  }

  public boolean isEmailArrivedToOutlook(String sender, String subject) {
    return outlookMailboxPage.isEmailArrived(sender, subject);
  }

  public boolean isEmailUnreadInOutlook(String sender, String subject) {
    return outlookMailboxPage.isEmailUnread(sender, subject);
  }

  public String getEmailFromOutlook(String sender, String subject) {
    return outlookMailboxPage.getEmailContent(sender, subject);
  }
}
