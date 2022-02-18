package seleniumForPraactice;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsPractice {
	//Locators: Id, Class Name, Tag Name, Name, Link Text, Partial Link Text, XPath, CSS
	WebDriver driver;
	
	@Before
	public void before() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://google.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void TestCse() throws InterruptedException {
		WebElement btn1 = driver.findElement(By.id("gbqfbb"));
		String actualText = btn1.getAttribute("value");
		String expectedText = "I'm Feeling Lucky";
		if(actualText.equals(expectedText)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
			System.out.println("Expected text: "+expectedText);
			System.out.println("Actual text: "+actualText);
		}
		Thread.sleep(5000);
		driver.close();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
