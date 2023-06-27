package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
	
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	} 
	
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement btnLogout;

	public void setUserName(String uname) 
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	public void setPassword(String pwd) 
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() 
	{
		btnLogin.click();
	}
	
	public void clickLogout() 
	{
		btnLogout.click();
	}
}
