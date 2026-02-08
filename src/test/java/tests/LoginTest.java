package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import util.DriverFactory;
import util.TestData1;

public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=DriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
	}
	
	@Test(dataProvider="testdata1",dataProviderClass=TestData1.class)
	public void logtest1(String username,String password,String Expected) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
		
		if(username.equals("student") && password.equals("Password123")) {
			Assert.assertEquals(Expected,"Success");
			}
		else if(username.equals("student") && password.equals("123pas")) {
			Assert.assertEquals(Expected,"Fail");
			
		}
		else if (username.equals("123stud")&& password.equals("Password123")) {
			Assert.assertEquals(Expected, "Fail");
		}
		else {
			Assert.assertEquals(Expected,"Fail");
		}
		
		
	}
	
	
	@AfterMethod
	public void teardown() {
		 
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\Pavilion G6\\eclipse-workspace\\Login_Test_Simple\\target\\t1.png");
			try {
				Files.copy(src, dest);
			
			}
			catch(IOException e) {
				e.getStackTrace();
			}
				
		
			
		
		
		driver.quit();
	}

}
