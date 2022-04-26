Feature: Verify login functionality

  Scenario: Verify login by entering valid username and password
    Given User is redirected on login page
    When User enter valid username and password
    When User click on login button
    Then User is logged in successfully

  Scenario: Verify login by entering invalid username and password
    Given User is redirected on login page
    When User enter valid username and password
    When User click on login button
    Then User is logged in successfully
