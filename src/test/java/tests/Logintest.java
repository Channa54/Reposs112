package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Accountpage;
import pageobjects.Landingpage;
import pageobjects.Loginpage;
import resources.base;

public class Logintest  extends base{
    WebDriver driver;
    
    @BeforeMethod
    public void openbrowserr() {

		 driver = intializer();
		driver.get("https://tutorialsninja.com/demo/");
		
    }
    
	@Test(dataProvider="getlogindata")
	public void login(String email , String password, String expectedstatus) {
		
		Landingpage page = new Landingpage(driver);
		page.myaccountdropdown().click();
		page.loginoption().click();
		
		Loginpage page1 = new Loginpage(driver);
		page1.emailfield().sendKeys(email);
		page1.passwordfield().sendKeys(password);
		page1.Loginbutton().click();
		
		Accountpage page2 = new Accountpage(driver);
		String actualresult ;
		
		try{
		page2.Accountpageinfo().isDisplayed();
		actualresult="succsessful";
		}
	catch (Exception e ){
		actualresult="Failure";
	}
		
		Assert.assertEquals(actualresult, expectedstatus);
	}
	@DataProvider
	public Object[][] getlogindata() {
		Object [][] data = {{"abcx1@gmail.com","Channu@322","succsessful"},{"sachin@gmail.com","akash@345","Failure"}};
		return data;
	}
	
	
	@AfterMethod
	public void closure() {
		
		driver.close();
	}
	
}

