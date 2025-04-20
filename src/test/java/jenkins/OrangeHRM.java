package jenkins;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrangeHRM {
	private WebDriver driver;
	@Test(priority=1)
	public void initializeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments(
		    "--headless",               // run headless
		    "--no-sandbox",             // required on many CI systems
		    "--disable-dev-shm-usage",  // avoid limited or full shared memory issues
		    "--disable-gpu",            // applicable if GPU is unavailable
		    "--window-size=1920,1080"   // often needed to render elements correctly
		);

		//options.addArguments("headless");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver= new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test(priority=2)
	public void enterUsernamePassword() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
