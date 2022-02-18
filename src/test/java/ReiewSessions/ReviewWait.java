package ReiewSessions;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver; //instance
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReviewWait {

  //instance  value=0
	WebDriver driver; //declared class level
	WebDriverWait wait; 
	
	 
	@Before                                          
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
	//	myName = "Risa";
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicitWait
	}
	
	@Test
	public void test1() {
		
		driver.findElement(By.name("q")).sendKeys("Techcircle School", Keys.ENTER);
		
		
		wait = new WebDriverWait(driver, 30); 
		
		WebElement resultText = driver.findElement(By.id("result-stats"));
		
		wait.until(ExpectedConditions.visibilityOf(resultText));
		
		System.out.println(resultText.getText());     //explicitWait
		
		
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
