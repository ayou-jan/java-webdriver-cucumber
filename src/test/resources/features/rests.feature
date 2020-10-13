@rest
  Feature: REST API automation for Careers project

    @rest1
    Scenario: REST API Position CRUD
      Given I login via REST as "recruiter"
      When I create via REST "automation" position
      Then I verify via REST new "automation" position is in the list
      When I update via REST "automation" position
      Then I verify via REST new "automation" position is updated
      When I delete via REST new position
      Then I verify via REST new position is deleted

    @rest2
    Scenario: REST API Candidates CRUD
      Given I login via REST as "recruiter"
      When I create via REST "sdet" candidate
      Then I verify via REST new "sdet" candidate is in the list
      When I update via REST "sdet" candidate
      Then I verify via REST new "sdet" candidate is updated
      When I delete via REST new candidate
      Then I verify via REST new candidate is deleted
