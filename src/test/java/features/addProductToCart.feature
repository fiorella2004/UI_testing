Feature: Add product to cart

Scenario: Add one product to cart
	Given the user opens the homepage
	And the cookie banner is displayed
	When the user clicks accept all cookies
	Then the cart widget shows zero products
	When the user clicks add to cart the book KIDNAPPERS
	Then the cart widget shows one product
	
Scenario: The user can see the product added in the widget
	Given the user opens the homepage
	And the cookie banner is displayed
	When the user clicks accept all cookies
	When the user clicks add to cart the book KIDNAPPERS
	When the user clicks the cart widget
	Then the cart widget shows the product added