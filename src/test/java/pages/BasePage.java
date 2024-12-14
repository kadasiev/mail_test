package pages;

import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void waitForVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfAll(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void switchToFrame(WebElement frame) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public void waitAndClick(WebElement element) {
        waitForVisibilityOf(element);
        element.click();
    }

    public void waitAndSendKeys(WebElement element, String keys) {
        waitForVisibilityOf(element);
        element.sendKeys(keys);
    }

    public String waitAndGetText(WebElement element) {
        waitForVisibilityOf(element);
        return element.getText();
    }
}
