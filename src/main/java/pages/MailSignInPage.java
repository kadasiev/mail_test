package pages;

import static driver.Driver.switchToDefaultContent;
import static element.Element.xpath;

import element.Element;

public class MailSignInPage {

    private Element openSignInFormButton = xpath("//*[contains(@class, 'btn_primary')]");
    private Element signInIframe = xpath("//*[contains(@class, 'layout__iframe')]");
    private Element accountNameField = xpath("//input[@name='username']");
    private Element enterPasswordButton = xpath("//div[contains(@class, 'submit')]/button");
    private Element tryAnotherWayToLogInButton = xpath("//*[contains(@data-test-id, 'restore-type-btn')]");
    private Element passwordField = xpath("//div/input[@name='password']");
    private Element signInButton = xpath("//button/span[@class='inner-0-2-81 innerTextWrapper-0-2-82']");
    private Element errorMessageFromWrongUsername = xpath("//small[@class='base-0-2-25 small-0-2-34 error-0-2-40']");
    private Element errorMessageFromWrongPassword = xpath("//div[@data-test-id='password-input-error']");

    public MailSignInPage openSignInWindow() {
        openSignInFormButton.click();
        return this;
    }

    public MailSignInPage enterAccountName(String name) {
        signInIframe.switchToFrame();
        accountNameField.sendKeys(name);
        enterPasswordButton.click();
        switchToDefaultContent();
        return this;
    }

    public MailSignInPage chooseAnotherWayToLogIn() {
        signInIframe.switchToFrame();
        tryAnotherWayToLogInButton.click();
        switchToDefaultContent();
        return this;
    }

    public void enterPassword(String password) {
        signInIframe.switchToFrame();
        passwordField.sendKeys(password);
        signInButton.click();
        switchToDefaultContent();
    }

    public String getErrorMessageFromWrongUsername() {
        signInIframe.switchToFrame();
        String errorMessage = errorMessageFromWrongUsername.getText();
        switchToDefaultContent();
        return errorMessage;
    }

    public String getErrorMessageFromWrongPassword() {
        if(signInIframe.isPresent()) {
            signInIframe.switchToFrame();
        }
        String errorMessage = errorMessageFromWrongPassword.getText();
        switchToDefaultContent();
        return errorMessage;
    }
}
