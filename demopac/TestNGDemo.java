package demopac;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	public static WebDriver driver;
	
	@Test(priority = 1)
	public void checkWrongPassword() {
		
		WebElement email= driver.findElement(By.id("text"));
		email.sendKeys("test1@student.com");
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("1234567");
		WebDriverWait wait = new WebDriverWait(driver,15);
		driver.findElement(By.className("login-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
		email.clear();
		password.clear();
		
	}
	
	@Test(priority = 2)
	public void checkWrongUsername() {
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement email= driver.findElement(By.id("text"));
		email.sendKeys("test11@student.com");
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("1234567");
		WebDriverWait wait = new WebDriverWait(driver,15);
		driver.findElement(By.className("login-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
		email.clear();
		password.clear();
		
	}
	
	@Test(priority = 3)
	public void checkCorrectCredentials() {
		
		
		WebElement email= driver.findElement(By.id("text"));
		email.sendKeys("test1@student.com");
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.findElement(By.className("login-btn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("login-btn")));
		
				
	}
	//executed once only before starting a test case
	@BeforeClass
	public void launchbrowser() {
		System.out.println("test before launch");
		
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chrome/chromedriver.exe");
		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.unirely.com/");
	}
	
	//executed once only after the test cases are ended
//		@AfterClass
//		public void closebrowser() {
//			System.out.println("test after browser close");
//			
//			driver.close();
//		}
//	
	
	
	//executed before every test case method
	//precondition of a test case
//	@BeforeMethod
//	public void launchbrowser() {
//		
//	}
	
	
	//executed after every test case method
	//post condition of a test case
//		@AfterMethod
//		public void closebrowser() {
//			
//		}
}
