Feature: As a user I should be able to update my first name, last name, grade and my password

  Scenario: As a user when I update my first name, last name and password I should see a success message
    Given I am on the profile page
    When I update my first name to "Gary"
    And I update my last name to "Smith"
    And I update my grade to "A7"
    And I click the update details button
    Then I should see a update success message

  Scenario: As a user when I update just my fist name I should see a success message
    Given I am on the profile page
    When I update my first name to "Harry"
    And I click the update details button
    Then I should see a update success message

  Scenario: As a user when I update just my last name I should see a success message
    Given I am on the profile page
    When I update my last name to "Edwards"
    And I click the update details button
    Then I should see a update success message


  Scenario: As a user when I update just my grade I should see a success message
    Given I am on the profile page
    When I update my grade to "A5"
    And I click the update details button
    Then I should see a update success message

  Scenario Outline: As a user if I try to use my password with incorrect information I should see an update failure message
    Given I am on the profile page
    When I enter my current password "<Current Password>"
    And I enter my new password "<New Password>"
    And I enter the confirm password "<Confirm Password>"
    And I click the update password button
    Then I should see an update failure message
    Examples:
      | Current Password | New Password | Confirm Password |
      | invalidPass      | newPass      | newPass          |
      | pass             | invalidPass  | newPass          |
      | invalid          | invalid      | newPass          |

  Scenario Outline: As a user if I update my password with the correct information i should see an update success message
    Given I am on the login page
    When I login with the username & password, "<Username>" and "<Password>"
    And I navigate to the profile page
    And I enter my current password "<Current Password>"
    And I enter my new password "<New Password>"
    And I enter the confirm password "<Confirm Password>"
    And I click the update password button
    Then I should see a update success message
    Examples:
      | Username | Password | Current Password | New Password | Confirm Password |
      | haedward | pass     | pass             | newPass      | newPass          |
      | haedward | newPass  | newPass          | pass         | pass             |