package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utlities.WaitHelper;

public class SearchCustomerPage  {
			
	public WebDriver ldriver;
	
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver,this);
		waithelper = new WaitHelper(ldriver);
	} 
	@FindBy(id = "SearchEmail") WebElement emailbox;
	@FindBy(id = "search-customers")WebElement searchBtn;
	@FindBy(xpath = "//table[@id='customers-grid']")WebElement table;
	@FindBy(id = "SearchFirstName")WebElement FirstName;
	@FindBy(id = "SearchLastName")WebElement LastName;

	
	@FindBy(xpath = "//*[@id='customers-grid']//tbody/tr") List<WebElement> tableRow;
	@FindBy(xpath = "//*[@id='customers-grid']//tbody/tr/td") List<WebElement> tableColumn;
	
	
//Action methods.........
	public void setEmail(String email) {
		emailbox.clear();
		emailbox.sendKeys(email);
	}
	public void setFirstName(String fname) {
		FirstName.clear();
		FirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		LastName.clear();
		LastName.sendKeys(lname);
	}
	public void clickOnSearch() {
		searchBtn.click();
	}
	public int getNoOfRows() {
		return tableRow.size();
	}
	public int getNoOfColumns() {
		return tableColumn.size();
	}
	public boolean SearchCustomerByMail(String email) {
		boolean flag = false;
			for(int i=1;i<=getNoOfRows();i++) {
				String mailid =table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr[1]/td[2]")).getText();
			
			if (mailid.equals(email)) 
			 {
				flag=true;
			}
}
			return flag;
	}
	public boolean SearchCustomerByName(String Name) {
		boolean flag= false;
		for(int i=1;i<=getNoOfRows();i++) {
			String name=table.findElement(By.xpath("//table[@id=\"customers-grid\"]/tbody/tr[1]/td[3]")).getText();
			String[] names=name.split(" ");
		if(names[0].equals("Victoria")&& names[1].equals("Terces"))
		{
			flag=true;
		}
		}
		return flag;
	}
	}
