Feature: Pay Bills

  Background:
    Given the user is on the login page
    And the user enters "username" and "password"
    When the user navigates to "Pay Bills" page

  Scenario: Check Pay Bills page title
    Then the user should land in "Pay Bills" page

  Scenario: Successful pay operation
    And the user selects the payee as "Apple"
    And the user selects the account as "Checking"
    And the user enters the transfer amount as "300.12"
    And the user enters the transfer date as "22-9-2021"
    And the user enters the transfer description as "Test payment"
    And the user clicks the Pay button
    Then the user gets the following payment result message
      |The payment was successfully submitted.|

  Scenario: The user doesn't enter payment amount
    And the user selects the payee as "Apple"
    And the user selects the account as "Checking"
    And the user enters the transfer amount as ""
    And the user enters the transfer date as "22-9-2021"
    And the user enters the transfer description as "Test payment"
    And the user clicks the Pay button
    Then the transfer amount validation message should pop up as follows
      |Please fill out this field.|


  Scenario: The user does not enter date
    And the user selects the payee as "Apple"
    And the user selects the account as "Checking"
    And the user enters the transfer amount as "255.45"
    And the user enters the transfer date as ""
    And the user enters the transfer description as "Test payment"
    And the user clicks the Pay button
    Then the date validation message should pop up as follows
      |Please fill out this field.|


  Scenario: The amount box negative test with invalid characters
    And the user enters the transfer amount as "Abq%"
    Then the amount box should be empty


  Scenario: The date box negative test with invalid characters
    And the user enters the transfer date as "Abq"
    Then the date box should be empty
