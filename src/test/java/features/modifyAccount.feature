Feature: Modify account

Scenario: Modify the information of an existing account
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies
    And the user clicks the user button
    Then the user button is displayed
    And the user logs with their account
    When the user clicks the edit profile link
    Then the page shows the information to edit
    When the user writes their new information
    And the user clicks the save button
    Then the page shows that the information has been saved

Scenario: Modify the password of an existing account
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies
    And the user clicks the user button
    Then the user button is displayed
    And the user logs with their account
    When the user clicks the change password link
    Then the page shows the information to edit
    When the user writes their new password
    And the user clicks the save button
    Then the page shows that the information has been saved
    
Scenario: Modify the password of an existing account making an error
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies
    And the user clicks the user button
    Then the user button is displayed
    And the user logs with their account
    When the user clicks the change password link
    Then the page shows the information to edit
    When the user writes their password incorrectly
    And the user clicks the save button
    Then the page shows that the password doesnt match