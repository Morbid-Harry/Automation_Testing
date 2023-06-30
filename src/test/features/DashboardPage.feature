Feature: As a User on the dashboard I should be able to favorite and show interest in roles
  Scenario: As a user I should be able to view roles and show interest in them
    Given I am on the dashboard page
    When I show interest in a project role
    Then I should see an email sent message

  Scenario: As a user when I view a specific project the details of it should be correct (Without tags all information filled out)
    Given I am on the dashboard page
    When I view the project role client: "Company:539" and project "Project:268"
    Then The card title should be "Company:539"
    And The project name should be "Project:268"
    And The grade required should be "A9"
    And The start date should be "2023-05-30"
    And The end date should be "2023-12-31"
    And The way of working should be "Client_Site"
    And The address should be "Test Address: 586"
    And The description should be "This is a general description for the Client: Company:539 and Project:268"

  Scenario: As a user when I view a specific project the details of it should be correct (No Address and Remote)
    Given I am on the dashboard page
    When I view the project role client: "Company:448" and project "Project:421"
    Then The card title should be "Company:448"
    And The project name should be "Project:421"
    And The grade required should be "A9"
    And The start date should be "2023-05-30"
    And The end date should be "2023-12-31"
    And The way of working should be "Remote"
    And The address should be "From Home"
    And The description should be "This is a general description for the Client: Company:448 and Project:421"

  Scenario: As a user when I view a specific project the details of it should be correct (No Address, Remote and no start or end date)
    Given I am on the dashboard page
    When I view the project role client: "Company:201" and project "Project:802"
    Then The card title should be "Company:201"
    And The project name should be "Project:802"
    And The grade required should be "A3"
    And The start date should be "Unknown"
    And The end date should be "Unknown"
    And The way of working should be "Remote"
    And The address should be "From Home"
    And The description should be "This is a general description for the Client: Company:201 and Project:802"

  Scenario: As a user when I filter by Grade i should only see roles that are for the selected grade
    Given I am on the dashboard page
    When I filter by grade "A10"
    Then All roles I see should have the grade "A10"

  Scenario: As a user when I filter by Way of Working i should only see roles that are for the selected Way of Working
    Given I am on the dashboard page
    When I filter by Way of Working "Hybrid"
    Then All roles I see should have the Way of Working "Hybrid"

  Scenario: As a user when I filter by Tool Used I should only see roles that a for the select tool used
    Given I am on the dashboard page
    When I filter by the Tool used "Eggplant"
    Then All roles I see should have the Tool used "Eggplant"
    
  Scenario: As a user when click view details on a role I should be able to favourite it
    Given I am on the dashboard page
    When I view the project role client: "Company:539" and project "Project:268"
    And I click the Add to Favourites button
    Then I should see an added to favourites message

  Scenario: As a user when I try to favourite a role already in my favourites then I should see a project in your favourites message
    Given I am on the dashboard page
    When I view the project role client: "Company:539" and project "Project:268"
    And I click the Add to Favourites button
    Then I should see an already in your favourites message

  Scenario: As a user I should be able to remove a project from my favourites
    Given I am on the favourites page
    When I view the project role client: "Company:539" and project "Project:268"
    And I click Remove from Favourites button
    Then I should see project removed from favourites message
