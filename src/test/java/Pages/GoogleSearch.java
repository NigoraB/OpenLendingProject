package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	static WebDriverWait w;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

     WebDriver driver = new ChromeDriver(); // launch chrome
    

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.get("http://www.google.com");
	
		
		 WebElement search=driver.findElement(By.xpath("//*[@name='q']"));
		 search.sendKeys("Open Lending");
		  w= new WebDriverWait(driver, 5);
	      w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
	      search.submit();
	     String currentUrl=driver.getCurrentUrl(); 
	     System.out.println(currentUrl);
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      
	      //Find element by link text and store in variable "Element"   
	      
	        WebElement Element = driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md' and text()='Open Lending | LinkedIn']"));
	        w.until(ExpectedConditions.elementToBeClickable(Element));
	        System.out.println(Element.getText());
	        System.out.println(Element.isDisplayed());
       
	        
//	        Actions actions = new Actions(driver);
//	       actions.moveToElement(Element).click();
	        
		 	
	     
	       js.executeScript("arguments[0].scrollIntoView(true);", Element);
		}
	}	
