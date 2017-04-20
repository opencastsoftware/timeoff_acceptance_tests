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
@Acceptance
Feature: Login
	To test the login feature of Opencastsoftware Timeoff Tracker

@HappyPath
Scenario: Login happy path
Given I access the homepage
When I fill in valid email address and password
Then I should be successfully logged into the homepage
And I should see "Welcome Jon" at the top left hand corner

@HappyPath
Scenario Outline: Login happy path examples
Given I access the homepage
When I fill "<email>"  and "<password>"
Then I should be successfully logged into the homepage
And I should see "<name>" at the top left hand corner

Examples:

		| email                            | password   | name |
		|jon.everett@opencastsoftware.com  | Br!tann!a01| Jon  |
		|levis.brisibe@opencastsoftware.com| Thompson01 | Levis|




