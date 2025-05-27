Feature: validate login

  Scenario: Login user with correct email and password
    Given user enters the e-commerce page
    When user selects the option to create a "login"
    And enters "email" and "password" in the login module
    Then verify the "username" is visible