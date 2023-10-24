Feature: Login the Application with Internal and External User

@DailyRegression
  Scenario Outline: Login with External User

    When User opens the Browser
    And External User able to Login into Connect System with "<External_Username>" and "<External_password>"
    And  User Click on Login button on Connect Login Page as ExternalUser

    Examples: 
      | External_Username          | External_password |
      | connectnednatman@sbv.co.za | P@ssword          |
      | connectnednatman@sbv.co.za | password1234     |

@DailyRegression
  Scenario Outline: Login with Internal User
    When User opens the Browser
    And Internal User able to Login into Connect System with "<Internal_Username>" and "<Internal_password>"
    And User Click on Login button on Connect Login Page as InternalUser

    Examples: 
      | Internal_Username       | Internal_password |
      | connectvpkclo@sbv.co.za | P@ssword          |
      | connectvpkclo@sbv.co.za | password1234      |
