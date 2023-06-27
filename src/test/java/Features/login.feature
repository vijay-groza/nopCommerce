Feature: Login
Scenario: Successful Login with Valid credentials 

Given User launches the Browser
When the User enters the url "https://admin-demo.nopcommerce.com/login"
Then the User enters the id "admin@yourstore.com" and the password "admin"
When the User clicks the Login button
Then the page title should be "Dashboard / nopCommerce administration"
When the User clicks the logout button.
Then the page title should be "Your store. Login"
And close the browser

Scenario Outline: Login Data Driven

Given User launches the Browser
When the User enters the url "https://admin-demo.nopcommerce.com/login"
Then the User enters the id "<email>" and the password "<password>"
When the User clicks the Login button
Then the page title should be "Dashboard / nopCommerce administration"
When the User clicks the logout button.
Then the page title should be "Your store. Login"
And close the browser

Examples: 
			| email | password |
			| admin@yourstore.com | admin |
			| wrongdata | woring data |
			










