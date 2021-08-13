@accountActivity
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is on the login page
    And the user enters "username" and "password"


  Scenario: Check Account Activity page title
    When the user navigates to "Account Activity" page
    Then the user should land in "Account Activity" page


  Scenario: Check the default account type is Savings in dropdown menu
    When the user navigates to "Account Activity" page
    Then the current dropdown account type should be "Savings"


  Scenario: Account dropdown options
    When the user navigates to "Account Activity" page
    Then the account dropdown should have the following options
      |Savings      |
      |Checking     |
      |Loan         |
      |Credit Card  |
      |Brokerage    |


  Scenario: Transaction table headers
    When the user navigates to "Account Activity" page
    Then the transaction table headers should have the following titles
      |Date       |
      |Description|
      |Deposit    |
      |Withdrawal |

  Scenario: Savings Account redirect
    When the user clicks on "Savings" link on the Account Summary page
    Then the user should land in "Account Activity" page
    And the current dropdown account type should be "Savings"

  Scenario: Brokerage Account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the user should land in "Account Activity" page
    And the current dropdown account type should be "Brokerage"

  Scenario:Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the user should land in "Account Activity" page
    And the current dropdown account type should be "Credit Card"

  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the user should land in "Account Activity" page
    And the current dropdown account type should be "Loan"
