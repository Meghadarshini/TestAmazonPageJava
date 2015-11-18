package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonPage {
	
	WebDriverWait wait;
	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@Test( groups = { "loadPage" })
	void pageLoad()
	{
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	}
	

	
	
	@BeforeClass(alwaysRun = true)
	public void beforeMethod()
	{
		driver = new FirefoxDriver();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterMethod()
	{
		
	}

}
