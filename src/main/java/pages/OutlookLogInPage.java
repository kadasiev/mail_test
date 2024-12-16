package pages;

import util.Element;

public class OutlookLogInPage {

    Element accountNameField = Element.byXpath("//input[@data-report-event='Signin_Email_Phone_Skype']");
    Element nextButton = Element.byXpath("//input[@data-report-event='Signin_Submit']");
    Element passwordField = Element.byXpath("//input[@name='passwd']");
    Element signInButton = Element.byXpath("//input[@data-report-event='Signin_Submit']");
    Element doNotStaySignInButton = Element.byXpath("//input[@id='idBtn_Back']");

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

    public OutlookLogInPage clickDoNotStaySignInButton() {
        doNotStaySignInButton.click();
        return this;
    }
}
