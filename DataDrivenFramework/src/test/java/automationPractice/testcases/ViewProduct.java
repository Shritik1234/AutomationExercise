package automationPractice.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;

public class ViewProduct extends TestcaseBase{
	
	
	@Test
	public void viewProduct() {
		click("productButton_Xpath");
		
	    softassert.assertTrue(driver.getCurrentUrl().contains("products"));//to verify product page launched
		
		
		WebElement viewProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("viewProduct_Xpath"))));
		
		 js.executeScript("arguments[0].scrollIntoView(true);", viewProduct); 
		 
		 viewProduct.click();
		 
		
			softassert.assertTrue(driver.getCurrentUrl().contains("product_details")); //to verify product detail page launched
			
		
		//to verify below fields are visible
		String[] elementKeys = {"productName_Xpath","productPrice_Xpath", "availablity_Xpath","conditions_Xpath","brand_Xpath"};	
		
		
	  
		for(String key:elementKeys ) {
		
			WebElement product=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty(key))));
			softassert.assertTrue(product.isDisplayed(), key+"not dispalyed");
		}
		
		
		
	
	}

}
