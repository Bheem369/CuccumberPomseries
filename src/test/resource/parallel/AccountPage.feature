Feature: Accountpage feature

Background:
Given user had logged into Application
|username||password|
|spdlfh@gmail.com||spdlfh|

@accounts
Scenario: Accountpage title
Given user is on account page
When user gets the title of the page
Then page title should be "My Account"

@accounts 
Scenario: Accounts Sectioncount
Given user is on account page
Then user gets accounts section
|My Account|
|My Orders|
|My Affiliate Account|
|Newsletter|
And accounts section count should be 4

