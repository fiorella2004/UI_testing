Feature: View product detail

Scenario: View product detail  
  Given the user opens the index page
  And the cookie banner is displayed
  When the user clicks accept all cookies
  And the user clicks one product
  Then the product details are shown

