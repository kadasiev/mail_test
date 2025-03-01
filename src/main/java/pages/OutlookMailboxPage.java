package pages;

import static driver.Driver.waitFor;
import static element.Element.xpath;

import element.Element;
import model.Letter;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

public class OutlookMailboxPage {

  private static final String LETTER_BY_SUBJECT_PATTERN = "//div[contains(@class, 'jGG6V') and contains(@aria-label, '%s')]";
  private static final String CHECKBOX = "//*[contains(@class, 'checkbox')]";
  private static final String LETTERS_TOR_MENU = "//*[@id = 'BottomBar']";
  private static final String LETTER_BY_SENDER_AND_SUBJECT_PATTERN =
      "//div[contains(@class, 'jGG6V') and contains(@aria-label, '%s') and contains(@aria-label, '%s')]";
  private static final long TIMEOUT_FOR_THE_EMAIL_TO_ARRIVE = 180;

  private Element letters = xpath("//div[contains(@class, 'jGG6V')]");
  private Element letterContent = xpath("//div[contains(@id, 'UniqueMessageBody')]/div/div/div");
  private Element menuButton = xpath("//*[contains(@id, 'MainLink_MePhoto')]");
  private Element signOutButton = xpath("//a[@id='mectrl_body_signOut']");
  private Element acceptCookiesButton = xpath("//button[@id='onetrust-accept-btn-handler']");
  private Element deleteButton = xpath(LETTERS_TOR_MENU +
      "//*[text() = 'Delete' or text() = 'Empty folder']");
  private Element accountManu = xpath("//*[contains(@class, 'currentAccount')]");

  public void waitUntilEmailArrives(Letter letter) {
    xpath(String.format(LETTER_BY_SENDER_AND_SUBJECT_PATTERN,
        letter.sender(),
        letter.subject()))
        .waitForVisibilityFor(TIMEOUT_FOR_THE_EMAIL_TO_ARRIVE);
  }

  public boolean isEmailArrived(Letter letter) {
    waitUntilEmailArrives(letter);

    return xpath(String.format(LETTER_BY_SENDER_AND_SUBJECT_PATTERN,
        letter.sender(),
        letter.subject()))
        .isDisplayed();
  }

  public boolean isEmailUnread(Letter letter) {
    waitUntilEmailArrives(letter);

    return xpath(String.format(LETTER_BY_SENDER_AND_SUBJECT_PATTERN,
        letter.sender(),
        letter.subject()))
        .attributeContains("aria-label", "Unread");
  }

  public OutlookMailboxPage openEmail(Letter letter) {
    xpath(String.format(LETTER_BY_SENDER_AND_SUBJECT_PATTERN,
        letter.sender(),
        letter.subject())).clickFor(TIMEOUT_FOR_THE_EMAIL_TO_ARRIVE);
    return this;
  }

  public String getEmailContent() {
    return letterContent.getText().trim();
  }

  public OutlookMailboxPage openMenu() {
    for (int i = 0; i < 4; i++) {
      menuButton.click();
      waitFor(1);
      if (accountManu.isDisplayed()) {
        break;
      }
    }
    return this;
  }

  public void clickLogOut() {
    try {
      signOutButton.click();
    } catch (ElementClickInterceptedException e) {
      //Wait until the email arrived notification disappears
      waitFor(3);
      signOutButton.click();
    }
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
