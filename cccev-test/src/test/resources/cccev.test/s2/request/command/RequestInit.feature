Feature: RequestCreate

  Scenario: I want to create a request
    When I create a request:
      | hasConcept | hasEvidenceTypeList |
      | c1         | etl1                |
    Then The request should be created
