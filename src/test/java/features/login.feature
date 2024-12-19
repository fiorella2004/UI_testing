Feature: Login

Scenario: Login with an existing account
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies
    And the user clicks the user button
    Then the user button is displayed
    When the user writes their email
    And the user writes their password
    And the user clicks the login button
    Then the user is logged