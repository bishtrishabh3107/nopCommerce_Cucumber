Feature: Customers

Background: Below are common steps for every scenario
	Given User launches the chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
  And User enters email as "admin@yourstore.com" and password as "admin"
  And Clicks on Login button
  Then User can view Dashboard

@sanity
Scenario: Add a new Customer
  When User click on customer menu
  And click on customer menu item
  And click on Add new button
  Then User can view Add new cutomer page
  When User enters customer info
  And click on save button
  Then User can view confirmation message "The new customer has been added successfully"
  And close browser

@regression
Scenario: Search Customer by EmailID
  When User click on customer menu
  And click on customer menu item
  And enter customer email
  When click on search button
  Then user should found email on search table
  And close browser

@regression
Scenario: Search Customer by Name
  When User click on customer menu
  And click on customer menu item
  And enter customer firstname
  And enter customer lastname
  When click on search button
  Then user should found Name on search table
  And close browser