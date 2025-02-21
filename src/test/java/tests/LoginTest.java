package tests;

import static driver.Driver.openPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static util.TestDataReader.getTestData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  private static final String EXPECTED_TITLE = "Входящие - Почта Mail";

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

  @Test(groups = {"regression", "run"})
  public void signInWithValidUsernameAndPassword() {
    openPage(getTestData("mailBasePage"));
    loginSteps.mailLogin();
    String mailboxTitle = loginSteps.getTitle();
    logoutSteps.mailLogOut();

    assertTrue(mailboxTitle.contains(EXPECTED_TITLE),
        "Fail to log-in with valid username and password!");
  }

  @Test(dataProvider = "dataForUsernameField", groups = {"regression"})
  public void signInWithWrongUsername(String username, String expectedErrorMessage,
      String assertFailMessage) {
    openPage(getTestData("mailBasePage"));
    loginSteps.mailEnterAccountName(username);

    assertEquals(loginSteps.getErrorMessageFromWrongUsername(),
        expectedErrorMessage, assertFailMessage);
  }

  @Test(dataProvider = "dataForPasswordField", groups = {"regression"})
  public void signInWithWrongPassword(String username, String password,
      String expectedErrorMessage, String assertFailMessage) {
    openPage(getTestData("mailBasePage"));
    loginSteps.mailLogin();

    assertEquals(loginSteps.getErrorMessageFromWrongPassword(),
        expectedErrorMessage, assertFailMessage);
  }
}
