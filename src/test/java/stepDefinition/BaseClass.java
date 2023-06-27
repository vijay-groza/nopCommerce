package stepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	
	public LoginPage lp; 
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCustomer;

//This method creates random string which can be appended!
	public static String RandomString() {
		String genString = RandomStringUtils.randomAlphabetic(5);
		return genString;
		
	}
}