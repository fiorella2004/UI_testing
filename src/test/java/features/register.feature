Feature: Register

Scenario: Complete the registration form without CAPTCHA verification
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies
    And the user clicks the user button
    Then the user button is displayed
    When the user clicks the register button
    Then the user can see the register page
    When the user writes their information
    And the user clicks the confirm register button