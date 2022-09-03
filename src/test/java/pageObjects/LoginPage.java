package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement linkLogout;
	
	
	public void setUserName(String UserName) {
		txtEmail.clear();
		txtEmail.sendKeys(UserName);
	}
	
	public void setPassword(String Password) {
		txtPassword.clear();
		txtPassword.sendKeys(Password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		linkLogout.click();
	}

}
