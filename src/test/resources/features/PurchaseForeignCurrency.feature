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

