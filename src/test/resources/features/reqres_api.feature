Feature: ReqRes user API

  As a QA engineer
  I want to validate the ReqRes user API
  So that I can verify its responses and data integrity

  Scenario: Retrieve the list of users
    Given Juan uses the ReqRes API
    When he requests the users from page 2
    Then the users response should be successful
    And the response should contain users from page 2

  Scenario: Create a new user
    Given Juan uses the ReqRes API
    When he creates a user named "Juan Chacon" with job "QA Automation Engineer"
    Then the user should be created successfully
    And the created user should contain the submitted information

  Scenario: Update an existing user
    Given Juan uses the ReqRes API
    When he updates user 2 with name "Juan Chacon" and job "Senior QA Automation Engineer"
    Then the user should be updated successfully
    And the updated user should contain the submitted information