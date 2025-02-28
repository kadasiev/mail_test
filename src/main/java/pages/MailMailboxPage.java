package pages;

import static driver.Driver.waitFor;
import static element.Element.xpath;

import driver.Driver;
import element.Element;
import model.Letter;

public class MailMailboxPage {

    static final String FOLDER_PATTERN = "//div[@id = 'sideBarContent']//*[contains(text(), '%s')]";
    static final String LETTERS_LIST = "//*[contains(@class, 'new-selection') and contains(@class, 'letter-list-item')]";
    static final String CHECKBOX = "//label[contains(@class, 'checkbox')]";
    static final String LETTER_BY_SUBJECT_PATTERN = "//*[contains(@class, 'sj__normal') and text() = '%s']//ancestor::*[contains(@class, 'letter-list-item')]";
    static final String LETTERS_TOP_MENU = "//*[@class = 'new-menu']";

    Element menuButton = xpath("//img[@alt='selenium.test124@mail.ru']");
    Element logOutButton = xpath("//*[contains(@class, 'item__social')][4]");
    Element newLetterButton = xpath("//span[@class='compose-button__txt']");
    Element sendToField = xpath("//input[@tabindex='100']");
    Element subjectField = xpath("//input[@name='Subject']");
    Element bodyField = xpath("//div[@tabindex='505']");
    Element sendButton = xpath("//span[@class='vkuiButton__content']");
    Element emailIsSentNotificationsCloseButton = xpath("//span[contains(@class, 'button2_close')]/span[2]");
    //Letters top menu buttons
    Element deleteButton = xpath(LETTERS_TOP_MENU + "//*[text() = 'Удалить']");

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

    public MailMailboxPage sendLetter() {
        sendButton.click();
        return this;
    }

    public void closeEmailIsSentNotification() {
        emailIsSentNotificationsCloseButton.click();
    }

    public void openFolder(String folderName) {
        xpath(String.format(FOLDER_PATTERN, folderName)).click();
    }

    public void openLetter(Letter letter) {
        xpath(String.format(LETTER_BY_SUBJECT_PATTERN, letter.subject())).click();
    }

    public MailMailboxPage selectLetter(Letter letter) {
        xpath(String.format(LETTER_BY_SUBJECT_PATTERN, letter.subject())).hoverOver();
        xpath(String.format(LETTER_BY_SUBJECT_PATTERN, letter.subject()) + CHECKBOX).click();
        return this;
    }

    public void deleteLetter() {
        deleteButton.click();
    }
}
