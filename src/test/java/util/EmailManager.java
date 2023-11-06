package util;

import pages.MailSignInPage;

public class EmailManager {
    public static void sendLetter(String receiver, String subject, String letter) throws InterruptedException {
        new MailSignInPage().openPage()
                .openSignInWindow()
                .enterUsername("selenium.test124@mail.ru")
                .enterPassword("q2r5h7k9#")
                .sendLetter(receiver, subject, letter)
                .waitUntilEmailIsSent()
                .signOut();
    }
}
