package pages;

import static element.Element.xpath;

import element.Element;

public class OutlookLogInPage {

    private Element accountNameField = xpath("//input[@aria-describedby='usernameTitle']");
    private Element submitButton = xpath("//button[@type = 'submit']");
    private Element passwordField = xpath("//input[@name='passwd']");
    private Element doNotStaySignInButton = xpath("//*[@id = 'declineButton']");

    public void enterAccountName(String accountName) {
        accountNameField.sendKeys(accountName);
        submitButton.click();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public void clickDoNotStaySignInButton() {
        doNotStaySignInButton.click();
    }

    public boolean isDoNotStaySignInButtonDisplayed() {
        return doNotStaySignInButton.isDisplayed();
    }
}
