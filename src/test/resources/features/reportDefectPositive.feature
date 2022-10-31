@reportdefectpos

Feature: Report a Defect Positive

    Background: User logs in
      Given User is on the login page
      When User types in a username of "username"
      And User types in a password of "password"
      And User clicks the login button



  Scenario: Report New Defect
    Given User navigates to the Defect Reporter page
    When User selects a date
    And User types in the Description box with "description"
    And User types in the How to Reproduce box with "steps"
    And User selects Medium priority
    And User selects Low severity
    And User clicks the Report button
    And A confirmation box appears stating 'Confirm Bug Report?'
    And User clicks Ok
    And A modal appears displaying the newly created Defect ID
    And User clicks close
    Then The modal should disappear
