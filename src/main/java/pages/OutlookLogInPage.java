package pages;

import static driver.Driver.refreshPage;
import static driver.Driver.waitFor;
import static element.Element.xpath;

import element.Element;

public class OutlookLogInPage {

    private Element accountNameField = xpath("//input[@aria-describedby='usernameTitle']");
    private Element submitButton = xpath("//button[@type = 'submit']");
    private Element passwordField = xpath("//input[@name='passwd']");

    public OutlookLogInPage enterAccountName(String accountName) {
        accountNameField.sendKeys(accountName);
        submitButton.click();
        return this;
    }

    public OutlookLogInPage submitAccountName() {
        submitButton.click();
        return this;
    }

    public OutlookLogInPage enterPassword(String password) {
        for (int i = 0; i < 2; i++) {
            passwordField.sendKeys(password);
            submitButton.click();
            //Wait until password filed disappears
            waitFor(2);
            if (!passwordField.isDisplayed()) {
                break;
            }
        }
        return this;
    }

    public OutlookLogInPage submitPassword() {
        submitButton.click();
        return this;
    }

    public void clickDoNotStaySignInButton() {
        for (int i = 0; i < 10; i++) {
            if (submitButton.isDisplayed()) {
               break;
            }
            refreshPage();
            waitFor(3);
        }
        submitButton.click();
    }
}
