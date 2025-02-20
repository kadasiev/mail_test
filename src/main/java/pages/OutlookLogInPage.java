package pages;

import static element.Element.xpath;

import element.Element;

public class OutlookLogInPage {

    Element accountNameField = xpath("//input[@aria-describedby='usernameTitle']");
    Element submitButton = xpath("//button[@type = 'submit']");
    Element passwordField = xpath("//input[@name='passwd']");
    Element doNotStaySignInButton = xpath("//input[@id='idBtn_Back']");

    public OutlookLogInPage enterAccountName(String accountName) {
        accountNameField.sendKeys(accountName);
        return this;
    }

    public OutlookLogInPage submitAccountName() {
        submitButton.click();
        return this;
    }

    public OutlookLogInPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public OutlookLogInPage submitPassword() {
        submitButton.click();
        return this;
    }

    public void clickDoNotStaySignInButton() {
        doNotStaySignInButton.click();
    }
}
