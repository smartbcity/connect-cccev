Feature: RequestAddEvidence

  Scenario: I want to add evidences to a request
    Given An evidence type is created:
      | identifier |
      | et1        |
    And A request is created
    When I add an evidence to the request:
      | evidence | name  | isConformantTo |
      | e1       | proof | et1            |
    And I add an evidence to the request:
      | evidence | name             | isConformantTo |
      | e2       | proof_but_better | et1            |
    Then The requests should contain the evidences:
      | evidence | name             | isConformantTo |
      | e1       | proof            | et1            |
      | e2       | proof_but_better | et1            |
