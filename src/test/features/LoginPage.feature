Feature: Login Page Functionality
  As a user
  I want to be able to login to the application
  So that I can access my account

  Scenario: Successful Login
    Given I am on the login page
    When I login with the username & password, "haedward" and "pass"
    Then I should see the text "Welcome to your Dashboard Harry"

  Scenario: Failed Login
    Given I am on the login page
    When I login with the username & password, "badusername" and "badpassword"
    Then I should see a failed to login message

  Scenario: Logout
    Given I am on the login page
    When I login with the username & password, "haedward" and "pass"
    And I click logout
    Then I should see a logout success message

  Scenario Outline: Login as Admin or Resource Manager
    Given I am on the login page
    When I login with the username & password, "<Username>" and "<Password>"
    Then I should see the sidebar button "<Sidebar Button>"
    Examples:
      | Username | Password  | Sidebar Button       |
      | admin    | adminpass | Create User          |
      | admin    | adminpass | Manage Project Roles |
      | rm_user1 | rmpass1   | Manage Project Roles |