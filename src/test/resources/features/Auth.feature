Feature: Login Functionality

  @auth @positive @negative @eben
  Scenario: Login
    Given Admin is on the login page
    When Admin enters email "admin@hadir.com" and password "MagangSQA_JC@123"
    Then Admin should be redirected to the dashboard
