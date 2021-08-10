@accountSummary
Feature: Account Summary

  Background:
    Given the user is on the login page
    When the user enters "username" and "password"

  Scenario: Account Types
    Then the following account types should be available
      |Cash Accounts      |
      |Investment Accounts|
      |Credit Accounts    |
      |Loan Accounts      |

  Scenario: Credit Accounts Table Headers
    Then the Credit Accounts columns should be following
      |Account    |
      |Credit Card|
      |Balance    |
