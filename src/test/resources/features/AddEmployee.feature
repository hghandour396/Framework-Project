Feature: Add employee scenarios

  #all the common steps for all the scenarios will be written in the background section
  #the steps in the background section will be executed before each scenario
  #the steps in the background section will be executed in the order they are written
  #the background is different for every feature file

  Background:
  Background:
   # Given user is able to access HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully
    When user clicks on PIM option
    And user clicks on add employee option

  @regression @addEmployee @positive
  Scenario: Add employee without providing Employee ID
    When user enters employee value "Rabhi" and "Ms" and "Tefah" and leaves employee ID empty
    And user clicks on save button
    Then user is able to see employee added successfully

  @regression  @negative @addEmployee
  Scenario: Verify required fields when adding employee
    When user tries to save without first name
    Then user should display required field error