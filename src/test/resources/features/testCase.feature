@testcase

Feature: Test Cases

  Background: User Logs In
    Given Tester is on the login page
    When Tester types in a username of "username"
    And Tester types in a password of "password"
    And Tester clicks the login button

    Scenario: Add a Test Case
      Given Tester navigates to the Test Cases page
      When Tester types "description" into Description box
      And Tester types "steps" into Steps box
      And Tester presses the submit button
      Then The test case should appear at the bottom of the table
      And The test case result should say 'UNEXECUTED'

    Scenario: View Test Case Details
      Given Tester navigates to the Test Cases page
      When Tester clicks on Details button of a test case
      And The test case modal appears displaying the case ID
      And The Performed By field says No One
      And The tester clicks the close button
      Then The modal will be closed

    Scenario Outline: Edit Existing Case
      Given Tester navigates to the Test Cases page
      When Tester clicks on Details button of <nth> test case
      And The test case modal appears displaying the case ID
      And Tester clicks on the Edit button within the modal
      And Tester navigates to the <nth> test case editor
      And The fields are uneditable
      And Tester clicks on the Edit button
      And The test case fields become editable
      And Tester edits the text in the Description text box
      And Tester edits the text in the Steps text box
      And Tester clicks on the automated check mark
      And Tester selects cavalier89 from Performed By drop down
      And Tester selects <result> from Test Result drop down
      And Tester edits the text in the Summary text box for <nth> test case
      And Tester clicks the Save button
      And A confirmation prompt appears saying 'Are you sure you want to update the test case?'
      And Tester clicks Ok
      Then An alert appears saying 'Test Case has been Saved'
      And Tester clicks Ok
      And The fields become uneditable
      And The test result displays <result> for <nth> test case

      Examples:
      | nth | result|
      | 3rd | FLAKY |
      | 5th | FAIL  |
      | 7th | PASS  |

  Scenario: Test Case Visible on Tester Homepage
  Given Tester navigates to the Test Cases page
    When Tester clicks on Details button of 7th test case
    And The test case modal appears displaying the case ID
    And Tester clicks on the Edit button within the modal
    And Tester navigates to the 7th test case editor
    And The fields are uneditable
    And Tester clicks on the Edit button
    And The test case fields become editable
    And Tester selects ryeGuy from Performed By drop down
    And Tester clicks the Save button
    And A confirmation prompt appears saying 'Are you sure you want to update the test case?'
    And Tester clicks Ok
    And An alert appears saying 'Test Case has been Saved'
    And Tester clicks Ok
    Then Tester clicks Home link to navigate to the homepage
    And The test case appears on Fakey McFakeFace's homepage

    Scenario: Reset Test Case
      Given Tester navigates to the Test Cases page
      When Tester clicks on Details button of a test case
      And The test case modal appears displaying the case ID
      And Tester clicks on the Edit button within the modal
      And Tester navigates to the 6th test case editor
      And The fields are uneditable
      And Tester clicks on the Edit button
      And The test case fields become editable
      And Tester types a new description into the Description text box
      And Tester types new steps into the Steps text box
      And Tester clicks on the automated check mark
      And Tester selects ryeGuy from Performed By drop down
      And Tester selects FAIL from Test Result drop down
      And Tester types a new summary into the Summary text box
      And Tester clicks on the Reset button
      Then The fields should be populated with their old values
      And The fields should be uneditable