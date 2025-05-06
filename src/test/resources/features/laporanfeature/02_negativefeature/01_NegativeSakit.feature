Feature: Negative Test Sick Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Sakit

  @auth @negative
  Scenario: Search sick report by invalid date
    When Admin navigates to the Sick report page
    And Admin selects start date "Mar 1, 2026" and end date "Mar 31, 2026"
    And Admin clicks the Search button
    Then No sick report data should be displayed

  @auth @negative
  Scenario: Search sick report by invalid employee name
    When Admin clicks the Reset button
    And Admin inputs "Kazama" in the search field
    And Admin clicks the Search button
    Then No sick report data should be displayed

  @auth @negative
  Scenario: Search sick report by invalid unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs invalid unit name "Fotografer"
    And Admin clicks the Apply button
    Then No sick report data should be displayed