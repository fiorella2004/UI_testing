Feature: add product to a wishlist

Scenario: the user add product to a wishlist
	Given the user opens the index page
	And the cookie banner is displayed
	When the user clicks accept all cookies
	And the user clicks product
	And the user clicks icon heart
	And the website requires username and password
	And the user writes username and password
	Then the website displays a message that the product has been added