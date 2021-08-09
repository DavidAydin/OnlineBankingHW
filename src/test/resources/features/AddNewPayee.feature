@addPayee
Feature: Add new payee under pay bills

Background:
  Given the user is on the login page
  And the user enters "username" and "password"
  And the user should land in "Account Summary" page
  And the user navigates to "Pay Bills" page
  And the user should land in "Pay Bills" page
  And the user clicks on "Add New Payee" tab on the Pay Bills page

  Scenario: Ad payee
    When the user enters the following data to add new Payee
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then the user gets the following addPayee result message
      |The new payee The Law Offices of Hyde, Price & Scharks was successfully created.|

