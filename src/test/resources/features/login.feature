@login

Feature: Login

  Scenario Outline: Valid Login Credentials
    Given User is at the login page
    When User types in a valid username of <username>
    And User types in a valid password of <password>
    And User clicks the login button
    Then User should be redirected to the <role> homepage

    Examples:
      | username   |  password  | role    |
      | g8tor      |  chomp!    | Manager |
      | ryeGuy     |  coolbeans | Tester  |
      | cavalier89 |  alucard   | Tester  |

  Scenario Outline: Login Greeting
    Given User is at the login page
    When User types in a valid username of <username>
    And User types in a valid password of <password>
    And User clicks the login button
    Then User should be redirected to the <role> homepage
    And User sees greeting message displaying Welcome <firstname> <lastname>

    Examples:
      | username   |  password  | role    | firstname | lastname  |
      | g8tor      |  chomp!    | Manager | Patty     | Pastiche  |
      | ryeGuy     |  coolbeans | Tester  | Fakey     | McFakeFace|
      | cavalier89 |  alucard   | Tester  | Dracula   | Fangs     |

  Scenario: Valid Username, Invalid Password
    Given User is at the login page
    When User types in a valid username of "username"
    And User types in an invalid password of "password"
    And User clicks the login button
    Then User should see an alert for invalid password stating 'Wrong password for user'

  Scenario: Invalid Username, Valid Password
    Given User is at the login page
    When User types in an invalid username of "username"
    And User types in a valid password of "password"
    And User clicks the login button
    Then User should see an alert for invalid username stating 'Username not found'

  Scenario: Invalid Login Credentials
    Given User is at the login page
    When User types in an invalid username of "username"
    And User types in an invalid password of "password"
    And User clicks the login button
    Then User should see an alert for invalid username and password stating 'Wrong username/password for user'