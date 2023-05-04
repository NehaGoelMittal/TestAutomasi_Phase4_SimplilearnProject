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
Feature: Automating TestAutomasi

  @tag1
  Scenario Outline: Verify course title
    Given user lands on TestAutomasi website
    And click on elearning
    When user clicks on search bar
    And user searches for course "<coursename>"
    Then verify title of course contains "<coursename>"
    And click on View More button
    Then click on Buy More button
    And verify the error message
    Examples:
      | coursename |
      | Jmeter |
      | Selenium |
      | Appium |
      





   

  