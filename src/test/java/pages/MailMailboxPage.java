package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class MailMailboxPage extends BasePage {
    @FindBy(xpath = "//img[@class='ph-avatar-img svelte-dfhuqc']")
    private WebElement menuButton;

    @FindBy(xpath = "//div[@class='ph-text svelte-1popff4']")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement newLetterButton;

    @FindBy(xpath = "//input[@tabindex='100']")
    private WebElement sendToField;

    @FindBy(xpath = "//input[@tabindex='400']")
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
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ph-text svelte-1popff4']")));
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

    public MailMailboxPage waitForTheEmailToArrive() throws InterruptedException {
        Thread.sleep(30000);
        return this;
    }
}
