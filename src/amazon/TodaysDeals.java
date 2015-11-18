package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TodaysDeals extends AmazonPage {
	public String dealTitle;
	
	@Test( groups = { "todaysDeal" })
	void todaysDealCheck()
	{
		wait = new WebDriverWait(driver, 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Today's Deals"))).click(); 
	}
	
	@Test( groups = {"cart"} ) //, dependsOnMethods = { "todaysDealCheck" } )
	void addToCart()
	{
		wait = new WebDriverWait(driver, 4000);
		WebElement wasteKing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goldbox-single-deal-large859382486051017")));
		Actions action = new Actions(driver);
		action.moveToElement(wasteKing);
		action.perform();
		String dealTitle = driver.findElement(By.id("dealTitle")).getText();		
		driver.findElement(By.id("dealActionButton")).click();
		
	}
	
	@Test( groups = { "cart" }, dependsOnMethods = { "addToCart" } )
	void checkCart()
	{
		wait = new WebDriverWait(driver, 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hlb-view-cart-announce"))).click();
		WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a-fixed-left-grid-col.a-col-right")));
		
		String cartItemTitle = driver.findElement(By.cssSelector("a-size-medium.sc-product-title.a-text-bold")).getText();
		softAssert.assertEquals(cartItemTitle, dealTitle, "Title incorrect");
	}
	
	@Test( groups = { "cart" }, dependsOnMethods = { "checkCart" }  )
	void countItems()
	{
		String count = driver.findElement(By.id("nav-cart-count")).getText();
		String cartCount = driver.findElement(By.className("a-dropdown-prompt")).getText();
		softAssert.assertEquals(count, cartCount, "Count incorrect");
		
	}
		

}
