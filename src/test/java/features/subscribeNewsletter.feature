Feature: Subscribe to the newsletter

Scenario: The user subscribes to the newsletter
	Given the user opens the index page
	And the cookie banner is displayed
	When the user clicks accept all cookies
	Then the page shows the option to subscribe to the newsletter
	When the user completes the form
	And the user clicks the subscribe button
	Then the page shows the verification
	
Scenario: The user subscribes to the newsletter checking the promo checkbox
	Given the user opens the index page
	And the cookie banner is displayed
	When the user clicks accept all cookies
	Then the page shows the option to subscribe to the newsletter
	When the user completes the form
	And the user checks the promo checkbox
	And the user clicks the subscribe button
	Then the page shows the verification