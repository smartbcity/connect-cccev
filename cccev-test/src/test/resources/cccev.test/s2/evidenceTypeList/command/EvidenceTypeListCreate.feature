Feature: EvidenceTypeListCreate

  Scenario: I want to create an evidence type list
    Given Some evidence types are created:
      | identifier |
      | et1        |
      | et2        |
      | et3        |
    When I create an evidence type list:
      | specifiesEvidenceType |
      | et1, et2, et3         |
    Then The evidence type list should be created
