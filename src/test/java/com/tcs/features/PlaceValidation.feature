#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @smoke
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Validation of addplace API
    Given Add place payload with <name>, <value> and <address>
    When I check for the <value> in step
    Then I verify the <status> in step And scope in response is "App"
    And VerifyPlaceId maps to <name> using "GetPlaceAPI"

    Examples: 
      | name  | value | address  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
   Scenario: Verify if Deleteplace API is working
   Given DeletePlace Payload
   When User calls "deletePlaceAPI" with "POST" request
   Then response should have status code 200
   And "status" in the body is "OK"
