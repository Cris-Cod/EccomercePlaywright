Feature: validate login

  Scenario: Login user with correct email and password
    Given user enters the e-commerce page
    When user selects the option to create a "login"
    And enters "email" and "password" in the login module
    Then verify the "username" is visible

  Scenario: Login User with incorrect email and password
    Given user enters the e-commerce page
    When user selects the option to create a "login"
    And enters incorrect "email" and "password" in the login module
    Then Verify error "Your email or password is incorrect!" is visible

  @ContactUS
  Scenario: Contact Us Form
    Given user enters the e-commerce page
    When user selects the new option to create a "contact us"
    And  enters "name", "email", "subject" and "message"
    Then Verify success message "Success! Your details have been submitted successfully." is visible
