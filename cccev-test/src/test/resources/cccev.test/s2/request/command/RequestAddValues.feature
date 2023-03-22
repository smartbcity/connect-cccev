Feature: RequestAddValues

  Background:
    Given A data unit is created

  Scenario: I want to add values to a request
    Given Some information concepts are created:
      | identifier |
      | ic1        |
      | ic2        |
      | ic3        |
    And A request is created
    When I add values to the request:
      | concept | value  |
      | ic1     | blblbl |
      | ic2     | 3      |
    Then The request should contain the values

  Scenario: I want to update values of a request
    Given Some information concepts are created:
      | identifier |
      | ic1        |
      | ic2        |
      | ic3        |
    And A request is created
    And Some values are added to the request:
      | concept | value  |
      | ic1     | blblbl |
      | ic2     | 3      |
    When I add values to the request:
      | concept | value              |
      | ic1     | blblblblblblblblbl |
      | ic3     | yey                |
    Then The request should contain the values:
      | concept | value              |
      | ic1     | blblblblblblblblbl |
      | ic2     | 3                  |
      | ic3     | yey                |
