Feature: Product search using filter

Scenario Outline: the user uses the menu filters  
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies  
    And the user clicks on the Menu button  
    And the user selects <filter> filter
    Then the user should see a message <title>
    
    Examples:
			| filter				|	title																							|
			|	COMICS				|	Norma Cómics: La Mayor Tienda De Cómics De Europa	|
			|	LIBROS				|	Libros																						|			
			|	MERCHANDISING	|	Merchandising																			|
			| PRÓXIMAMENTE	|	Próximamente En Norma Comics											|
			| NOVEDADES			|	Novedades En Cómics Y Libros											|
    
Scenario: the user uses filter merchandising 
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies  
    And the user clicks on the merchandising button  
    Then the user should see a product of portamanga sushi