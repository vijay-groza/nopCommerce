package stepDefinition;

import java.awt.Window;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	
	
	
    @Given("User launches the Browser")
	public void user_launches_the_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vijay\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}
    
    @When("User enters the url {string}")
    public void user_enters_the_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
    }
    @Then("User enters the id {string} and the password {string}")
    public void user_enters_the_id_and_the_password(String string, String string2) {
    	 lp.setUserName(string);
 	    lp.setPassword(string2);
    }
    @When("User clicks the Login button")
    public void user_clicks_the_login_button() {
    	 lp.clickLogin();
    }


	@Then("the page title should be {string}")
	public void the_page_title_should_be(String string) {
	    if (driver.getPageSource().contains("Login was unsuccessful.")){
			driver.close();
		Assert.assertTrue(false);
	    }else {
			Assert.assertEquals(string, driver.getTitle());
		}
	}
//Add New Customer........................................................................


	@Then("User can view the Dashboard")
	public void user_can_view_the_dashboard() {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",
				   addCust.getPageTitle());
	}
	@When("Click on the Customers Main menu")
	public void click_on_the_customers_main_menu() {
		   addCust.clickOnCustomerMainMenu();

	}
	@Then("Click on the Customers Sub menu")
	public void click_on_the_customers_sub_menu() {
	   addCust.clickOnCustomerSubMenu();
	}
	@Then("User clicks Add new button")
	public void user_clicks_add_new_button() throws InterruptedException {
	  addCust.AddNew();
		Thread.sleep(3000);

	}
	@Then("User can view Add new Customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
	}
	@When("User enters all the Customer info")
	public void user_enters_all_the_customer_info() {
		
	   String emailRan=RandomString()+"@yahoo.com";
	    addCust.setEmail(emailRan);
	    addCust.setPwd("1234@asf");
	    addCust.setFirstName("Vijay");
	    addCust.setLastName("Kumar");
	   addCust.DOB("5/5/1997");
	   addCust.setCompanyName("BrownWhale");
	   //addCust.setCustomerRole("Guest");
	   addCust.setAdminComment("Everything is Good");
	    
	}
	@When("User clicks the Save button")
	public void user_clicks_the_save_button() {
	    addCust.clickSaveButton();
	}
	@Then("the message should be displayed as {string}")
	public void the_message_should_be_displayed_as(String string) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).
	    		getText().contains("The new customer has been added successfully"));
	}
//Add New Customer ends.................................................................

	@When("the User clicks the logout button.")
	public void the_user_clicks_the_logout_button() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(4000);
	}
////////Searching the Customer through email

	@When("User enters the email in the Email box")
	public void user_enters_the_email_in_the_email_box() {
		searchCustomer = new SearchCustomerPage(driver);
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
	}
	@When("User clicks the search button")
	public void user_clicks_the_search_button() throws InterruptedException {
	    searchCustomer.clickOnSearch();
	    Thread.sleep(3000);
	}
	@Then("User should find the email in the Search Table")
	public void user_should_find_the_email_in_the_search_table() {
	    boolean status =searchCustomer.SearchCustomerByMail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true, status);
	}
////searching through email ends.....
	
//Searching a customer using the Name starts....

	@Then("Enter the Customers First name")
	public void enter_the_customers_first_name() {
		searchCustomer = new SearchCustomerPage(driver);
	    searchCustomer.setFirstName("Victoria");
	}
	@When("Enter the Customers Last name")
	public void enter_the_customers_last_name() {
	    searchCustomer.setLastName("Terces");
	}
	@Then("User should find the Name in the Search Table")
	public void user_should_find_the_name_in_the_search_table() {
	    Boolean status =searchCustomer.SearchCustomerByName("Victoria Terces");
	    Assert.assertEquals(true,status);
	}
	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	    
	}

}
