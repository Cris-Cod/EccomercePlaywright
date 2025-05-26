Feature: Register user

  Scenario: Create and delete a user account
    Given the user enters the e-commerce page
    When the user selects the option to create a "new account"
    And enters "userName" and "email"
    And provides information: "title", "password", and date of birth ("day", "month", "year")
    And enters personal information: "firstName", "lastName", "address", "country", "state", "city", "zipcode", and "phoneNumber"
    Then the account is created successfully
    When the user logs into the newly created account
    And selects the option to delete the account
    Then the account is deleted