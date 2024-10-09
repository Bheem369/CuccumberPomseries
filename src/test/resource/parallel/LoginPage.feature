@Login
Feature: LoginPage feature

@Smoke
Scenario: LoginPage Title
Given user is on login page
When user gets the title of the page
Then page title should be "Account Login"

@Smoke
Scenario: forgot password link
Given user is on login page
Then forgot your password link should be displayed

@Regression @Skip
Scenario: Login with Correct Credentials
Given user is on login page
When user enters username "spdlfh@gmail.com"
And user enters password "spdlfh"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My Account"