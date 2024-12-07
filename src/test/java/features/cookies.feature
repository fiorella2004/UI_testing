Feature: Manage cookies

Scenario: Accept all cookies
	Given The user opens the homepage
	And The cookie banner is displayed
	When The user clicks accept all cookies
	Then The cookie banner disappears
	And All cookies are enabled

Scenario: Reject all cookies
	Given The user opens the homepage
	And The cookie banner is displayed
	When The user clicks reject all cookies
	Then The cookie banner disappears
	And Only essential cookies are enabled