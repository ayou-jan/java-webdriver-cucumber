@quote
Feature: Quote OOP


  @quote1
  Scenario: Required fields for quote oop
    Given I open "quote" page
    When I fill out required fields for "user" oop
    And I submit the form oop
    Then I verify required fields for "user" oop
