package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By linkCustomer_Menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By linkCustomer_MenuItem=By.xpath("(//li[@class='nav-item']//p[contains(text(),'Customers')])[1]");
	By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
	By txtEmail=By.id("Email");
	By txtPassword=By.id("Password");
	By txtFirstName=By.id("FirstName");
	By txtLastName=By.id("LastName");
	By rbtnGender_Male=By.id("Gender_Male");
	By rbtnGender_Female=By.id("Gender_Female");
	By txtDateOfBirth=By.id("DateOfBirth");
	By txtCompany=By.id("Company");
	By ckIsTaxExempt=By.id("IsTaxExempt");
	
	By txtNewsLetter= By.xpath("//label[@id='SelectedNewsletterSubscriptionStoreIds_label']");
	
	By option1NewsLetter=By.xpath("//label[@id='SelectedNewsletterSubscriptionStoreIds_label']/following::option[1]");
	
	By option2NewsLetter=By.xpath("//label[@id='SelectedNewsletterSubscriptionStoreIds_label']/following::option[2]");
	
	By txtCustomerRole= By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/following-sibling::input");
	
	By optionAdministrators=By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/following::option[1]");
	
	By optionForumModerators=By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/following::option[2]");
	
	By optionGuests=By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/following::option[3]");
	
	By optionRegistered=By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/following::option[4]");
	
	By optionVendors=By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/following::option[5]");
	
	@FindBy(id="VendorId")
	WebElement selectVendor;
	
	@FindBy(id="Active")
	WebElement ckActive;

	By txtAdminComment=By.id("AdminComment");
	By btnSave=By.name("save");
	By btnSaveContinue=By.name("save-continue");

	
	//Actions
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickCutomerMenu() {
		ldriver.findElement(linkCustomer_Menu).click();
	}
	
	public void clickCutomerMenuItem() {
		ldriver.findElement(linkCustomer_MenuItem).click();
	}
	
	public void clickAddNew() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setFirstName(String FirstName) {
		ldriver.findElement(txtFirstName).sendKeys(FirstName);
	}
	
	public void setLastName(String LastName) {
		ldriver.findElement(txtLastName).sendKeys(LastName);
	}
	
	public void selectMaleFemale(String gender) {
		if(gender=="Male") {
			ldriver.findElement(rbtnGender_Male).click();
		}else if(gender=="Female") {
			ldriver.findElement(rbtnGender_Female).click();
		}
	}
	
	public void setDOB(String dob) {
		ldriver.findElement(txtDateOfBirth).sendKeys(dob);
	}
	
	public void setCompany(String Company) {
		ldriver.findElement(txtCompany).sendKeys(Company);
	}
	
	public void selectIsTaxExempt() {
		ldriver.findElement(ckIsTaxExempt).click();
	}
	
	public void setCustomerRole(String role) {
		ldriver.findElement(txtCustomerRole).click();
		
		WebElement listItem;
		if(role.equals("Vendor")) {	
			listItem=ldriver.findElement(optionVendors);
		}
		else if(role.equals("Administrators")) {
			listItem=ldriver.findElement(optionAdministrators);
		}
		else if(role.equals("Forum Moderators")) {
			listItem=ldriver.findElement(optionForumModerators);
		}
		else if(role.equals("Guests")) {
			listItem=ldriver.findElement(optionGuests);
		}
		else if(role.equals("Registered")) {
			listItem=ldriver.findElement(optionRegistered);
		}else {
			listItem=ldriver.findElement(optionGuests);
		}
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0]", listItem);
	}
	
	public void setManagerOfVendor(String Vendor) {
		Select s=new Select(selectVendor);
		s.selectByVisibleText(Vendor);
	}
	
	
	
	public void selectActive() {
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0]", ckActive);
	}
	
	public void settxtAdminComment(String AdminComment) {
		ldriver.findElement(txtAdminComment).sendKeys(AdminComment);
	}
	
	public void clickSave() {
		ldriver.findElement(btnSave).click();
	}
}
