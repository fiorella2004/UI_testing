Feature: Verify social link

Scenario Outline: the user clicks on the social links
    Given the user opens the index page
    And the cookie banner is displayed
    When the user clicks accept all cookies 
    And the user clicks <social> link
    Then a new page opens with url <url>

    Examples:
			| social		|	url						|
			|	Facebook	|	facebook.com	|
			|	Twitter		|	x.com					|			
			|	Instagram	|	instagram.com	|