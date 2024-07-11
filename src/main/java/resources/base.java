package resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	
	 WebDriver driver;
	 
	   public WebDriver intializer() {
		   
		   String browser = "chrome";
		   
		   if(browser.equalsIgnoreCase("chrome")) {
			   WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
		   }
		   
		   else if ( browser.equalsIgnoreCase("firefox")){
			   WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver();
		   }
		   
		   driver.manage().window().maximize();
		   //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   return driver;
	   }
	
	
	
	
	
}
