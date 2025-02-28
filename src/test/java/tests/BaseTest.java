package tests;

import static driver.DriverFactory.closeBrowser;
import static driver.DriverFactory.openBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.EmailVerificationSteps;
import steps.LettersManagementSteps;
import steps.LoginSteps;
import steps.LogoutSteps;
import steps.NavigationSteps;

public class BaseTest {

    protected EmailVerificationSteps emailVerificationSteps = new EmailVerificationSteps();
    protected LoginSteps loginSteps = new LoginSteps();
    protected LogoutSteps logoutSteps = new LogoutSteps();
    protected NavigationSteps navigationSteps = new NavigationSteps();
    protected LettersManagementSteps lettersManagementSteps = new LettersManagementSteps();

    @BeforeMethod(groups = {"regression", "run"})
    public void setUp() {
        openBrowser();
    }

    @AfterMethod(groups = {"regression", "run"})
    public void tearDown() {
        closeBrowser();
    }
}
