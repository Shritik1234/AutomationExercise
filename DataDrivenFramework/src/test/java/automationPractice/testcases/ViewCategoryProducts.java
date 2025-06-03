package automationPractice.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;

public class ViewCategoryProducts extends TestcaseBase {
	
	
	@Test
	public void viewCategoryProducts() {
		
		log.info("View Category Product Test");
		
		validateCategoryList();
		
		viewAndVerifyCategory("women_Xpath","dress_Xpath","dressProductHeading_Xpath","WOMEN - DRESS PRODUCTS");
		viewAndVerifyCategory("men_Xpath","thsirt_Xpath","thsirtProductHeading_Xpath","MEN - TSHIRTS PRODUCTS");
	
		softassert.assertAll();
		log.info("==== View Category Products Test Completed ====");
		
	
	
	
	
}
	
	private void validateCategoryList() {
		
		List<WebElement> values = driver.findElements(By.xpath(or.getProperty("categoryList_Xpath")));
		for(WebElement list: values) {

			String name = list.getText().trim();
			
			softassert.assertFalse(name.isEmpty(), "Name should not be empty");
				
		
		
	}
}
	
	
	private void viewAndVerifyCategory(String category, String subCategory, String productHeading, String Heading) {		
		

		WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(category))));
		js.executeScript("arguments[0].scrollIntoView(true);", elm);
		
		click(category);
		click(subCategory);
		
		
		WebElement heading= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty(productHeading))));

		log.info("Heading found: " + heading.getText().trim());
		
		softassert.assertEquals(heading.getText().trim(), Heading, "Mismatch in category heading");
			
		
		
		
	}
}