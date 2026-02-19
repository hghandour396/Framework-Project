Feature: Login Validation for HRMs Portal

  Background:
    #Given user is able to access HRMS application

  @regression @smoke @emptyUsername
  Scenario: Login with empty username
    When user leaves admin username empty
    And user clicks on login button
    Then I should see the error message "Required"

  @regression @emptyPassword
  Scenario: Login with empty password
    And user leaves password empty
    And user clicks on login button
    Then I should see the error message "Required"


    @regression @invalidCredentials
    Scenario: Login with invalid credentials
      When user enters invalid admin username and password
      And user clicks on login button
      Then I should see the error message "Invalid credentials"
      And user should be able to attempt login again

  @regression @smoke
  Scenario: Valid admin login
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully


