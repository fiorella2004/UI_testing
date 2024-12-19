Feature: Product search using the search bar

Scenario: Search for an existing product  
  Given the user opens the index page
  And the cookie banner is displayed
  When the user clicks accept all cookies
  And the user enters arcane in the search bar
  Then the results show products related to arcane
  
Scenario: Search for a non-existing product
  Given the user opens the index page
  And the cookie banner is displayed
  When the user clicks accept all cookies
  And the user enters mmmmm in the search bar 
  Then a message indicates Prueba de nuevo con otra busqueda
