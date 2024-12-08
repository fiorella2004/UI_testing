Feature: Add product to cart

Scenario: Add one product to cart
	Given the user opens the homepage
	And the cookie banner is displayed
	When the user clicks accept all cookies
	Then the cart widget shows zero products
	When the user clicks add to cart the book KIDNAPPERS
	Then the cart widget shows one product