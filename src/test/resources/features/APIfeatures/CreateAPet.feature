Feature: Create A Pet - TASK 1

  @task1 @wip @api
  Scenario: Create a new pet
    Given I connected to Base URI
    * Endpoint is "pet"
    * Content-type is "application/json"
    * Accept is "application/json"
    When I send a POST request with the following JSON model
    """
        {
        "category": {
          "id": 2,
          "name": "Pets"
        },
        "name": "Rockyy",
        "photoUrls": [
          "rocky.png"
        ],
        "tags": [
          {
           "id": 2,
           "name": "tigers"
          }
        ],
        "status": "available"
        }
    """
    Then the status code must be 200
    * Response body must have an id
    * Created name should be equal to the posted name
    * Content-type should be "application/json"
    * Response header should has a date value
