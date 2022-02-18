package Day4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownTest {

	WebDriver driver; 
	
		
		@Before
		public void beforeMethod() {  

			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver(); 
			driver.get("https://the-internet.herokuapp.com/dropdown");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
		}
		
		@Ignore
		@Test
		public void staticDropDown() throws InterruptedException {
			
			WebElement staticDropDown = driver.findElement(By.id("dropdown"));
			
			Select select = new Select(staticDropDown);
			
			Thread.sleep(2000);
			
			select.selectByIndex(1);   //option1
			Thread.sleep(3000);
			select.selectByValue("2");  //option2
			Thread.sleep(3000); 
			select.selectByVisibleText("Option 1");//option1
			
		}
		
		
		@Test
		public void dynamicDropdown() {
			driver.get("https://www.makemytrip.com/");
			driver.findElement(By.xpath("//html")).click();
			driver.findElement(By.id("fromCity")).click();
			
		}
		
		
		
		
		
		
		
		
		
		
		 
		
		
		
		
		
	
}
