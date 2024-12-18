package pages;

import static element.Element.xpath;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import element.Element;

public class OutlookMailboxPage {

    Element letters = xpath("//div[@class='hcptT gDC9O']");
    Element letterContent = xpath("//div[@id='UniqueMessageBody']/div/div/div");
    Element menuButton = xpath("//img[@alt='DK']");
    Element signOutButton = xpath("//a[@id='mectrl_body_signOut']");
    Element acceptCookiesButton = xpath("//button[@id='onetrust-accept-btn-handler']");

    public boolean isEmailArrived(String sender, String subject) {
        boolean isArrived = false;

       for(WebElement letter : letters.getList()){
            if(letter.getAttribute("aria-label").contains(sender + " " + subject)) {
                isArrived = true;
                break;
            }
       }
       return isArrived;
    }

    public boolean isEmailUnread(String sender, String subject) {
        boolean isArrived = false;

        for(WebElement letter : letters.getList()) {
            if(letter.getAttribute("aria-label").contains("Unread")
                && letter.getAttribute("aria-label").contains(sender + " " + subject)) {
                isArrived = true;
                break;
            }
        }
        return isArrived;
    }

    public String getEmailContent(String sender, String subject) {
        for(WebElement letter : letters.getList()) {
            if(letter.getAttribute("aria-label").contains(sender + " " + subject)) {
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
