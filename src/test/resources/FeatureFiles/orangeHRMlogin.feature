Feature: OrangeHRM Login Functionality

  Scenario: Login using valid credentials.
    Given user is navigating to orangeHRM url
    When user enters valid username and password
    Then user should navigate to the home page.
    And close the application

  Scenario: 1 Login using Invalid credentials.
    Given user is navigating to orangeHRM url
    When user enters invalid username and password
    Then user should see an error message
    And close the application

  Scenario Outline: Login using multiple data.
    Given user is navigating to orangeHRM url
    When user enters "<username>" and "<password>"
    Then user should navigate to the next page
    And close the application
    Examples: 
      | username | password    |
      | Admin    | admin123    |
      | abcde    | adfgwr12345 |
      | Baljeev  | malayil123  |
      | Radha123 | Baljeev123  |
