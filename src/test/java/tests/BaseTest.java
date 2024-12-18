package tests;

import driver.DriverFactory;
import org.testng.annotations.AfterClass;
import steps.EmailVerificationSteps;
import steps.LoginSteps;
import steps.LogoutSteps;

public class BaseTest {

    public EmailVerificationSteps emailVerificationSteps = new EmailVerificationSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public LogoutSteps logoutSteps = new LogoutSteps();

    @AfterClass
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}
