@currency
Feature: Purchase Foreign Currency

  Background:
    Given the user is on the login page
    And the user enters "username" and "password"
    And the user should land in "Account Summary" page
    And the user navigates to "Pay Bills" page
    And the user should land in "Pay Bills" page
    And the user clicks on "Purchase Foreign Currency" tab on the Pay Bills page

  Scenario: Available Currencies
    Then the following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |
@wip
  Scenario: Error message for not selecting currency
    When the user enters "100.02" as the amount to calculate currency
    And the user clicks on the Calculate Costs button
    Then currency calculator error message should be displayed
@wip
  Scenario: Error message for not entering value
    When the user selects the currency as "Canada (dollar)"
    And the user checks the selected currency radio button
    And the user clicks on the Calculate Costs button
    Then currency calculator error message should be displayed
