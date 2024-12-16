package pages;

import driver.Driver;
import util.Element;

public class MailMailboxPage {

    Element menuButton = Element.byXpath("//img[@alt='selenium.test124@mail.ru']");
    Element logOutButton = Element.byXpath("//*[contains(@class, 'item__social')][4]");
    Element newLetterButton = Element.byXpath("//span[@class='compose-button__txt']");
    Element sendToField = Element.byXpath("//input[@tabindex='100']");
    Element subjectField = Element.byXpath("//input[@name='Subject']");
    Element bodyField = Element.byXpath("//div[@tabindex='505']");
    Element sendButton = Element.byXpath("//span[@class='vkuiButton__content']");

    public String getTitle() {
        Driver.waitFor(3);
        return Driver.getTitle();
    }

    public MailMailboxPage openMenu() {
        menuButton.click();
        return this;
    }

    public MailMailboxPage clickLogOut() {
        logOutButton.click();
        return this;
    }

    public MailMailboxPage createLetter() {
        newLetterButton.click();
        return this;
    }

    public MailMailboxPage fillReceiver(String receiver) {
        sendToField.sendKeys(receiver);
        return this;
    }

    public MailMailboxPage fillSubject(String subject) {
        subjectField.sendKeys(subject);
        return this;
    }

    public MailMailboxPage clearMailBody() {
        bodyField.clear();
        return this;
    }

    public MailMailboxPage fillMailBody(String body) {
        bodyField.sendKeys(body);
        return this;
    }

    public MailMailboxPage sendLetter() {
        sendButton.click();
        return this;
    }
}
