@defectstat

Feature: Defect Status

  Background: Tester logs in
    Given Tester is on the login page
    When Tester types in a username of "username"
    And Tester types in a password of "password"
    And Tester clicks the login button
    Then Tester is on the homepage

  Scenario: Tester can view the defect
    When Tester is on the homepage
    Then Tester should see the pending defects assigned to them


  Scenario: Change Defect Status
    When Tester is on the homepage
    And Tester clicks on a defect to view its details
    And Tester clicks the Change Status button
    And Tester clicks the Accepted button
    Then Tester should see the defect has a different status