Feature: Recover password

Scenario: Recover the password from an existing account
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies
    And the user clicks the user button
    Then the user button is displayed
    When the user clicks the link to recover their password
    Then the user provides their email
    When the user clicks the recover password button
    Then the user can see the page to recover their password