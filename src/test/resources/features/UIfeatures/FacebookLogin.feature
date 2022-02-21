Feature: Login

  @wip
  Scenario: Login with Facebook account
    Given I navigate to home page
    And I click on "Giriş Yap" button
    When I try to log in through Facebook with valid credentials
    Then I should be logged in


