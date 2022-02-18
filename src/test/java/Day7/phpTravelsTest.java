package Day7;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class phpTravelsTest {

	WebDriver driver;
	private String url = "https://phptravels.com/demo";

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws InterruptedException {

		String email = "agent@phptravels.com";
		String password = "demoagent";

		// open front page
		driver.findElement(
				By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a/small"))
				.click();

		System.out.println("Before switching - title is " + driver.getTitle());

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();

		String parentID = id.next();
		String childID = id.next();

		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);

		// switch my selenium to new window
		driver.switchTo().window(childID);
		System.out.println("After switching, child window title is " + driver.getTitle());

		// Enter email
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input"))
				.sendKeys(email);

		// Enter password
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input"))
				.sendKeys(password);

		// Login
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button/span[1]"))
				.click();

		// Add Funds
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[3]/a")).click();

		// Pay with Bank Transfer
		driver.findElement(By.xpath("//*[@id=\"myTab\"]/div[1]/div/label/div/img")).click();

		// Pay Now
		driver.findElement(By.xpath(
				"//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button"))
				.click();

		// Verify
		String actualResult = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/small/strong")).getText();
		String expectedResult = "Bank Transfer USD 50.00";
		System.out.println(actualResult);
		Assert.assertEquals(expectedResult, actualResult);
		 //back to invoice
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]")).click();
        
        //click yes
        driver.findElement(By.xpath("//div[@class='btn is-open']/div/a")).click();
        Thread.sleep(3000);
        
        //click logout button
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[5]/a")).click();
        //driver.switchTo().window(parentID);
        Thread.sleep(3000);

	}

}