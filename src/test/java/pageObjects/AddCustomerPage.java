package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	public WebDriver ldriver;

	public  AddCustomerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
	WebElement CustomerMainMenu;
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a")
	WebElement CustomerSubMenu;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement AddNewButton;
	
	///////////////Customer info/////////////////////
	
	@FindBy(id = "Email")
	WebElement EmailBox;
	
	@FindBy(id = "Password")
	WebElement Password;
	
	@FindBy(id = "FirstName")
	WebElement FirstName;
	
	@FindBy(id = "LastName")
	WebElement LastName;
	
	@FindBy(id="Gender_Male")
	WebElement GenderMale;
	
	@FindBy(id="Gender_Female")
	WebElement GenderFemale;
	
	@FindBy(id = "DateOfBirth")
	WebElement DOB;
	
	@FindBy(id = "Company")
	WebElement CompanyName;

	
	@FindBy(xpath = "//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")
	WebElement CustomerRoles;
	
	

//Customer Roles:
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]")
	WebElement Administrator;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]")
	WebElement ForumModerator;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")
	WebElement Guests;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]")
	WebElement Registered;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]")
	WebElement Vendors;
////////////////Customer Roles end///////////////////////////////
	
	@FindBy(id = "VendorId")
	WebElement ManagerOfVendor;
	
	@FindBy(id = "AdminComment")
	WebElement AdminComment;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form/div[1]/div/button[1]/i")
	WebElement saveBtn;
	
	
	
	
//Action Methods..................................................
	
	
	

	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMainMenu() {
		CustomerMainMenu.click();
	}
	public void clickOnCustomerSubMenu() {
		CustomerSubMenu.click();
	}
	public void AddNew() {
		AddNewButton.click();
	}
	///////////Customer info///////////////
	public void setEmail(String emailRan) {
	EmailBox.sendKeys(emailRan);
	}
	public void setPwd(String password) {
		Password.sendKeys(password);
	}
	public void setFirstName(String string) {
		FirstName.sendKeys(string);
	}
	public void setLastName(String string) {
		LastName.sendKeys(string);
	}
	public void DOB(String string) {
		DOB.sendKeys(string);
	}
	public void setCompanyName(String string) {
		CompanyName.sendKeys(string);
	}
	public void setAdminComment(String string) {
		AdminComment.sendKeys(string);
	}
	///////////Customer info ends///////////////
	
	public void clickSaveButton() {
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
}
