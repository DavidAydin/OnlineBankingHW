Feature: Find Transactions in Account Activity
  
  Background:
    Given the user is on the login page
    And the user enters "username" and "password"
    And the user should land in "Account Activity" page
    
  @wip
  Scenario: Search date range
    When the user clicks on Find Transaction tab on the Account Activity page
    And the user enters start date "2012-09-01" and end date "2012-09-06"
    And the user clicks on the Find button
   
    