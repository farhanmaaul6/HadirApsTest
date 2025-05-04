Feature: Positive Import Absen

  Background:
    Given Admin is on the dashboard page for Absen

  @auth @positive
  Scenario: Download template data for absen
    When Admin navigates to Import > Absen
    And Admin clicks download template for Absen
    Then Template for Absen should be downloaded

  @auth @positive
  Scenario: Import data Absen (valid data)
    When Admin uploads valid absen template file
    Then Absen should be imported successfully

