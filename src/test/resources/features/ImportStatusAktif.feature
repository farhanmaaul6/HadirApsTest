Feature: Positive Test Import Status Aktif

  Background:
    Given Admin is on the dashboard for Status Aktif

  @auth @positive
  Scenario: Download template data status aktif
    When Admin navigates to Import > Status Aktif
    And Admin clicks Download Template Status Aktif
    Then Template for Status Aktif should be downloaded

  @auth @positive
  Scenario: Import data status aktif (valid file)
    When Admin uploads valid status aktif template file
    Then Status aktif data should be imported successfully