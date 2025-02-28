package pages;

import static element.Element.xpath;

import element.Element;
import model.Letter;
import org.openqa.selenium.WebElement;

public class OutlookMailboxPage {

  static final String LETTER_BY_SUBJECT_PATTERN = "//div[contains(@class, 'jGG6V') and contains(@aria-label, '%s')]";
  static final String CHECKBOX = "//*[contains(@class, 'checkbox')]";
  static final String LETTERS_TOR_MENU = "//*[@id = 'BottomBar']";

  Element letters = xpath("//div[contains(@class, 'jGG6V')]");
  Element letterContent = xpath("//div[@id='UniqueMessageBody']/div/div/div");
  Element menuButton = xpath("//*[contains(@id, 'MainLink_MePhoto')]");
  Element signOutButton = xpath("//a[@id='mectrl_body_signOut']");
  Element acceptCookiesButton = xpath("//button[@id='onetrust-accept-btn-handler']");
  Element deleteButton = xpath(LETTERS_TOR_MENU +
      "//*[text() = 'Delete' or text() = 'Empty folder']");

  public boolean isEmailArrived(Letter expectedLetter) {
    boolean isArrived = false;

    for (WebElement letter : letters.getList()) {
      if (letter.getAttribute("aria-label")
          .contains(expectedLetter.sender() + " " + expectedLetter.subject())) {
        isArrived = true;
        break;
      }
    }
    return isArrived;
  }

  public boolean isEmailUnread(Letter expectedLetter) {
    boolean isArrived = false;

    for (WebElement letter : letters.getList()) {
      if (letter.getAttribute("aria-label").contains("Unread")
          && letter.getAttribute("aria-label")
          .contains(expectedLetter.sender() + " " + expectedLetter.subject())) {
        isArrived = true;
        break;
      }
    }
    return isArrived;
  }

  public String getEmailContent(Letter expectedLetter) {
    for (WebElement letter : letters.getList()) {
      if (letter.getAttribute("aria-label")
          .contains(expectedLetter.sender() + " " + expectedLetter.subject())) {
        letter.click();
        return letterContent.getText().trim();
      }
    }
    return "The letter doesn't exist";
  }

  public OutlookMailboxPage openMenu() {
    menuButton.click();
    return this;
  }

  public OutlookMailboxPage clickLogOut() {
    signOutButton.click();
    return this;
  }

  public void acceptCookies() {
    acceptCookiesButton.tryToClickFor(30);
  }

  public OutlookMailboxPage selectLetter(Letter letter) {
    xpath(String.format(LETTER_BY_SUBJECT_PATTERN, letter.subject())).hoverOver();
    xpath(String.format(LETTER_BY_SUBJECT_PATTERN, letter.subject()) + CHECKBOX).click();
    return this;
  }

  public void deleteLetter() {
    deleteButton.click();
  }
}
