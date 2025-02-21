package model;

public record Letter(String sender, String receiver, String subject, String body) {

  @Override
  public String toString() {
    return "Letter\n" +
        "Sender: " + sender + '\n' +
        "Receiver: " + receiver + '\n' +
        "Subject: " + subject + '\n' +
        "Body: " + body;
  }
}
