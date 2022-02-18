package seleniumForPraactice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementByXPath {

	
WebDriver driver;
	
	@Before
	public void before() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.fairfaxnissan.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void TestCse() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[8]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[8]/ul/li[1]/ul/li[6]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"cfe782249b9d45e893fbb14914c3576a\"]/dt/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"activeStaff-item\"]/dd[4]")).click();
		Thread.sleep(3000);

		
		
	}
	

}
