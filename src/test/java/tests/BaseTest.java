package tests;

import driver.DriverFactory;
import org.testng.annotations.AfterClass;
import steps.EmailVerificationSteps;
import steps.LoginSteps;
import steps.LogoutSteps;
import steps.NavigationSteps;

public class BaseTest {

    public EmailVerificationSteps emailVerificationSteps = new EmailVerificationSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public LogoutSteps logoutSteps = new LogoutSteps();
    public NavigationSteps navigationSteps = new NavigationSteps();

    @AfterClass
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}
