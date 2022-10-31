@assigndef
Feature: Assign Defect

  Scenario: View defect description
    Given Manager is logged in as a manager
    And Manager is on the homepage
    When Manager clicks on the select button for a defect
    Then The defect description appears in bold font

    Scenario: Assign defect
      Given Manager is logged in as a manager
      And Manager is on the homepage
      When Manager clicks on the select button for a defect
      And Manager selects a tester from the drop down
      And Manager clicks the assign button
      Then The defect is assigned to the tester

    Scenario: Tester can view the defect
      Given Tester is logged in as a tester
      When Tester is on the homepage
      Then Tester should see the pending defect assigned to them
