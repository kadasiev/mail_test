package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MailMailboxPage;
import pages.MailSignInPage;

public class LoginTest extends BaseTest {

  @DataProvider(name = "dataForUsernameField")
  public Object[][] dataForUsernameField() {
    return new Object[][]{{"selenium.5748124@mail.ru", "That account is not registered", "Sign-in with non-existent username"},
        {"", "The \"Account name\" field is required", "Sign-in with empty username"}};
  }

  @DataProvider(name = "dataForPasswordField")
  public Object[][] dataForPasswordField() {
    return new Object[][]{{"selenium.test124@mail.ru", "jyfy", "Incorrect password. Try again", "Sign-in with wrong password"},
        {"selenium.test124@mail.ru", "", "The \"Password\" field is required", "Sign-in with empty password"}};
  }

  @Test()
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

  @Test(dataProvider = "dataForUsernameField")
  public void signInWithWrongUsername(String username, String expectedErrorMessage,
      String assertFailMessage) {
    new MailSignInPage().openPage()
        .openSignInWindow()
        .enterUsername(username);

    Assert.assertEquals(new MailSignInPage().getErrorMessageFromWrongUsername(),
        expectedErrorMessage, assertFailMessage);
  }

  @Test(dataProvider = "dataForPasswordField")
  public void signInWithWrongPassword(String username, String password,
      String expectedErrorMessage, String assertFailMessage) {
    new MailSignInPage().openPage()
        .openSignInWindow()
        .enterUsername(username)
        .enterPassword(password);

    Assert.assertEquals(new MailSignInPage().getErrorMessageFromWrongPassword(),
        expectedErrorMessage, assertFailMessage);
  }
}
