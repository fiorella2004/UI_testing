Feature: Legal and information pages

Scenario: The user views a legal and information page  
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies  
    And the user clicks on <pageName> page
    Then the page should open with the <title>
    
    Examples:
			| pageName								|	title																	|
			|	Quiénes somos						|	Quiénes somos													|
			|	Condiciones generales		|	Condiciones generales de contratación |			
			|	Condiciones de uso			|	Condiciones de uso										|
			| Política de privacidad	|	Política de Privacidad y Cookies			|
			| Derecho de desistimiento|	Derecho de desistimiento							|