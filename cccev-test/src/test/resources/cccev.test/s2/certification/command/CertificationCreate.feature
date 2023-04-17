Feature: CertificationCreate

  Scenario: I want to create a certification
    Given Some requirements are created:
      | identifier |
      | r1         |
      | r2         |
      | r3          |
    When I create a certification:
      | name       | description | requirements |
      | ze rekwest | blblbl      | r1, r2       |
    Then The certification should be created
