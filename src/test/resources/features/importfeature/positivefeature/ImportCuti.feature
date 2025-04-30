Feature: Positive Import Cuti

  Background:
    Given Admin is on the dashboard page for Absen

  @auth @positive
  Scenario: Download template cuti
    When Admin navigates to Import > Cuti
    And Admin clicks Download Template Cuti
    Then Template for Cuti should be downloaded

  @auth @positive
  Scenario: Import data cuti (valid file)
    When Admin uploads valid cuti template files
    Then Cuti data should be imported successfully