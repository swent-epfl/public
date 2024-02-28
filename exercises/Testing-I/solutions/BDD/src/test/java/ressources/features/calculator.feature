Feature: Calculator
  Scenario: Initialize a calculator
    Given I have a calculator
    Then the result should be 0

  Scenario: Add a series of numbers
    Given I have a calculator displaying 0
    When I add 2
    Then the result should be 2

  Scenario: Subtract a number
    Given I have a calculator displaying 0
    When I subtract 3
    Then the result should be -3

  Scenario: A series of operations
    Given I have a calculator displaying 0
    When I add 2
    And I subtract 3
    And I add 5
    Then the result should be 4

  Scenario: Calculator already has a value
    Given I have a calculator displaying 10
    When I add 5
    And I subtract 3
    And I subtract 2
    Then the result should be 10


