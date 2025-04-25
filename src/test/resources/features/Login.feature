Feature: Login Functionality

  @auth @positive @negative
  Scenario: Login
    Given User is on the login page
    When User enters email "admin@hadir.com" and password "MagangSQA_JC@123"
    Then User should be redirected to the dashboard
