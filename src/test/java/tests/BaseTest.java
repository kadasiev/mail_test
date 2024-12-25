package tests;

import static driver.DriverFactory.openBrowser;

import driver.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.EmailVerificationSteps;
import steps.LoginSteps;
import steps.LogoutSteps;

public class BaseTest {

    public EmailVerificationSteps emailVerificationSteps = new EmailVerificationSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public LogoutSteps logoutSteps = new LogoutSteps();

    @BeforeClass
    public void setUp() {
        openBrowser();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}
