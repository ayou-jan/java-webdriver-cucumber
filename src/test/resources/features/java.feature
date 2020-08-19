@java
  Feature: Java Feature

    @java1
    Scenario: Hello world
      Given I say hello world
      And I say "hello again"
      And I print to console "my var" and "my VAR"
      And I print to console "my var" and "my VAR" in UPPERcase
      And I print to console the length of "my var" and "my VAR"
      And I compare if "my var" and "my VAR" are the same
      And I compare if "my var" and "my VAR" are the same ignoring case
      And I check if "my var" contains a part of "my VAR"

    @java2
    Scenario: Exercises after day 5
      And I play with numbers
      And I print url for "sample" page
      And I print if number "35" is positive
      And I print "5" th day of week

      @java3
      Scenario: Exercise after day 6
        And I swap the names

      @java4
      Scenario: Exercises after day 7
        Given array "5,2,9,7,3"
        Given does 8 divisible by


