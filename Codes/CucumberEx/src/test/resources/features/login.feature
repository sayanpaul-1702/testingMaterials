@smoke
Feature: User Login
  @positive
  Scenario Outline: Successful Login
    Given the browser is opened
    And the user is on the login page
    When the user enters valid credentials(username: "<username>", password: "<password>")
    And the user clicks on login button
    Then the user should be redirected to the dashboard
    And the user should see the title of the dashboard(title: "Dashboard")

    Examples:
      | username | password  |
      | Admin    | admin123 |


