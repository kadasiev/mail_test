package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MailSignInPage;
import pages.MailMailboxPage;
import pages.OutlookSignInPage;
import pages.OutlookMailboxPage;

public class BaseTest {
    private static WebDriver driver;
    protected MailSignInPage mailSignInPage;
    protected MailMailboxPage mailMailboxPage;
    protected OutlookSignInPage outlookSignInPage;
    protected OutlookMailboxPage outlookMailboxPage;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        mailSignInPage = new MailSignInPage();
        mailMailboxPage = new MailMailboxPage();
        outlookSignInPage = new OutlookSignInPage();
        outlookMailboxPage = new OutlookMailboxPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
