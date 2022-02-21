Feature: Get some Pet - TASK 2

  @task2 @wip @api
  Scenario: Get a new pet
    Given I connected to Base URI
    * Endpoint is "pet"
    * Content-type is "application/json"
    * Accept is "application/json"
    When I send a GET request with pet id
    Then the status code must be 200
    * Response body must be the same as Task-1
    * Content-type should be "application/json"
    * Response header should has a date value