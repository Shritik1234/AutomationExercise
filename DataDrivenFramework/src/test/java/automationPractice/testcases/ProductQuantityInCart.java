package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;

public class ProductQuantityInCart extends TestcaseBase{
	
	@Test
	public void productQuantityInCart() {		

		WebElement viewProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("viewProduct_Xpath"))));
		
		js.executeScript("arguments[0].scrollIntoView(true);", viewProduct); 
		 
		viewProduct.click();
		softassert.assertTrue(driver.getCurrentUrl().contains("product_details")); 
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("quantityInput_Xpath")))).sendKeys(Keys.DELETE);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("quantityInput_Xpath")))).sendKeys("4");
		click("addToCartOnProductDetail_Xpath");
		click("viewCart_Xpath");
		String quantity= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("quantity_Xpath")))).getText();
		
		if(quantity.equals("4")) {
			
			softassert.assertTrue(true, "quantity is not 4");
			
		}else {
			
			softassert.assertTrue(false, "quantity is not 4");
		}
	
		softassert.assertAll();
	}

}
