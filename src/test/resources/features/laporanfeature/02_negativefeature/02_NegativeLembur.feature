Feature: Negative Test Overtime Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Lembur

  @auth @negative
  Scenario: Export overtime report with empty data
    When Admin navigates to the Overtime report page
    And Admin clicks the Export button
    Then Export file should not be generated

  @auth @negative
  Scenario: Search overtime by invalid date
    When Admin clicks the Reset button
    And Admin selects start date "Jan 1, 2026" and end date "Jan 31, 2026"
    And Admin clicks the Search button
    Then No overtime report data should be displayed

  @auth @negative
  Scenario: Search overtime by invalid employee name
    When Admin clicks the Reset button
    And Admin inputs "Joko" in the search field
    And Admin clicks the Search button
    Then No overtime report data should be displayed

  @auth @negative
  Scenario: Search overtime by invalid unit name
    When Admin clicks the Reset button
    And Admin clicks the Filter button
    And Admin inputs invalid unit name "Pedagang"
    And Admin clicks the Apply button
    Then No overtime report data should be displayed