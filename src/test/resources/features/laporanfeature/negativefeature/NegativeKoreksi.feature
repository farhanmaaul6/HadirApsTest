Feature: Negative Test Correction Report

  Background:
    Given Admin is logged in and on the dashboard for Laporan Koreksi

  @auth @negative
  Scenario: Search without any input
    When Admin navigates to Correction Report
    And Admin clicks the Search button without entering any filter
    Then No correction data should be displayed or an alert message should appear

  @auth @negative
  Scenario: Search using invalid unit name
    When Admin clicks the Filter button
    And Admin inputs invalid unit name "XXX Unit"
    And Admin clicks the Apply filter button
    Then No correction data should be displayed or an alert should appear

  @auth @negative
  Scenario: Reject correction without entering a reason
    When Admin clicks the Reject button for the first correction
    And Admin clicks the Submit rejection button without reason
    Then An alert popup should appear with message "Please fill out this field."
