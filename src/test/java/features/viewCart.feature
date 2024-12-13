Feature: View cart

Scenario: The user can see the product in the cart page
	Given the user opens the homepage
	And the cookie banner is displayed
	When the user clicks accept all cookies
	Then the cart widget shows zero products
	When the user clicks add to cart the book KIDNAPPERS
	Then the cart widget shows one product
	When the user clicks the cart widget
	And the user clicks go to cart
	Then the user can see the cart page
	And the user can see the book in the cart page
	
Scenario: The user can increase the product by one
	Given the user opens the homepage
	And the cookie banner is displayed
	When the user clicks accept all cookies
	Then the cart widget shows zero products
	When the user clicks add to cart the book KIDNAPPERS
	Then the cart widget shows one product
	When the user clicks the cart widget
	And the user clicks go to cart
	Then the user can see the cart page
	And the user can see the book in the cart page
	When the user increases the product by one
	Then the cart shows two items of that product
