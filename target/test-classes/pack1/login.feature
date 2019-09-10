Feature: Perform multiple user login

  @tag1
  Scenario: Successful login
    Given user enters the login page
    And user enters the "<username>" and "<password>" in the field
    | username | password       |
    |  Lalitha | Password123    |
    |  Jazeela | Jazeela123     |
    And verify the login details
    Then verify the page title
