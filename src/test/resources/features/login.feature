Feature: Login

  Scenario: Valid login credentials
    Given User is at the login page
    When User types in a valid username of "username"
    And User types in a valid password of "password"
    And User clicks the login button
    Then User should be redirected to the homepage

  Scenario: Valid username, invalid password
    Given User is at the login page
    When User types in a valid username of "username"
    And User types in an invalid password of "password"
    And User clicks the login button
    Then User should see an alert for invalid password stating 'Wrong password for user'

  Scenario: Invalid username, valid password
    Given User is at the login page
    When User types in an invalid username of "username"
    And User types in a valid password of "password"
    And User clicks the login button
    Then User should see an alert for invalid username stating 'Username not found'

  Scenario: Invalid login credentials
    Given User is at the login page
    When User types in an invalid username of "username"
    And User types in an invalid password of "password"
    And User clicks the login button
    Then User should see an alert for invalid username and password stating 'Wrong username/password for user'