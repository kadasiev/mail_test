package pages;

import driver.Driver;
import util.Element;

public class MailSignInPage {

    Element openSignInFormButton = Element.byXpath("//*[contains(@class, 'btn_primary')]");
    Element signInIframe = Element.byXpath("//*[contains(@class, 'layout__iframe')]");
    Element accountNameField = Element.byXpath("//input[@name='username']");
    Element enterPasswordButton = Element.byXpath("//div/button[@data-test-id='next-button']");
    Element tryAnotherWayToLogOnButton = Element.byXpath("//*[contains(@data-test-id, 'restore-type-btn')]");
    Element passwordField = Element.byXpath("//div/input[@name='password']");
    Element signInButton = Element.byXpath("//button/span[@class='inner-0-2-81 innerTextWrapper-0-2-82']");
    Element errorMessageFromWrongUsername = Element.byXpath("//small[@class='base-0-2-25 small-0-2-34 error-0-2-40']");
    Element errorMessageFromWrongPassword = Element.byXpath("//div[@data-test-id='password-input-error']");

    public MailSignInPage openSignInWindow() {
        openSignInFormButton.click();
        return this;
    }

    public MailSignInPage enterUsername(String name) {
        signInIframe.switchToFrame();
        accountNameField.sendKeys(name);
        enterPasswordButton.click();
        Driver.switchToDefaultContent();
        return this;
    }

    public MailSignInPage chooseAnotherWayToLogIn() {
        signInIframe.switchToFrame();
        tryAnotherWayToLogOnButton.click();
        Driver.switchToDefaultContent();
        return this;
    }

    public void enterPassword(String password) {
        signInIframe.switchToFrame();
        passwordField.sendKeys(password);
        signInButton.click();
        Driver.switchToDefaultContent();
    }

    public String getErrorMessageFromWrongUsername() {
        signInIframe.switchToFrame();
        String errorMessage = errorMessageFromWrongUsername.getText();
        Driver.switchToDefaultContent();
        return errorMessage;
    }

    public String getErrorMessageFromWrongPassword() {
        if(signInIframe.isPresent()) {
            signInIframe.switchToFrame();
        }
        String errorMessage = errorMessageFromWrongPassword.getText();
        Driver.switchToDefaultContent();
        return errorMessage;
    }
}
