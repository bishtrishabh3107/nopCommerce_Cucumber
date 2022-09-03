package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class steps extends BaseClass {
	
	@Before
	public void setup() {
		
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Given("User launches the chrome browser")
	public void user_launches_the_chrome_browser() {
		
		logger.info("******** Launching Browser *********");
		lp=new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("******** Opening URL *********");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("******** Providing login details *********");
		lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() throws InterruptedException {
		logger.info("******** Started Login *********");
	    lp.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	logger.info("******** Login Passed *********");
	    	driver.close();
	    	Assert.assertTrue(false);
	    }else {
	    	Assert.assertEquals(title, driver.getTitle());
	    	logger.info("******** Login Failed *********");
	    }
	}

	@When("User clicks on Log out link")
	public void user_clicks_on_log_out_link() throws InterruptedException {
		lp.clickLogout(); 
		logger.info("******** Click on logout link *********");
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	    logger.info("******** Closing Browser *********");
	}
	
   //customer features step definitions
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		logger.info("******** Opening Dashboard View *********");
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	    
	}
	@When("User click on customer menu")
	public void user_click_on_customer_menu() {
		logger.info("******** Click customer menu *********");
		addCust.clickCutomerMenu();
		
	}
	
	@When("click on customer menu item")
	public void click_on_customer_menu_item() {
		logger.info("******** Click on customer list *********");
		addCust.clickCutomerMenuItem();
	    
	}
	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		logger.info("******** Click on add new button *********");
		addCust.clickAddNew();
		Thread.sleep(2000);
	}
	
	@Then("User can view Add new cutomer page")
	public void user_can_view_add_new_cutomer_page() {
		logger.info("******** Navigated to Add a new customer page *********");
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	  
	}
	@When("User enters customer info")
	public void user_enters_customer_info() {
		logger.info("******** Enter customer info *********");
	    String email=randomestring()+"@gmail.com";
	    addCust.setEmail(email);
	    addCust.setPassword("test123");
	    addCust.setFirstName("Pavan");
	    addCust.setLastName("Kumar");
	    addCust.setDOB("7/31/1994");
	    addCust.setCompany("busyQA");
	    addCust.settxtAdminComment("This is a testing -----!");
	    addCust.selectMaleFemale("Male");
	    addCust.selectIsTaxExempt();
	    addCust.selectActive();
	    //addCust.setCustomerRole("Guest");
	    addCust.setManagerOfVendor("Vendor 2");
	}
	@When("click on save button")
	public void click_on_save_button() {
		logger.info("******** Click on save button *********");
		addCust.clickSave();
	    
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		logger.info("******** Confirmation message is displayed *********");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	    
	}
	
	//Steps for searching a customer by email id
	@When("enter customer email")
	public void enter_customer_email() {
		logger.info("******** Enter customer email *********");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setMail("victoria_victoria@nopCommerce.com");
		
	}
	
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("******** click search *********");
		searchCust.clickSearch();
		Thread.sleep(2000);
	
	}
	
	@Then("user should found email on search table")
	public void user_should_found_email_on_search_table() {
		logger.info("******** Seaching customer by email *********");
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    
		Assert.assertEquals(true, status);
	}
	
	//Steps for searching a customer by name
	@When("enter customer firstname")
	public void enter_customer_firstname() {
		logger.info("******** Enter customer firstname *********");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}
	
	@When("enter customer lastname")
	public void enter_customer_lastname() {
		logger.info("******** Enter customer lastname *********");
		searchCust.setLastName("Terces");
	}
	
	@Then("user should found Name on search table")
	public void user_should_found_name_on_search_table() {
		logger.info("******** Seaching customer by name *********");
	    boolean status=searchCust.searchCustomerByName("Victoria Terces");
	    Assert.assertEquals(true, status);
	}


}
