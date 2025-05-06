Feature: Positive Test Correction Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Koreksi

  @auth @positive
  Scenario: Search correction by date
    When Admin navigates to Correction Report
    And Admin selects start date "Jan 1, 2025" and end date "Feb 28, 2025"
    And Admin clicks the Search button
    Then The correction data within the selected date range is displayed

  @auth @positive
  Scenario: Search correction by employee name
    When Admin clicks the Reset button
    And Admin inputs "Juned" in the search field
    And Admin clicks the Search button
    Then Correction report data should be shown by employee name

  @auth @positive
  Scenario: Search correction by unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs unit name "Brodo"
    And Admin clicks the Apply button
    Then The correction data related to the unit name is displayed

  @auth @positive
  Scenario: Search correction by name and date
    When Admin clicks the Reset button
    And Admin inputs "Juned" in the search field
    And Admin selects start date "Feb 1, 2024" and end date "Feb 29, 2024"
    And Admin clicks the Search button
    Then The correction data filtered by name and date is displayed

  @auth @positive
  Scenario: Approve a correction request
    When Admin clicks the Approve button for the first correction
    And Admin clicks the Confirm button
    Then A success popup should appear

  @auth @positive
  Scenario: Reject a correction request
    When Admin clicks the Reject button for the first correction
    And Admin inputs rejection reason "Alasan tidak valid"
    And Admin clicks the Submit rejection button
    Then A success popup should appear