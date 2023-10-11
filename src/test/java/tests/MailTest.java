package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MailTest extends BaseTest {
    @Test
    public void validUsernameAndPasswordTest() {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#");

        Assert.assertEquals(mailMailboxPage.getTitle(), "Почта Mail.ru");

        mailMailboxPage.signOut();
    }

    @Test
    public void wrongUserNameTest() {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("selenium.5748124@mail.ru");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromWrongUsername(),
                "That account is not registered");
    }

    @Test
    public void emptyUserNameTest() {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromWrongUsername(),
                "The \"Account name\" field is required");
    }

    @Test
    public void wrongPasswordTest() {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("jyfy");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromWrongPassword(),
                "Incorrect password. Try again");
    }

    @Test
    public void emptyPasswordTest() {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("");

        Assert.assertEquals(mailSignInPage.getErrorMessageFromEmptyPassword(),
                "The \"Password\" field is required");
    }

    @Test
    public void emailIsArrivedTest() throws InterruptedException {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#")
                .sendLetter("selenium.test124@outlook.com", "test7"
                        , "Hi!\n\nHow are you?\n\nBest Regards\nDavid")
                .waitForTheEmailToArrive()
                .signOut();

        boolean isArrived = outlookSignInPage.goTo("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=16&ct=1696870280&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26RpsCsrfState%3de427b455-e16e-e65b-55eb-6b5f905de2eb&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c")
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .isEmailArrived("David Kadasiev", "test7");

        outlookMailboxPage.signOut();

        Assert.assertTrue(isArrived);
    }

    @Test
    public void emailUnreadTest() throws InterruptedException {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#")
                .sendLetter("selenium.test124@outlook.com", "test8"
                        , "Hi\n\nHow are you?\n\nBest Regards\nDavid")
                .waitForTheEmailToArrive()
                .signOut();

        boolean isUnread = outlookSignInPage.goTo("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=16&ct=1696870280&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26RpsCsrfState%3de427b455-e16e-e65b-55eb-6b5f905de2eb&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c")
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .isEmailUnread("David Kadasiev", "test8");

        outlookMailboxPage.signOut();

        Assert.assertTrue(isUnread);
    }

    @Test
    public void emailContentTest() throws InterruptedException {
        mailSignInPage.goTo("https://mail.ru/")
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#")
                .sendLetter("selenium.test124@outlook.com", "test9"
                        , "Hi\n\nHow are you?\n\nBest Regards\nDavid")
                .waitForTheEmailToArrive()
                .signOut();

        String emailContent = outlookSignInPage.goTo("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=16&ct=1696870280&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26RpsCsrfState%3de427b455-e16e-e65b-55eb-6b5f905de2eb&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c")
                .signIn("selenium.test124@outlook.com", "q2r5h7k9#")
                .getEmailContent("David Kadasiev", "test9");

        outlookMailboxPage.signOut();

        Assert.assertEquals(emailContent,
                " Hi\n\nHow are you?\n\nBest Regards\nDavid");

    }
}

