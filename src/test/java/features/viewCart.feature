Feature: View cart

Scenario: The user can see the product in the cart page
	Given the user opens the homepage
	When the user clicks accept all cookies
	And the user clicks add to cart one book
	Then the cart widget shows one product
	When the user clicks the cart widget
	And the user clicks go to cart
	Then the user can see the cart page
	And the user can see the book in the cart page