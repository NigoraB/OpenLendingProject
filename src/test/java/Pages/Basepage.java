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

    public List<WebElement> findWebElements(By locator) {
        Wait fWait = new FluentWait(DriverWrapper.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is not found after 30seconds of wait");

        List<WebElement> elements = (List<WebElement>) fWait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
        return elements;
    }

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
        // return DriverWrapper.getDriver().findElement(locator);
    }

    public void type(By locator, String data) {
        findWebElement(locator).sendKeys(data);
    }

    public void clickThis(By locator) {
        findWebElement(locator).click();
    }

    public boolean isElementDisplayed(By locator) {
        return findWebElement(locator).isDisplayed();
    }

    // isSelected

    // isEnabled

    // getText

    // getAttribute

    // getTitle

    // getCurrentUrl

    // method to select any value (using text) in any dropdown
    public void selectUsingText(By locator, String text) { ;
        WebElement dropdownElement = findWebElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(text);
    }

    public void selectUsingValueAttr(By locator, String value) { ;
        WebElement dropdownElement = findWebElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public void selectUsingOptionIndex(By locator, int index) { ;
        WebElement dropdownElement = findWebElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    public String getCurrentWindowHandle() {
        return DriverWrapper.getDriver().getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return DriverWrapper.getDriver().getWindowHandles();
    }

    public void switchToNewWindow(String handle) {
        DriverWrapper.getDriver().switchTo().window(handle);
    }

    public void switchToFrame(String id) {
        DriverWrapper.getDriver().switchTo().frame(id);
    }

    public void switchToFrame(By locator) {
        WebElement frame = findWebElement(locator);
        DriverWrapper.getDriver().switchTo().frame(frame);
    }

    public Alert switchToAlert() {
        return DriverWrapper.getDriver().switchTo().alert();
    }

    public String getAlertText(Alert alert) {
        return alert.getText();
    }

    public void dismissAlert(Alert alert) {
        alert.dismiss();
    }

    public void acceptAlert(Alert alert) {
        alert.accept();
    }

    public void writeOnAlert(Alert alert, String data) {
        alert.sendKeys(data);
    }

    public void mouseHoverOnElement(By locator) {
        WebElement element = findWebElement(locator);
        Actions act = new Actions(DriverWrapper.getDriver());
        act.moveToElement(element);
    }

    public void mouseHoverOnElement(WebElement element) {
        Actions act = new Actions(DriverWrapper.getDriver());
        act.moveToElement(element);
    }

    public void selectFromAutoSuggestion(By locator, String selectThis) {
        List<WebElement> suggestions = findWebElements(locator);
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase(selectThis)) {
                suggestion.click();
                break;
            }
        }
    }

    public void scrollDownByPixel(int y) {
        JavascriptExecutor js = (JavascriptExecutor)DriverWrapper.getDriver();
        js.executeScript("scrollBy(0,"+y+");");
    }

    public void scrollUpByPixel(int y) {
        JavascriptExecutor js = (JavascriptExecutor)DriverWrapper.getDriver();
        js.executeScript("scrollBy(0,-"+y+");");
    }

    public void MoveAroundByPixel(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor)DriverWrapper.getDriver();
        js.executeScript("scrollBy("+x+","+y+");");
    }

    public void scrollUptoElement(By locator) {
        WebElement element = findWebElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)DriverWrapper.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor)DriverWrapper.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }




}
