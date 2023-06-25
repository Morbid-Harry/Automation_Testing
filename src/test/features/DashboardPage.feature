Feature: As a User on the dashboard I should be able to favorite and show interest in roles
  Scenario: As a user I should be able to view roles and show interest in them
    Given I am on the dashboard page
    When I show interest in a project role
    Then I should see an email sent message

  Scenario: As a user when I view a specific project the details of it should be correct (Without tags)
    Given I am on the dashboard page
    When I view the project role client: "Company:539" and project "Project:268"
    Then The card title should be "Company:549"
    And The project name should be "A9"
    And The start date should be "2023-05-30"
    And The end date should be "2023-12-31"
    And The way of working should be "Client_Site"
    And The address should be "Test Address: 586"

