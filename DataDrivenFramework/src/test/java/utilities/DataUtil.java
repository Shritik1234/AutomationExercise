package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import automationPractice.base.TestcaseBase;


public class DataUtil extends TestcaseBase{
	
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		
		String sheetName = m.getName();//sheetname should be same method name which we are using for data provider
		//String sheetName = "LoginTestCase";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
	
		Object[][] data = new Object[rowNum-1][colNum];
		
	
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
				
			}
			
			
		}
		
		
		return data;
		
	}

	
	@DataProvider(name = "data")
	public Object[][] getData( ) {
		
		String sheetName = "signUp";//sheetname should be same method name which we are using for data provider
		//String sheetName = "LoginTestCase";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
	
		Object[][] data = new Object[rowNum-1][colNum];
		
	
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
				
			}
			
			
		}
		
		
		return data;
		
	}
	
	@DataProvider(name = "Logindata")
	public Object[][] getLoginData( ) {
		
		String sheetName = "loginWithCorrectEmailnPass";//sheetname should be same method name which we are using for data provider
		//String sheetName = "LoginTestCase";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
	
		Object[][] data = new Object[rowNum-1][colNum];
		
	
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
				
			}
			
			
		}
		
		
		return data;
		
	}
}
