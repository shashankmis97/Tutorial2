package jenkins;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrangeHRM {
	private WebDriver driver;

	@Test(priority = 1)
	public void initializeBrowser() {
		// Set the path for ChromeDriver (ensure it's correctly set)
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		// Set Chrome options
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/usr/bin/google-chrome"); // Use the correct binary path for Chrome
		options.addArguments(
				"--headless=new",
				"--no-sandbox", // Disable sandbox (needed in some environments)
				"--disable-dev-shm-usage", // Prevent errors related to shared memory
				"--disable-gpu", // Disable GPU hardware acceleration
				"--window-size=1920,1080", // Set window size (important for headless mode)
				"--remote-debugging-port=9222" // Enable remote debugging for troubleshooting
		);

		// Initialize ChromeDriver with options
		driver = new ChromeDriver(options);

		// Open the OrangeHRM login page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 2)
	public void enterUsernamePassword() throws InterruptedException {
		// Simulate user interaction with the login page
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
