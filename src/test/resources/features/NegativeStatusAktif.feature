Feature: Negative Test Import Status Aktif

  Background:
    Given Admin is on the dashboard for Status Aktif

  @auth @negative
  Scenario: Import tanpa memilih file (Status Aktif)
    When Admin navigates to Import > Status Aktif
    And Admin clicks Import without choosing a file
    Then Error message should be shown for missing file in the Status Aktif

  @auth @negative
  Scenario: Import file tidak sesuai template (Status Aktif)
    When Admin uploads incorrect status aktif template file
    Then Error message should be shown for invalid format in Status Aktif

  @auth @negative
  Scenario: Import file bukan format Excel (Status Aktif)
    When Admin uploads non-Excel file for status aktif
    Then Error message should be shown for file type in Status Aktif