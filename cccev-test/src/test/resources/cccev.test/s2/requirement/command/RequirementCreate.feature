Feature: RequirementCreate

  Background:
    Given A data unit is created
    And An information concept is created:
      | identifier |
      | c1         |
    And Some evidence types are created:
      | identifier |
      | et1        |
      | et2        |
      | et3        |
    And An evidence type list is created:
      | identifier |
      | etl1       |

  Scenario: I want to create a requirement
    When I create a requirement:
      | hasConcept | hasEvidenceTypeList |
      | c1         | etl1                |
    Then The requirement should be created
