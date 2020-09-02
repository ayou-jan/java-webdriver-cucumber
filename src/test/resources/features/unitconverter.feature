@converter
  Feature: unit converter testing

    @converter1
      Scenario Outline: temperature-weight-length testing
      Given I go to converter page
      And I click on "<unit>"
      And I set from "<from>" Unit and to "<to>" Unit
      And I set <value> in From field value and verify that result is <result> in To value
      Examples:
        | unit | from | to | value | result |
        | Temperature | Fahrenheit | Celsius | 54 | 12.2 |
        | Weight | Pound | Kilogram | 170 | 77.1 |
        | Length | Mile | Kilometer | 50 | 80.4 |



