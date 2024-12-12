Feature: My Account page activities features

  Background: User login and navigated to My Account screen
    Given the user is on the home page
    When the user clicks on the Sign In header button
    And the user enters the email id and password and click on Submit login button

  Scenario: User is able to go to My Account page by login
    Then the user navigates to the My Account screen

  Scenario: User is able to navigate to Add my first address page
    When the user clicks on the "Add my first address" button
    Then the user navigates to the "Add my first address" screen

  Scenario: User is able to navigate to Order history and details page
    When the user clicks on the "Order history and details" button
    Then the user navigates to the "Order history and details" screen

  Scenario: User is able to navigate to My credit slips page
    When the user clicks on the "My credit slips" button
    Then the user navigates to the "My credit slips" screen

  Scenario: User is able to navigate to My Addresses page
    When the user clicks on the "My Addresses" button
    Then the user navigates to the "My Addresses" screen

  Scenario: User is able to navigate to My personal Info page
    When the user clicks on the "My personal Info" button
    Then the user navigates to the "My personal Info" screen