Feature: User Login with valid credentials

  As a user
  I want to login to my platform account
  So that I can access & shop on platform.

  Background: User is logged in
    Given the user is on the home page
    When the user clicks on the Sign In header button
    And the user enters the email id and password and click on Submit login button


  Scenario: User logs in successfully and is redirected to the home page
    Then the user's username should be displayed as the logged-in user

  Scenario: User can successfully sign out from the platform
    And the user clicks on the Sign out header button
    Then the user is sign out successfully
