@login
Feature: login
  Background:
    Given the user is on the login page


  Scenario: User enters valid username and password
    When the user enters "username" and "password"
    Then the user should land in "Account Summary" page


  Scenario: User enters wrong password
    When the user enters "username" and "wrong_password"
    Then the webpage return following error message
      |Login and/or password are wrong.|


  Scenario: User enters wrong username
    When the user enters "wrong_username" and "password"
    Then the webpage return following error message
      |Login and/or password are wrong.|


  Scenario: User enters wrong username and wrong password
    When the user enters "wrong_username" and "wrong_password"
    Then the webpage return following error message
      |Login and/or password are wrong.|


  Scenario: Username enters blank username
    When the user enters "blank_username" and "password"
    Then the webpage return following error message
      |Login and/or password are wrong.|


  Scenario: Username enters blank password
    When the user enters "username" and "blank_password"
    Then the webpage return following error message
      |Login and/or password are wrong.|


  Scenario: Username enters blank username and blank password
    When the user enters "blank_username" and "blank_password"
    Then the webpage return following error message
      |Login and/or password are wrong.|
