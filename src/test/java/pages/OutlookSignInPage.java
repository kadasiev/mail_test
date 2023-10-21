package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OutlookSignInPage extends BasePage{
    @FindBy(xpath = "//input[@data-report-event='Signin_Email_Phone_Skype']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@data-report-event='Signin_Submit']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@data-report-event='Signin_Submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='idBtn_Back']")
    private WebElement doNotStaySignInButton;

    public OutlookSignInPage openPage() {
        driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=16&ct=1696870280&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26RpsCsrfState%3de427b455-e16e-e65b-55eb-6b5f905de2eb&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
        return this;
    }

    public OutlookMailboxPage signIn(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        signInButton.click();

        wait.until(ExpectedConditions.visibilityOf(doNotStaySignInButton));
        doNotStaySignInButton.click();
        return new OutlookMailboxPage();
    }
}
