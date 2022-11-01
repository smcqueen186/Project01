@testcase

Feature: Test Cases

  Background: User logs in
    Given User is on the login page
    When User types in a username of "username"
    And User types in a password of "password"
    And User clicks the login button

    Scenario: Add a test case
      Given User navigates to the Test Cases page
      When User types "description" into Description box
      When The tester types "Steps" into input with
        """
        1. Go to create a new account page
        2. create several users with each username having 1 illegal character
        3. Make sure none of them are successful
        illegal characters: $, #, /, <, >, (, ), ^
        """
      When The tester presses the submit button
      Then The test case should appear at the bottom of the table
      Then The test case result should say UNEXECUTED
      When The tester presses on details
      Then A test case modal should appear showing the case ID
      Then The performed by field should say No One
      When The tester presses the close buttton
      Then The Modal Should be closed





Test Case has been Saved

Are you sure you want to update the test case?