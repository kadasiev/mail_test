package pages;

import static element.Element.xpath;

import element.Element;

public class OutlookLogInPage {

    Element accountNameField = xpath("//input[@data-report-event='Signin_Email_Phone_Skype']");
    Element nextButton = xpath("//input[@data-report-event='Signin_Submit']");
    Element passwordField = xpath("//input[@name='passwd']");
    Element signInButton = xpath("//input[@data-report-event='Signin_Submit']");
    Element doNotStaySignInButton = xpath("//input[@id='idBtn_Back']");

    public OutlookLogInPage enterAccountName(String accountName) {
        accountNameField.sendKeys(accountName);
        return this;
    }

    public OutlookLogInPage submitAccountName() {
        nextButton.click();
        return this;
    }

    public OutlookLogInPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public OutlookLogInPage submitPassword() {
        signInButton.click();
        return this;
    }

    public void clickDoNotStaySignInButton() {
        doNotStaySignInButton.click();
    }
}
