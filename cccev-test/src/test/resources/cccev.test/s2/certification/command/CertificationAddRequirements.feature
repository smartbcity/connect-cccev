Feature: CertificationAddRequirements

  Scenario: I want to add requirements to a certification
    Given Some requirements are created:
      | identifier |
      | r1         |
      | r2         |
      | r3          |
    And A certification is created:
      | requirements |
      | r1           |
    When I add requirements to the certification:
      | requirements |
      | r2, r3       |
    Then The certification should contain the requirements
