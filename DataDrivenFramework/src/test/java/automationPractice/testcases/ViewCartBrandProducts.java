package automationPractice.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;

public class ViewCartBrandProducts extends TestcaseBase {
	
	@Test
	public void viewCartBrandProducts() {
		
		log.info("----view Cart Brand Products Test----");
		
		click("productButton_Xpath");
		verifyProductList();
		verifyBrandPage("poloName_Xpath","poloHeading_Xpath","BRAND - POLO PRODUCTS");
		verifyBrandPage("hNMName_Xpath","hNMHeading_Xpath","BRAND - H&M PRODUCTS");
		softassert.assertAll();
		
		
	}
	
	private void verifyProductList() {
		
	List<WebElement> brandList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(or.getProperty("brandName_Xpath"))));
	
	for(WebElement brandName: brandList ) {
		
		log.info("brandNames" + "->"+brandName.getText().trim());
		
		softassert.assertFalse(brandName.getText().isEmpty(), "Brand Name Should Not Be Empty");	
	}	 
		
	}
	
	
	private void verifyBrandPage(String brandName, String brandHeading, String brandHeadingValue) {
		
		WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(brandName))));
		js.executeScript("arguments[0].scrollIntoView(true);", elm);
		
		click(brandName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		softassert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty(brandHeading)))).getText(), brandHeadingValue);
		
	}
	
	
	
	

}
