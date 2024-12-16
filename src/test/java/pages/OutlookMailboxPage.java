package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import util.Element;

public class OutlookMailboxPage {

    Element letters = Element.byXpath("//div[@class='hcptT gDC9O']");
    Element letterContent = Element.byXpath("//div[@id='UniqueMessageBody']/div/div/div");
    Element menuButton = Element.byXpath("//img[@alt='DK']");
    Element signOutButton = Element.byXpath("//a[@id='mectrl_body_signOut']");
    Element acceptCookiesButton = Element.byXpath("//button[@id='onetrust-accept-btn-handler']");

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

    public void signOut() {
        menuButton.click();
        signOutButton.click();

        try {
            acceptCookiesButton.waitAndClick(30);
        } catch(TimeoutException ignored) {}
    }
}
