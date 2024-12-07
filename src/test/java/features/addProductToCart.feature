Feature: Add product to cart

Scenario: Add product to cart
	Given The user opens the homepage
	And The cookie banner is displayed
	When The user clicks accept all cookies
	Then The user clicks add to cart for the first product on the homepage
	And The cart widget shows one product added