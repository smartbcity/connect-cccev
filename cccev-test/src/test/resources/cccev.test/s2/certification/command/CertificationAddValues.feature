Feature: CertificationAddValues

  Background:
    Given A data unit is created

  Scenario: I want to add values to a certification
    Given Some information concepts are created:
      | identifier |
      | ic1        |
      | ic2        |
      | ic3        |
    And A certification is created
    When I add values to the certification:
      | concept | value  |
      | ic1     | blblbl |
      | ic2     | 3      |
    Then The certification should contain the values

  Scenario: I want to update values of a certification
    Given Some information concepts are created:
      | identifier |
      | ic1        |
      | ic2        |
      | ic3        |
    And A certification is created
    And Some values are added to the certification:
      | concept | value  |
      | ic1     | blblbl |
      | ic2     | 3      |
    When I add values to the certification:
      | concept | value              |
      | ic1     | blblblblblblblblbl |
      | ic3     | yey                |
    Then The certification should contain the values:
      | concept | value              |
      | ic1     | blblblblblblblblbl |
      | ic2     | 3                  |
      | ic3     | yey                |
