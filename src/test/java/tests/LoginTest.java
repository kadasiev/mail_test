package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private static final String USERNAME = "selenium.test124@mail.ru";
  private static final String PASSWORD = "q2r5h7k9#";
  private static final String EXPECTED_TITLE = "Почта Mail.ru";

  @DataProvider(name = "dataForUsernameField")
  public Object[][] dataForUsernameField() {
    return new Object[][]{{"selenium.5748124@mail.ru", "That account is not registered",
        "Sign-in with non-existent username"},
        {"", "The \"Account name\" field is required", "Sign-in with empty username"}};
  }

  @DataProvider(name = "dataForPasswordField")
  public Object[][] dataForPasswordField() {
    return new Object[][]{{"selenium.test124@mail.ru", "cjyfy", "Incorrect password. Try again",
        "Sign-in with wrong password"},
        {"selenium.test124@mail.ru", "", "The \"Password\" field is required",
            "Sign-in with empty password"}};
  }

  @Test()
  public void signInWithValidUsernameAndPassword() {
    loginSteps.mailLogin(USERNAME, PASSWORD);
    String mailboxTitle = loginSteps.getTitle();
    logoutSteps.mailLogout();

    assertEquals(mailboxTitle, EXPECTED_TITLE,
        "Fail to log-in with valid username and password!");
  }

  @Test(dataProvider = "dataForUsernameField")
  public void signInWithWrongUsername(String username, String expectedErrorMessage,
      String assertFailMessage) {
    loginSteps.mailEnterUsername(username);

    assertEquals(loginSteps.getErrorMessageFromWrongUsername(),
        expectedErrorMessage, assertFailMessage);
  }

  @Test(dataProvider = "dataForPasswordField")
  public void signInWithWrongPassword(String username, String password,
      String expectedErrorMessage, String assertFailMessage) {
    loginSteps.mailLogin(username, password);

    assertEquals(loginSteps.getErrorMessageFromWrongPassword(),
        expectedErrorMessage, assertFailMessage);
  }
}
