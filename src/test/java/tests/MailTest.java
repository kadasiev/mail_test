package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MailMailboxPage;
import pages.MailSignInPage;
import pages.OutlookMailboxPage;
import pages.OutlookSignInPage;
import util.EmailManager;

public class MailTest extends BaseTest {
    @Test(description = "Validate that sign-in with a real username and password succeeds")
    public void signInWithValidUsernameAndPassword() {
        new MailSignInPage().openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#");

        MailMailboxPage mailMailboxPage = new MailMailboxPage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(mailMailboxPage.getTitle(), "Почта Mail.ru",
                "Sign-in with valid username and password");
        mailMailboxPage.signOut();
        softAssert.assertAll();
    }

    @Test(dataProvider = "dataForUsernameField",
            description = "Validate that the user can't sign in with an unknown and empty username")
    public void signInWithWrongUsername(String username, String expectedErrorMessage,
                                      String assertFailMessage) {
        new MailSignInPage().openPage()
                .openSignInWindow()
                .enterUsername(username);

        Assert.assertEquals(new MailSignInPage().getErrorMessageFromWrongUsername(),
                expectedErrorMessage, assertFailMessage);
    }

    @Test(dataProvider = "dataForPasswordField",
            description = "Validate that the user can't sign in with wrong or empty password")
    public void signInWithWrongPassword(String username, String password,
                                        String expectedErrorMessage, String assertFailMessage) {
        new MailSignInPage().openPage()
                .openSignInWindow()
                .enterUsername(username)
                .enterPassword(password);

        Assert.assertEquals(new MailSignInPage().getErrorMessageFromWrongPassword(),
                expectedErrorMessage, assertFailMessage);
    }

    @Test(description = "Validate that the sent email arrived at the target mailbox")
    public void validateEmailIsArrived() throws InterruptedException {
        EmailManager.sendLetter("selenium.test124@outlook.com", "test7",
                "Hi!\n\nHow are you?\n\nBest Regards\nDavid");

        boolean isArrived = new OutlookSignInPage().openPage()
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .isEmailArrived("David Kadasiev", "test7");
        new OutlookMailboxPage().signOut();

        Assert.assertTrue(isArrived, "Validation that email is arrived");
    }

    @Test(description = "Validate that the new email is unread")
    public void validateEmailUnread() throws InterruptedException {
        EmailManager.sendLetter("selenium.test124@outlook.com", "test8",
                "Hi\n\nHow are you?\n\nBest Regards\nDavid");

        boolean isUnread = new OutlookSignInPage().openPage()
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .isEmailUnread("David Kadasiev", "test8");
        new OutlookMailboxPage().signOut();

        Assert.assertTrue(isUnread, "Validation that the new email is unread");
    }

    @Test(description = "Validate that the email content is correct")
    public void validateEmailContent() throws InterruptedException {
        EmailManager.sendLetter("selenium.test124@outlook.com", "test9",
                "Hi\n\nHow are you?\n\nBest Regards\nDavid");

        String emailContent = new OutlookSignInPage().openPage()
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .getEmailContent("David Kadasiev", "test9");
        new OutlookMailboxPage().signOut();

        Assert.assertEquals(emailContent,
                "Hi\n\nHow are you?\n\nBest Regards\nDavid", "Validation of the email content");

    }
}

