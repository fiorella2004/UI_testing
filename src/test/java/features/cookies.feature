Feature: Manage cookies

Scenario: Accept all cookies
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies
    Then the cookie banner disappears
    And the cookie widget appears

Scenario: Accept only essential cookies
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks reject all cookies
    Then the cookie banner disappears
    And the cookie widget appears