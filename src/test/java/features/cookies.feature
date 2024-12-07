Feature: Manage cookies

Scenario: Accept all cookies
	Given The user opens the homepage
	And The cookie banner is displayed
	When The user clicks accept all cookies
	Then The cookie banner disappears
	And The cookie widget appears

Scenario: Accept only essential cookies
  Given The user opens the homepage
  And The cookie banner is displayed
  When The user clicks reject all cookies
  Then The cookie banner disappears
  And The cookie widget appears