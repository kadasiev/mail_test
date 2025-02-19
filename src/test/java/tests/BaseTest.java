package tests;

import static driver.DriverFactory.closeBrowser;
import static driver.DriverFactory.openBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.EmailVerificationSteps;
import steps.LoginSteps;
import steps.LogoutSteps;

public class BaseTest {

    public EmailVerificationSteps emailVerificationSteps = new EmailVerificationSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public LogoutSteps logoutSteps = new LogoutSteps();

    @BeforeMethod(groups = {"regression", "run"})
    public void setUp() {
        openBrowser();
    }

    @AfterMethod(groups = {"regression", "run"})
    public void tearDown() {
        closeBrowser();
    }
}
