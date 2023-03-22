Feature: RequestCreate

  Scenario: I want to create a request
    Given Some requirements are created:
      | identifier |
      | r1         |
      | r2         |
      | r3          |
    When I create a request:
      | name       | description | requirements |
      | ze rekwest | blblbl      | r1, r2       |
    Then The request should be created
