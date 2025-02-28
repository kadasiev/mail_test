package steps;

import model.Letter;

public class LettersManagementSteps extends BaseSteps {

  public void deleteLetterFromMail(Letter letter) {
    mailMailboxPage.selectLetter(letter)
        .deleteLetter();
  }

  public void deleteLetterFromOutlook(Letter letter) {
    outlookMailboxPage.selectLetter(letter)
        .deleteLetter();
  }
}
