package automationPractice.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automationPractice.base.TestcaseBase;
import utilities.DataUtil;

public class Signup extends TestcaseBase {
	
	
	       public void signUp(String Names, String EmailIDs) {
	    				
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/input[2]"))).sendKeys(Names);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/input[3]"))).sendKeys(EmailIDs);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/button[@type='submit']"))).click();
			
			//WebElement AccountHeading = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='form']/div/div/div/div[1]/h2")));
			//String AccountHeadingValue= AccountHeading.getText();
			//Assertion for Enter account information page is visible
			//softassert.assertEquals(AccountHeadingValue, "ENTER ACCOUNT INFORMATION", "Enter Account Information Expected");
				
	       }
	       
	       public void fillForm(String gender, String password, String date, String month, String year) {
	    	 
	    	if(gender.equalsIgnoreCase("mr")) {
	    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div/div/label[@for='id_gender1']/div"))).click();	
	    	}else if(gender.equalsIgnoreCase("mrs")) {
	    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div/div/label[@for='id_gender2']/div"))).click();
	    	}   
				
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div[4]/input"))).sendKeys(password);
			
			
			selectDropDownByValue("//form[@action='/signup']/div[5]/div/div[1]/div/select",date);
			
			selectDropDownByValue("//form[@action='/signup']/div[5]/div/div[2]/div/select",month);
			
			selectDropDownByValue("//form[@action='/signup']/div[5]/div/div[3]/div/select",year);
		       
		    
		   WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div[6]")));
		   js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
		   checkbox.click();
		   WebElement checkbox2 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/div[7]")));
		   js.executeScript("arguments[0].scrollIntoView(true);", checkbox2); 
		   checkbox.click();
		   
	       }
	       
	       public void addressForm(String FirstName, String LastName, String Company, String Address1, String Address2, String Country, String State, String City, String Zipcode, String MobileNo ) {
		    /*...Address information...*/
		 
		    fillInputValues("//form[@action='/signup']/p[1]/input",FirstName);
		    fillInputValues("//form[@action='/signup']/p[2]/input",LastName);
		    fillInputValues("//form[@action='/signup']/p[3]/input",Company);
		    fillInputValues("//form[@action='/signup']/p[4]/input",Address1);
		    fillInputValues("//form[@action='/signup']/p[5]/input",Address2);
		    selectDropDownByValue("//form[@action='/signup']/p[6]/select",Country);
		  
		    fillInputValues("//form[@action='/signup']/p[7]/input",State);
		    fillInputValues("//form[@action='/signup']/p[8]/input",City);
		    fillInputValues("//form[@action='/signup']/p[9]/input",Zipcode);
		    fillInputValues("//form[@action='/signup']/p[10]/input",MobileNo);
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/signup']/button[@type='submit']"))).click();
		    
		    /*WebElement accountCreated = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='form']/div/div/div/h2/b")));
		    String header = accountCreated.getText();  
		    
		    softassert.assertEquals(header, "ACCOUNT CREATED!", "Account not created");
		   
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pull-right']/a"))).click();
		    
		    WebElement CustomerName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-middle']/div/div/div[2]/div/ul/li[10]/a/b")));
		  
		    softassert.assertEquals(CustomerName.getText(), "Shritik Sharma", "Customer Name not appeared");
		    softassert.assertAll();*/
			
		}
	  private void selectDropDownByValue(String Xpath, String value) {
			WebElement daysSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			js.executeScript("arguments[0].scrollIntoView(true);", daysSelect);
		    new Select(daysSelect).selectByValue(value);
			
		}
		private void fillInputValues(String Xpath, String value) {
			
			 WebElement fill = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
			 js.executeScript("arguments[0].scrollIntoView(true);", fill);
			 fill.sendKeys(value);
		}
	

}
