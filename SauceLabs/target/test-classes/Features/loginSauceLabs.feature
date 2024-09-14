Feature: Login Scenario

  Scenario: 
    Given user on login page
    When enter "<username>" and "<password>"
    And clicked on login button
    Then user navigated to home page
    And close browser

    Examples:
|	username |	password	|
|	standard_user |	secret_sauce|
|	locked_out_user |	secret_sauce|
|	problem_user |	secret_sauce|
|	performance_glitch_user |	secret_sauce|