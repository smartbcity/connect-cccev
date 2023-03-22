Feature: RequestRemoveRequirements

  Scenario: I want to remove requirements from a request
    Given Some requirements are created:
      | identifier |
      | r1         |
      | r2         |
      | r3          |
    And A request is created:
      | requirements |
      | r1, r2, r3   |
    When I remove requirements from the request:
      | requirements |
      | r1, r2       |
    Then The request should not contain the requirements:
      | requirements |
      | r1, r2       |
    And The request should contain the requirements:
      | requirements |
      | r3           |
