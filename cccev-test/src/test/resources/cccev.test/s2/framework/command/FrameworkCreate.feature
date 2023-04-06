Feature: FrameworkCreate

  Scenario: I want to create a framework
    When I create a framework:
      | name         |
      | ze framework |
    Then The framework should be created
