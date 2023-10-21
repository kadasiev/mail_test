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

}
