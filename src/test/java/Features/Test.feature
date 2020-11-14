Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario: Login as a authenticated user
    Given user is on homepage
    When user navigates to Login Page
    And user typed blog.cucumber@gmail.com and Password
    Then success message is displayed

  Scenario Outline: Login as a authenticated user with different data
    Given user is on homepage
    When user navigates to Login Page
    And user typed <USER> and Password
    Then success message is displayed

    Examples: 
      | USER                    |
      | blog.cucumber@gmail.com |
      | allu.cucumber@gmail.com |
