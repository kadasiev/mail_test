package pages;

import static driver.Driver.waitFor;
import static element.Element.xpath;

import driver.Driver;
import element.Element;

public class MailMailboxPage {

    Element menuButton = xpath("//img[@alt='selenium.test124@mail.ru']");
    Element logOutButton = xpath("//*[contains(@class, 'item__social')][4]");
    Element newLetterButton = xpath("//span[@class='compose-button__txt']");
    Element sendToField = xpath("//input[@tabindex='100']");
    Element subjectField = xpath("//input[@name='Subject']");
    Element bodyField = xpath("//div[@tabindex='505']");
    Element sendButton = xpath("//span[@class='vkuiButton__content']");

    public String getTitle() {
        waitFor(15);
        return Driver.getTitle();
    }

    public MailMailboxPage openMenu() {
        menuButton.click();
        return this;
    }

    public void clickLogOut() {
        logOutButton.click();
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

    public void sendLetter() {
        sendButton.click();
    }
}
