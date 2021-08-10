Feature: Find Transactions in Account Activity

  Background:
    Given the user is on the login page
    And the user enters "username" and "password"
    And the user should land in "Account Summary" page
    And the user navigates to "Account Activity" page
    And the user should land in "Account Activity" page
    And the user clicks on Find Transaction tab on the Account Activity page

  Scenario: Search date range
    When the user enters start date "2012-09-01" and end date "2012-09-06"
    And the user clicks on the Find button
    Then the shown results should be between dates "2012-09-01" and "2012-09-06"

  Scenario: Search date range
    When the user enters start date "2012-09-01" and end date "2012-09-06"
    And the user clicks on the Find button
    Then the results should be sorted by most recent date

  Scenario: Search date range
    When the user enters start date "2012-09-02" and end date "2012-09-06"
    And the user clicks on the Find button
    Then the shown results should be between dates "2012-09-02" and "2012-09-06"

  Scenario: Search date range
    When the user enters start date "2012-09-02" and end date "2012-09-06"
    And the user clicks on the Find button
    Then the shown results should should not contain "2012-09-01"

  Scenario: Search description
    When the user enters "ONLINE" in description
    And the user clicks on the Find button
    Then results table should only show transactions with description "ONLINE"


  Scenario: Search description
    When the user enters "OFFICE" in description
    And the user clicks on the Find button
    Then results table should only show transactions with description "OFFICE"
    And results table should not show transactions with description "ONLINE"


  Scenario: Search description case sensitive
    When the user enters "ONLINE" in description
    And the user clicks on the Find button
    Then results table should only show transactions with description "ONLINE"
    When the user enters "online" in description
    And the user clicks on the Find button
    Then results table should only show transactions with description "ONLINE"


  Scenario: Transaction Type: Empty

    When the user clicks on the Find button
    Then results table should show at least one result under "Deposit"
    Then results table should show at least one result under "Withdrawal"


  Scenario: Transaction Type: Deposit
    When user selects type "Deposit" and hits Find button
    Then results table should show at least one result under "Deposit"
    But results table should show no result under "Withdrawal"


  Scenario: Transaction Type: Withdrawal
    When user selects type "Withdrawal" and hits Find button
    Then results table should show at least one result under "Withdrawal"
    But results table should show no result under "Deposit"


