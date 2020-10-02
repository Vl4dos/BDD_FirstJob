Feature: Create Issues

  Background: Login
    Given I navigate to Jira Login Page
    And I enter user name - "webinar5"
    And I enter password - "webinar5"
    And I click on the login button
    Then I am on the Home Page
#
  @Regression
  Scenario: Create issues
    Then I click on Create button
    Then Create Issues for is opened
    When I fill all mandatory fields
    Then An issues is create
    And The issues number is shown