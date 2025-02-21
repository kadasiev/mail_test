package pages;

import static element.Element.xpath;

import element.Element;
import model.Letter;
import org.openqa.selenium.WebElement;

public class OutlookMailboxPage {

  Element letters = xpath("//div[@class='hcptT gDC9O']");
  Element letterContent = xpath("//div[@id='UniqueMessageBody']/div/div/div");
  Element menuButton = xpath("//img[@alt='DK']");
  Element signOutButton = xpath("//a[@id='mectrl_body_signOut']");
  Element acceptCookiesButton = xpath("//button[@id='onetrust-accept-btn-handler']");

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
}
