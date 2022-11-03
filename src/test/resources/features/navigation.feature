@navi

Feature: Navigation

  Background: User logging in as Manager
    Given User is logging in as Manager

  Scenario Outline: All Links Viable
    Given Manager is on the homepage
    When Manager clicks on <link>
    Then Manager navigates to a page displaying the title <title>

    Examples:
      | link           | title               |
      | Matrices       | Matrix Overview     |
      | Test Cases     | Test Case Overview  |
      | Report a Defect| Defect Reporter     |
      | Defect Overview| Defect Overview     |


  Scenario Outline: Back Navigation
    Given Manager is on the homepage
    And Manager clicks on <link>
    When Manager navigates to <link> page
    And Manager clicks the browser back button
    Then Manager returns to the homepage

    Examples:
      | link           |
      | Matrices       |
      | Test Cases     |
      | Report a Defect|
      | Defect Overview|

  Scenario Outline: Page Refresh
    Given Manager is on the homepage
    And Manager clicks on <link>
    When Manager navigates to <link> page
    And Manager clicks the browser refresh button
    Then Manager refreshes the <link> page

    Examples:
      | link           |
      | Matrices       |
      | Test Cases     |
      | Report a Defect|
      | Defect Overview|

