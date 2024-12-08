Feature: Add product to cart

Scenario: Add product to cart
	Given The user opens the homepage
	And The cookie banner is displayed
	When The user clicks accept all cookies
	Then The cart widget shows zero products
	When The user clicks add to cart the book KIDNAPPERS
	Then The cart widget shows one product 