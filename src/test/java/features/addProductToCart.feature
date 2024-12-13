Feature: Add product to cart

Scenario: The user can see the product added in the cart 
	Given the user opens the homepage
	When the user clicks accept all cookies
	And the user clicks add to cart one book
	Then the cart widget shows one product
	When the user clicks the cart widget
	Then the cart widget shows the product added