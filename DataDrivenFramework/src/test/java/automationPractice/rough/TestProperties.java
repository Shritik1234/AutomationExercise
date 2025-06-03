package automationPractice.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestProperties {
	
	public static WebDriver driver;
	public static FileInputStream file;
	public static Properties config;
	public static Properties or;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.getProperty("user.dir");
		System.out.println(System.getProperty("user.dir"));
		try {
			config = new Properties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		or = new Properties();
		try {
			file = new FileInputStream (System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
			config.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		config.getProperty("browser");
		System.out.println(config.getProperty("browser"));

	}

}
