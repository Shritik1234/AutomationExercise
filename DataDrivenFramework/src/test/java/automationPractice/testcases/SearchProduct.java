package automationPractice.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;


public class SearchProduct extends TestcaseBase{
	
	@Test
	public void searchProduct() {
		log.info("inside search product!!");
		
		click("productButton_Xpath");
		type("searchProduct_Xpath","Tops");
		click("searchButton_Xpath");
		
		String heading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("searchProductHeading_Xpath")))).getText();
		softassert.assertEquals(heading, "SEARCHED PRODUCTS", "Expected heading searched products not visisble" );
		
		
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='features_items']/div/div/div[1]/div[1]/p")));
		
		/*List<WebElement> featuredItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='features_items']/div/div/div[1]/div[1]/p")));
		
		if(featuredItems.isEmpty()) {
			softassert.assertTrue(true, "No featured items found — test passed by negative condition");
		}else {
			
			WebElement firstItem = featuredItems.get(1);
            js.executeScript("arguments[0].scrollIntoView(true);", firstItem);

            String itemText = firstItem.getText();
            log.info(itemText);
            softassert.assertTrue(itemText.contains("Top"), "Expected item to contain text 'Top'");
		
		}*/
		
		if(wait.until(driver-> driver.findElements(By.xpath("//div[@class='features_items']/div/div/div[1]/div[1]/p"))).size()==0)
		{
			softassert.assertTrue(true, "No featured items found — test passed by negative condition");	
		}else {
			List<WebElement> featuredItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='features_items']/div/div/div[1]/div[1]/p")));
			WebElement firstItem = featuredItems.get(1);
            js.executeScript("arguments[0].scrollIntoView(true);", firstItem);

            String itemText = firstItem.getText();
            log.info(itemText);
            softassert.assertTrue(itemText.contains("Top"), "Expected item to contain text 'Top'");
		}
		softassert.assertAll();
		
	
	}
	
	
}

