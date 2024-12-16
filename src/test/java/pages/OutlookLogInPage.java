package pages;

import driver.Driver;
import util.Element;

public class OutlookLogInPage {

    Element accountNameField = Element.byXpath("//input[@data-report-event='Signin_Email_Phone_Skype']");
    Element nextButton = Element.byXpath("//input[@data-report-event='Signin_Submit']");
    Element passwordField = Element.byXpath("//input[@name='passwd']");
    Element signInButton = Element.byXpath("//input[@data-report-event='Signin_Submit']");
    Element doNotStaySignInButton = Element.byXpath("//input[@id='idBtn_Back']");

    public OutlookLogInPage openPage() {
        Driver.navigateTo("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=16&ct=1696870280&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26RpsCsrfState%3de427b455-e16e-e65b-55eb-6b5f905de2eb&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
        return this;
    }

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
