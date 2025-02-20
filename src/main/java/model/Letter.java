package model;

public class Letter {

  private final String sender;
  private final String receiver;
  private final String subject;
  private final String body;

  public Letter(String sender, String receiver, String subject, String body) {
    this.sender = sender;
    this.receiver = receiver;
    this.subject = subject;
    this.body = body;
  }

  public String getSender() {
    return sender;
  }

  public String getReceiver() {
    return receiver;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  @Override
  public String toString() {
    return "Letter\n" +
        "Sender: " + sender + '\n' +
        "Receiver: " + receiver + '\n' +
        "Subject: " + subject + '\n' +
        "Body: " + body;
  }
}
