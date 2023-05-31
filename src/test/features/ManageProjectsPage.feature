Feature: Manage Project Page Functionality
  As a resource manager/admin
  I want to be able to manage available projects
  Meaning I can create, update or delete projects

  Scenario: Create a project with all fields filled out correctly
    Given I am on the Manage Project Page
    When I create a project with all fields filled
    Then I should see a project created success message

  Scenario: Create a project with remote location selected
    Given I am on the Manage Project Page
    When I create a project with that is remote
    Then I should see a project created success message

  Scenario: Create a project with no tool tags selected
    Given I am on the Manage Project Page
    When I create a project with no tool tags selected
    Then I should see a project created success message

  Scenario: Create a project with no dates selected
    Given I am on the Manage Project Page
    When I create a project with no dates
    Then I should see a project created success message

  Scenario: Fail to create a project with invalid dates
    Given I am on the Manage Project Page
    When I create a project with invalid dates
    Then I shouldn't see a project created success message
