Feature: Customers

Background: Common steps
 Given User launches the Browser
When User enters the url "https://admin-demo.nopcommerce.com/login"
Then User enters the id "admin@yourstore.com" and the password "admin"
When User clicks the Login button
Then User can view the Dashboard
When Click on the Customers Main menu
Then Click on the Customers Sub menu



Scenario: Add Customer info


And User clicks Add new button
Then User can view Add new Customer page
When User enters all the Customer info
And User clicks the Save button
Then the message should be displayed as "The new customer has been added successfully"
And close the browser

Scenario: Search Customer by Email id

When User enters the email in the Email box
And User clicks the search button
Then User should find the email in the Search Table
And close the browser

Scenario: Search Customer by Name


And Enter the Customers First name
When Enter the Customers Last name
And User clicks the search button
Then User should find the Name in the Search Table
And close the browser


