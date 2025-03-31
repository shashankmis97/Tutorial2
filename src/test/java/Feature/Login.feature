Feature: Login Functionality

  Scenario: login with valid credentials
    Given user is on login page
    When user enters the username and password
    And click on login button
    Then user navigated to homepage
