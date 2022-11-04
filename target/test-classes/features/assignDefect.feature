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
      And Manager assigns a tester to the defect
      And Manager clicks the assign button
      Then The defect disappears from the list on the homepage
      And The defect is visible on the tester's homepage


