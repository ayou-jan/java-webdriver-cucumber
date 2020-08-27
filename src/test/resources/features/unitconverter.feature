@converter
  Feature: unit converter testing

    @converter1
      Scenario: temperature testing
      Given I go to converter page
      And I click on "Temperature"
      And I set from "Fahrenheit" Unit and to "Celsius" Unit
      And I set 54 in From field value and verify that result is 12.2 in To value

    @converter1
    Scenario: temperature testing
      Given I go to converter page
      And I click on "Weight"
      And I set from "Pound" Unit and to "Kilogram" Unit
      And I set 170 in From field value and verify that result is 77.1 in To value

    @converter1
    Scenario: temperature testing
      Given I go to converter page
      And I click on "Length"
      And I set from "Mile" Unit and to "Kilometer" Unit
      And I set 50 in From field value and verify that result is 80.4 in To value


