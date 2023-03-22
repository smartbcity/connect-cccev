Feature: RequestAddRequirements

  Scenario: I want to add requirements to a request
    Given Some requirements are created:
      | identifier |
      | r1         |
      | r2         |
      | r3          |
    And A request is created:
      | requirements |
      | r1           |
    When I add requirements to the request:
      | requirements |
      | r2, r3       |
    Then The request should contain the requirements
