package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OutlookSignInPage extends BasePage{
    @FindBy(xpath = "//input[@id='i0116']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='idSIButton9']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='i0118']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='idSIButton9']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='idBtn_Back']")
    private WebElement doNotStaySignInButton;

    public OutlookSignInPage goTo(String url) {
        driver.get(url);
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
