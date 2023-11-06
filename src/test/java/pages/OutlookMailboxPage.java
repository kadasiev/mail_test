package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OutlookMailboxPage extends BasePage {
    @FindBy(xpath = "//div[@class='hcptT gDC9O']")
    private List<WebElement> letters;

    @FindBy(xpath = "//div[@id='UniqueMessageBody']/div/div/div")
    private WebElement letterContent;

    @FindBy(xpath = "//img[@alt='DK']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@id='mectrl_body_signOut']")
    private WebElement signOutButton;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookiesButton;

    public boolean isEmailArrived(String sender, String subject) {
        wait.until(ExpectedConditions.visibilityOfAllElements(letters));
        boolean isArrived = false;

       for(WebElement letter : letters){
            if(letter.getAttribute("aria-label").contains(sender + " " + subject)) {
                isArrived = true;
                break;
            }
        }
        return isArrived;
    }

    public boolean isEmailUnread(String sender, String subject) {
        wait.until(ExpectedConditions.visibilityOfAllElements(letters));
        boolean isArrived = false;

        for(WebElement letter : letters) {
            if(letter.getAttribute("aria-label").contains("Unread")
                && letter.getAttribute("aria-label").contains(sender + " " + subject)) {
                isArrived = true;
                break;
            }
        }
        return isArrived;
    }

    public String getEmailContent(String sender, String subject) {
        wait.until(ExpectedConditions.visibilityOfAllElements(letters));

        for(WebElement letter : letters) {
            if(letter.getAttribute("aria-label").contains(sender + " " + subject)) {
                letter.click();
                wait.until(ExpectedConditions.visibilityOf(letterContent));
                return letterContent.getText().trim();
            }
        }
        return "The letter doesn't exist";
    }

    public void signOut() {
        wait.until(ExpectedConditions.visibilityOf(menuButton));
        menuButton.click();
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        signOutButton.click();

        try {
            WebDriverWait waitForCookies = new WebDriverWait(driver, Duration.ofSeconds(30));
            waitForCookies.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
            acceptCookiesButton.click();
        } catch(TimeoutException ignored) {
        }
    }
}


