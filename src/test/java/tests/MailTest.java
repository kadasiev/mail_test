package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MailTest extends BaseTest {
    @Test
    public void validUsernameAndPasswordTest() {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#");

        Assert.assertEquals(mailMailboxPage.getTitle(), "Почта Mail.ru");

        mailMailboxPage.signOut();
    }

    @Test
    public void wrongUserNameTest() {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("selenium.5748124@mail.ru");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromWrongUsername(),
                "That account is not registered");
    }

    @Test
    public void emptyUserNameTest() {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromWrongUsername(),
                "The \"Account name\" field is required");
    }

    @Test
    public void wrongPasswordTest() {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("jyfy");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromWrongPassword(),
                "Incorrect password. Try again");
    }

    @Test
    public void emptyPasswordTest() {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromEmptyPassword(),
                "The \"Password\" field is required");
    }

    @Test
    public void emailIsArrivedTest() throws InterruptedException {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#")
                .sendLetter("selenium.test124@outlook.com", "test7"
                        , "Hi!\n\nHow are you?\n\nBest Regards\nDavid")
                .waitUntilEmailIsSent()
                .signOut();

        boolean isArrived = outlookSignInPage.openPage()
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .isEmailArrived("David Kadasiev", "test7");
        outlookMailboxPage.signOut();

        Assert.assertTrue(isArrived);
    }

    @Test
    public void emailUnreadTest() throws InterruptedException {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#")
                .sendLetter("selenium.test124@outlook.com", "test8"
                        , "Hi\n\nHow are you?\n\nBest Regards\nDavid")
                .waitUntilEmailIsSent()
                .signOut();

        boolean isUnread = outlookSignInPage.openPage()
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .isEmailUnread("David Kadasiev", "test8");
        outlookMailboxPage.signOut();

        Assert.assertTrue(isUnread);
    }

    @Test
    public void emailContentTest() throws InterruptedException {
        mailSignInPage.openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#")
                .sendLetter("selenium.test124@outlook.com", "test9"
                        , "Hi\n\nHow are you?\n\nBest Regards\nDavid")
                .waitUntilEmailIsSent()
                .signOut();

        String emailContent = outlookSignInPage.openPage()
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .getEmailContent("David Kadasiev", "test9");
        outlookMailboxPage.signOut();

        Assert.assertEquals(emailContent,
                " Hi\n\nHow are you?\n\nBest Regards\nDavid");

    }
}

