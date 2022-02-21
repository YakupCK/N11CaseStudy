Feature: Remove A Pet - TASK 3

  @task3 @wip @api
  Scenario: Remove a new pet
    Given I connected to Base URI
    * Endpoint is "pet"
    * Content-type is "application/json"
    * Accept is "application/json"
    When I send a DELETE request with pet id
    Then the status code must be 200
    * Content-type should be "application/json"
    * Message in the response body must be the same as id
    * Type in the response body must be "unknown"