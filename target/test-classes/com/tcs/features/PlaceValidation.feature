#Author: m.yousuf@tcs.com
#Keywords Summary :
#Feature: List of scenarios.
Feature: Validating Place APIs
#Scenario: Business rule through list of steps with arguments.
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
Scenario Outline: Verify if place added successfully
#Given: Some precondition step
Given addPlace payload provided with "<name>","<language>" and "<address>"
#When: Some key actions
When User calls the "AddPlaceAPI" using "post" http request
#Then: To observe outcomes or validation
Then API call should be successful and returns "200" status code
#And,But: To enumerate more Given,When,Then steps
And "Status" body in the response payload is "OK" 
And "scope"  body in the response payload is "APP"
And Verify placeId created maps to "<name>" using "getPlaceAPI"


#Examples: Container for s table
Examples: 
	|name|language|address|
	|Benedict|English-EN|221-bakerSt, London|
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

