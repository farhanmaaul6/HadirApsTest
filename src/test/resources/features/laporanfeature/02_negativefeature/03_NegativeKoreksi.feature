Feature: Negative Test Correction Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Koreksi

  @auth @negative
  Scenario: Search correction by empty date result
    When Admin navigates to Correction Report
    And Admin selects start date "Jan 1, 2026" and end date "Jan 31, 2026"
    And Admin clicks the Search button
    Then No correction data should be displayed

  @auth @negative
  Scenario: Search correction by invalid employee name
    When Admin clicks the Reset button
    And Admin inputs "Joko" in the search field
    And Admin clicks the Search button
    Then No correction data should be displayed

  @auth @negative
  Scenario: Search correction by invalid unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs invalid unit name "Juru Parkir"
    And Admin clicks the Apply button
    And Admin clicks the Search button
    Then No correction data should be displayed

  @auth @negative
  Scenario: Reject correction without reason
    When Admin navigates to Correction Report
    And Admin clicks the Reset button
    And Admin clicks the Reject button for the first correction
    And Admin clicks the Submit rejection button without reason
    Then A validation error should appear indicating reason is required