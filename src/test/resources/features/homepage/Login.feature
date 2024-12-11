Feature: User Login with valid credentials

  As a user
  I want to login to my platform account
  So that I can access & shop on platform.

  Scenario: User logs in successfully and is redirected to the home page

    Given the user is on the home page
    When the user clicks on the Sign In header button
    And the user enters the email id and password and click on Submit login button
    Then the user's username should be displayed as the logged-in user
