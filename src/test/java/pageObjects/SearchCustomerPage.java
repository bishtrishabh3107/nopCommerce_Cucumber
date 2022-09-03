package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
	
	@FindBy(how=How.ID, using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID, using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID, using="SearchMonthOfBirth")
	@CacheLookup
	WebElement dropDOBMonth;
	
	@FindBy(how=How.ID, using="SearchDayOfBirth")
	@CacheLookup
	WebElement dropDOBDay;
	
	@FindBy(how=How.ID, using="SearchCompany")
	@CacheLookup
	WebElement txtSearchCompany;
	
	@FindBy(how=How.ID, using="SearchIpAddress")
	@CacheLookup
	WebElement txtSearchIpAddress;
	
	@FindBy(how=How.CLASS_NAME, using="k-multiselect-wrap k-floatwrap")
	@CacheLookup
	WebElement txtCustomerRole;
	
	
	@FindBy(how=How.ID, using="SelectedCustomerRoleIds")
	@CacheLookup
	WebElement selectCustomerRole;
	
	@FindBy(how=How.ID, using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows; 
	
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setMail(String email) {
		waithelper.WaitForElement(txtEmail, 20);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String FirstName) {
		waithelper.WaitForElement(txtFirstName, 20);
		txtFirstName.clear();
		txtFirstName.sendKeys(FirstName);
	}
	
	public void setLastName(String LastName) {
		waithelper.WaitForElement(txtLastName, 20);
		txtLastName.clear();
		txtLastName.sendKeys(LastName);
	}
	
	public void clickSearch() {
		waithelper.WaitForElement(btnSearch, 20);
		btnSearch.click();
	}
	
	public int getNoOfRows() {
		return tableRows.size();
	}
	
	public int getNoOfColums() {
		return tableColumns.size();
	}
	
	public boolean searchCustomerByEmail(String email) {
	
		boolean flag=false;	
		
		for(int i=1;i<getNoOfRows();i++) {
			
			String emailId=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println("Email Id is "+emailId);
			
			if(emailId.equals(email)) {
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name) {
		
		boolean flag=false;	
		
		for(int i=1;i<getNoOfRows();i++) {
			
			String name=ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			
			System.out.println("Name is "+name);
			
			String names[]=name.split(" ");
			String Names[]=Name.split(" ");
			
			if(names[0].equals(Names[0]) && names[1].equals(Names[1])) {
				flag=true;
			}
		}
		return flag;
	}
	
	
	

}
