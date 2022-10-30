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
    And Manager saves the matrix
    Then Matrix is visible for all testers and managers

  Scenario Outline: Add Defects/Test Cases to Matrix
    Given Manager is on the homepage
    And Manager clicks on the Matrices link
    And Manager navigates to the Matrices page
    When Manager clicks the Show button to view details of a matrix
    And Manager clicks the edit button to a User Story
    And Manager inputs an ID number of a <item>
    And Manager clicks the add button to add the <item>
    Then The <item> is added to the list

    Examples:
    | item      |
    | defect    |
    | test case |

  Scenario Outline: Remove Defects/Test Cases from Matrix
    Given Manager is on the homepage
    And Manager clicks on the Matrices link
    And Manager navigates to the Matrices page
    When Manager clicks the Show button to view details of a matrix
    And Manager clicks the Edit button for a User Story
    And Manager clicks the Remove button to remove a <item>
    Then The <item> is removed from the list

    Examples:
      | item      |
      | defect    |
      | test case |
