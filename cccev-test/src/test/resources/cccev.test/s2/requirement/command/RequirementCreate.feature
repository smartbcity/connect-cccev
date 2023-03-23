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
      | identifier | specifiesEvidenceType |
      | etl1       | et1, et2, et3         |

  Scenario: I want to create a requirement
    When I create a requirement:
      | type     | hasConcept | hasEvidenceTypeList |
      | activity | c1         | etl1                |
    Then The requirement should be created

  Scenario: I want to create a requirement with a sub-requirement
    Given A requirement is created:
      | identifier | type | hasConcept | hasEvidenceTypeList |
      | r1         | step | c1         | etl1                |
    When I create a requirement:
      | type     | hasRequirement |
      | activity | r1             |
    Then The requirement should be created
