package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MailSignInPage extends BasePage {
    @FindBy(xpath = "//button[@data-testid='enter-mail-primary']")
    private WebElement openSignInFormButton;

    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement signInIframe;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//div/button[@data-test-id='next-button']")
    private WebElement enterPasswordButton;

    @FindBy(xpath = "//div/input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button/span[@class='inner-0-2-81 innerTextWrapper-0-2-82']")
    private WebElement signInButton;

    @FindBy(xpath = "//small[@class='base-0-2-25 small-0-2-34 error-0-2-40']")
    private WebElement errorMessageFromWrongUsername;

    @FindBy(xpath = "//div[@data-test-id='password-input-error']")
    private WebElement errorMessageFromWrongPassword;

    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private List<WebElement> dynamicElement;

    public MailSignInPage openPage() {
        driver.get("https://mail.ru/");
        return this;
    }

    public MailSignInPage openSignInWindow() {
        waitForVisibilityOf(openSignInFormButton);
        openSignInFormButton.click();
        return this;
    }

    public MailSignInPage enterUsername(String name) {
        switchToFrame(signInIframe);
        switchToFrame(usernameField);
        usernameField.sendKeys(name);
        enterPasswordButton.click();
        driver.switchTo().defaultContent();
        return this;
    }

    public void enterPassword(String password) {
        switchToFrame(signInIframe);
        waitAndSendKeys(passwordField, password);
        signInButton.click();
        driver.switchTo().defaultContent();
    }

    public String getErrorMessageFromWrongUsername() {
        switchToFrame(signInIframe);
        String errorMessage = waitAndGetText(errorMessageFromWrongUsername);
        driver.switchTo().defaultContent();
        return errorMessage;
    }

    public String getErrorMessageFromWrongPassword() {
        if(isIframeExist()) {
            switchToFrame(signInIframe);
        }
        String errorMessage = waitAndGetText(errorMessageFromWrongPassword);
        driver.switchTo().defaultContent();
        return errorMessage;
    }

    public boolean isIframeExist() {
        return !dynamicElement.isEmpty();
    }
}

