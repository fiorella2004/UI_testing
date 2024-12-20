Feature: View cart

Scenario: The user can see the product in the cart page
	Given the user opens the index page
	And the cookie banner is displayed
	When the user clicks accept all cookies
	And the user clicks add to cart one book
	Then the cart widget shows one product
	When the user clicks the cart widget
	And the user clicks go to cart
	Then the user can see the cart page
	And the user can see the book in the cart page
	
Scenario: The user can increase the number of the products
	Given the user opens the index page
	And the cookie banner is displayed
	When the user clicks accept all cookies
	And the user clicks add to cart one book
	Then the cart widget shows one product
	When the user clicks the cart widget
	And the user clicks go to cart
	Then the user can see the cart page
	When the user increases the number of the products
	Then the cart shows two products
	
Scenario: The user can decrease the number of the products
	Given the user opens the index page
	And the cookie banner is displayed
	When the user clicks accept all cookies
	And the user clicks add to cart one book
	Then the cart widget shows one product
	When the user clicks the cart widget
	And the user clicks go to cart
	Then the user can see the cart page
	When the user increases the number of the products
	Then the cart shows two products
	When the user decreases the number of the products
	Then the cart shows one product

Scenario: The user can delete de product in the cart
	Given the user opens the index page
	And the cookie banner is displayed
	When the user clicks accept all cookies
	And the user clicks add to cart one book
	Then the cart widget shows one product
	When the user clicks the cart widget
	And the user clicks go to cart
	Then the user can see the cart page
	And the user can see the book in the cart page
	When the user clicks the delete button
	And the user clicks the accept button
	Then the cart shows zero products