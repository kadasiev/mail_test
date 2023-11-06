package tests;

import driver.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

public class BaseTest {
    @AfterClass
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }

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

}
