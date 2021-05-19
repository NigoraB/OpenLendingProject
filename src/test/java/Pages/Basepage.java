package Pages;

import DriverPkg.DriverWrapper;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Basepage {

    public WebElement findWebElement(final By locator) {
        Wait fWait = new FluentWait(DriverWrapper.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found after 30seconds of wait");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }

    public void type(By locator, String data) {
        findWebElement(locator).sendKeys(data);
    }

    public void clickThis(By locator) {
        findWebElement(locator).click();
    }

    public void scrollAndClickToWebElement(By locator) {
        for (int i=0 ; i < 11 ; i++) {
            try {
                DriverWrapper.getDriver().findElement(locator).click();
                break;
            } catch (NoSuchElementException e) {
                JavascriptExecutor js = (JavascriptExecutor)DriverWrapper.getDriver();
                js.executeScript("scrollBy(0,200)");
            }
        }
    }

    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

}
