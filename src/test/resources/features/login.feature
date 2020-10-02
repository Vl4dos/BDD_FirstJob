Feature: Login To Jira



  @Regression
  Scenario: Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "webinar5"
    And I enter password - "webinar5"
    And I click on the login button
    Then I am on the Home Page

  @Regression
  Scenario Outline: Failed Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "<login>"
    And I enter password - "<password>"
    And I click on the login button
    Then I am on an error page

    Examples:
      | login        | password     |
      | webinar5VLAD | webinar5     |
      | webinar5     | webinar5VLAD |


