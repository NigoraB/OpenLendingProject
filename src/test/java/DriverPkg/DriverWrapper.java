package DriverPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverWrapper {

    private static WebDriver driver;
 

    @Parameters({"url", "browserName"})
    @BeforeMethod
    public void initDriver(String appUrl, @Optional("chrome") String client) {
        System.out.println("Client name: " + client);
        switch (client.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./driverExec/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./driverExec/geckodriver");
                driver = new FirefoxDriver();
                break;
          
            default:
                new Exception("invalid browser name: " + client);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
        driver.get("https://www.google.com/");

    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
