Feature: Negative Test Import Struktur User

  Background:
    Given Admin is on the dashboard for Struktur User

  @auth @negative
  Scenario: Import tanpa memilih file (Struktur User)
    When Admin navigates to Import > Struktur User
    And Admin clicks Import Struktur User without choosing a file
    Then Error message should be shown for missing file in the Struktur User

  @auth @negative
  Scenario: Import file tidak sesuai template (Struktur User)
    When Admin uploads incorrect struktur user template file
    Then Error message should be shown for invalid format in Struktur User

  @auth @negative
  Scenario: Import file bukan format Excel (Struktur User)
    When Admin uploads non-Excel file for struktur user
    Then Error message should be shown for file type in Struktur User