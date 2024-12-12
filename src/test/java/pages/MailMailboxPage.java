package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class MailMailboxPage extends BasePage {
    @FindBy(xpath = "//img[@alt='selenium.test124@mail.ru']")
    private WebElement menuButton;

    @FindBy(xpath = "//div[@class='ph-text svelte-1popff4']")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement newLetterButton;

    @FindBy(xpath = "//input[@tabindex='100']")
    private WebElement sendToField;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@tabindex='505']")
    private WebElement bodyField;

    @FindBy(xpath = "//span[@class='vkuiButton__content']")
    private WebElement sendButton;

    public String getTitle() {
        wait.until(ExpectedConditions.titleIs("Почта Mail.ru"));
        return driver.getTitle();
    }

    public void signOut() {
        wait.until(ExpectedConditions.visibilityOf(menuButton));
        menuButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(menuItems));
        menuItems.get(3).click();
    }

    public MailMailboxPage sendLetter(String sendTo, String subject, String body) {
        wait.until(ExpectedConditions.visibilityOf(newLetterButton));
        newLetterButton.click();

        wait.until(ExpectedConditions.visibilityOf(sendToField));
        sendToField.sendKeys(sendTo);
        subjectField.sendKeys(subject);
        bodyField.clear();
        bodyField.sendKeys(body);
        sendButton.click();
        return this;
    }

    public MailMailboxPage waitUntilEmailIsSent() {
        try {
            Thread.sleep(30000);
        }
        catch (InterruptedException ignored) {
        }
        return this;
    }
}
