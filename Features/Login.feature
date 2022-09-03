Feature: Login
	
	@sanity
  Scenario: Successful login with Valid Credentials
    Given User launches the chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Clicks on Login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Log out link
    Then Page title should be "Your store. Login" 
    And close browser
   
  @regression
  Scenario Outline: Successful login with Valid Credentials
    Given User launches the chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<email>" and password as "<password>"
    And Clicks on Login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Log out link
    Then Page title should be "Your store. Login" 
    And close browser
    
    Examples:
      |email|password|
      |admin@yourstore.com|admin|
      |admin1@yourstore.com|admin1|
  