Feature: Verify google maps link

Scenario: the user clicks on the google maps link
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies 
    And the user clicks quienes somos
    And the page quienes somos opens
    And the user clicks googleMaps 
    Then google maps page opens