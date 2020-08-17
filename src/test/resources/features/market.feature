@market
  Feature: Marketing test suite

    @market1
    Scenario: Navigation for quote
      Given I go to "quote" page
      And I print page details
      And I wait for 2 sec
      And I go to "google" page
      And I print page details
      And I go back and forward, then refresh

    @market2
    Scenario: Required fields for quote
      Given I go to "quote" page
      And I print page details
      When I fill out required fields
      And I "accept" agreement
      And I submit the form
      And I wait for 1 sec
      Then I verify required fields
      Then I verify that fields values recorded correctly
      Then I verify email field behavior


    @market3
    Scenario: Play with resolutions
      Given I go to "quote" page
      And I change resolution to "phone"
      And I wait for 1 sec
      And I change resolution to "desktop"
      And I wait for 1 sec
