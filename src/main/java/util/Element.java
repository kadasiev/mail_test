package util;

import driver.DriverFactory;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {

  private final By by;
  public static final int TIMEOUT = 20;

  private Element(By by) {
    this.by = by;
  }

  public static Element byXpath(String xpath) {
    return new Element(By.xpath(xpath));
  }

  public WebElement waitForVisibility() {
    return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public WebElement waitForVisibilityFor(long seconds) {
    return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public List<WebElement> waitForVisibilityOfAll() {
    return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
  }

  public void switchToFrame() {
    new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(DriverFactory.getDriver().findElement(by)));
  }

  public void click() {
    waitForVisibility().click();
  }

  public void waitAndClick(long seconds) {
    waitForVisibilityFor(seconds).click();
  }

  public void sendKeys(String keys) {
    waitForVisibility().sendKeys(keys);
  }

  public void clear() {
    waitForVisibility().clear();
  }

  public String getText() {
    return waitForVisibility().getText();
  }

  public WebElement get(int index) {
    return waitForVisibilityOfAll().get(index);
  }

  public List<WebElement> getList() {
    return waitForVisibilityOfAll();
  }

  public boolean isPresent() {
    return !waitForVisibilityOfAll().isEmpty();
  }
}