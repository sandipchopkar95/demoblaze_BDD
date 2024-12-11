Feature: Home Page Navigation

  As a user
  I want to navigate directly to the home page by entering the URL
  So that I can access the application's main functionalities.

  Scenario: User navigates to the home page by entering the URL
    Given the user enters the application URL in the browser
    When the page loads
    Then the user should be redirected to the home page
    And the home page title should be "My Shop"