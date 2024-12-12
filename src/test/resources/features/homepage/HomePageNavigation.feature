Feature: Home Page Navigation

  As a user
  I want to navigate directly to the home page by entering the URL
  So that I can access the application's main functionalities.

  Background: user launch the platform
    Given the user enters the application URL in the browser
    When the page loads
    Then the user should be redirected to the home page

  Scenario: user navigates to the home page by entering the URL
    And the home page title should be "My Shop"

  Scenario: user can navigate to Contact Us page
    When the user clicks on the Contact us header button
    Then the user is navigated to the Contact us screen

  Scenario: user can navigate to Shopping Cart
    When the user clicks on the Cart button
    Then the user navigates to the card screen

  Scenario: user can search any product by using search function
    When the user enters specific text in search bar and clicks search button
    Then the list of product is loaded with search text in product name

  Scenario: User is redirected to the Login page when trying to access Orders without being logged in
    When the user clicks on the My Orders button in the footer
    Then the user is taken to the Login page