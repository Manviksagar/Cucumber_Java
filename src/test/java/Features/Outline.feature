Feature: Login Feature
  Verify if user is able to Login in to the site

Scenario Outline: Login as a authenticated user with valid username and Password
    Given user is on LandingPage
    When 	user navigates to LandingPage Page
    And 	user enters <username> and <Password>
    Then 	success message is populated

    
 		Examples:
	 		| username	              | Password	    |
	 		| blog.cucumber@gmail.com | Cucumber@blog |
	 		| allu.cucumber@gmail.com | Cucumber@blog |