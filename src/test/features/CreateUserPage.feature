Feature: As an admin I should be able to create a user, resource manager or admin
  Scenario: An admin can create a user
    Given I am on the create user screen
    When I create a user
    Then I should see a user created success message

  Scenario: An admin can create a admin
    Given I am on the create user screen
    When I create an admin
    Then I should see a user created success message

  Scenario: An admin can create a resource manager
    Given I am on the create user screen
    When I create an resource manager
    Then I should see a user created success message

  Scenario: An admin cannot create a user with an already used username
    Given I am on the create user screen
    When I create a user with the username "haedward"
    Then I should see a user created success message

  Scenario: An admin cannot create a user with an already used email
    Given I am on the create user screen
    When I create a user with the email "admin@admin.com"
    Then I should see a user created success message



