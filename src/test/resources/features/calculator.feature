@calculator
Feature: Playing with calc

  @play1
  Scenario Outline: Verify calculator result
    Given I go to "calculator" page
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    Then I verify "Please provide a positive interest value." calculator error
    And I enter "<price>" price, "<months>" months, "<interest>" interest, "<downpayment>" downpayment, "<tradeIn>" trade-in, "<state>" state, "<percentTax>" percent tax, "<fees>" fees
    And I calculate
    Then I verify monthly pay is "<monthlyPay>"
    Examples:
      | price | months | interest | downpayment | tradeIn | state      | percentTax | fees | monthlyPay |
      | 25000 | 36     | 4.5      | 5000        | 0       | California | 7          | 300  | $594.94    |
      | 30000 | 24     | 5.0      | 7000        | 7000    | Florida    | 6          | 250  | $701.94    |
      | 90000 | 60     | 3.0      | 12000       | 14000   | New York   | 5          | 600  | $1,150.00   |
