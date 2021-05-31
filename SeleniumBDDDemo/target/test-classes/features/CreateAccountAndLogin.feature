Feature: Create account and Login

  Scenario: Register into website as a new user
    Given I am on the login page
    When I click on 'create account' link
    And I create a new profile without accepting captcha challenge
    When I am on the login page
    And I login with new user details
    Then I see user unable to login with error message "Incorrect email or password."