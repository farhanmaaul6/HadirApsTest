Feature: Negative Test Import Cuti

  Background:
    Given Admin is on the dashboard for Cuti

  @auth @negative
  Scenario: Import tanpa memilih file (Cuti)
    When Admin navigates to Import Cuti
    And Admin clicks Import without select a file
    Then Error Message should be show for missing file in cuti

  @auth @negative
  Scenario: Import file tidak sesuai template (Cuti)
    When Admin uploads incorrect Cuti template file
    Then Error message should be show for invalid format in Cuti

  @auth @negative
  Scenario: Import file bukan format excel (Cuti)
    When Admin uploads non-excel file for cuti
    Then Error message should be show for file type in cuti