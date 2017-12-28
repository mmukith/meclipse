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
Feature: Login to Facebook
Keywords Summary : This test will verify login related scenarios to FACEBOOK.COM

  @tag1
  Scenario: Login with valid credentials
    
    
    Given user navigate to FACEBOOK.COM
    When user enter Username as "USER" and password "PASSWORD"
    And user click on login buttton
	  Then Login should be succesful 
    
    
     Scenario: Login with invalid credentials
    
    
    Given user navigate to FACEBOOK.COM
    When user enter Username as "USER" and password "PASSWORD"
    And user click on login buttton
	  Then Login should not be succesful 
  
  