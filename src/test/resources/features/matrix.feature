@matrix

Feature: Matrix

  Background: User logging in as Manager
    Given User is logging in as Manager

  Scenario: Create a New Matrix
    Given Manager is on the homepage
    When Manager clicks on the button to create a matrix
    And Manager pulls up a form to make a new matrix
    And Manager adds a title to the matrix
    And Manager adds a user story
    And Manager selects a priority level
    And Manager adds a note
    And Manager adds requirements to the matrix
    Then Manager saves the matrix

  Scenario: Add Defects to Matrix
    Given Manager is on the homepage
    And Manager clicks on the Matrices link
    And Manager navigates to the Matrices page
    When Manager clicks the Show button to view details of a matrix
    And Manager clicks the edit button to a User Story
    And Manager inputs an ID number of a defect
    And Manager clicks the add button to add the defect
    Then The defect is added to the list
    And Manager sees an alert stating 'Matrix Saved'

  Scenario: Add Test Case to Matrix
    Given Manager is on the homepage
    And Manager clicks on the Matrices link
    And Manager navigates to the Matrices page
    When Manager clicks the Show button to view details of a matrix
    And Manager clicks the edit button to a User Story
    And Manager inputs an ID number of a test case
    And Manager clicks the add button to add the test case
    Then The test case is added to the list
    And Manager sees an alert stating 'Matrix Saved'

  Scenario: Remove Defect from Matrix
    Given Manager is on the homepage
    And Manager clicks on the Matrices link
    And Manager navigates to the Matrices page
    When Manager clicks the Show button to view details of a matrix
    And Manager clicks the edit button to a User Story
    And Manager clicks the remove button to remove the defect
    Then The defect is removed
    And Manager sees an alert stating 'Matrix Saved'

  Scenario: Remove Test Case from Matrix
    Given Manager is on the homepage
    And Manager clicks on the Matrices link
    And Manager navigates to the Matrices page
    When Manager clicks the Show button to view details of a matrix
    And Manager clicks the edit button to a User Story
    And Manager clicks the remove button to remove the test case
    Then The test case is removed
    And Manager sees an alert stating 'Matrix Saved'
