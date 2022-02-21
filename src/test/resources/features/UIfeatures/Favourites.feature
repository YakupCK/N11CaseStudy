Feature: Add to favourites

  @wip
  Scenario: Add seventh item to the favourites
    Given I logged in through Facebook
    * I navigate to "Parfüm & Deodorant" under "Kozmetik & Kişisel Bakım"
    * I searched for "Lacoste"
    * I click 7 th item and added to Favorilerim
    When I go to "Favorilerim / Listelerim" page
    Then the product title must be the same as product details page

