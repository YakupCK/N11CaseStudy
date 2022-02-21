Feature:Footer Menu

  @wip
  Scenario: Verify footer menu
    Given I logged in through Facebook
    And I write all the footer links to a text file
    When I click on "Markalar" at the footer
    Then footer links must be the same as the text file

