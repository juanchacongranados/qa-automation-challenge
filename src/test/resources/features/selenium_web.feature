Feature: Selenium website navigation

  As a user interested in Selenium
  I want to navigate through the Selenium website
  So that I can access its documentation and resources

  Scenario: Verify Selenium home page loads successfully
    Given Juan opens the Selenium website
    Then the Selenium home page should be displayed
    And the page title should contain "Selenium"