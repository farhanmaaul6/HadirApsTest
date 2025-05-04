Feature: Positive Test Import Struktur User

  Background:
    Given Admin is on the dashboard for Struktur User

  @auth @positive
  Scenario: Download template data struktur user
    When Admin navigates to Import > Struktur User
    And Admin clicks Download Template Struktur User
    Then Template for Struktur User should be downloaded

  @auth @positive
  Scenario: Import data struktur user (valid file)
    When Admin uploads valid struktur user template file
    Then Struktur user data should be imported successfully