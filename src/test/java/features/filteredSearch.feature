Feature: Product search using filter

Scenario: Filter comics   
    Given the user is in the index page
    When The user clicks accept all cookies  
    And the user clicks on the Menu button  
    And the user selects Comics   
    Then the user should see a message Norma Comics La Mayor Tienda De Comics De Europa
    
Scenario: Filter books  
    Given the user is in the index page
    When The user clicks accept all cookies  
    And the user clicks on the Menu button  
    And the user selects Libros   
    Then the user should see a message Libros
    
Scenario: Filter merchandising 
    Given the user is in the index page
    When The user clicks accept all cookies  
    And the user clicks on the merchandising button  
    Then the user should see a product of portamanga sushi