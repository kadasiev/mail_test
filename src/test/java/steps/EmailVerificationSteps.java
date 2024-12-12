package steps;

public class EmailVerificationSteps extends BaseSteps {

  public void sendLetterFromMail(String receiver, String subject, String letter) {
    mailMailboxPage.sendLetter(receiver, subject, letter)
        .waitUntilEmailIsSent();
  }

  public boolean isEmailArrivedToOutlook(String sender, String subject) {
    return outlookMailboxPage.isEmailArrived(sender, subject);
  }

  public boolean isEmailUnreadToOutlook(String sender, String receiver) {
    return outlookMailboxPage.isEmailUnread(sender, receiver);
  }

  public String getEmailFromOutlook(String sender, String subject) {
    return outlookMailboxPage.getEmailContent(sender, subject);
  }
}
