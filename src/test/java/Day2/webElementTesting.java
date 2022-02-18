package Day2;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webElementTesting {

	WebDriver driver;
	

	@Before
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Index.html");

	}

	@Test
	public void inputEmailAddress() {
		
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("enterimg")).click();
		
		
		//continue the rest of the form
		
		//firstname
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Erdni");
		//lastname
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Burulov");
		//address
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("1944 Kennedy Drive, McLean, VA 22102, Apt.T4");
		//email
		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("burulov1985@gmail.com");
		//phone
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("571-527-9666");
		//Gender
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();
		//Hobbies
		driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();

    
		
	
       
		
	}

}
